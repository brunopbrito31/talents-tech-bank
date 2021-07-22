package projetosistemavendas.model.entities;

import java.util.Objects;


//checar os atributos de pesagem
public class Produto {

    private Long id;
    private String descricao;
    private Double valorCusto;
    private Double valorUnitario;
    private String unidadeMedidaPeso;
    private String codigoDeBarras;
    private Double valorDaVenda;

    public Produto(Long id, String descricao, double valorCusto, double valorUnitario, String unidadeMedidaPeso, String codigoDeBarras, double valorDaVenda) {
        this.id = id;
        this.descricao = descricao;
        this.valorCusto = valorCusto;
        this.valorUnitario = valorUnitario;
        this.unidadeMedidaPeso = unidadeMedidaPeso;
        this.codigoDeBarras = codigoDeBarras;
        this.valorDaVenda = valorDaVenda;
    }

    public Produto() {
    }

    public String exibirParaVenda(){
        return  "Código de Barras: "+getCodigoDeBarras()+"\n"+
                "Descrição do Produto: "+getDescricao()+"\n"+
                "Vendido por: "+getUnidadeMedidaPeso()+"\n"+
                "Valor por "+getUnidadeMedidaPeso()+" R$: "+String.format("%.2f",getValorUnitario())+"\n";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(double valorCusto) {
        this.valorCusto = valorCusto;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getUnidadeMedidaPeso() {
        return unidadeMedidaPeso;
    }

    public void setUnidadeMedidaPeso(String unidadeMedidaPeso) {
        this.unidadeMedidaPeso = unidadeMedidaPeso;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public void setCodigoDeBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }

    public double getValorDaVenda() {
        return valorDaVenda;
    }

    public void setValorDaVenda(double valorDaVenda) {
        this.valorDaVenda = valorDaVenda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", valorCusto=" + valorCusto +
                ", valorUnitario=" + valorUnitario +
                ", unidadeMedidaPeso='" + unidadeMedidaPeso + '\'' +
                ", codigoDeBarras='" + codigoDeBarras + '\'' +
                ", valorDaVenda=" + valorDaVenda +
                '}';
    }
}
