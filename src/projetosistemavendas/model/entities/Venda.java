package projetosistemavendas.model.entities;

import java.util.Date;
import java.util.Objects;

public class Venda {

    private Long id;
    private Double valor;
    private Date dataHora;
    //private List<ItemVenda> itensVenda;

    public Venda(Long id, Double valor, Date dataHora) {
        this.id = id;
        this.valor = valor;
        this.dataHora = dataHora;
        //itensVenda = new ArrayList<>();
    }

    public Venda() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    /*public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venda venda = (Venda) o;
        return Objects.equals(id, venda.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", valor=" + valor +
                ", dataHora=" + dataHora+
                '}';
    }
}
