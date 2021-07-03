package dia4;

import java.util.Scanner;

public class Exercicios {

    public static void main(String[] args) {
        exercicio2();
    }

    public static void exercicio1 (){
        /* Construa um algoritmo que leia 10 valores inteiros e positivos e:
        Encontre o maior valor
        Encontre o menor valor
        Calcule a média dos números lidos Esse exercício foi dado na aula 3 e
        agora vamos otimizar ele utilizando o while e for. */

        /* Construa um algoritmo que leia 10 valores inteiros e positivos e:
        Encontre o maior valor
        Encontre o menor valor
        Calcule a média dos números lidos */

        Scanner reader = new Scanner(System.in);

        int maiorValor = 0, menorValor=0;
        double soma =0.0;

        /*
        // Criação com o for
        for(int i=0; i<10; i++){
            System.out.println("Digite um número inteiro e positivo: ");
            validaInteiros(reader);
            int num = reader.nextInt();

            validaInteirosPositivos(reader,num);
            soma = soma+num;
            if(num>maiorValor){
                maiorValor=num;
            }
            if(menorValor==0){
                menorValor=num;
            }
            if(num<menorValor){
                menorValor=num;
            }
        }
        System.out.println("Resultado com o FOR");
        System.out.println("O maior valor é: "+maiorValor);
        System.out.println("O menor valor é: "+menorValor);
        System.out.println("A média do conjunto de números é: "+soma/10.0);*/

        // Criação com o while

        int num =0;// Variável usada para controle do while
        while(num<10){
            System.out.println("Digite um número inteiro e positivo: ");

            validaInteiros(reader); // Validação -> Número Inteiro
            int numax = reader.nextInt();
            validaInteirosPositivos(reader,numax); // Validação -> Número positivo

            soma = soma+numax;
            if(numax>maiorValor){
                maiorValor=numax;
            }
            if(menorValor==0){
                menorValor=numax;
            }
            if(numax<menorValor){
                menorValor=numax;
            }
            num++;
        }

        System.out.println("O maior valor é: "+maiorValor);
        System.out.println("O menor valor é: "+menorValor);
        System.out.println("A média do conjunto de números é: "+soma/10.0);
        reader.close();
    }


    public static void exercicio2 (){
        /* Construa um algoritmo usando uma estrutura de repetição que calcule
        o fatorial de um número. */

        Scanner reader = new Scanner(System.in);
        System.out.println("Digite o número que deseja calcular o fatorial");
        validaLong(reader); // Validação se o número é inteiro
        long num = reader.nextLong();
        validaInteirosPositivos(reader,(int)num); // Validação se o número é positivo

        long result =1;
        long numA = num; // variável auxiliar apenas

        while(num>1){
            result = result*num;
            num--;
        }
        System.out.println("O Fatorial de : "+numA+" é: "+result);
    }

    //Funções auxiliares

    public static void validaInteiros(Scanner reader){
        if(!reader.hasNextInt()){
            System.out.println("Erro de entrada: Só é permitida a entrada de números inteiros!");
            reader.close();
            System.exit(1);
        }
    }
    public static void validaInteirosPositivos(Scanner reader,int num){
        if(num<0){
            System.out.println("Erro de entrada: Só é permitida a entrada de números positivos!");
            reader.close();
            System.exit(1);
        }
    }
    public static void validaLong(Scanner reader){
        if(!reader.hasNextLong()){
            System.out.println("Erro de entrada: Só é permitida a entrada de números inteiros!");
            reader.close();
            System.exit(1);
        }
    }
}
