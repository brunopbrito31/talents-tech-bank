package projetosistemavendas.model.entities;

import projetosistemavendas.model.entitiesDao.FabricaDAO;
import projetosistemavendas.model.entitiesDao.ItemVendaDAO;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;

public class ItemVenda {

    private Long id;
    private BigDecimal quantidade;
    private BigDecimal pesoUnitario;
    private BigDecimal valorTotal;
    private Produto produto;
    private Venda venda;

    public ItemVenda() {
    }

    public ItemVenda(Long id, BigDecimal quantidade, BigDecimal pesoUnitario, BigDecimal valorTotal, Produto produto, Venda venda) {
        this.id = id;
        this.quantidade = quantidade;
        this.pesoUnitario = pesoUnitario;
        this.valorTotal = valorTotal;
        this.produto = produto;
        this.venda = venda;// porque o item de venda nasce antes da venda, o item de venda só recebe uma venda associada após a mesma ser criada
    }

    public static ItemVenda registrarItemVenda(ItemVenda itemVenda) {
        ItemVendaDAO itemVendaDAO = FabricaDAO.criarItemVendaDAO();

        Predicate<ItemVenda> codigoBarrasIguais = x -> x.getProduto().getCodigoDeBarras().equals(itemVenda.getProduto().getCodigoDeBarras());
        Predicate<ItemVenda> valorDeVendaIgual = x -> x.getProduto().getValorDaVenda().equals(itemVenda.getProduto().getValorDaVenda());

        Boolean condicaoCodBarras = itemVenda.getVenda().getItensVenda().stream().filter(codigoBarrasIguais).count() > 0;
        Boolean condicaoValorVenda = itemVenda.getVenda().getItensVenda().stream().filter(valorDeVendaIgual).count() > 0;

        // Caso o produto já esteja no carrinho de compras, ele só irá atualizar o valor total e a quantidade
        if (condicaoCodBarras && condicaoValorVenda) {
            Optional<ItemVenda> itemVendaExistente = itemVenda.getVenda().getItensVenda()
                    .stream()
                    .filter(x -> x.getProduto().getCodigoDeBarras().equals(itemVenda.getProduto().getCodigoDeBarras()))
                    .findFirst();
            itemVendaExistente.get().setQuantidade(itemVendaExistente.get().getQuantidade().add(itemVenda.getQuantidade())); // adicionei a quantidade do atual
            itemVendaExistente.get().setValorTotal(itemVendaExistente.get().getValorTotal().add(itemVenda.getValorTotal())); // adiciona o valor total ao existnte
            if (itemVendaExistente.isPresent()) {
                itemVendaDAO.atualizar(itemVendaExistente.get());
            }
            return itemVendaExistente.get();

        } else {// Caso o produto não esteja no carrinho, ele irá apenas adicionar
            itemVendaDAO.inserir(itemVenda);
            itemVenda.getVenda().getItensVenda().add(itemVenda);
            itemVenda.getVenda().setValor(itemVenda.getVenda().getValor().add(itemVenda.valorTotal));
            itemVenda.getVenda().atualizarVenda();
            return itemVenda;
        }
    }

    public void exibirItemNaVenda() {
        System.out.println("*********************************" + "\n" +
                "Produto: " + this.getProduto().getDescricao() + "\n" +
                "Quantidade: " + this.getQuantidade() + "\n" +
                "Peso unitário: " + this.getPesoUnitario() + "\n" +
                "Valor por " + this.getProduto().getUnidadeMedidaPeso() + " R$: " + this.getProduto().getValorDaVenda() + "\n" +
                "Valor Total R$: " + this.getValorTotal()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPesoUnitario() {
        return pesoUnitario;
    }

    public void setPesoUnitario(BigDecimal valorUnitario) {
        this.pesoUnitario = valorUnitario;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemVenda itemVenda = (ItemVenda) o;
        return Objects.equals(id, itemVenda.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ItemVenda{" +
                "id=" + id +
                ", quantidade=" + quantidade +
                ", pesoUnitario=" + pesoUnitario +
                ", valorTotal=" + valorTotal +
                ", produto=" + produto +
                '}';
    }
}
