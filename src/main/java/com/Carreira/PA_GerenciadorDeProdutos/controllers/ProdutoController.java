package com.Carreira.PA_GerenciadorDeProdutos.controllers;


import com.Carreira.PA_GerenciadorDeProdutos.models.ProdutoModel;
import com.Carreira.PA_GerenciadorDeProdutos.repositories.ProdutoRepository;
import com.Carreira.PA_GerenciadorDeProdutos.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> findAllProduto(){
        return ResponseEntity.ok(produtoService.findAll());
    }

    @PostMapping
    public ResponseEntity<ProdutoModel> criarProduto(@RequestBody ProdutoModel produtoModel){
        ProdutoModel novo = produtoService.criarProduto(produtoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoModel> buscarId(@PathVariable Long id){
        Optional<ProdutoModel> produto = produtoService.buscarPorId(id);

        if (produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoModel> atualizarProduto(@PathVariable Long id,
                                                         @RequestBody ProdutoModel produtoModel){
        Optional<ProdutoModel> existente = produtoService.buscarPorId(id);

        if (existente.isPresent()) {
            ProdutoModel atualizado = produtoService.atualizar(id, produtoModel);
            return ResponseEntity.ok(atualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id){
        Optional<ProdutoModel> existente = produtoService.buscarPorId(id);

        if (existente.isPresent()) {
            produtoService.deletar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
