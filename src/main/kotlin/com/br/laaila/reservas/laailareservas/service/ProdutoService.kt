package com.br.laaila.reservas.laailareservas.service

import com.br.laaila.reservas.laailareservas.infrastructure.exception.NotFoundException
import com.br.laaila.reservas.laailareservas.infrastructure.repository.ProdutoRepository
import com.br.laaila.reservas.laailareservas.model.entity.Produto
import com.br.laaila.reservas.laailareservas.model.mapper.map
import com.br.laaila.reservas.laailareservas.model.request.ProdutoCreate
import com.br.laaila.reservas.laailareservas.model.request.ProdutoUpdate
import org.springframework.stereotype.Service

@Service
class ProdutoService(
        private val repository: ProdutoRepository
) {
    fun create(produtoCreate: ProdutoCreate): Produto {
        return repository.save(map(produtoCreate))
    }

    fun update(id: Long, produtoUpdate: ProdutoUpdate): Produto {
        return repository.save(repository.findById(id)
                .orElseThrow { NotFoundException() }
                .apply {
                    this.nome = produtoUpdate.nome ?: this.nome
                    this.valor = produtoUpdate.valor ?: this.valor
                }
        )
    }

    fun delete(id: Long) {
        repository.findById(id)
                .orElseThrow { NotFoundException() }
                .run {
                    repository.deleteById(id)
                }
    }
}