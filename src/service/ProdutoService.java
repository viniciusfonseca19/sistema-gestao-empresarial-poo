package service;

import dto.ProdutoRequest;
import database.model.Produto;
import database.repository.ProdutoRepository;

public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService() {
        repository = new ProdutoRepository();
    }

    public boolean cadastrar(ProdutoRequest request){

        validarProduto(request);

        Produto produto = new Produto();

        produto.setNome(request.getNome());
        produto.setPreco(request.getPreco());
        produto.setEstoque(request.getEstoque());

        return repository.salvar(produto);
    }

    public void validarProduto(ProdutoRequest request){

        if (request.getNome() == null || request.getNome().isBlank()) {
            throw new IllegalArgumentException("O nome do produto é obrigatório.");
        }

        if (request.getPreco() == null || request.getPreco() <= 0) {
            throw new IllegalArgumentException("O preço deve ser maior que zero.");
        }

        if (request.getEstoque() == null || request.getEstoque() < 0) {
            throw new IllegalArgumentException("O estoque não pode ser negativo.");
        }
    }
}
