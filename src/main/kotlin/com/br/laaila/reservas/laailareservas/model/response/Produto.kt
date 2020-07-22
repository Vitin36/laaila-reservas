package com.br.laaila.reservas.laailareservas.model.response

data class ProdutoCreatedOrUpdated(
        val id: Long,
        val nome: String,
        val valor: Long,
        val descricao: String
)