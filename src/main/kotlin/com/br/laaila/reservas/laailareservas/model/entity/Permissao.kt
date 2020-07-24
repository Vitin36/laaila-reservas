package com.br.laaila.reservas.laailareservas.model.entity

import org.springframework.security.core.GrantedAuthority
import javax.persistence.Entity
import javax.persistence.Id

@Entity
enum class Permissao(
        @Id
        open val id: Long,
        open val valor: String
) : GrantedAuthority {
    ADMIN(1, "ADMIN") {
        override fun getAuthority() = this.valor
    },
    CLIENTE(2, "CLIENTE") {
        override fun getAuthority() = this.valor
    }
}