package com.br.laaila.reservas.laailareservas.model.request

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Min

data class UsuarioCreate(
        @field:[Email] val email: String,
        @field:[NotNull NotBlank NotEmpty Min(5)]val senha: String,
        @field:[NotNull NotBlank NotEmpty Min(5)]val nome: String,
        @field:[NotNull NotBlank NotEmpty Min(11)]val contato: String
)