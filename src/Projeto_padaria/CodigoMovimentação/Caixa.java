package Projeto_padaria.CodigoMovimentação;

import java.util.ArrayList;
import java.util.List;

public class Caixa {
    private double saldo;
    private List<Movimentacao> movimentacoes;

    public Caixa(double saldo) {
        this.saldo = saldo;
        this.movimentacoes = new ArrayList<>();
    }

    // Registrar entrada
    public void registrarEntrada(String descricao, double valor) {
        if( valor > saldo) {
            System.out.println("Saldo insuficiente para registrar saída.");
            return;
        }
        saldo += valor;
        movimentacoes.add(new Movimentacao(descricao, valor,"ENTRADA"));
        System.out.println("Entrada registrada: " + descricao + " - R$" + valor);
    }

    public double getSaldoAtual(){
        return saldo;
    }

    // Exibir as movimentações
    public void exibirMovimentacoes() {
        System.out.println("Histórico de movimentações");
        for(Movimentacao movimentacao : movimentacoes) {
            System.out.println(movimentacao);
        }
        System.out.println("Saldo atual: R$" + saldo);
    }
}
