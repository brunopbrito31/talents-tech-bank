package dia12.exerciciodatv;

public class Canal {

    private String nome;
    private Integer numero;

    public Canal(String nome, Integer numero) {
        this.nome = nome;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Canal{" +
                "nome='" + nome + '\'' +
                ", numero=" + numero +
                '}';
    }
}
