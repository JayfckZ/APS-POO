package classes;

import java.io.*;
import java.util.ArrayList;
import java.time.LocalDate;

public class Empresa {
    public static ArrayList<Funcionario> funcionarios = new ArrayList();
    public static ArrayList<Tarefa> tarefas = new ArrayList();
    
    private static final String FUNCIONARIOS_FILE_PATH = "funcionarios.csv";
    private static final String TAREFAS_FILE_PATH = "tarefas.csv";
    
    public static ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    
    public static void addFuncionario(Funcionario func) {
        funcionarios.add(func);
        System.out.println("Funcionário criado: " + func.nome);
    }

    public static ArrayList<Tarefa> getTarefas() {
        return tarefas;
    }
    
    public static void addTarefa(Tarefa tarf) {
        tarefas.add(tarf);
        System.out.println("Tarefa criada: " + tarf.titulo);
    }
    
    //  savar os funcionarios em um CSV
    public static void salvarFuncionarios() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FUNCIONARIOS_FILE_PATH))) {
            for (Funcionario funcionario : funcionarios) {
                String linha = funcionarioToCSV(funcionario);
                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // carregar todos os funcionarios de um CSV e transformá-los em ArrayList
    public static void carregarFuncionarios() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FUNCIONARIOS_FILE_PATH))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (csvToFuncionario(linha) != null) {
                    funcionarios.add(csvToFuncionario(linha));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // savar as tarefas em um CSV
    public static void salvarTarefas() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TAREFAS_FILE_PATH))) {
            for (Tarefa tarefa : tarefas) {
                String linha = tarefaToCSV(tarefa);
                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // carregar todos as tarefas de um CSV e transformá-los em ArrayList
    public static void carregarTarefas() {
        try (BufferedReader reader = new BufferedReader(new FileReader(TAREFAS_FILE_PATH))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                Tarefa tarefa = csvToTarefa(linha);
                if (tarefa != null) {
                    tarefas.add(tarefa);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // métodos conversores entre CSV e obijeto
    private static String funcionarioToCSV(Funcionario funcionario) {
        if (funcionario instanceof Gerente) {
            Gerente gerente = (Gerente) funcionario;
            return String.join(",", "Gerente", gerente.getNome(), gerente.getCpf(),
                    String.valueOf(gerente.getSalario()), gerente.getFuncao(),
                    String.valueOf(gerente.id), gerente.login, gerente.senha,
                    String.valueOf(gerente.getBonus()));
        } else if (funcionario instanceof Operador) {
            Operador operador = (Operador) funcionario;
            return String.join(",", "Operador", operador.getNome(), operador.getCpf(),
                    String.valueOf(operador.getSalario()), operador.getFuncao(),
                    String.valueOf(operador.id), operador.login, operador.senha);
        }
        return "";
    }

    private static Funcionario csvToFuncionario(String linha) {
        String[] campos = linha.split(",");
        String tipo = campos[0];
        String nome = campos[1];
        String cpf = campos[2];
        float salario = Float.parseFloat(campos[3]);
        String funcao = campos[4];
        int id = Integer.parseInt(campos[5]);
        String login = campos[6];
        String senha = campos[7];

        if (tipo.equals("Gerente")) {
            float bonus = Float.parseFloat(campos[8]);
            return new Gerente(nome, cpf, salario, funcao, bonus, login, senha);
        } else if (tipo.equals("Operador")) {
            Operador func = new Operador(nome, cpf, salario, funcao, login, senha);
            func.tarefas = carregarTarefasOperador(cpf);
            return func;
        }
        return null;
    }
    
    private static ArrayList<Tarefa> carregarTarefasOperador(String cpfOperador) {
        ArrayList<Tarefa> tarefasOp = new ArrayList<>();
        String caminhoArquivoTarefas = "tarefas.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivoTarefas))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] campos = linha.split(",");
                String cpf = campos[0];
                if (cpf.equals(cpfOperador)) {  // verifica se a tarefa pertence ao operador
                    String titulo = campos[1];
                    String descricao = campos[2];
                    LocalDate prazo = LocalDate.parse(campos[3]);
                    String status = campos[4];

                    Tarefa tarefa = new Tarefa(titulo, descricao, prazo);
                    tarefa.status = status;
                    tarefasOp.add(tarefa);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return tarefasOp;
    }

    private static String tarefaToCSV(Tarefa tarefa) {
        String funcionarioCpf = tarefa.funcionario != null ? tarefa.funcionario.getCpf() : "null";
        return String.join(",",
                tarefa.titulo,
                tarefa.descricao,
                tarefa.prazo.toString(),
                funcionarioCpf,
                tarefa.status);
    }

    private static Tarefa csvToTarefa(String linha) {
        String[] campos = linha.split(",");
        String titulo = campos[0];
        String descricao = campos[1];
        LocalDate prazo = LocalDate.parse(campos[2]);
        String funcionarioCpf = campos[3];
        String status = campos[4];

        Tarefa tarefa = new Tarefa(titulo, descricao, prazo);
        tarefa.status = status;

        // associar a tarefa a um Operador, se o CPF for válido
        if (!funcionarioCpf.equals("null")) {
            for (Funcionario func : funcionarios) {
                if (func.getCpf().equals(funcionarioCpf) && func instanceof Operador) {
                    tarefa.setFuncionario((Operador) func);
                    break;
                }
            }
        }
        return tarefa;
    }

}