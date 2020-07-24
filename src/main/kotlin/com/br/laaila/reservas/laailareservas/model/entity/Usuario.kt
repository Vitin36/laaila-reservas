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
        @OneToMany(fetch = FetchType.EAGER)
        var permissoes: MutableList<Permissao>? = mutableListOf(Permissao.CLIENTE)
) : UserDetails {

    private val ativo = true

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