package com.br.laaila.reservas.laailareservas.model.mapper

import com.br.laaila.reservas.laailareservas.model.entity.Produto
import com.br.laaila.reservas.laailareservas.model.request.ProdutoCreate
import com.br.laaila.reservas.laailareservas.model.response.ProdutoCreatedOrUpdated

fun map(produtoCreateRequest: ProdutoCreate) = Produto(
        nome = produtoCreateRequest.nome,
        valor = produtoCreateRequest.valor,
        descricao = produtoCreateRequest.descricao)

fun map(produto: Produto) = ProdutoCreatedOrUpdated(
        id = produto.id,
        nome = produto.nome,
        valor = produto.valor,
        descricao = produto.descricao
)