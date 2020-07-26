package com.br.laaila.reservas.laailareservas.model.response

import com.br.laaila.reservas.laailareservas.model.entity.ExternalType
import com.br.laaila.reservas.laailareservas.model.entity.Permissao

data class UsuarioResponse(
        val id: Long,
        val email: String,
        var nome: String,
        var ativo: Boolean,
        var contato: String? = null,
        var permissao: Permissao? = null,
        var externalClientType: ExternalType? = null,
        var externalClientId: String? = null
)