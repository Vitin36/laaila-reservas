package com.br.laaila.reservas.laailareservas.service

import com.br.laaila.reservas.laailareservas.infrastructure.repository.CatalogoRepository
import com.br.laaila.reservas.laailareservas.model.entity.Catalogo
import com.br.laaila.reservas.laailareservas.model.mapper.map
import com.br.laaila.reservas.laailareservas.model.request.CatalogoCreate
import com.br.laaila.reservas.laailareservas.model.request.CatalogoUpdate
import com.br.laaila.reservas.laailareservas.infrastructure.exception.NotFoundException
import org.springframework.stereotype.Service

@Service
class CatalogoService(
        private val repository: CatalogoRepository
) {

    private val NOT_FOUND_MESSAGE = "Catalogo não encontrado"

    fun findById(id: Long): Catalogo {
        return repository.findById(id).orElseThrow { NotFoundException(NOT_FOUND_MESSAGE) }
    }

    fun findAll(): List<Catalogo> {
        return repository.findAll()
    }

    fun create(catalogo: CatalogoCreate): Catalogo {
        return repository.save(map(catalogo))
    }

    fun update(id: Long, catalogo: CatalogoUpdate): Catalogo {
        return repository.save(repository.findById(id)
                .orElseThrow { NotFoundException(NOT_FOUND_MESSAGE) }
                .apply {
                    this.nome = catalogo.nome ?: this.nome
                    this.status = catalogo.status ?: this.status
                    this.descricao = catalogo.descricao ?: this.descricao
                }
        )
    }

    fun delete(id: Long) {
        repository.findById(id)
                .orElseThrow { NotFoundException(NOT_FOUND_MESSAGE) }
                .run {
                    repository.deleteById(id)
                }
    }

}