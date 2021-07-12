package dia12.exerciciospropostos.exercicio5;

public class ConversaoDeUnidadesDeVolume {

    private static final double LITRO_P_CENTIMETROSCUBICOS = 1_000;

    private static final double METROCUBICO_P_LITROS = 1_000;

    private static final double METROCUBICO_P_PESCUBICOS = 35.32;

    private static final double GALAOAMERICANO_P_POLEGADASCUBICAS = 231;

    private static final double GALAOAMERICANO_P_LITROS = 3_785;

    public static double litroParaCentCubicos (double litros){
        return litros * LITRO_P_CENTIMETROSCUBICOS;
    }

    public static double metroCubicoParaLitro (double metroCubico){
        return metroCubico * METROCUBICO_P_LITROS;
    }

    public static double metroCubicoParaPesCubicos (double metroCubico){
        return metroCubico * METROCUBICO_P_PESCUBICOS;
    }

    public static double galaoAmericanoParaPolegadasCubicas (double galaoAmericano){
        return galaoAmericano * GALAOAMERICANO_P_POLEGADASCUBICAS;
    }

    public static double galaoAmericanoParaLitros (double galaoAmericano){
        return galaoAmericano * GALAOAMERICANO_P_LITROS;
    }

}
