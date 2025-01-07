package Projeto_padaria.CodigoMovimentação;

import java.time.LocalDateTime;

public class Movimentacao {
    private String descricao;
    private double valor;
    private LocalDateTime dataHora;
    private String tipo; // "ENTRADA" ou "SAÍDA"

    public Movimentacao(String descricao, double valor, String tipo) {
        this.descricao = descricao;
        this.valor = valor;
        this.dataHora = LocalDateTime.now();
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "[" + dataHora + "]" + tipo + ": " + descricao + " - R$" + valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getTipo() {
        return tipo;
    }
}
