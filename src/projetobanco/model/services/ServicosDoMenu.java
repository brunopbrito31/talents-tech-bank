package projetobanco.model.services;

import projetobanco.model.entities.Banco;
import projetobanco.model.entities.contas.ContaBancaria;
import projetobanco.model.entities.contas.ContaCorrente;

import java.util.Scanner;

public class ServicosDoMenu {

    public static void exibirMenu(){
        Scanner reader = new Scanner(System.in);
        try{
            int m = 0;
            while(m == 0){
                System.out.println("Digite o número da conta que deseja utilizar: ");
                int num = reader.nextInt();
                ContaBancaria cont = ServicosDaConta.encontrarContaBancaria(num);
                exibirOpções();
                int op = processarEntradaDoMenu(reader);
                m = processarOpcaoMenu(op,cont,reader);
            }
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
                    String validar = reader.nextLine().trim();
                    // Corigir a validação
                    if(Banco.getGerentes().stream().filter(x -> x.getIdentificador().equals(validar)).count() > 0){
                        System.out.print("Digite o valor que deseja adicionar de limite de cheque especial para o cliente: ");
                        double valorr = reader.nextDouble();
                        reader.nextLine();
                        ServicosDaConta.adicionarLimiteDeChequeEspecial((ContaCorrente) contaBancaria,validar,valorr);
                        System.out.println("Adicionado com sucesso!");
                        break;
                    }else{
                        throw new IllegalArgumentException("Erro de Validação: Gerente não encontrado");
                    }
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

        }
        return 0; // no case 7 tenho que por return 1
    }


    public static void validaEntradaInteiro(Scanner reader){
        if(!reader.hasNextInt()){
            throw new IllegalArgumentException("Erro de entrada!");
        }
    }
    public static void validaOpcao(int op){
        if(op > 7 || op < 1){
            throw new IllegalArgumentException("Opção Inválida!");
        }
    }


}
