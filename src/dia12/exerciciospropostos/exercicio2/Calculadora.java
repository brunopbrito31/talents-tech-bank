package dia12.exerciciospropostos.exercicio2;

import java.util.function.Function;

public class Calculadora {

    public static double somar (double a, double b){
        return a + b ;
    }
    public static double subtrair (double a, double b){
        return a - b;
    }
    public static double multiplicar (double a, double b){
        return a * b;
    }
    public static double dividir (double dividendo, double divisor){
        if(divisor == 0 || (dividendo == 0 && divisor == 0)){
            throw new IllegalArgumentException("Indefinição matemática");
        }else{
            return dividendo/divisor;
        }
    }
    public static double elevarA (double base, double expoente){
        double result = 1;
        for(int i = 0 ;i < expoente ; i ++){
            result = result*base;
        }
        return result;
    }
    public static int calcularFactorial(int num){
        int result = 1;
        for(int i = num; i>0; i --){
            result = result*i;
        }
        return result;
    }
}
