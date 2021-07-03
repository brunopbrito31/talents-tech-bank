package dia2;

import java.util.Locale;
import java.util.Scanner;

public class Exercicios {

    public static void main(String[] args){
        exercicio4();
    }

    public static void exercicio1(){
        /*Descrição do Exercicio:
        Algoritmo que armazena o valor 99 em na variável y e o valor 11 na variável z.
        Realiza a troca dos valores das variáveis entre si utilizando apenas atribuições
        entre variáveis
        * */

        short z = 11;
        short y = 99;
        short coringa = 0; // Variável auxiliar para ajudar no processo da troca

        System.out.println("Valores Iniciais:");
        System.out.println("Valor inicial de y: "+y);
        System.out.println("Valor inicial de Z: "+z);

        coringa = y;
        y = z;
        z = coringa;

        System.out.println();// Quebra de linha para organizar melhor a saída
        System.out.println("Valores Finais:");
        System.out.println("Valor final de y: "+y);
        System.out.println("Valor final de Z: "+z);
    }

    public static void exercicio2(){
        /*Descrição do Exercicio:
        Algoritmo para realizar a leitura de um valor(do teclado) e escrever na tela
        o seu antecessor
        */

        Scanner reader = new Scanner(System.in);
        System.out.print("Digite o número que deseja verificar o antecessor: ");
        int num = reader.nextInt();
        //TODO tratar erros de inputs diferentes de inteiros
        reader.nextLine(); // Limpeza de Buffer

        System.out.println("O Antecessor do número digitado é: "+ --num);

        reader.close();
    }

    public static void exercicio3(){
        /*Descrição do Exercicio:
        Algoritmo que lê as dimensões de um retângulo(base e altura), calcula e
        escreve a área do retângulo.
        */
        Locale.setDefault(Locale.US); // Para manter no padrão: "." como delimitador de ponto flutuante

        Scanner reader = new Scanner(System.in);
        System.out.println("Digite a base do retângulo: ");
        double base = reader.nextDouble();
        System.out.println("Digite a altura do retângulo: ");
        double altura = reader.nextDouble();

        double area = base*altura;

        System.out.println("A área desse retângulo é: "+String.format(String.format("%.2f",area)));
        /* String.format... poderia ser substituido por uma combinação de:
        System.out.printf("A área desse retângulo é de %.2f",area);
        entre várias outras possibilidades.
        */

        reader.close();
    }

    public static void exercicio4(){
        /*Descrição do Exercicio:
        Algoritmo que recebe a quantidade total de votos de um município e calcula as porcentagens de
        votos nulos, brancos e válidos em relação ao total de eleitores.
        */

        /*Entrada com adoção de variáveis do tipo double para conseguir realizar o cálculo da divisão
        no cálculo da porcentagem com precisão maior, pois com casting eu teria valores truncados, com
        grande perda na precisão*/
        Scanner reader = new Scanner(System.in);
        System.out.println("Digite a quantidade de votos brancos: ");
        double votosBrancos = reader.nextInt();
        System.out.println("Digite a quantidade de votos nulos: ");
        double votosNulos = reader.nextInt();
        System.out.println("Digite a quantidade de votos válidos: ");
        double votosValidos = reader.nextInt();

        // Processamento
        double votosTotalMunicipio = votosBrancos+votosNulos+votosValidos;
        double percentualVotosBrancos, percentualVotosNulos, percentualVotosValidos;
        percentualVotosBrancos = (votosBrancos*100/votosTotalMunicipio);
        percentualVotosNulos = (votosNulos*100/votosTotalMunicipio);
        percentualVotosValidos = (votosValidos*100/votosTotalMunicipio);

        //Saída
        System.out.println(); // Para garantir uma organização melhor da saída de dados
        System.out.println("Percentual-de-Votos ********************************************");
        System.out.println("Brancos: "+String.format("%.2f",percentualVotosBrancos)+"%");
        System.out.println("Nulos: "+String.format("%.2f",percentualVotosNulos)+"%");
        System.out.println("Válidos: "+String.format("%.2f",percentualVotosValidos)+"%");
        System.out.println("****************************************************************");

        reader.close();
    }

}
