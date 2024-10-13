package classes;

public class Funcionario {
    public String nome;
    public String cpf;
    private float salario;
    public String funcao;
    public int id;
    public String login;
    public String senha;
    
    // ---------- getters e setters ----------
    
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nm) {
        this.nome = nm;
    }
    
    public String getCpf() {
        return this.cpf;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public float getSalario() {
        return this.salario;
    }
    
    public void setSalario(float sal) {
        this.salario = sal;
    }
    
    public String getFuncao() {
        return this.funcao;
    }
    
    public void setFuncao(String func) {
        this.funcao = func;
    }
}
