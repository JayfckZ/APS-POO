package classes;
import java.time.LocalDate;

public class Tarefa {
    public String titulo;
    public String descricao;
    public LocalDate prazo;
    public Operador funcionario;
    public String status;
    
    public Tarefa(String tit, String desc, LocalDate prz, Operador func) {
        this.titulo = tit;
        this.descricao = desc;
        this.prazo = prz;
        this.funcionario = func;
        this.status = "Pendente";
    }
    
    // ---------- getter e setter ----------
    
    // add as funcoes
}
