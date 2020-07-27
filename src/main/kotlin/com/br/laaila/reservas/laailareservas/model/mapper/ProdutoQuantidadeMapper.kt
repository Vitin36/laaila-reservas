package com.br.laaila.reservas.laailareservas.model.mapper

import com.br.laaila.reservas.laailareservas.model.entity.ProdutoQuantidade
import com.br.laaila.reservas.laailareservas.model.response.ProdutoQuantidadeResponse

fun map(produtoQuantidade: ProdutoQuantidade): ProdutoQuantidadeResponse = ProdutoQuantidadeResponse(
        produtoId = produtoQuantidade.produto.id,
        quantidade = produtoQuantidade.quantidade
)