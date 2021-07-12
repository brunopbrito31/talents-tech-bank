package dia12.exerciciospropostos.exercicio5;

public class Main {

    public static void main(String[] args) {

        double n1 = ConversaoDeUnidadesDeVolume.galaoAmericanoParaLitros(10d);
        double n2 = ConversaoDeUnidadesDeVolume.galaoAmericanoParaPolegadasCubicas(10d);
        double n3 = ConversaoDeUnidadesDeVolume.metroCubicoParaLitro(10d);
        double n4 = ConversaoDeUnidadesDeVolume.metroCubicoParaPesCubicos(10d);
        double n5 = ConversaoDeUnidadesDeVolume.litroParaCentCubicos(10d);

        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
        System.out.println(n4);
        System.out.println(n5);
    }
}
