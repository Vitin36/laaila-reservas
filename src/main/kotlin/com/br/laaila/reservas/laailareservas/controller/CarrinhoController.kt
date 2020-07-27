package com.br.laaila.reservas.laailareservas.controller

import com.br.laaila.reservas.laailareservas.model.mapper.map
import com.br.laaila.reservas.laailareservas.model.request.CarrinhoUpdate
import com.br.laaila.reservas.laailareservas.model.response.CarrinhoResponse
import com.br.laaila.reservas.laailareservas.service.CarrinhoService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("carrinho")
class CarrinhoController(
        private val carrinhoService: CarrinhoService
) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findByUsuarioId(@RequestParam("usuarioId") usuarioId: Long): CarrinhoResponse {
        return map(carrinhoService.findByUsuario(usuarioId))
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(@PathVariable("id") id: Long): CarrinhoResponse {
        return map(carrinhoService.findById(id))
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCarrinho(@RequestBody @Valid carrinhoUpdate: CarrinhoUpdate) {
        carrinhoService.updateCarrinho(carrinhoUpdate)
    }

}