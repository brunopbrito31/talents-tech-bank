package dia2;

import java.util.Locale;
import java.util.Scanner;

public class Exercicios {
    public static void main(String[] args) {
        exercicio4();
    }

    public static void exercicio1(){ // Concluído
        // Escreva um algoritmo que leia um número inteiro e diga que se ele é par ou ímpar.

        Scanner reader = new Scanner(System.in);

        System.out.println("Digite o número: ");

        if(!reader.hasNextInt()){
            System.out.println("Erro de entrada: Você precisa digitar um número do tipo inteiro!");
            reader.close();
            System.exit(1);
        }

        int numero = reader.nextInt();

        System.out.println("IF/ELSE");
        if(numero % 2 == 0){
            System.out.println("O número é par");
        }else{
            System.out.println("O número é ímpar");
        }

        System.out.println("SWITCH/CASE");

        int mod = numero%2;

        switch(mod){
            case 0:
                System.out.println("É um número par");
                break;
            default:
                System.out.println("É um número ímpar");
        }

        System.out.println("IF/ELSE TERNÁRIO");

        String resultadoTernario = numero % 2 == 0 ? "É um número par": "É um número ímpar";

        System.out.println(resultadoTernario);

        reader.close();
    }

    public static void exercicio2(){ // Concluído
        // Elaborar um algoritmo que dada a idade de um nadador, classifique-o em
        // Infantil A = 5 a 7 anos, Infantil B = 8 a 11 anos
        // Juvenil A = 12 a 13 anos, Juvenil B = 14 a 17 anos
        // Adultos = Maiores de 18 anos

        Scanner reader = new Scanner(System.in);
        System.out.println("Digite a idade do nadador: ");

        if(!reader.hasNextInt()){
            System.out.println("Erro de entrada: A idade deve ser representada através de um número inteiro! ");
            reader.close();
            System.exit(1);
        }

        int idade = reader.nextInt();

        // Opção escolhida, levando em consideração este caso : If-Else
        System.out.println("******************************************************");
        System.out.print("Resultado: ");
        if(idade >= 5 && idade <= 7){
            System.out.println("O Nadador informado pertence a categoria Infantil A");
        }
        if(idade >= 8 && idade <= 11){
            System.out.println("O Nadador informado pertence a categoria Infantil B");
        }
        if(idade == 12 || idade == 13){
            System.out.println("O Nadador informado pertence a categoria Juvenil A");
        }
        if(idade >= 14 && idade <= 17){
            System.out.println("O Nadador informado pertence a categoria Juvenil B");
        }
        if(idade >= 18 && idade <= 100){
            System.out.println("O Nadador é maior de idade, adulto");
        }
        if(idade < 5 || idade > 100){ // Estou convencionando 100 como idade máxima
            System.out.println("Erro de entrada: Idade não permitida");
        }

        reader.close();

    }

    public static void exercicio3(){ // Concluído
        /* Escreva um algoritmo em Java que leia dois números inteiros e determine qual é o menor.
        Escreva um algoritmo que determina o maior também. */

        Scanner reader = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        if(!reader.hasNextInt()){
            System.out.println("Erro de entrada: A entrada deverá conter somente números inteiros");
            reader.close();
            System.exit(1);
        }
        int numA = reader.nextInt();
        System.out.print("Digite o segundo número: ");
        if(!reader.hasNextInt()){
            System.out.println("Erro de entrada: A entrada deverá conter somente números inteiros");
            reader.close();
            System.exit(1);
        }
        int numB = reader.nextInt();

        /*if(numA == numB){ // Código alternativo, substituido pelo código mais abaixo
            System.out.println("Os numeros digitados são iguais");
            reader.close();
            System.exit(0);
        }else{
            String resultMaior = numA>numB?"O primeiro número digitado é o maior: "+numA:"O segundo número digitado é o maior: "+numB;
            String resultMenor = numA<numB?"O primeiro número digitado é o menor: "+numA:"O segundo número digitado é o menor: "+numB;
            System.out.println(); // Organização da saída
            System.out.println("Resultado: *************");
            System.out.println(resultMaior); // Caso eu quiser calcular o  menor basta trocar a variável para resultMenor dentro da impressão.
        }*/


        String resultMaior = numA == numB?"Os números são iguais": numA>numB?"O Primeiro número digitado é o maior: "+numA:"O segundo numero digitado é o maior: "+numB;
        String resultMenor = numA == numB?"Os números são iguais": numA<numB?"O Primeiro número digitado é o menor: "+numA:"O segundo numero digitado é o menor: "+numB;
        System.out.println(); // Organização da saída
        System.out.println("Resultado: *************");

        if(resultMenor != "Os números são iguais"){
            System.out.println("Trabalhando com o maior número: "+resultMaior);
            System.out.println("Trabalhando com o menor número: "+resultMenor);
        }else{
            System.out.println(resultMaior);
        }

        reader.close();
    }

    public static void exercicio4(){ // Concluído
        /* Construa um algoritmo que leia 10 valores inteiros e positivos e:
        Encontre o maior valor
        Encontre o menor valor
        Calcule a média dos números lidos */

        Scanner reader = new Scanner(System.in);

        int maiorValor = 0, menorValor=0;

        //Apenas me utilizei do laço de repetição pois pela quantidade de números, o código ficaria muito "sujo"

        for(int i=0; i<10; i++){
            System.out.println("Digite um número inteiro e positivo: ");
            if(!reader.hasNextInt()){
                System.out.println("Erro de entrada: Só é permitida a entrada de números inteiros!");
                reader.close();
                System.exit(1);
            }
            int num = reader.nextInt();
            if(num<0){
                System.out.println("Erro de entrada: Só é permitida a entrada de números positivos!");
                reader.close();
                System.exit(1);
            }
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
        System.out.println("O maior valor é: "+maiorValor);
        System.out.println("O menor valor é: "+menorValor);
        reader.close();
    }

    public static void exercicio5(){ // Concluído
        /* Escreva um algoritmo em Java que seja capaz de fazer as seguintes operações matemáticas
        (adição, subtração, multiplicação e divisão). Todas as operações serão entre dois valores.
        No começo do algoritmo pergunte ao usuário qual operação ele deseja fazer e quais são os valores.
        * */

        Locale.setDefault(Locale.US); // o separador de casas decimais dos números será '.'
        Scanner reader = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        if(!reader.hasNextDouble()){
            System.out.println("Erro de entrada: A entrada deverá ser um número! ");
            reader.close();
            System.exit(1);
        }
        Double numA = reader.nextDouble();
        System.out.print("Digite o segundo número: ");
        if(!reader.hasNextDouble()){
            System.out.println("Erro de entrada: A entrada deverá ser um número! ");
            reader.close();
            System.exit(1);
        }
        Double numB = reader.nextDouble();

        boolean indefinicao =(numA == 0 && numB == 0) || numB ==0;

        System.out.println("******************************************************");
        System.out.println("Escolha a operação que deseja realizar, Digite: ");
        if(indefinicao){
            System.out.println("Atenção! Para os números informados não será possível realizar a operação de divisão, pois resultaria em uma indefinição matemática.");
            System.out.println("1 Para Soma, 2 Para Subtração e 3 Para Multiplicação");
        }else{
            System.out.println("1 Para Soma, 2 Para Subtração, 3 Para Multiplicação e 4 Para Divisão: ");
        }

        if(!reader.hasNextInt()){
            System.out.println("Erro de entrada: Operação Inválida, não permitida.");
            reader.close();
            System.exit(1);
        }

        int operacao = reader.nextInt(); // Variavel sinalizar indeterminação matemática

        //Nesse caso, optei por um switch, por questões de praticidade e desempenho
        switch (operacao){
            case 1:
                System.out.println("O Resultado da Soma: "+numA+" + "+numB+" é: "+(numA+numB));
                break;
            case 2:
                System.out.println("O Resultado da Subtração: "+numA+" - "+numB+" é: "+(numA-numB));
                break;
            case 3:
                System.out.println("O Resultado da Multiplicação: "+numA+" X "+numB+" é: "+(numA*numB));
                break;
            case 4:
                if(indefinicao){// caso o usuário digite mesmo assim a opção de divisão, Deleguei a responsabilidade de lançar o erro pro próprio trecho responsável pela execução
                    System.out.println("Indefinição matemática, Operação não permitida!");
                    break;
                }else{
                    System.out.println("O Resultado da Divisão: "+numA+" / "+numB+" é: "+String.format("%.2f",(numA/numB)));
                    break;
                }
        }
        reader.close();
    }

    public static void exercicio6(){ // Concluído
        /* Faça a implementação do Jogo Pedra, Papel e Tesoura (Jokempô). O algoritmo deverá perguntar qual é a escolha
        do jogador 1 (Pedra [pe], Papel [pa], Tesoura [t]) e deverá fazer o mesmo para o jogador 2. No final da execução
        o algoritmo deverá dizer qual é o jogador vencedor ou se houve empate.*/

        Scanner reader = new Scanner(System.in);

        //Optei por não fazer com laço de repetição, para seguir cronograma.
        System.out.println("Jogador1 - Faça a sua escolha: ");
        System.out.println("Digite:");
        System.out.println("pe - pedra  |pa - papel  |t - tesoura");

        String jogadorA = reader.next();// jogadorA = jogador1, nomear como jogador1 não seria uma boa prática de programação
        reader.nextLine();// limpeza de buffer
        // Tratamento da entrada
        if(!jogadorA.equals("pe") && !jogadorA.equals("pa") && (jogadorA.charAt(0) != 't')){
            System.out.println("Erro de entrada: Opção Inválida!");
            reader.close();
            System.exit(1);
        }

        System.out.println("Jogador2 - Faça a sua escolha: ");
        System.out.println("Digite:");
        System.out.println("pe - pedra  |pa - papel  |t - tesoura");

        String jogadorB = reader.next();
        reader.nextLine();// limpeza de buffer
        // Tratamento da entrada
        if(!jogadorB.equals("pe") && !jogadorB.equals("pa") && (jogadorB.charAt(0) != 't')){
            System.out.println("Erro de entrada: Opção Inválida!");
            reader.close();
            System.exit(1);
        }

        System.out.println("Resultado ****************** ");
        if(jogadorA.equals(jogadorB)){
            System.out.println("Empate");
        }
        switch (jogadorA){
            case "pa":
                if(jogadorB.equals("pe")){
                    System.out.println("Vencedor: Jogador 1");
                }
                if(jogadorB.charAt(0) == 't'){
                    System.out.println("Vencedor: Jogador 2");
                }
                break;
            case "pe":
                if(jogadorB.equals("pa")){
                    System.out.println("Vencedor: Jogador 2");
                }
                if(jogadorB.charAt(0) == 't'){
                    System.out.println("Vencedor: Jogador 1");
                }
                break;
            case "t":
                if(jogadorB.equals("pe")){
                    System.out.println("Vencedor: Jogador 2");
                }
                if(jogadorB.equals("pa")){
                    System.out.println("Vencedor: Jogador 1");
                }
                break;
        }
        reader.close();
    }
}
