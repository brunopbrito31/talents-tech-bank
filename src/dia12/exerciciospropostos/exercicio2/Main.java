package dia12.exerciciospropostos.exercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner reader = new Scanner(System.in);
        int status = 0;

        while(status == 0){
            exibeTelaOpcoes();
            try{
                int op = leInteiroELimpaBuffer(reader);
                status = processarCalculadora(op,reader);
            }catch (IllegalArgumentException e){
                System.out.println("Error: "+e.getMessage());
            }
        }
        reader.close();

    }
    public static void exibeTelaOpcoes(){
        System.out.println("Qual Operação deseja realizar?");
        System.out.println("1.Soma    | 2.Subtração   | 3.Fatorial | 4.Multiplicação");
        System.out.println("5.Divisão | 6.Potenciação | 7.Sair");
    }

    public static void validaInteiro(Scanner reader){
        if(!reader.hasNextInt()){
            //reader.close();
            throw new IllegalArgumentException("Entrada inválida");
        }
    }
    public static void validaOpcao(Scanner reader, int op){
        if(op < 1 || op > 7){
            //reader.close();
            throw new IllegalArgumentException("Opção Inválida");
        }
    }

    public static int leInteiroELimpaBuffer(Scanner reader){
        validaInteiro(reader);
        int num = reader.nextInt();
        reader.nextLine();
        validaOpcao(reader,num);
        return num;
    }

    public static int processarCalculadora(int op, Scanner reader){
        List<Double> numeros = new ArrayList<>();
        int stop = 0;
        if(op != 3 && op != 7){

            for(int i = 0; i < 2; i++){
                System.out.print("Digite um número: ");
                double numm = reader.nextDouble();
                numeros.add(numm);
            }
            System.out.println();
            switch (op){
                case 1:
                    System.out.println("O Resultado da soma: "+numeros.get(0)+" + "+numeros.get(1)+" é: "+Calculadora.somar(numeros.get(0),numeros.get(1)));
                    System.out.println();
                    break;
                case 2:
                    System.out.println("O Resultado da subtração: "+numeros.get(0)+" - "+numeros.get(1)+" é: "+Calculadora.subtrair(numeros.get(0),numeros.get(1)));
                    System.out.println();
                    break;
                case 4:
                    System.out.println("O Resultado da multiplicação: "+numeros.get(0)+" X "+numeros.get(1)+" é: "+Calculadora.multiplicar(numeros.get(0),numeros.get(1)));
                    System.out.println();
                    break;
                case 5:
                    try{
                        System.out.println("O Resultado da divisão: "+numeros.get(0)+" / "+numeros.get(1)+" é: "+Calculadora.dividir(numeros.get(0),numeros.get(1)));
                        System.out.println();
                    }catch (IllegalArgumentException e){
                        System.out.println("Error: "+e.getMessage());
                    }finally {
                        break;
                    }
                case 6:
                    System.out.println("O resultado da potenciação: "+numeros.get(0)+" ^ "+numeros.get(1)+" é: "+Calculadora.elevarA(numeros.get(0),numeros.get(1)));
                    System.out.println();
                    break;
            }
        }else if(op == 3){
            System.out.println("Digite o número: ");
            validaInteiro(reader);
            int numm = reader.nextInt();
            reader.nextLine();
            System.out.println("O Resultado do fatorial de "+numm+" é : "+Calculadora.calcularFactorial(numm));
            System.out.println();
        }else if(op == 7){
            stop = 1;
        }
        return stop;
    }


}
