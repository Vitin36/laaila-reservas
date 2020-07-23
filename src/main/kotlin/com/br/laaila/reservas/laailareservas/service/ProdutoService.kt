package com.br.laaila.reservas.laailareservas.service

import com.br.laaila.reservas.laailareservas.infrastructure.exception.DependentEntityNotFound
import com.br.laaila.reservas.laailareservas.infrastructure.exception.NotFoundException
import com.br.laaila.reservas.laailareservas.infrastructure.repository.ProdutoRepository
import com.br.laaila.reservas.laailareservas.model.entity.Produto
import com.br.laaila.reservas.laailareservas.model.mapper.map
import com.br.laaila.reservas.laailareservas.model.request.ProdutoCreate
import com.br.laaila.reservas.laailareservas.model.request.ProdutoUpdate
import org.springframework.stereotype.Service

@Service
class ProdutoService(
        private val repository: ProdutoRepository,
        private val catalogoService: CatalogoService
) {

    private val NOT_FOUND_MESSAGE = "Produto não encontrado"

    fun findById(id: Long): Produto {
        return repository.findById(id).orElseThrow { NotFoundException(NOT_FOUND_MESSAGE) }
    }

    fun findAll(): List<Produto> {
        return repository.findAll()
    }

    fun create(produtoCreate: ProdutoCreate): Produto {
        try {
            return repository.save(
                    map(produtoCreate, catalogoService.findById(produtoCreate.catalogo))
            )
        } catch (ex: NotFoundException) {
            throw DependentEntityNotFound("Catalogo não encontrado")
        }
    }

    fun update(id: Long, produtoUpdate: ProdutoUpdate): Produto {
        return repository.save(repository.findById(id)
                .orElseThrow { NotFoundException(NOT_FOUND_MESSAGE) }
                .apply {
                    this.nome = produtoUpdate.nome ?: this.nome
                    this.valor = produtoUpdate.valor ?: this.valor
                    this.descricao = produtoUpdate.descricao ?: this.descricao
                    produtoUpdate.catalogo?.let {
                        this.catalogo = catalogoService.findById(it)
                    }
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