package com.br.laaila.reservas.laailareservas.config

import com.br.laaila.reservas.laailareservas.service.UsuarioService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer


@EnableWebSecurity
@EnableAuthorizationServer
@EnableResourceServer
@Configuration
open class SecurityConfig(
//        private val usuarioService: UsuarioService
) : WebSecurityConfigurerAdapter() {

    lateinit var usuarioService: UsuarioService

    private val email = "vitor.silva@zup.com.br"
    private val senha = "1234567"
    private val nome = "vitor hugo ferreira silva"
    private val contato = "34992291965"

//    @Bean
//    open fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    //    @Bean
//    open fun configureUser() {
//        usuarioService.inactivate(email)
//        usuarioService.create(UsuarioCreate(
//                email,
//                senha,
//                nome,
//                contato
//        ))
//    }

    override fun authenticationManager(): AuthenticationManager? {
        return super.authenticationManager()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication()
                .withUser("alexandre")
                .password("123")
                .roles("ADMIN")
    }

    override fun configure(http: HttpSecurity) {
        http.userDetailsService(userDetailsService())
    }

    @Bean
    open fun passwordEncoder(): PasswordEncoder? {
        return NoOpPasswordEncoder.getInstance()
    }

}