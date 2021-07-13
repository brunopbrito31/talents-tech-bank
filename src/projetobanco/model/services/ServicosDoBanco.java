package projetobanco.model.services;

import projetobanco.model.entities.Banco;
import projetobanco.model.entities.usuarios.Gerente;

import java.util.Scanner;

public class ServicosDoBanco {

    public static void criarGerente(){
        Scanner reader = new Scanner(System.in);
        System.out.print("Deseja adicionar quantos gerentes? ");
        int n = reader.nextInt();
        reader.nextLine();
        for(int i = 0; i < n; i++){
            System.out.print("Digite o nome do gerente: ");
            String nome = reader.nextLine().trim();
            System.out.print("Digite o número do gerente: ");
            String numero = reader.nextLine().trim();
            System.out.print("Crie uma senha para o gerente: ");
            String senha = reader.nextLine().trim();
            Banco.getGerentes().add(new Gerente(nome,numero,senha));
        }
        System.out.println("Todos os gerentes foram criados com sucesso!");


    }
}
