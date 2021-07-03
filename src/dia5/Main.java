package dia5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        exercicio2();
    }

    public static void exercicio1(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Digite a base: ");
        validaInteiros(reader);
        int base = reader.nextInt();
        validaInteirosPositivos(base,reader);
        int resultado=1;

        System.out.println("Digite o expoente");
        validaInteiros(reader);
        int expoente = reader.nextInt();
        validaInteirosPositivos(expoente,reader);

        for(int i=1; i<=expoente;i++){
            resultado = resultado * base;
        }
        System.out.println("Resultado = "+resultado);

        reader.close();
    }

    public static void exercicio2(){

        //padrão i - Feito
        System.out.println("Padrão i");
        for(int i = 0; i<4; i++){
            for (int j = 0; j <10; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        //padrão ii - Feito
        System.out.println("Padrão ii");
        for(int i = 1;i <= 5; i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        //padrão iii - Feito
        System.out.println("Padrão iii");
        for(int i = 1;i <= 5;i++){
            int k = 5-i;
            int t =k;
            while(k>0){
                System.out.print(" ");
                k--;
            }
            for(int j=t;j<=5;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        //padrão iv - Feito
        System.out.println("Padrão iv");
        for(int i = 1;i <= 5; i++){
            int aux = 5-i; // quantos espaços em branco que eu terei de imprimir antes
            while(aux>0){
                System.out.print(" ");
                aux--;
            }
            aux = 5-i;

            for(int j = aux; j< aux+(2*i-1);j++){ // 2*i-1 é a expressão para encontrar a quantidade de repetições
                System.out.print("*");
            }
            System.out.println();
        }
        // padrão v - Feito
        System.out.println("Padrão v");
        for(int i = 1;i <= 5; i++){
            int aux = 5-i; // quantos espaços em branco que eu terei de imprimir antes
            while(aux>0){
                System.out.print(" ");
                aux--;
            }
            aux = 5-i;

            for(int j = aux; j< aux+(2*i-1);j++){ // 2*i-1 é a expressão para encontrar a quantidade de repetições
                System.out.print(i);
            }
            System.out.println();
        }

        // padrão vi - Feito
        System.out.println("Padrão vi");
        int qtLinhas =5;
        for(int i = 1; i <= qtLinhas; i++){
            // Impressão dos espaços em branco;
            for(int j = 0; j < (qtLinhas-i);j++){
                System.out.print(" ");
            }
            // Impressão do lado esquerdo
            for(int j = i; j>=1;j--){
                System.out.print(j);
            }
            // Impressão do lado direito
            for(int j=2 ; j<=i; j++){
                System.out.print(j);
            }
            System.out.println();
        }

    }

    // métodos auxiliares
    public static void validaInteiros(Scanner reader){
        if(!reader.hasNextInt()){
            System.out.println("Erro de entrada: Só são aceitos inteiros positivos");
            reader.close();
            System.exit(1);
        }
    }
    public static void validaInteirosPositivos(int num, Scanner reader){
        if(num<0){
            System.out.println("Erro de entrada: entrada inválida! ");
            reader.close();
            System.exit(1);
        }
    }
}
