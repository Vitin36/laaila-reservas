package com.br.laaila.reservas.laailareservas.controller

import com.br.laaila.reservas.laailareservas.model.mapper.map
import com.br.laaila.reservas.laailareservas.model.request.CatalogoStatusUpdate
import com.br.laaila.reservas.laailareservas.model.request.UsuarioCreate
import com.br.laaila.reservas.laailareservas.model.request.UsuarioStatusUpdate
import com.br.laaila.reservas.laailareservas.model.response.UsuarioResponse
import com.br.laaila.reservas.laailareservas.service.UsuarioService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/usuario")
class UsuarioController(
        private val usuarioService: UsuarioService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun create(@RequestBody @Valid create: UsuarioCreate): UsuarioResponse {
        return map(usuarioService.create(create))
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findById(@RequestParam("email") email: String): UsuarioResponse {
        return map(usuarioService.findById(email))
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateStatus(@RequestBody @Valid usuarioStatusUpdate: UsuarioStatusUpdate) {
        usuarioService.updateStatus(usuarioStatusUpdate)
    }

}