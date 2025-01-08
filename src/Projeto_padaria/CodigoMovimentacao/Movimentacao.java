package Projeto_padaria.CodigoMovimentacao;

import java.time.LocalDateTime;

public class Movimentacao {
    private String descricao;
    private double valor;
    private LocalDateTime dataHora;
    private String tipo;// "ENTRADA" ou "SAÍDA"
    private String categoria; // Nova categoria

    public Movimentacao(String descricao, double valor, String tipo, String categoria) {
        this.descricao = descricao;
        this.valor = valor;
        this.dataHora = LocalDateTime.now();
        this.tipo = tipo;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "[" + dataHora + "]" + tipo + " - " + categoria + ": " + descricao + " - R$" + valor;
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

    public String getCategoria() {
        return categoria;
    }
}
