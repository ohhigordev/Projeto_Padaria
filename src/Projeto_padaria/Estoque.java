package Projeto_padaria;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Produto> produtos;

    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    // Adicionando produtos
    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
        System.out.println("Produto adicionado: " + produto.getNome());
    }

    // Remover produtos
    public void removerProduto(int id) {
        produtos.removeIf(produto -> produto.getId() == id);
        System.out.println("Produto com o ID " + id + " foi removido.");
    }

    // Atualizar o estoque
    public void atualizarEstoque(int id, int quantidade) {
       for(Produto produto : produtos) {
           if(produto.getId() == id) {
               produto.setQuantidade(quantidade);
               System.out.println("Estoque atualizado para o produto: " + produto.getNome());
               return;
           }
       }
        System.out.println("O produto com o ID " + id + " não foi encontrado.");
    }

    // Lista de produtos
    public void listaProdutos() {
        System.out.println("Produtos no estoque: ");
        for(Produto produto : produtos) {
            System.out.println(produto);
        }
    }
}
