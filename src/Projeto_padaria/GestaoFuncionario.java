package Projeto_padaria;

import java.util.ArrayList;
import java.util.List;

public class GestaoFuncionario {
    private List<Funcionario> funcionarios;

    public GestaoFuncionario() {
        this.funcionarios = new ArrayList<>();
    }

    // Adicionar um funcionário
    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        System.out.println("Funcionário adicionado: " + funcionario.getNome());
    }

    // Remover funcionários
    public void removerFuncionario(int id) {
        funcionarios.removeIf(funcionario -> funcionario.getId() == id);
        System.out.println("Funcionário " + id + " foi removido.");
    }

    // Altualizar funcionário
    public void atualizarFuncionario(int id, String nome, String cargo, double salario) {
        for(Funcionario funcionario : funcionarios){
            if(funcionario.getId() == id) {
                funcionario.setNome(nome);
                funcionario.setCargo(cargo);
                funcionario.setSalario(salario);
                System.out.println("OS dados do funcionário com o ID " + id + " foram atualizados.");
            }
        }
        System.out.println("OS dados do funcionário com o ID " + id + " não foram encontrados.");
    }

    // Exibir a lista de funcionários
    public void listarFuncionarios() {
        System.out.println("Lista de funcionários: ");
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }
    }
}
