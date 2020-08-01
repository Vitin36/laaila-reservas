package com.br.laaila.reservas.laailareservas.controller

import com.br.laaila.reservas.laailareservas.model.mapper.map
import com.br.laaila.reservas.laailareservas.model.request.CatalogoStatusUpdate
import com.br.laaila.reservas.laailareservas.model.request.UsuarioCreate
import com.br.laaila.reservas.laailareservas.model.request.UsuarioStatusUpdate
import com.br.laaila.reservas.laailareservas.model.request.UsuarioUpdate
import com.br.laaila.reservas.laailareservas.model.response.UsuarioResponse
import com.br.laaila.reservas.laailareservas.service.UsuarioService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*
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

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(@PathVariable("id") id: UUID): UsuarioResponse {
        return map(usuarioService.findById(id))
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun update(@PathVariable("id") id: UUID, @RequestBody @Valid update: UsuarioUpdate): UsuarioResponse {
        return map(usuarioService.update(id, update))
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateStatus(@RequestBody @Valid usuarioStatusUpdate: UsuarioStatusUpdate) {
        usuarioService.updateStatus(usuarioStatusUpdate)
    }

}