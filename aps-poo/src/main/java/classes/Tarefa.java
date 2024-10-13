package classes;
import java.time.LocalDate;

public class Tarefa {
    public String titulo;
    public String descricao;
    public LocalDate prazo;
    public Operador funcionario;
    public String status;
    
    public Tarefa(String tit, String desc, LocalDate prz) {
        this.titulo = tit;
        this.descricao = desc;
        this.prazo = prz;
        this.funcionario = null;
        this.status = "Pendente";
    }
    
    // ---------- getter e setter ----------
    
    public void setFuncionario(Operador func) {
        this.funcionario = func;
    }
    
    public void alteraStatus() {
        this.status = "Concluída";
    }
}
