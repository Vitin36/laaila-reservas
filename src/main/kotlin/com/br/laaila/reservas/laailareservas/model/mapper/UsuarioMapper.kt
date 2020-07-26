package com.br.laaila.reservas.laailareservas.model.mapper

import com.br.laaila.reservas.laailareservas.model.entity.Usuario
import com.br.laaila.reservas.laailareservas.model.request.UsuarioCreate
import com.br.laaila.reservas.laailareservas.model.response.UsuarioResponse

fun map(usuarioCreate: UsuarioCreate): Usuario = Usuario(
        email = usuarioCreate.email,
        senha = usuarioCreate.senha,
        nome = usuarioCreate.nome,
        contato = usuarioCreate.contato,
        externalClientId = usuarioCreate.externalClientId,
        externalClientType = usuarioCreate.externalClientType
)

fun map(usuario: Usuario): UsuarioResponse = UsuarioResponse(
        id = usuario.id,
        email = usuario.email,
        nome = usuario.nome,
        contato = usuario.contato,
        permissao = usuario.permissao,
        ativo = usuario.ativo,
        externalClientId = usuario.externalClientId,
        externalClientType = usuario.externalClientType
)