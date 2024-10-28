package classes;
import java.util.ArrayList;

public class Operador extends Funcionario {
    public ArrayList<Tarefa> tarefas;
    
    public Operador(String nm, String cpf, float sal, String func, String login, String senha) {
        this.nome = nm;
        setCpf(cpf);
        this.setSalario(sal);
        this.funcao = func;
        this.tarefas = new ArrayList<>();
        this.login = login;
        this.senha = senha;
        this.id = 0;
    }
    
    // ---------- getter e setter ----------
    
    public ArrayList<Tarefa> getTarefas() {
        return this.tarefas;
    }
    
    public void setTarefa(Tarefa tarf) {
        this.tarefas.add(tarf);
        System.out.println("Tarefa adicionada: " + tarf.titulo);
    }
    
    // ---------- demais funcoes ----------
    // atualiza o status e logo após da lista
    public void realizaTarefa(Tarefa tarf) {
        tarf.alteraStatus();
        this.tarefas.remove(tarf);
    }
}
