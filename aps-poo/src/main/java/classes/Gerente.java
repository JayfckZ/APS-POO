package classes;

public class Gerente extends Funcionario {
    public float bonus;
    
    public Gerente(String nm, String cpf, float sal, String func, float bns) {
        this.nome = nm;
        this.cpf = cpf;
        this.setSalario(sal);
        this.funcao = func;
        this.bonus = bns;
        this.id = 1;
    }
    
    // ---------- getter e setter ----------
    
    public float getBonus() {
        return this.bonus;
    }
    
    public void setBonus(float bns) {
        this.bonus = bns;
    }
    
    public float getSalario() {
        return super.getSalario() + this.bonus;
    }
    
    // ---------- demais funções ----------
   
    public void atribuiTarefa(Operador func, Tarefa tarf) {;
        func.setTarefa(tarf);
        tarf.setFuncionario(func);
    }
}
