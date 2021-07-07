package dia8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Desafio {
    public static void main(String[] args) {
        int[] vect = {-6,-9,-2,0,2,5,7,3,12};
        desafio1(vect);
    }

    public static void desafio1(int[] arrayGenérico){
        /*Dado um array de números inteiros com valores negativos e positivos,
        encontro o número mais próximo de zero. Se ouver valores como 2 e -2,
        considere o número positivo.*/
        if(encontrarMenor(arrayGenérico, x -> x > 0, 1) == -encontrarMenor(arrayGenérico, x -> x < 0, 2)){
            System.out.println("Como os 2 números possuíam módulos iguais, retorno apenas do módulo do número: "+encontrarMenor(arrayGenérico, x -> x > 0, 1));
        }else {
            System.out.println("Valor que mais se aproxima de 0 pelo lado positivo é: " + encontrarMenor(arrayGenérico, x -> x > 0, 1));
            System.out.println("O valor que mais se aproxima de 0 pelo lado negativo é: " + encontrarMenor(arrayGenérico, x -> x < 0, 2));
        }
    }

    // operacao = 1 para numeros positivos, 2 para indicar numeros negativos
    public static Integer encontrarMenor(int[] array, Predicate<Integer> condicaoMenor,int operacao){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < array.length; i++) list.add(array[i]);
        int menor = Math.abs(list.get(0));
        list = list.stream().filter(condicaoMenor).collect(Collectors.toList());

        // operacao para encontrar o menor numero
        for(int i = 0; i < list.size(); i++){
            if(Math.abs(list.get(i)) < menor) menor = Math.abs(list.get(i));
        }
        if(operacao == 1) return menor;
        if(operacao == 2) return (-1*menor);
        return null;

    }



}
