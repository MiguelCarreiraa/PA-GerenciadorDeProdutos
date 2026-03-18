package com.Carreira.PA_GerenciadorDeProdutos.repositories;

import com.Carreira.PA_GerenciadorDeProdutos.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

}
