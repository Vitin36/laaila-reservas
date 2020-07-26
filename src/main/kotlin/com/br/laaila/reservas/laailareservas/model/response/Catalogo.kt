package com.br.laaila.reservas.laailareservas.model.response


data class CatalogoResponse(
        val id: Long,
        val nome: String,
        val descricao: String?,
        val ativo: Boolean
)

data class CatalogoProdutoResponse(
        val id: Long,
        val nome: String,
        val descricao: String?,
        val produtos: List<ProdutoResponse>,
        val ativo: Boolean
)