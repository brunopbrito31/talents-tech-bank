package dia12.exerciciospropostos.exercicio6;

public class Main {
    public static void main(String[] args) {

        double n1 = ConversaoDeUnidadesDeTempo.minutoParaSegundos(3);
        double n2 = ConversaoDeUnidadesDeTempo.horaParaMinutos(3);
        double n3 = ConversaoDeUnidadesDeTempo.diaParaHoras(3);
        double n4 = ConversaoDeUnidadesDeTempo.SemanaPDias(3);
        double n5 = ConversaoDeUnidadesDeTempo.mesParaDias(3);
        double n6 = ConversaoDeUnidadesDeTempo.anoParaDias(3);

        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
        System.out.println(n4);
        System.out.println(n5);
        System.out.println(n6);

    }
}
