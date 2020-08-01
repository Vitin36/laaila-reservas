package com.br.laaila.reservas.laailareservas.model.request

import java.util.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive

data class ProdutoCreate(
        @field:[NotNull NotEmpty NotBlank] val nome: String,
        @field:[NotNull Positive] val valor: Double,
        @field:[NotNull NotEmpty NotBlank] val descricao: String,
        @field:[NotNull] val catalogo: UUID
)

data class ProdutoUpdate(
        val nome: String?,
        val valor: Double?,
        val descricao: String?,
        val catalogo: UUID?,
        val ativo: Boolean?
)

data class ProdutoStatusUpdate(
        @field:[NotNull] val id: UUID,
        @field:[NotNull] val ativo: Boolean
)
