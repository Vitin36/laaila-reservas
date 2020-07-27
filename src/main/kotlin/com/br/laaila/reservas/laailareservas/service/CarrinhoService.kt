package com.br.laaila.reservas.laailareservas.service

import com.br.laaila.reservas.laailareservas.infrastructure.exception.NotFoundException
import com.br.laaila.reservas.laailareservas.infrastructure.exception.NotPermittedOperationException
import com.br.laaila.reservas.laailareservas.infrastructure.repository.CarrinhoRepository
import com.br.laaila.reservas.laailareservas.model.entity.Carrinho
import com.br.laaila.reservas.laailareservas.model.request.CarrinhoUpdate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class CarrinhoService(
        private val carrinhoRepository: CarrinhoRepository
) {

    @Autowired
    private lateinit var usuarioService: UsuarioService

    @Autowired
    private lateinit var produtoQuantidadeService: ProdutoQuantidadeService

    private val NOT_FOUND_MESSAGE = "Carrinho não encontrado"

    fun createByUsuario(usuarioId: Long): Carrinho {
        val usuario = usuarioService.findById(usuarioId).apply {
            if (this.carrinho !== null) {
                throw NotPermittedOperationException("Este usuário já possui um carrinho!")
            }
        }
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

    @Transactional
    open fun updateCarrinho(carrinhoUpdate: CarrinhoUpdate) {
        findById(carrinhoUpdate.carrinhoId).itens
                .forEach { produtoQuantidadeService.delete(it.id) }
        carrinhoUpdate.itens
                .filter { it.quantidade > 0 }
                .forEach { produtoQuantidadeService.create(carrinhoUpdate.carrinhoId, it) }
    }

}