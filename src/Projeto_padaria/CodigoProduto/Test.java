package Projeto_padaria.CodigoProduto;

public class Test {
    public static void main(String[] args) {
        // Criando a instância do estoque.
        Estoque estoque = new Estoque();

        Produto p1 = new Produto(1,"Pão",0.75,1000,"Padaria");
        Produto p2 = new Produto(2,"Torta de morango (Fatia)",5.0,200,"Doces");
        Produto p3 = new Produto(3,"Coxinha", 7.50,500,"Salgado");
        Produto p4 = new Produto(4,"Caixa de leite", 4.50, 40, "Bebidas");
        Produto p5 = new Produto(5,"Pão de queijo", 5.0, 60, "Padaria");
        Produto p6 = new Produto(6,"Bolo de chocolate", 25, 20, "Doces");

        // Adicionando produtos ao estoque
        estoque.adicionarProduto(p1);
        estoque.adicionarProduto(p2);
        estoque.adicionarProduto(p3);
        estoque.adicionarProduto(p4);
        estoque.adicionarProduto(p5);
        estoque.adicionarProduto(p6);

        // Testando a listagem de todos os produtos
        estoque.listaProdutos();

        // Testando a busca por nome
        System.out.println("\nBuscando produtos por nome 'Pão': ");
        estoque.buscarPorNome("Pão");

        // Testando a busca por ID
        System.out.println("\nBuscando produtos por ID 3: ");
        Produto produtoBuscado = estoque.buscarPorID(3);
        if(produtoBuscado != null) {
            System.out.println(produtoBuscado);
        }

        // Testando filtro por categoria
        System.out.println("\nFiltrando produtos por categoria 'Bebidas': ");
        estoque.filtrarPorCategoria("Bebidas");

        // Testando filtro por faixa de preço
        System.out.println("\nFiltrando produtos por faixa de preço 0.0 - 5.0: ");
        estoque.filtrarPorPreco(0.0 , 5.0);

        // Testando filtro por estoque critico (quantidade < 50)
        System.out.println("\nFiltrando produtos com estoque abaixo de 50 unidades: ");
        estoque.filtrarPorEstoqueCritico(50);

        // Testando atualização de estoque
        System.out.println("\nAtualizando o estoque do produto com ID 2 para 40 unidades: ");
        estoque.atualizarEstoque(2, 40);
        estoque.listaProdutos();

        // Testando a remoção de produto
        System.out.println("\nRemovendo o produto com ID 1: ");
        estoque.removerProduto(1);
        estoque.listaProdutos();
    }
}
