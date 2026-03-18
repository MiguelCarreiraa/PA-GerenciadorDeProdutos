package com.Carreira.PA_GerenciadorDeProdutos.controllers;


import com.Carreira.PA_GerenciadorDeProdutos.models.ProdutoModel;
import com.Carreira.PA_GerenciadorDeProdutos.repositories.ProdutoRepository;
import com.Carreira.PA_GerenciadorDeProdutos.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path ="/produtos")
public class ProdutoController {

        @Autowired
        private ProdutoService produtoService;

        @GetMapping
        public List<ProdutoModel> findAll(){
            return produtoService.findAll();
        }

        @PostMapping
        public ProdutoModel criarProduto(@RequestBody ProdutoModel produtoModel){
            return  produtoService.criarProduto(produtoModel);
        }

        @GetMapping("/{id}")
        public Optional<ProdutoModel> buscarId(@PathVariable("id") Long id){
            return produtoService.buscarPorId(id);
        }

        @PutMapping("/{id}")
        public ProdutoModel atualizarProduto(@PathVariable("id") long id,@RequestBody ProdutoModel produtoModel ){
            return  produtoService.atualizar(id,produtoModel);
        }

        @DeleteMapping("/{id}")
        public void deletarProduto(@PathVariable("id") Long id){
            produtoService.deletar(id);
        }
}
