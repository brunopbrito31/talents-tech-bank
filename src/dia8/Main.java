package dia8;

import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    /*Exercicios:
    * Crie uma classe para representar uma pessoa, com os atributos de nome, ano de nascimento e altura.
    Crie e também um método para imprimir todos dados de uma pessoa. Crie um método para mostrar quantos anos
    a pessoa fará/terá neste ano.
    Crie uma classe Agenda que pode armazenar 10 pessoas e que seja capaz de realizar as seguintes operações:
    void armazenaPessoa(String nome, int idade, float altura);
    void removePessoa(String nome);
    int buscaPessoa(String nome); // informa em que posição da agenda está a pessoa
    void imprimeAgenda(); // imprime os dados de todas as pessoas da agenda
    void imprimePessoa(int index); // imprime os dados da pessoa que está na posição “i” da agenda.*/


    public static void main(String[] args) throws ParseException {
        // Ps: como se trata de uma agenda eu poderia ter feito todos os métodos estáticos caso quisesse utilizar apenas 1,
        // como quero admitir a existência de várias agendas optei por tratar cada agenda como uma instância
        Locale.setDefault(Locale.US);
        Scanner reader = new Scanner(System.in);

        Agenda agenda = new Agenda();

        System.out.println("Digite quantos contatos deseja adicionar na agenda: ");
        int n = reader.nextInt();
        reader.nextLine(); // Limpeza de buffer

        entradaDeDadosAgenda(n,reader,agenda);

        agenda.imprimirAgenda();

        reader.close();


    }

    public static void entradaDeDadosAgenda(int n, Scanner reader, Agenda agenda) throws ParseException {
        while(n > 0){
            System.out.print("Digite o nome do contato: ");
            String nome = reader.nextLine().trim();
            System.out.print("Digite a altura do contato: ");
            Float altura = reader.nextFloat();
            reader.nextLine(); // Limpeza de buffer
            System.out.print("Digite a data de nascimento do contato (Formato: DD/MM/AAAA): ");
            String dtNascimento = reader.nextLine().trim();
            agenda.armazenarPessoa(nome,dtNascimento,altura);
            n--;
        }
    }


}
