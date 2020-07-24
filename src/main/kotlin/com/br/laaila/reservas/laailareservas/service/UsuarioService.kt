package com.br.laaila.reservas.laailareservas.service

import com.br.laaila.reservas.laailareservas.infrastructure.repository.UsuarioRepository
import com.br.laaila.reservas.laailareservas.model.entity.Usuario
import com.br.laaila.reservas.laailareservas.model.mapper.map
import com.br.laaila.reservas.laailareservas.model.request.UsuarioCreate
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

    fun create(usuarioCreate: UsuarioCreate): Usuario {
        return repository.save(map(usuarioCreate).apply { this.senha = encrypt(this.senha) })
    }

    fun delete(email: String) {
        repository.deleteById(email)
    }

    fun encrypt(senha: String): String {
        return passwordEncoder.encode(senha)
    }

    override fun loadUserByUsername(email: String): UserDetails {
        return repository.findById(email).orElseThrow { UsernameNotFoundException("Usuário não encontrado") }
    }

}