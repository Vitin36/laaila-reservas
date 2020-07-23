package com.br.laaila.reservas.laailareservas.model.response

import com.br.laaila.reservas.laailareservas.model.entity.CatalogoStatus

data class CatalogoResponse(
        val id: Long,
        val nome: String,
        val descricao: String?,
        val status: CatalogoStatus,
        val produtos: List<Long>
)

data class CatalogoProdutoResponse(
        val id: Long,
        val nome: String,
        val descricao: String?,
        val status: CatalogoStatus,
        val produtos: List<ProdutoResponse>
)