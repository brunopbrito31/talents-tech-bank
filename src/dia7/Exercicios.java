package dia7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercicios {

    // leia os numeros e insira os num array
    public static void main(String[] args) {
        exercicio2();


    }

    public static void exercicio1(){

        Scanner reader = new Scanner(System.in);
        System.out.println("Digite a quantidade de números que deseja adicionar: ");
        int n = reader.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int i=0; i<n; i++){
            System.out.print("Digite um número: ");
            validaInteiro(reader);
            Integer num = reader.nextInt();
            list.add(num);
        }
        System.out.println("Lista: "+list.toString());
        reader.close();
    }

    public static void exercicio2(){
        /* Escreva um algoritmo que leia números, insira em um array e após mostre a quantidade de números negativos. */

        Scanner reader = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int negativos =0;

        System.out.println("Digite quantos números deseja adicionar: ");
        validaInteiro(reader);
        int n = reader.nextInt();
        for (int i = 0; i < n; i++){
            System.out.print("Digite um número: ");
            int num = reader.nextInt();
            if(num<0) negativos++;
            list.add(num);
        }
        System.out.println("Quantidade de negativos: "+negativos);
        System.out.println("Com Predicate: ");
        System.out.println("Quantidade de negativos: "+list.stream().filter(x -> x < 0).count());

        reader.close();
    }

    public static void exercicio3(){
        //Escreva um algoritmo que leia números, insira em um array e após mostre a quantidade de números pares.
        Scanner reader = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int pares =0;

        System.out.println("Digite quantos números deseja adicionar: ");
        validaInteiro(reader);
        int n = reader.nextInt();
        for (int i = 0; i < n; i++){
            System.out.print("Digite um número: ");
            int num = reader.nextInt();
            if(num%2==0) pares++; // poderia ter montado uma lista de pares através de predicate, mas optei por criar durante a criação da lista
            list.add(num);
        }

        System.out.print("Números pares: "+list.stream().filter(numero -> numero % 2 ==0).count());
        reader.close();

    }

    public static void exercicio4(){
        //Escreva um algoritmo que leia números, insira em um array e após mostre o maior valor.
        Scanner reader = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int maiorValor =0;

        System.out.println("Digite quantos números deseja adicionar: ");
        validaInteiro(reader);
        int n = reader.nextInt();
        for (int i = 0; i < n; i++){
            System.out.print("Digite um número: ");
            validaInteiro(reader);
            int num = reader.nextInt();
            if(num > maiorValor) maiorValor = num;
            list.add(num);
        }
        System.out.println("Maior Número: "+maiorValor);
        reader.close();
    }

    public static void exercicio5(){
        /*Escreva um algoritmo que simula um jogo da forca simples. o usuario precisara adivinhar
        uma palavra chutando cada letra em no máximo 10 chutes, caso o usuario acerte a letra o jogo
        dirá que ele acertou, caso tenha errado, o numero de tentativas vai diminuindo. Caso o numero
        de tentativas chegue a 0 o usuário perde.*/

        Scanner reader = new Scanner(System.in);

        System.out.println("Defina a palavra: ");
        String word = reader.nextLine();
        List<Character>letters = stringToList(word);
        // faltou uma implementação para limpar o console
        //List<Character>exibithion = generateExibithion(letters);

        System.out.println("Digite quantas tentativas o jogador terá por letra");
        validaInteiro(reader);
        int qt = reader.nextInt();
        reader.nextLine();
        int end = 0;

        List<Character>copLetters = new ArrayList<>(); // Lista auxiliar para guardar os elementos e posições originais
        copLetters.addAll(letters);
        List<Character>aux = createAuxiliarGraphicList(copLetters); // Lista auxiliar para os gráficos

        while (!letters.isEmpty() && end == 0) {

            int attempts = 0; //
            while(attempts < qt && end ==0){ // verificar essa condição
                System.out.println("Digite uma letra: ");
                char letter = reader.nextLine().charAt(0);
                if(letters.stream().filter(x -> x == letter).collect(Collectors.toList()).isEmpty()){
                    // verificar essa primeira condição
                    if(attempts == (qt-1)){
                        System.out.println("Você perdeu o jogo");
                        end = 1;
                    }else{
                        if(!copLetters.stream().filter(a -> a == letter).collect(Collectors.toList()).isEmpty()) {
                            System.out.println("Você já jogou essa letra, penalização: - 1 tentativa, tentativas restantes: "+(qt-(attempts+1)));
                        }else{
                            System.out.println("Errou, tente novamente! "+(qt-(attempts+1))+" tentativas restantes");
                        }
                        attempts++;
                    }
                }else{
                    System.out.println("Parabéns, você acertou!");
                    for(int j = 0; j<copLetters.size(); j++){
                        if(copLetters.get(j) == letter){
                            aux.set(j,letter);
                        }
                    }
                    aux.forEach(System.out::print);
                    System.out.println();
                    letters.removeIf(x -> x == letter);
                    attempts = qt;
                }
            }
            if(letters.isEmpty()) System.out.println("Parabéns, você ganhou o jogo! ");
        }
        reader.close();
    }
    // métodos auxiliares do exercicio5
    public static List<Character> stringToList(String word){
        List<Character> letters = new ArrayList<>();
        for(int i = 0; i < word.length(); i++) letters.add(word.charAt(i));

        return letters;
    }
    public static List<Character> createAuxiliarGraphicList(List<Character>data){
        List<Character>aux = new ArrayList<>();
        for(int i = 0; i < data.size();i++) aux.add('-');
        return aux;
    }


    //método auxiliar geral
    public static void validaInteiro(Scanner reader){
        if(!reader.hasNextInt()){
            System.out.println("Valor inválido! ");
            reader.close();
            System.exit(1);
        }
    }

    // Escreva um algoritmo que dê os numeros negativos
    // pares
    // maior valor
    // simular um jogo de forca simples
    //
}


