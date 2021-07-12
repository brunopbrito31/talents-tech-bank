package dia12.exerciciodatv;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Televisao {

    private int status =0;
    private Integer numeroSerie = 5257;
    private Integer volume = 0;
    private List<Canal> listaDeCanais;
    private Canal canalAtual;

    public Televisao() {
        this.listaDeCanais = new ArrayList<>();
        listaDeCanais.add(new Canal("globo",11));
        listaDeCanais.add(new Canal("record",5));
        listaDeCanais.add(new Canal("sbt",4));
        canalAtual = listaDeCanais.get(0);
    }

    public void trocarParaCanalIndicado(int num){
        if(listaDeCanais.stream().filter(x -> x.getNumero().equals(num)).collect(Collectors.toList()).isEmpty()){
            System.out.println("Canal não encontrado");
        }else{
            for(Canal x: listaDeCanais){ // solução temporária, porém ruim
                if(x.getNumero() == num) canalAtual = x;
            }
            //this.canalAtual = listaDeCanais.get(listaDeCanais.indexOf(num));// condição que está quebrando o programa
            System.out.println("Canal: "+canalAtual);
        }
    }

    public void trocarProximoCanal(){
        // Verificação se irá retornar para o canal inicial, caso o canal seja o ultimo da lista
        if(canalAtual == listaDeCanais.get(listaDeCanais.size()-1)){
            canalAtual = listaDeCanais.get(0);
            System.out.println("Canal: "+canalAtual);
        } else{
            canalAtual = listaDeCanais.get(listaDeCanais.indexOf(canalAtual)+1);
            System.out.println("Canal: "+canalAtual);
        }
    }

    public void aumentarVolume(){
        if(volume <= 100) volume++;
        System.out.println("Volume = "+volume);
    }
    public void diminuirVolume(){
        if(volume == 0) System.out.println("Volume = 0");
        else{
            volume--;
            System.out.println("Volume = "+volume);
        }
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public List<Canal> getListaDeCanais() {
        return listaDeCanais;
    }

    public void setListaDeCanais(List<Canal> listaDeCanais) {
        this.listaDeCanais = listaDeCanais;
    }

    public Canal getCanalAtual() {
        return canalAtual;
    }

    public void setCanalAtual(Canal canalAtual) {
        this.canalAtual = canalAtual;
    }
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Televisao televisao = (Televisao) o;
        return Objects.equals(numeroSerie, televisao.numeroSerie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroSerie);
    }
}
