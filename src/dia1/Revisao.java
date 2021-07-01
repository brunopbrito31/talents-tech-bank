package dia1;

import java.sql.SQLOutput;

public class Revisao {

    public static void main(String[] args) {

        short s = 123;
        int i = s;
        long l = i;
        float f = l;
        double d = f;

        double d2 = 100000000000000.00;
        float f2 = (float)d2;
        long l2 = (long)f2;
        int i2 = (int)12;
        short s2 = (short)i2;

        System.out.println("Primeiro teste, Valor de s2: "+s2);

        short a1 = 123, b1 = 123;
        int c1 = a1 + b1;

        System.out.println("Segundo teste, Valor de c1: "+c1);

        int a2 = 123, b2 = 123, c2 = a2 + b2;

        System.out.println("Terceiro teste, valor de c2: "+c2);

        int maiorIntA = 2147483647, maiorIntB = 2147483647;

        int resultado = maiorIntA+maiorIntB;
        System.out.println("Resultado da soma dos 2 maiores inteiros: "+resultado);

        long resultLong = (long)maiorIntA + (long)maiorIntB;
        long resultLong3 = maiorIntA*1L + maiorIntB*1L;
        System.out.println("Result Long = "+resultLong);
        System.out.println("Result Long3 = "+resultLong3);

        int xpto = 1;
        long xpto2 = 2;
        long resultXpto = xpto + xpto2;

        System.out.println("*****************************");

        System.out.println("Divisão de Números Inteiros: ");
        System.out.println("1/1 = "+1/1);
        System.out.println("1/2 = "+1/2);
        System.out.println("3/1 = "+3/1);
        System.out.println("9/3 = "+9/3);

        System.out.println("*****************************");
        System.out.println("Divisão de Números Double: ");
        System.out.println("1.0/1.0 = "+1.0/1.0);
        System.out.println("1.0/2.0 = "+1.0/2.0);
        System.out.println("3.0/1.0 = "+3.0/1.0);
        System.out.println("9.0/3.0 = "+9.0/3.0);

        System.out.println("*****************************");
        System.out.println("Divisão de Inteiros com Cast no Numerador: ");
        System.out.println("1/1 = "+((double)1/1));
        System.out.println("1/2 = "+((double)1/2));
        System.out.println("3/1 = "+((double)3/1));
        System.out.println("9/3 = "+((double)9/3));

        System.out.println("*****************************");
        System.out.println("Divisão de Inteiros com Cast no Numerador e Denominador: ");
        System.out.println("1/1 ="+ ((double)1 / (double)1));
        System.out.println("1/2 ="+ ((double)1 / (double)2));
        System.out.println("3/1 ="+ ((double)3 / (double)1));
        System.out.println("9/3 ="+ ((double)9 / (double)3));







    }
}
