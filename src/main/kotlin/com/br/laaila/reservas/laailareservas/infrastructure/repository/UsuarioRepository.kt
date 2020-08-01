package com.br.laaila.reservas.laailareservas.infrastructure.repository

import com.br.laaila.reservas.laailareservas.model.entity.Usuario
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UsuarioRepository : JpaRepository<Usuario, UUID> {
    fun findByEmail(email: String): Optional<Usuario>
}