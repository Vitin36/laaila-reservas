package com.br.laaila.reservas.laailareservas.service

import com.br.laaila.reservas.laailareservas.infrastructure.exception.NotFoundException
import com.br.laaila.reservas.laailareservas.infrastructure.exception.NotPermittedOperationException
import com.br.laaila.reservas.laailareservas.infrastructure.repository.UsuarioRepository
import com.br.laaila.reservas.laailareservas.model.entity.Usuario
import com.br.laaila.reservas.laailareservas.model.mapper.map
import com.br.laaila.reservas.laailareservas.model.request.UsuarioCreate
import com.br.laaila.reservas.laailareservas.model.request.UsuarioStatusUpdate
import com.br.laaila.reservas.laailareservas.model.request.UsuarioUpdate
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService(
        private val repository: UsuarioRepository,
        private val passwordEncoder: PasswordEncoder
) : UserDetailsService {

    private val NOT_FOUND_MESSAGE = "Usuário não encontrado"
    private val NOT_PERMITTED_MESSAGE = "Usuário já existe"

    fun create(usuarioCreate: UsuarioCreate): Usuario {
        repository.findByEmail(usuarioCreate.email).ifPresent { throw NotPermittedOperationException(NOT_PERMITTED_MESSAGE) }
        return repository.save(map(usuarioCreate).apply { this.senha = encrypt(this.senha) })
    }

    fun findById(id: UUID): Usuario {
        return repository.findById(id).orElseThrow { NotFoundException(NOT_FOUND_MESSAGE) }
    }

    fun findByEmail(email: String): Usuario {
        return repository.findByEmail(email)
                .orElseThrow { UsernameNotFoundException(NOT_FOUND_MESSAGE) }
    }

    fun updateStatus(usuarioStatusUpdate: UsuarioStatusUpdate) {
        repository.save(findById(usuarioStatusUpdate.id)
                .apply { this.ativo = usuarioStatusUpdate.ativo })
    }

    fun update(id: UUID, usuarioUpdate: UsuarioUpdate): Usuario {
        return repository.save(findById(id).apply {
            this.nome = usuarioUpdate.nome ?: this.nome
            this.permissao = usuarioUpdate.permissao ?: this.permissao
            this.contato = usuarioUpdate.contato ?: this.contato
            if (usuarioUpdate.senha !== null) {
                this.senha = usuarioUpdate.senha
            }
        })
    }

    fun encrypt(senha: String): String {
        return passwordEncoder.encode(senha)
    }

    override fun loadUserByUsername(email: String): UserDetails {
        return findByEmail(email)
    }

}