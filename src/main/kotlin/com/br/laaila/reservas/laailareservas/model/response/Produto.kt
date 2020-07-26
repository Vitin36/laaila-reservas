package com.br.laaila.reservas.laailareservas.model.response

data class ProdutoResponse(
        val id: Long,
        val nome: String,
        val valor: Long,
        val descricao: String,
        val catalogo: Long,
        val ativo: Boolean
)