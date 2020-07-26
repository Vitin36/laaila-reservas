package com.br.laaila.reservas.laailareservas.model.request

import com.br.laaila.reservas.laailareservas.model.entity.ExternalType
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class UsuarioCreate(
        @field:[Email] val email: String,
        @field:[NotNull NotBlank NotEmpty Size(min = 5)] val senha: String,
        @field:[NotNull NotBlank NotEmpty Size(min = 5)] val nome: String,
        @field:[NotNull NotBlank NotEmpty Size(min = 11)] val contato: String,
        val externalClientId: String?,
        val externalClientType: ExternalType?
)

data class UsuarioStatusUpdate(
        @field:[NotNull] val email: String,
        @field:[NotNull] val ativo: Boolean
)