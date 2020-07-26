package com.br.laaila.reservas.laailareservas.model.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class CatalogoCreate(
        @field:[NotNull NotEmpty NotBlank] val nome: String,
        val descricao: String?,
        val ativo: Boolean?
)

data class CatalogoUpdate(
        val nome: String?,
        val descricao: String?,
        val ativo: Boolean?
)

data class CatalogoStatusUpdate(
        @field:[NotNull] val id: Long,
        @field:[NotNull] val ativo: Boolean
)