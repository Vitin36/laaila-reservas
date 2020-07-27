package com.br.laaila.reservas.laailareservas.model.response

data class CarrinhoResponse(
        val id: Long,
        val itens: List<ProdutoQuantidadeResponse> = emptyList(),
        val usuario: Long
)