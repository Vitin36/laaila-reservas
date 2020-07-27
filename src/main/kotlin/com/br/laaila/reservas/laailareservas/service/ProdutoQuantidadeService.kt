package com.br.laaila.reservas.laailareservas.service

import com.br.laaila.reservas.laailareservas.infrastructure.exception.NotFoundException
import com.br.laaila.reservas.laailareservas.infrastructure.repository.ProdutoQuantidadeRepository
import com.br.laaila.reservas.laailareservas.model.entity.Carrinho
import com.br.laaila.reservas.laailareservas.model.entity.ProdutoQuantidade
import com.br.laaila.reservas.laailareservas.model.request.CarrinhoProdutoQuantidade
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProdutoQuantidadeService(
        private val produtoQuantidadeRepository: ProdutoQuantidadeRepository
) {

    @Autowired
    private lateinit var produtoService: ProdutoService

    @Autowired
    private lateinit var carrinhoService: CarrinhoService

    fun create(carrinhoId: Long, carrinhoProdutoQuantidade: CarrinhoProdutoQuantidade): ProdutoQuantidade {
        val produto = produtoService.findById(carrinhoProdutoQuantidade.produtoId)
        val carrinho = carrinhoService.findById(carrinhoId)
        return produtoQuantidadeRepository.save(
                ProdutoQuantidade(
                        quantidade = carrinhoProdutoQuantidade.quantidade,
                        produto = produto,
                        carrinho = carrinho
                )
        )
    }

    fun delete(id: Long) {
        produtoQuantidadeRepository.deleteById(id)
    }

}