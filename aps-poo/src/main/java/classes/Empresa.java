package classes;
import java.util.ArrayList;

public class Empresa {
    public ArrayList<Operador> funcionarios;
    public ArrayList<Tarefa> tarefas;

    public ArrayList<Operador> getFuncionarios() {
        return this.funcionarios;
    }
    
    public void setFuncionario(Operador func) {
        this.funcionarios.add(func);
        System.out.println("Tarefa adicionada: " + func.nome);
    }

    public ArrayList<Tarefa> getTarefas() {
        return this.tarefas;
    }
    
    public void setTarefa(Tarefa tarf) {
        this.tarefas.add(tarf);
        System.out.println("Tarefa adicionada: " + tarf.titulo);
    }

}