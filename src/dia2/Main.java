package dia2;

public class Main {

    public static void main(String[] args) {
        operadores();
    }

    public static void operadores() {
        int idade = 20; // ok

        int i = 1 + 1; // ok

        System.out.println(10.0 / 3.0);  // ok
        System.out.println(10 % 3);  // ok


        boolean operadorRelacional = 1 == 2; // ==, !=, >, <,  >=, <= // ok
        //boolean tiposDiferentes = "1" == 1; Impossível de fazer no Java // ok


        // Operadores Lógicos

        boolean testeLogico = 1 == 1 || 2 == 1; // ok

        boolean invertido = !true; // ok
    }

}
