package projetosistemavendas.model.entities;

import projetosistemavendas.model.entitiesDao.FabricaDAO;
import projetosistemavendas.model.entitiesDao.VendaDAO;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Venda {

    private Long id;
    private BigDecimal valor;
    private Date dataHora;
    private List<ItemVenda> itensVenda;

    public Venda(Long id, BigDecimal valor, Date dataHora) {
        this.id = id;
        this.valor = valor;
        this.dataHora = dataHora;
        itensVenda = new ArrayList<>();
    }

    public Venda() {
    }

    public static Venda AbrirVenda() {
        Venda vendaAberta = new Venda(null, BigDecimal.valueOf(0d), new java.sql.Date(Date.from(Instant.now()).getTime()));
        FabricaDAO.criarVendaDAO().inserirAberturaVenda(vendaAberta);
        return vendaAberta;
    }

    public void atualizarVenda() {
        FabricaDAO.criarVendaDAO().atualizar(this);
    }

    public void exibirTodosItens() {
        itensVenda.forEach(ItemVenda::exibirItemNaVenda);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }

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
                ", dataHora=" + dataHora +
                '}';
    }
}
