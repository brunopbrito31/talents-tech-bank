package projetobanco.model.services;

import projetobanco.model.entities.Banco;
import projetobanco.model.entities.contas.ContaBancaria;
import projetobanco.model.entities.contas.ContaCorrente;

import java.util.Scanner;

public class ServicosDoMenu {

    public static void exibirMenu(){
        Scanner reader = new Scanner(System.in);
            int m = 0;
            while(m == 0){
                try {
                    System.out.println("Digite o número da conta que deseja utilizar: ");
                    int num = reader.nextInt();
                    ContaBancaria cont = ServicosDaConta.encontrarContaBancaria(num);
                    exibirOpções();
                    int op = processarEntradaDoMenu(reader);
                    m = processarOpcaoMenu(op, cont, reader);
                }catch (IllegalArgumentException e){
                    System.out.println("Error: "+e.getMessage());
                }
            }
        }


    public static void exibirOpções(){
        System.out.println("Escolha qual opção deseja realizar:");
        System.out.println("1. Listar extrato");
        System.out.println("2. Realizar saque");
        System.out.println("3. Depositar");
        System.out.println("4. Adicionar limite de cheque especial");
        System.out.println("5. Para adicionar uma nova conta");
        System.out.println("6. Para acessar uma conta pelo número");
        System.out.println("7. Para sair");
        System.out.println("8. Para encerrar uma conta");
    }

    public static int processarEntradaDoMenu(Scanner reader){
        validaEntradaInteiro(reader);
        int op = reader.nextInt();
        reader.nextLine();
        validaOpcao(op);
        return op;
    }

    public static int processarOpcaoMenu(int op, ContaBancaria contaBancaria,Scanner reader){
        switch (op){
            case 1:
                ServicosDaConta.imprimirExtrato(contaBancaria);
                break;
            case 2:
                System.out.println("Digite o valor que deseja sacar: ");
                double valor = reader.nextDouble();
                reader.nextLine();
                ServicosDaConta.sacar(valor,contaBancaria);
                break;
            case 3:
                System.out.println("Digite o valor que deseja depositar");
                double valorDeposito = reader.nextDouble();
                reader.nextLine();
                ServicosDaConta.depositar(valorDeposito,contaBancaria);
                break;
            case 4:
                if(!contaBancaria.getClass().equals(ContaCorrente.class)){
                    throw new IllegalArgumentException("Esta operação só é permitida para correntistas!");
                }
                System.out.println("Acesso Permitido somente para gerentes");
                System.out.println("Digite 1 para prosseguir ou 2 para cancelar");
                int opp = reader.nextInt();
                reader.nextLine();
                if(opp == 1){
                    System.out.print("Digite a sua senha: ");
                    int validar = reader.nextInt();
                    reader.nextLine();
                    // Corigir a validação

                    System.out.print("Digite o valor que deseja adicionar de limite de cheque especial para o cliente: ");
                    double valorr = reader.nextDouble();
                    reader.nextLine();
                    ServicosDaConta.adicionarLimiteDeChequeEspecial((ContaCorrente) contaBancaria,validar,valorr);
                    System.out.println("Adicionado com sucesso!");
                    break;

                }else{
                    break;
                }
            case 5:
                ServicosDaConta.criarContaBancaria();
                break;
            case 6:
                System.out.println("Digite o número da conta que deseja encontrar: ");
                int numConta = reader.nextInt();
                reader.nextLine();
                ServicosDaConta.encontrarContaBancaria(numConta);
                break;
            case 7:
                System.out.println("O Programa está sendo encerrado");
                return 1;
            case 8:
                System.out.println("Digite o número da conta que deseja encerrar: ");
                int numConta1 = reader.nextInt();
                reader.nextLine();
                ServicosDaConta.encerrarContaBancaria(numConta1);
        }
        return 0; // no case 7 tenho que por return 1
    }


    public static void validaEntradaInteiro(Scanner reader){
        if(!reader.hasNextInt()){
            throw new IllegalArgumentException("Erro de entrada!");
        }
    }
    public static void validaOpcao(int op){
        if(op > 8 || op < 1){
            throw new IllegalArgumentException("Opção Inválida!");
        }
    }


}
