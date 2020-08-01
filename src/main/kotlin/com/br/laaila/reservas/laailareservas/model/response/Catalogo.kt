package com.br.laaila.reservas.laailareservas.model.response

import java.util.UUID


data class CatalogoResponse(
        val id: UUID,
        val nome: String,
        val descricao: String?,
        val ativo: Boolean
)

data class CatalogoProdutoResponse(
        val id: UUID,
        val nome: String,
        val descricao: String?,
        val produtos: List<ProdutoResponse>,
        val ativo: Boolean
)