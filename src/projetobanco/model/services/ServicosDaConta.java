package projetobanco.model.services;

import projetobanco.model.entities.Banco;
import projetobanco.model.entities.contas.ContaBancaria;
import projetobanco.model.entities.contas.ContaCorrente;
import projetobanco.model.entities.contas.ContaPoupanca;
import projetobanco.model.entities.contas.Transacao;
import projetobanco.model.entities.usuarios.Cliente;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ServicosDaConta {

    public static void exibirMenu(){

    }



    public static void sacar(double valor, ContaBancaria contaBancaria){
        try{
            contaBancaria.sacar(valor);
            Transacao transacao = new Transacao("saque",valor, Date.from(Instant.now()));
            contaBancaria.getMovimentacoes().add(transacao);
            System.out.println("Saque efetuado com sucesso!");
            System.out.println("Dados da Transação: "+transacao);
        }catch (IllegalArgumentException e){
            System.out.println("Error, Operação não realizada: "+e.getMessage());
        }
    }

    public static void depositar(double valor, ContaBancaria contaBancaria){
        try{
            criarContaBancaria().depositar(valor);
            Transacao transacao = new Transacao("depósito",valor,Date.from(Instant.now()));
            contaBancaria.getMovimentacoes().add(transacao);
            System.out.println("Depósito realizado com sucesso!");
            System.out.println("Dados da Transação: "+transacao);
        }catch (IllegalArgumentException e){
            System.out.println("Error, Operação não realizada: "+e.getMessage());
        }
    }

    public static void transferir(ContaBancaria conta1, ContaBancaria conta2, double valor){
        try{
            conta1.sacar(valor);
            conta2.depositar(valor);
            Transacao transacao1 = new Transacao("transferência para conta: "+conta2.getNumeroDaConta(),valor,Date.from(Instant.now()));
            Transacao transacao2 = new Transacao("transferência recebida da conta: "+conta1.getNumeroDaConta(),valor,Date.from(Instant.now()));
            conta1.getMovimentacoes().add(transacao1);
            conta2.getMovimentacoes().add(transacao2);
            System.out.println("Transferência realizada com sucesso!");
            System.out.println("Dados da Transação: "+transacao1);
        }catch (IllegalArgumentException e){
            System.out.println("Error, Operação não realizada: "+e.getMessage());
        }
    }

    public static void imprimirExtrato(ContaBancaria contaBancaria){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println("Olá Cliente Rainbow Bank !");
        System.out.println("Extrato Bancário - Dados da conta: "+contaBancaria);
        System.out.println("Data e Hora: "+sdf.format(Date.from(Instant.now())));
        System.out.println("Movimentações*********************************");
        System.out.println("Tipo - Valor Movimentado - Data da Transação: ");
        contaBancaria.imprimirMovimentacoes();
    }

    public static void adicionarLimiteDeChequeEspecial(ContaCorrente conta, String senhaGerente, double valor){
        try{
            conta.adicionarLimiteChequeEspecial(valor,senhaGerente);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
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
        System.out.print("Digite o Número do Cliente: ");
        String telefone = reader.nextLine().trim();
        Cliente cliente = new Cliente(nome,telefone);
        System.out.print("Digite o saldo inicial: ");
        double saldoInicial = reader.nextDouble();
        reader.nextLine();
        System.out.print("Deseja criar qual tipo de conta? 1.Corrente | 2.Poupança: ");
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
                System.out.println("Numero da conta gerado: "+numeroConta2);
                return numeroConta2;
            }
        }
        return 0;
    }


}