package com.br.laaila.reservas.laailareservas.model.mapper

import com.br.laaila.reservas.laailareservas.model.entity.Catalogo
import com.br.laaila.reservas.laailareservas.model.entity.Produto
import com.br.laaila.reservas.laailareservas.model.request.ProdutoCreate
import com.br.laaila.reservas.laailareservas.model.response.ProdutoResponse

fun map(produtoCreateRequest: ProdutoCreate, catalogo: Catalogo) = Produto(
        nome = produtoCreateRequest.nome,
        valor = produtoCreateRequest.valor,
        descricao = produtoCreateRequest.descricao,
        catalogo = catalogo
)

fun map(produto: Produto) = ProdutoResponse(
        id = produto.id,
        nome = produto.nome,
        valor = produto.valor,
        descricao = produto.descricao,
        catalogo = produto.catalogo.id
)