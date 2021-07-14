package projetobanco;

import projetobanco.model.entities.Banco;

public class Main {

    public static void main(String[] args) {
        Banco.inicializar();
        Banco.getContas().forEach(System.out::println);
    }
}
