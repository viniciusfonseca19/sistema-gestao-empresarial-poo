package controller;

import dto.ProdutoRequest;
import service.ProdutoService;

public class ProdutoController {

    private final ProdutoService service;


    public ProdutoController(ProdutoService produtoService) {
        this.service = produtoService;
    }

    public boolean cadastrarProduto(String nome, Double preco, Integer estoque) {

        ProdutoRequest request = new ProdutoRequest();

        request.setNome(nome);
        request.setPreco(preco);
        request.setEstoque(estoque);

        return service.cadastrar(request);

    }
}
