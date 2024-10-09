package classes;
import java.util.ArrayList;

public class Operador extends Funcionario {
    public ArrayList<Tarefa> tarefas;
    
    public Operador(String nm, String cpf, float sal, String func) {
        this.nome = nm;
        this.cpf = cpf;
        this.setSalario(sal);
        this.funcao = func;
        this.tarefas = new ArrayList<>();
    }
    
    // ---------- getter e setter ----------
    
    public ArrayList<Tarefa>getTarefas() {
        return this.tarefas;
    }
    
    public void setTarefa(Tarefa tarf) {
        if (tarefas.size() < 3) {
            this.tarefas.add(tarf);
            System.out.println("Tarefa adicionada: " + tarf.titulo);
        } else {
            System.out.println("O funcionário já atingiu o limite de tarefas.");
        }
    }
}
