package dia3;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static int metodoRecursivo(int i) {   // Atenção ao estouro de pilha
        if(i <= 10){
            return metodoRecursivo(i+1);
        }
        return i;
    }

    public static void main(String[] args) {


        System.out.println("WHILE");
        int contagem = 11;

        while(contagem < 11){
            System.out.println(contagem);
            contagem++;
        }

        contagem = 11;

        System.out.println("DO-WHILE");
        do{
            System.out.println(contagem);
            contagem++;
        }while (contagem <11);

        // para (i =0; i < 10; i++)

        System.out.println("FOR");
        for( int i = 0; i < 10; i++){
            System.out.println(i);
        }

        System.out.println("Iterando sobre uma lista com forEach");

        List<Integer> listaDeInt = new ArrayList<>();
        listaDeInt.addAll(Arrays.asList(1,2,3));

        System.out.println("forEach1");
        listaDeInt.forEach(System.out::println);

        System.out.println("forEach2");
        listaDeInt.forEach(a ->{
            System.out.println(a);
        });

        System.out.println("for-each");
        for (int x: listaDeInt){
            System.out.println(x);
        }

        System.out.println("Testando o loop recursivo");
        System.out.println(metodoRecursivo(1));

        //TODO pesquisar cenários melhores para while e do while
    }
}
