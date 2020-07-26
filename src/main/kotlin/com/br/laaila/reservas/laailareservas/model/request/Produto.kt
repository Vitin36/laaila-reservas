package com.br.laaila.reservas.laailareservas.model.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

data class ProdutoCreate(
        @field:[NotNull NotEmpty NotBlank] val nome: String,
        @field:[NotNull Positive] val valor: Long,
        @field:[NotNull NotEmpty NotBlank] val descricao: String,
        @field:[NotNull] val catalogo: Long
)

data class ProdutoUpdate(
        val nome: String?,
        val valor: Long?,
        val descricao: String?,
        val catalogo: Long?,
        val ativo: Boolean?
)

data class ProdutoStatusUpdate(
        @field:[NotNull] val id: Long,
        @field:[NotNull] val ativo: Boolean
)
