package dia12.exerciciodatv;

public class ControleRemoto {

    private Televisao tv;

    public ControleRemoto(Televisao tv){
        this.tv = tv;
    }

    public void ligarTV(){
        if(tv.getStatus() == 0) tv.setStatus(1);
        System.out.println("BEM-VINDO! TV Ligada");
    }

    public void desligarTV(){
        if(tv.getStatus() == 1) tv.setStatus(0);
    }

    public void aumentarVolumeTV(){
        if(tv.getStatus() != 0){
            tv.aumentarVolume();
        }
    }
    public void diminuirVolumeTV(){
        if(tv.getStatus() != 0){
            tv.diminuirVolume();
        }
    }

    public void trocarProximoCanalTV(){
        if(tv.getStatus() != 0){
            tv.trocarProximoCanal();
        }
    }

    public void trocarCanalIndicadoTv(int num){
        if(tv.getStatus() != 0){
            tv.trocarParaCanalIndicado(num);
        }
    }

    public void consultarVolumeTV(){
        if(tv.getStatus() !=0 ){
            System.out.println("Volume: "+tv.getVolume());
        }
    }

    public void consultarCanalTV(){
        if(tv.getStatus() != 0){
            System.out.println("Canal: "+tv.getCanalAtual());
        }
    }

}
