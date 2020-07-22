package com.br.laaila.reservas.laailareservas.controller

import com.br.laaila.reservas.laailareservas.model.mapper.map
import com.br.laaila.reservas.laailareservas.model.request.ProdutoCreate
import com.br.laaila.reservas.laailareservas.model.request.ProdutoUpdate
import com.br.laaila.reservas.laailareservas.model.response.ProdutoCreatedOrUpdated
import com.br.laaila.reservas.laailareservas.service.ProdutoService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping(value = "/produto")
class ProdutoController(
        private val produtoService: ProdutoService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun create(@RequestBody @Valid produtoCreate: ProdutoCreate): ProdutoCreatedOrUpdated {
        return map(produtoService.create(produtoCreate))
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun update(@PathVariable("id") id: Long,
               @RequestBody @Valid produtoUpdate: ProdutoUpdate): ProdutoCreatedOrUpdated {
        return map(produtoService.update(id, produtoUpdate))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable("id") id: Long) {
        produtoService.delete(id)
    }

}