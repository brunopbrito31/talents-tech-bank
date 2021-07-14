package projetobanco.model.services;

import projetobanco.model.entities.Banco;
import projetobanco.model.entities.contas.ContaBancaria;
import projetobanco.model.entities.contas.ContaCorrente;
import projetobanco.model.entities.contas.ContaPoupanca;

import java.util.Locale;
import java.util.Scanner;

public class ServicosDoMenu {

    public static void exibirMenu(){
        Locale.setDefault(Locale.US);
        Scanner reader = new Scanner(System.in);
        int n = 0;
        while(n == 0){
            try{
                System.out.println("Digite o numero da conta com a qual deseja trabalhar:");
                validarInteiro(reader);
                int conta = reader.nextInt();
                reader.nextLine();
                ContaBancaria auxiliar = ServicosDaConta.encontrarContaBancaria(conta);
                listarOpcoes(auxiliar);
                validarInteiro(reader);
                int opcao = reader.nextInt();
                reader.nextLine();
                validarOpcaoEscolhida(opcao,auxiliar);




            }catch (IllegalArgumentException e){
                System.out.println("Error: "+e.getMessage());
            }
        }


    }

    // só o gerente que terá acesso as opções 5,6,7 - > Implementar nessa camada
    public static void listarOpcoes(ContaBancaria contaBancaria){
        System.out.println("MENU DE OPÇÕES*********************");
        System.out.println("Escolha qual opção deseja realizar:");
        System.out.println("1. Listar extrato");
        System.out.println("2. Realizar saque");
        System.out.println("3. Depositar");
        if(contaBancaria.getClass().equals(ContaCorrente.class)) listarOpcoesContaCorrente();
        System.out.println("5. Para adicionar uma nova conta");
        System.out.println("6. Para escolher outra conta pelo número");
        System.out.println("7. Para encerrar uma conta");
        System.out.println("8. Para sair");
    }

    public static int processarOpcao(int opcao, ContaBancaria contaBancaria, Scanner reader){

        switch (opcao){
            case 1:
                ServicosDaConta.imprimirExtrato(contaBancaria);
                break;
            case 2: // Saque
                System.out.print("Digite o valor que deseja sacar: ");
                validarDouble(reader);
                double valor = reader.nextDouble();
                reader.nextLine();
                ServicosDaConta.sacar(valor,contaBancaria);
                break;
            case 3: // Depósito
                System.out.println("Digite o valor que deseja depositar: ");
                validarDouble(reader);
                double valorDeposito = reader.nextDouble();
                reader.nextLine();
                ServicosDaConta.depositar(valorDeposito,contaBancaria);
                break;
            case 4: // adicionar cheque especial
                System.out.println("Operação permitida somente para gerentes");
                System.out.println("1. Digitar senha || 2. Voltar");
                validarInteiro(reader);
                int oppGer = reader.nextInt();
                reader.nextLine();
                if(oppGer < 1 || oppGer > 2) throw new IllegalArgumentException("Opção Inválida!");
                if(oppGer == 1){ // Caso seja um gerente
                    System.out.print("Digite a sua senha: ");
                    validarInteiro(reader);
                    int senhaAux = reader.nextInt();
                    reader.nextLine();
                    if(Banco.getGerentes().stream().filter(x -> x.getIdentificador().equals(senhaAux)).count() > 0){ // Verificação da senha
                        System.out.print("Digite o valor que deseja adicionar: ");
                        validarDouble(reader);
                        double valorAux1 = reader.nextDouble();
                        reader.nextLine();
                        ServicosDaConta.adicionarLimiteDeChequeEspecial((ContaCorrente) contaBancaria,senhaAux,valorAux1);
                        break;
                    }else{ // Caso a senha esteja incorreta
                        throw new IllegalArgumentException("Acesso Negado!");
                    }
                }else{
                    break;
                }
            case 5: // criação de nova conta
                ServicosDaConta.criarContaBancaria();
                break;
            case 6: // Buscar uma conta pelo número
                System.out.print("Digite o numero da conta com a qual deseja trabalhar: ");
                validarInteiro(reader);
                int numContaAux = reader.nextInt();
                reader.nextLine();
                ServicosDaConta.encontrarContaBancaria(numContaAux);
                break;
            case 7: // Encerrar uma conta



        }
        return 0;
    }


    public static void listarOpcoesContaCorrente(){
        System.out.println("4. Adicionar limite de cheque especial");
    }

    public static void validarInteiro(Scanner reader){
        if(!reader.hasNextInt()){
            throw new IllegalArgumentException("A entrada deve ser um número inteiro!");
        }
    }
    public static void validarDouble(Scanner reader){
        if(!reader.hasNextDouble()){
            throw new IllegalArgumentException("A entrada deve ser um número!");
        }
    }
    public static void validarOpcaoEscolhida(int opcao, ContaBancaria contaBancaria){
        if(opcao <= 0 || opcao > 8){
            throw new IllegalArgumentException("Opção Inválida!");
        }
        if(opcao == 4 && contaBancaria.getClass().equals(ContaPoupanca.class)){
            throw new IllegalArgumentException("Opção Inválida");
        }
    }

}
