package projetobanco.model.services;

import projetobanco.model.entities.Banco;
import projetobanco.model.entities.contas.ContaBancaria;

import java.util.Scanner;

public class ServicosDoMenu {

    public static void exibirMenu(){
        Scanner reader = new Scanner(System.in);
        try{
            System.out.println("Digite o número da conta que deseja utilizar: ");
            int num = reader.nextInt();
            ContaBancaria cont = ServicosDaConta.encontrarContaBancaria(num);
            exibirOpções();
            int op = processarEntradaDoMenu(reader);
            processarOpcaoMenu(op,cont);
        }catch (IllegalArgumentException e){
            System.out.println("Error: "+e.getMessage());
        }

    }

    public static void exibirOpções(){
        System.out.println("Escolha qual opção deseja realizar:");
        System.out.println("1. Listar Extrato");
        System.out.println("2. realizar saque");
        System.out.println("3. Depositar");
        System.out.println("4. Adicionar limite de cheque especial");
        System.out.println("5. Para Adicionar uma nova conta");
        System.out.println("6. Para acessar uma conta pelo número");
        System.out.println("7. Para sair");

    }

    public static int processarEntradaDoMenu(Scanner reader){
        validaEntradaInteiro(reader);
        int op = reader.nextInt();
        reader.nextLine();
        validaOpcao(op);
        return op;
    }

    public static void processarOpcaoMenu(int op, ContaBancaria contaBancaria){
        switch (op){
            case 1:
                ServicosDaConta.imprimirExtrato(contaBancaria);

        }
    }


    public static void validaEntradaInteiro(Scanner reader){
        if(!reader.hasNextInt()){
            throw new IllegalArgumentException("Erro de entrada!");
        }
    }
    public static void validaOpcao(int op){
        if(op > 5 || op < 1){
            throw new IllegalArgumentException("Opção Inválida!");
        }
    }


}
