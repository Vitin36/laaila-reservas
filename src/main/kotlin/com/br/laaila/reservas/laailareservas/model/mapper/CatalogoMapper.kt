package com.br.laaila.reservas.laailareservas.model.mapper

import com.br.laaila.reservas.laailareservas.model.entity.Catalogo
import com.br.laaila.reservas.laailareservas.model.entity.CatalogoStatus
import com.br.laaila.reservas.laailareservas.model.request.CatalogoCreate
import com.br.laaila.reservas.laailareservas.model.response.CatalogoProdutoResponse
import com.br.laaila.reservas.laailareservas.model.response.CatalogoResponse

fun map(catalogoCreate: CatalogoCreate) = Catalogo(
        nome = catalogoCreate.nome,
        status = catalogoCreate.status ?: CatalogoStatus.ABERTO,
        descricao = catalogoCreate.descricao
)

fun map(catalogo: Catalogo) = CatalogoResponse(
        id = catalogo.id,
        nome = catalogo.nome,
        status = catalogo.status,
        descricao = catalogo.descricao,
        produtos = catalogo.produtos.map { it.id }
)

fun mapCatalogoProduto(catalogo: Catalogo) = CatalogoProdutoResponse(
        id = catalogo.id,
        nome = catalogo.nome,
        status = catalogo.status,
        descricao = catalogo.descricao,
        produtos = catalogo.produtos.map { map(it) }
)