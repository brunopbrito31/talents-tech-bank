package dia12.exercicioconversaodeunidades;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Conversão de 10.2 Metros quadrados para pés quadrados: "+ConversaoDeUnidadesDeArea.convMetroQuadradoPesQuadrados(10.2));
        System.out.println("Conversão de 10.2 Pés quadrados para centimetros quadrados: "+ConversaoDeUnidadesDeArea.convPeQuadradoParaCentQuadrado(10.2));
        System.out.println("Conversão de 10.2 Milhas quadradas para acres: "+ConversaoDeUnidadesDeArea.convMilhaQuadradaParaAcres(10.2));
        System.out.println("Conversão de 10.2 acres para pés quadrados: "+String.format("%.2f",ConversaoDeUnidadesDeArea.convAcreParaPesQuadrados(10.2)));

    }



}
