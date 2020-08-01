package com.br.laaila.reservas.laailareservas.controller

import com.br.laaila.reservas.laailareservas.model.mapper.map
import com.br.laaila.reservas.laailareservas.model.mapper.mapCatalogoProduto
import com.br.laaila.reservas.laailareservas.model.request.CatalogoCreate
import com.br.laaila.reservas.laailareservas.model.request.CatalogoStatusUpdate
import com.br.laaila.reservas.laailareservas.model.request.CatalogoUpdate
import com.br.laaila.reservas.laailareservas.model.response.CatalogoProdutoResponse
import com.br.laaila.reservas.laailareservas.model.response.CatalogoResponse
import com.br.laaila.reservas.laailareservas.service.CatalogoService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("catalogo")
class CatalogoController(
        private val catalogoService: CatalogoService
) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun findAll(): List<CatalogoResponse> {
        return catalogoService.findAll().map { map(it) }
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: UUID): CatalogoProdutoResponse {
        return mapCatalogoProduto(catalogoService.findById(id))
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun create(@RequestBody @Valid create: CatalogoCreate): CatalogoResponse {
        return map(catalogoService.create(create))
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun update(@PathVariable("id") id: UUID, @RequestBody @Valid update: CatalogoUpdate): CatalogoResponse {
        return map(catalogoService.update(id, update))
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateStatus(@RequestBody @Valid catalogoStatusUpdate: CatalogoStatusUpdate) {
        catalogoService.updateStatus(catalogoStatusUpdate)
    }

}