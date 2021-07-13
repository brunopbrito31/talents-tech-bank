package projetobanco.model.services;

import projetobanco.model.entities.Banco;
import projetobanco.model.entities.contas.ContaBancaria;
import projetobanco.model.entities.contas.ContaCorrente;
import projetobanco.model.entities.contas.ContaPoupanca;
import projetobanco.model.entities.usuarios.Cliente;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ServicosDaConta {

    public static void transferir(ContaBancaria conta1, ContaBancaria conta2){
        // implementar método de transferência
    }

    public static void adicionarLimiteDeChequeEspecial(){
        // implementar método de adicionar limiteDeCheque
    }

    public static void encerrarContaBancaria(ContaBancaria conta){
        // implementar método de encerramento
    }

    public static ContaBancaria criarContaBancaria(){
        Locale.setDefault(Locale.US);

        Scanner reader = new Scanner(System.in);
        System.out.println("Criação de conta ******************");
        System.out.println("Seja Bem Vindo! Vamos começar? ");
        System.out.print("Digite o Nome do Cliente: ");
        String nome = reader.nextLine().trim();
        System.out.println("Digite o Número do Cliente: ");
        String telefone = reader.nextLine().trim();
        Cliente cliente = new Cliente(nome,telefone);
        System.out.println("Digite o saldo inicial: ");
        double saldoInicial = reader.nextDouble();
        reader.nextLine();
        System.out.println("Deseja criar qual tipo de conta? 1.Corrente | 2.Poupança");
        int opcao = reader.nextInt();
        reader.nextLine();
        reader.close();

        if(opcao == 1) return new ContaCorrente(gerarNumeroContaNaoRepetido(),cliente,saldoInicial);
        if(opcao == 2) return new ContaPoupanca(gerarNumeroContaNaoRepetido(),cliente,saldoInicial);
        else throw new IllegalArgumentException("Opção Inválida");


    }

    public static int gerarNumeroContaNaoRepetido(){  // Testar esse método
        Random numero = new Random();
        int numeroConta;
        int n = 0;
        while(n == 0){
            numeroConta = 1 + numero.nextInt(9999);
            final int numeroConta2 = numeroConta;
            if(Banco.getContas().stream().filter(x -> x.getNumeroDaConta() == numeroConta2).collect(Collectors.toList()).isEmpty()){

                n = 1;
                return numeroConta2;
            }
        }
        return 0;
    }
}
