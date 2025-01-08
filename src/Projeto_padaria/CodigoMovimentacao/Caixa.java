package Projeto_padaria.CodigoMovimentacao;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Caixa {
    private double saldo;
    private List<Movimentacao> movimentacoes;

    public Caixa(double saldo) {
        this.saldo = saldo;
        this.movimentacoes = new ArrayList<>();
    }

    // Formatação de valores
    private String formatarValor(double valor) {
        DecimalFormat df = new DecimalFormat("R$ #,##0.00"); // Padrão do BR;
        return df.format(valor);
    }


    // Registrar entrada com categoria
    public void registrarEntrada(String descricao, double valor, String categoria) {
        if( valor <= 0) { // Validação de valores inválidos
            System.out.println("Erro: O valor da entrada deve ser maior que zero.");
            return;
        }
        saldo += valor; // Atualizar saldo
        movimentacoes.add(new Movimentacao(descricao, valor,"ENTRADA", categoria));
        System.out.println("Entrada registrada: " + descricao + " - " + categoria + " - R$" + valor);
    }

    public double getSaldoAtual(){
        return saldo;
    }

    // Registrar saída com categoria
    public void registrarSaida(String descricao, double valor, String categoria) {
        if( valor <= 0) { // Validação de valores inválidos
            System.out.println("Erro: O valor da entrada deve ser maior que zero.");
            return;
        }
        if( valor > saldo) { // Verificação de saldo insuficiente
            System.out.println("Erro: Saldo insuficiente para realizar a saída");
            return;
        }
        saldo -= valor; // Atualizar saldo
        movimentacoes.add(new Movimentacao(descricao, valor, "SAIDA", categoria)); // Registrar movimentação de saída
        System.out.println("Saída registrada: " + descricao + " - " + categoria + " - R$" + valor);
    }


    // Exibir as movimentações por categoria
    public void exibirMovimentacoes(String categoria) {
        System.out.println("Movimentações na categoria: " + categoria);
        for(Movimentacao movimentacao : movimentacoes) {
            if(movimentacao.getCategoria().equalsIgnoreCase(categoria)) {
                System.out.println(movimentacao.getDescricao() + " - "
                                   + movimentacao.getTipo() + " : "
                                   + formatarValor(movimentacao.getValor()));

            }
        }
        System.out.println("Saldo atual: " + formatarValor(saldo));
    }

    // Exibindo movimentações por tipo
    public void exibirMovimentacoesPorTipo(String tipo) {
        System.out.println("Movimentações por tipo: ");
        for(Movimentacao movimentacao : movimentacoes) {
            if(movimentacao.getTipo().equalsIgnoreCase(tipo)) {
                System.out.println(
                        movimentacao.getDescricao() + " - "
                        + movimentacao.getTipo() + " : "
                        + formatarValor(movimentacao.getValor())
                );
            }
        }
    }

    // Exibir movimentação por intervalo de valores
    public void exibirMovimentacoesPorValor(double min, double max) {
        System.out.println("Movimentações entre R$" + formatarValor(min) + " e R$" + formatarValor(max));
        for(Movimentacao movimentacao : movimentacoes) {
            if(movimentacao.getValor() >= min && movimentacao.getValor() <= max) {
                System.out.println(
                        movimentacao.getDescricao() + " - "
                        + movimentacao.getTipo() + " : "
                        + formatarValor(movimentacao.getValor())
                );
            }
        }
    }

    // Exibir movimentações por descrição
    public void exibirMovimentacoesPorDescricao(String palavraChave) {
        System.out.println("Movimentações de conteúdo: " + palavraChave);
        for(Movimentacao movimentacao : movimentacoes) {
            if(movimentacao.getDescricao().toLowerCase().contains(palavraChave.toLowerCase())) {
                System.out.println(
                        movimentacao.getDescricao() + " - "
                        + movimentacao.getTipo() + " : "
                        + formatarValor(movimentacao.getValor())
                );
            }
        }
    }


    // Obter saldo atual formatado
    public String getSaldoFormatado() {
        return formatarValor(saldo);
    }

    // Gerar um relatório financeiro
    public void gerarRelatorio() {
        double totalEntradas = 0;
        double totalSaidas = 0;
        double lucroPrejuizo = 0;

        // Calculando o total de entradas, saídas, lucros/prejuízos.
        for(Movimentacao movimentacao : movimentacoes) {
            if(movimentacao.getTipo().equalsIgnoreCase("ENTRADA")) {
                totalEntradas += movimentacao.getValor();
            } else if (movimentacao.getTipo().equalsIgnoreCase("SAIDA")) {
                totalSaidas += movimentacao.getValor();
            }
        }
        lucroPrejuizo = totalEntradas - totalSaidas; // Calcula o lucro e o prejuizo

        // Exibindo o relatório
        System.out.println("====== RELATÓRIO DE MOVIMENTAÇÕES ======");
        System.out.println("Total de entradas: " + formatarValor(totalEntradas));
        System.out.println("Total de saídas: " + formatarValor(totalSaidas));
        System.out.println("Lucro/Prejuizo: " + formatarValor(lucroPrejuizo));
        System.out.println("Saldo final: " + formatarValor(saldo));
        System.out.println("Número de movimentações: " + movimentacoes.size());
    }
}
