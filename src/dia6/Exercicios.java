package dia6;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;

public class Exercicios {

    public static void exercicio1(){
        // Dado um array com 20 números, imprima seus valores de trás para frente.

        /*int[] vet = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        for(int i = vet.length-1; i>=0; i--){
            System.out.println(vet[i]);
        }*/

        Instant start = Instant.now();

        Random rd = new Random();
        int[] arr = new int[100_000];
        for(int i =0; i< arr.length; i++){
            arr[i] = rd.nextInt();
        }

        bubbleSort(arr);

        Instant stopTime = Instant.now();
        //long duration ;// passar o calculo da diferença

        System.out.println(Duration.between(start,stopTime));

        // TODO diferença entre o random e o math.random

    }
    // Eu determino o tamanho do array e ainda coloco para ele fazer a contagem automaticamente
    // seguindo a ordem decrescente
    public static void exercicio1Alternativo(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Digite o tamanho do vetor: ");
        int tam = reader.nextInt();
        int[] vect = new int[tam];

        for(int i = 0; i<tam;i++){
            System.out.println(tam-(i+1));
        }

    }

    // trabalho em grupo
    public static void selectionSort(){
        // valores a serem ordenados
        int vetor[] = {3,5,10,8,1,3};
        // armazenam o menor valor e o índice do menor valor
        int menor, indiceMenor;

        for (int i = 0; i < vetor.length - 1; i++) {
            // antes de comparar, considera-se menor o valor atual do loop
            menor = vetor[i];
            indiceMenor = i;

            // compara com os outros valores do vetor
            for (int j = i + 1; j < vetor.length; j++){
                if (vetor[j] < menor){
                    menor = vetor[j];
                    indiceMenor = j;
                }
            }

            // troca os valores menor e maior
            vetor[indiceMenor] = vetor[i];
            vetor[i] = menor;
        }

        // exibe os números na tela
        String numerosOrdenados = "";
        for (int n : vetor) {
            numerosOrdenados += n+"-";
        }
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + "-");

        }
    }

    // implementar o bubble sort
    public static void bubbleSort(int arr[]){
        int n = arr.length;

        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < n - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        exercicio1();
    }


}




