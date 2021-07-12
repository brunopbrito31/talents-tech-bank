package dia12.exerciciospropostos.exercicio6;

public class ConversaoDeUnidadesDeTempo {

    private final static double MINUTO_P_SEGUNDOS = 60;
    private final static double HORA_P_MINUTOS = 60;
    private final static double DIA_P_HORAS = 24;
    private final static double SEMANA_P_DIAS = 7;
    private final static double MES_P_DIAS = 30;
    private final static double ANO_P_DIAS = 365.25;

    public static double minutoParaSegundos (double minuto){
        return MINUTO_P_SEGUNDOS * minuto;
    }
    public static double horaParaMinutos (double hora){
        return HORA_P_MINUTOS * hora;
    }
    public static double diaParaHoras (double dia){
        return DIA_P_HORAS * dia;
    }
    public static double SemanaPDias (double semana) {
        return SEMANA_P_DIAS * semana;
    }
    public static double mesParaDias (double mes){
        return MES_P_DIAS * mes;
    }
    public static double anoParaDias (double ano){
        return ANO_P_DIAS * ano;
    }
}
