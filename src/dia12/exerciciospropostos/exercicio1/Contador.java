package dia12.exerciciospropostos.exercicio1;

public class Contador {
    private static int cont = 0;

    public Contador(){
        cont++;
    }

    public static void zerarContagem(){
        cont = 0;
    }

    public static void acrescentarContador(){
        new Contador();
    }

    public static int getCont(){
        return cont;
    }
}
