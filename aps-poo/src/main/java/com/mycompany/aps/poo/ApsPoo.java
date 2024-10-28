package com.mycompany.aps.poo;
import view.login;
import javax.swing.*;
import classes.*;

public class ApsPoo {

    public static void main(String[] args) {
        // carrega todos os funcionarios e tarefas dos arquivos CSV
        Empresa.carregarFuncionarios();
        Empresa.carregarTarefas();
        
        // abre a interface de login
        SwingUtilities.invokeLater(() -> {
            login tela_login = new login();
            tela_login.setVisible(true);
            System.out.println("Tudo certo!");
        });
        
    }
}
