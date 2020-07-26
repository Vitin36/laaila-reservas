package com.br.laaila.reservas.laailareservas.model.entity

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.*

@Entity
class Usuario(
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario")
        @SequenceGenerator(name = "usuario", sequenceName = "usuario_seq", allocationSize = 1)
        val id: Long = -1,
        @Column(unique = true)
        val email: String,
        var senha: String,
        var nome: String,
        var contato: String? = null,
        var ativo: Boolean = true,
        val externalClientId: String? = null,
        val externalClientType: ExternalType? = null,
        @Enumerated(value = EnumType.STRING)
        var permissao: Permissao = Permissao.CLIENTE
) : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableListOf(permissao)
    }

    override fun isEnabled(): Boolean {
        return ativo
    }

    override fun getUsername(): String {
        return email
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun getPassword(): String {
        return senha
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }
}

enum class ExternalType {
    FACEBOOK,
    GOOGLE
}

enum class Permissao(
        open val valor: String
) : GrantedAuthority {
    ADMIN("ADMIN") {
        override fun getAuthority() = this.valor
    },
    CLIENTE("CLIENTE") {
        override fun getAuthority() = this.valor
    }
}