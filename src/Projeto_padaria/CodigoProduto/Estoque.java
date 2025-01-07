package Projeto_padaria.CodigoProduto;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Produto> produtos;

    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    // Adicionando produtos com validação
    public void adicionarProduto(Produto produto) {
        if(produto == null) {
            System.out.println("Erro: Produto invalido!");
            return;
        }

        // Verificando se o produto já existe
        for(Produto p : produtos) {
            if(p.getId() == produto.getId()) {
                System.out.println("Erro: O ID " + produto.getId() + " já está em uso.");
                return;
            }
        }
        produtos.add(produto);
        System.out.println("Produto adicionado com sucesso: " + produto.getNome());
    }

    // Remover produtos com validação
    public void removerProduto(int id) {
        boolean produtoRemovido = produtos.removeIf(produto -> produto.getId() == id);

        if(produtoRemovido) {
            System.out.println("Produto com o ID " + id + " foi removido.");
        }else {
            System.out.println("Erro: Nenhum produto foi encontrado com o ID " + id + ".");
        }
    }

    // Atualizar o estoque com validação
    public void atualizarEstoque(int id, int quantidade) {
        if(quantidade < 0) {
            System.out.println("Erro: A quantidade tem que ser positiva");
            return;
        }

       for(Produto produto : produtos) {
           if(produto.getId() == id) {
               produto.setQuantidade(quantidade);
               System.out.println("Estoque atualizado para o produto: " + produto.getNome());
               return;
           }
       }
        System.out.println("O produto com o ID " + id + " não foi encontrado.");
    }

    // Lista de produtos com validação
    public void listaProdutos() {
        if(produtos.isEmpty()) {
            System.out.println("O estoque está vazio");
            return;
        }

        System.out.println("Produtos no estoque: ");
        for(Produto produto : produtos) {
            System.out.println(produto);
        }
    }
    /* Agora vamos fazer os metódos de busca e filtragem de produtos no nosso estoque. */

    // Buscando produtos por nome
    public void buscarPorNome(String nome) {
        boolean encontrado = false;
        System.out.println("Produtos encontrados com o nome '" + nome + "':");
        for(Produto p : produtos) {
            if(p.getNome().toLowerCase().contains(nome.toLowerCase())) {
                System.out.println(p);
                encontrado = true;
            }
        }
        if(!encontrado) {
            System.out.println("Nenhum produto encontrado com o nome '" + nome + "'.");
        }
    }

    // Buscando produtos pelo ID
    public Produto buscarPorID(int id) {
        for(Produto p : produtos) {
            if(p.getId() == id){
                return p;
            }
        }
        System.out.println("Nenhum produto encontrado com o ID " + id + ".");
        return null;
    }

    // Filtrando produtos pela categoria
    public void filtrarPorCategoria(String categoria) {
        boolean encontrado = false;
        System.out.println("Produtos por categoria '" + categoria + "':");
        for (Produto p : produtos) {
            if(p.getCategoria().equalsIgnoreCase(categoria)) {
                System.out.println(p);
                encontrado = true;
            }
        }
        if(!encontrado) {
            System.out.println("Nenhum produto encontrado na categoria '" + categoria + "'.");
            return;
        }
    }

    // Filtrando por faixa de preço
    public void filtrarPorPreco(double precoMin, double precoMax) {
       boolean encontrado = false;
        System.out.println("Produtos por faixa de preço: R$" + precoMin + " - R$" + precoMax);
        for(Produto p : produtos) {
            if(p.getPreco() >= precoMin && p.getPreco() <= precoMax) {
                System.out.println(p);
                encontrado = true;
            }
        }
        if(!encontrado) {
            System.out.println("Nenhum produto encontrado na faixa de preço especificada.");
        }
    }

    // Filtrando por estoque crítico
    public void filtrarPorEstoqueCritico(int limite) {
        boolean encontrado = false;
        System.out.println("Produtos com estoque abaixo de " + limite + " unidades: ");
        for(Produto p : produtos) {
            if(p.getQuantidade() < limite) {
                System.out.println(p);
                encontrado = true;
            }
        }
        if(!encontrado) {
            System.out.println("Nenhum produto com estoque crítico foi encontrado.");
        }
    }
}
