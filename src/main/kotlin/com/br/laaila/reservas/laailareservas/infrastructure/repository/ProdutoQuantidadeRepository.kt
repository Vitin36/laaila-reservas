package com.br.laaila.reservas.laailareservas.infrastructure.repository

import com.br.laaila.reservas.laailareservas.model.entity.ProdutoQuantidade
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ProdutoQuantidadeRepository : JpaRepository<ProdutoQuantidade, Long> {
    fun findByProduto_IdAndCarrinho_Id(produtoId: Long, carrinhoId: Long): Optional<ProdutoQuantidade>
}