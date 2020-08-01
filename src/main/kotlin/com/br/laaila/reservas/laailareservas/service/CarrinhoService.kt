package com.br.laaila.reservas.laailareservas.service

import com.br.laaila.reservas.laailareservas.infrastructure.exception.NotFoundException
import com.br.laaila.reservas.laailareservas.infrastructure.repository.CarrinhoRepository
import com.br.laaila.reservas.laailareservas.infrastructure.repository.ProdutoQuantidadeRepository
import com.br.laaila.reservas.laailareservas.model.entity.Carrinho
import com.br.laaila.reservas.laailareservas.model.entity.ProdutoQuantidade
import com.br.laaila.reservas.laailareservas.model.entity.Usuario
import com.br.laaila.reservas.laailareservas.model.request.CarrinhoUpdate
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CarrinhoService(
        private val carrinhoRepository: CarrinhoRepository,
        private val produtoQuantidadeRepository: ProdutoQuantidadeRepository,
        private val produtoService: ProdutoService
) {

    private val NOT_FOUND_MESSAGE = "Carrinho não encontrado"

    fun createByUsuario(usuario: Usuario): Carrinho {
        return carrinhoRepository.save(Carrinho(usuario = usuario))
    }

    fun findByUsuario(usuarioId: Long): Carrinho {
        return carrinhoRepository.findByUsuario_Id(usuarioId)
                .orElseThrow { NotFoundException(NOT_FOUND_MESSAGE) }
    }

    fun findById(id: Long): Carrinho {
        return carrinhoRepository.findById(id)
                .orElseThrow { NotFoundException(NOT_FOUND_MESSAGE) }
    }

    fun updateCarrinho(carrinhoUpdate: CarrinhoUpdate) {
        val carrinho = findById(carrinhoUpdate.carrinhoId)
        carrinho.itens.forEach { produtoQuantidadeRepository.deleteById(it.id) }
        carrinhoUpdate.itens
                .filter { it.quantidade > 0 }
                .forEach {
                    val produto = produtoService.findById(it.produtoId)
                    produtoQuantidadeRepository.save(ProdutoQuantidade(
                            quantidade = it.quantidade,
                            produto = produto,
                            carrinho = carrinho
                    ))
                }
    }

}