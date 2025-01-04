package Projeto_padaria;

import java.util.ArrayList;
import java.util.List;

public class Venda {
    private List<ItemVenda> itens;
    private double total;
    private MetodoPagemanto metodoPagemanto;

    public enum MetodoPagemanto {
        DINHEIRO, DEBITO, CREDITO, PIX
    }

    public Venda() {
        this.itens = new ArrayList<>();
        this.total = 0.0;
    }

    public void adiconarItem(Produto produto, int quantidade, Estoque estoque){
        if(produto.getQuantidade() < quantidade){
            System.out.println("Estoque insuficiente para o produto: " + produto.getNome());
            return;
        }
        // Atualizar o estoque
        estoque.atualizarEstoque(produto.getId(), produto.getQuantidade() - quantidade);

        // Adicionar item a venda
        ItemVenda item = new ItemVenda(produto, quantidade);
        itens.add(item);
        total += item.getSubTotal();

        System.out.println("Item adicionado: " + produto.getNome());

    }
    // Calculando o desconto
    private double calcularDesconto(){
        if(total >= 50 && (metodoPagemanto == MetodoPagemanto.DINHEIRO || metodoPagemanto == MetodoPagemanto.DEBITO)) {
            return  total * 0.05; // 5% de desconto;
        }
        return 0.0;
    }


    // Finalizando a venda
    public void finalizarVenda(MetodoPagemanto metodoPagemanto) {
        this.metodoPagemanto = metodoPagemanto;
        double desconto = calcularDesconto();


        System.out.println("Venda finalizada!");
        System.out.println("Itens vendidos: ");
        for(ItemVenda item : itens) {
            System.out.println(item);
        }
        System.out.println("Método de pagamento: " + metodoPagemanto);
        if(desconto > 0){
            System.out.println("Desconto aplicado: R$" + desconto);
        }
        System.out.println("Total da venda: R$" + (total - desconto));
    }

    public double getTotal() {
        return total;
    }
}
