package dia12.exerciciospropostos.exercicio1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int stop = 0;
        while(stop == 0){
            System.out.println("Digite: 1 = Zerar o Contador | 2 = Incrementar o Contador | 3 = Verificar Valor Atual | 4 = sair");
            validaInteiro(reader);
            int op = reader.nextInt();
            reader.nextLine();
            stop = processarEntrada(op);
            validaOpcao(op,reader);
        }
        reader.close();
    }
    public static void validaOpcao(int op, Scanner reader){
        if(op > 4 || op < 1){
            reader.close();
            throw new IllegalArgumentException("Opção Inválida");
        }
    }
    public static void validaInteiro(Scanner reader){
        if(!reader.hasNextInt()){
            reader.close();
            throw new IllegalArgumentException("Entrada Inválida");
        }
    }
    public static int processarEntrada(int op){
        int stop = 0;
        switch (op){
            case 1:
                Contador.zerarContagem();
                System.out.println("Contador zerado");
                break;
            case 2:
                Contador.acrescentarContador();
                System.out.println("Contador+1");
                break;
            case 3:
                System.out.println("Valor Atual: "+Contador.getCont());
                break;
            case 4:
                stop = 1;
                break;
        }
        return stop;
    }
}
