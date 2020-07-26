package com.br.laaila.reservas.laailareservas.service

import com.br.laaila.reservas.laailareservas.infrastructure.exception.NotFoundException
import com.br.laaila.reservas.laailareservas.infrastructure.exception.NotPermittedOperationException
import com.br.laaila.reservas.laailareservas.infrastructure.repository.UsuarioRepository
import com.br.laaila.reservas.laailareservas.model.entity.Usuario
import com.br.laaila.reservas.laailareservas.model.mapper.map
import com.br.laaila.reservas.laailareservas.model.request.UsuarioCreate
import com.br.laaila.reservas.laailareservas.model.request.UsuarioStatusUpdate
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UsuarioService(
        private val repository: UsuarioRepository,
        private val passwordEncoder: PasswordEncoder
) : UserDetailsService {

    private val NOT_FOUND_MESSAGE = "Usuário não encontrado"

    fun create(usuarioCreate: UsuarioCreate): Usuario {
        repository.findById(usuarioCreate.email)
                .ifPresent { throw NotPermittedOperationException("Usuário com este email já existe") }
        return repository.save(map(usuarioCreate).apply { this.senha = encrypt(this.senha) })
    }

    fun findById(email: String): Usuario {
        return repository.findById(email).orElseThrow { NotFoundException(NOT_FOUND_MESSAGE) }
    }

    fun updateStatus(usuarioStatusUpdate: UsuarioStatusUpdate) {
        repository.findById(usuarioStatusUpdate.email)
                .orElseThrow { NotFoundException(NOT_FOUND_MESSAGE) }
                .apply {
                    this.ativo = usuarioStatusUpdate.ativo
                    repository.save(this)
                }
    }

    fun encrypt(senha: String): String {
        return passwordEncoder.encode(senha)
    }

    override fun loadUserByUsername(email: String): UserDetails {
        return repository.findById(email)
                .orElseThrow { UsernameNotFoundException(NOT_FOUND_MESSAGE) }
    }

}