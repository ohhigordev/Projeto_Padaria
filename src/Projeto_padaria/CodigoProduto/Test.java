package Projeto_padaria.CodigoProduto;

public class Test {
    public static void main(String[] args) {
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

        //

    }




}
