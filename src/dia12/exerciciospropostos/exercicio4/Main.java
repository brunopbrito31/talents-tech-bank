package dia12.exerciciospropostos.exercicio4;

import dia12.exercicioconversaodeunidades.ConversaoDeUnidadesDeArea;

public class Main {

    public static void main(String[] args) {

        System.out.println("Conversão de 10.2 Metros quadrados para pés quadrados: "+ dia12.exercicioconversaodeunidades.ConversaoDeUnidadesDeArea.convMetroQuadradoPesQuadrados(10.2));
        System.out.println("Conversão de 10.2 Pés quadrados para centimetros quadrados: "+ dia12.exercicioconversaodeunidades.ConversaoDeUnidadesDeArea.convPeQuadradoParaCentQuadrado(10.2));
        System.out.println("Conversão de 10.2 Milhas quadradas para acres: "+ dia12.exercicioconversaodeunidades.ConversaoDeUnidadesDeArea.convMilhaQuadradaParaAcres(10.2));
        System.out.println("Conversão de 10.2 acres para pés quadrados: "+String.format("%.2f", ConversaoDeUnidadesDeArea.convAcreParaPesQuadrados(10.2)));

    }



}
