package com.br.laaila.reservas.laailareservas.model.request

import com.br.laaila.reservas.laailareservas.model.entity.CatalogoStatus
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class CatalogoCreate(
        @field:[NotNull NotEmpty NotBlank] val nome: String,
        val descricao: String?,
        val status: CatalogoStatus?
)

data class CatalogoUpdate(
        val nome: String?,
        val descricao: String?,
        val status: CatalogoStatus?
)