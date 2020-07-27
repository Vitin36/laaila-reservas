package com.br.laaila.reservas.laailareservas.model.mapper

import com.br.laaila.reservas.laailareservas.model.entity.Carrinho
import com.br.laaila.reservas.laailareservas.model.response.CarrinhoResponse

fun map(carrinho: Carrinho): CarrinhoResponse = CarrinhoResponse(
        id = carrinho.id,
        itens = carrinho.itens.map { map(it) },
        usuario = carrinho.usuario.id
)