package projetobanco.model.entities.usuarios;

import java.util.Objects;

public class Gerente extends Usuario{

    private String identificador = "Gerente";

    public Gerente(String nome, String telefone, String identificador) {
        super(nome, telefone);
        identificador = identificador;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Gerente gerente = (Gerente) o;
        return Objects.equals(identificador, gerente.identificador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), identificador);
    }
}
