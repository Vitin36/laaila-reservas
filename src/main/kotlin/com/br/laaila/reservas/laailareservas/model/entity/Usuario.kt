package com.br.laaila.reservas.laailareservas.model.entity

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.*

@Entity
class Usuario(
        @Id
        val email: String,
        var senha: String,
        var nome: String,
        var contato: String,
        var ativo: Boolean = true,
        val externalClientId: String? = null,
        val externalClientType: ExternalType? = null,
        @Enumerated(EnumType.STRING)
        @ElementCollection(targetClass = Permissao::class, fetch = FetchType.EAGER)
        @JoinTable(
                name = "usuario_permissoes",
                joinColumns = [JoinColumn(name = "usuario_email")]
        )
        @Column(name = "permissoes_id", nullable = false)
        var permissoes: MutableList<Permissao>? = mutableListOf(Permissao.CLIENTE)
) : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return permissoes!!
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