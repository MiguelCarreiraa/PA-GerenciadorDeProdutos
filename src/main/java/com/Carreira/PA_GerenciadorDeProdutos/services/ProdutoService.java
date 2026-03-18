package com.Carreira.PA_GerenciadorDeProdutos.services;

import com.Carreira.PA_GerenciadorDeProdutos.models.ProdutoModel;
import com.Carreira.PA_GerenciadorDeProdutos.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoModel> findAll(){
        return produtoRepository.findAll();
    }

    public ProdutoModel criarProduto(ProdutoModel produtoModel) {
        return produtoRepository.save(produtoModel);
    }

    public Optional<ProdutoModel> buscarPorId(Long id){
        return produtoRepository.findById(id);
    }

    public ProdutoModel atualizar(Long id, ProdutoModel produtoModel){
        ProdutoModel model = produtoRepository.findById(id).get();
        model.setEstoque(produtoModel.getEstoque());
        model.setNome(produtoModel.getNome());
        model.setPreco(produtoModel.getPreco());
        return produtoRepository.save(model);
    }

    public void deletar(Long id ){
        produtoRepository.deleteById(id);
    }
}
