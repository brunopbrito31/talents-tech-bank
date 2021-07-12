package dia12.exercicioconversaodeunidades;

public class ConversaoDeUnidadesDeArea {

    final static double METROQUADRADO_PESQUADRADOS = 10.76d;
    final static double PEQUADRADO_CENTQUADRADO = 929d;
    final static double MILHAQUADRADA_ACRES = 640d;
    final static double ACRE_PESQUADRADOS =  43_560;


    public static double convMetroQuadradoPesQuadrados(double metroQuadrado){
        return METROQUADRADO_PESQUADRADOS*metroQuadrado;
    }
    public static double convPeQuadradoParaCentQuadrado(double peQuadrado){
        return PEQUADRADO_CENTQUADRADO*peQuadrado;
    }
    public static double convMilhaQuadradaParaAcres(double milhaQuadrada){
        return MILHAQUADRADA_ACRES*milhaQuadrada;
    }
    public static double convAcreParaPesQuadrados(double acre){
        return acre*ACRE_PESQUADRADOS;
    }

}
