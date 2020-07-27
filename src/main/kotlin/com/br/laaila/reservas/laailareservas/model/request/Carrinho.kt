package com.br.laaila.reservas.laailareservas.model.request

import javax.validation.constraints.NotNull

data class CarrinhoUpdate(
        @field:[NotNull] val carrinhoId: Long,
        val itens: List<CarrinhoProdutoQuantidade>
)

data class CarrinhoProdutoQuantidade(
        @field:[NotNull] val produtoId: Long,
        @field:[NotNull] val quantidade: Int
)