package projetosistemavendas.model.entities;

import projetosistemavendas.model.entitiesDao.FabricaDAO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;


//checar os atributos de pesagem
public class Produto {

    private Long id;
    private String descricao;
    private BigDecimal valorCusto;
    private BigDecimal pesoUnitario;
    private String unidadeMedidaPeso;
    private String codigoDeBarras;
    private BigDecimal valorDaVenda;

    public Produto(Long id, String descricao, BigDecimal valorCusto, BigDecimal pesoUnitario, String unidadeMedidaPeso, String codigoDeBarras, BigDecimal valorDaVenda) {
        this.id = id;
        this.descricao = descricao;
        this.valorCusto = valorCusto;
        this.pesoUnitario = pesoUnitario;
        this.unidadeMedidaPeso = unidadeMedidaPeso;
        this.codigoDeBarras = codigoDeBarras;
        this.valorDaVenda = valorDaVenda;
    }

    public Produto() {
    }

    public void cadastrarNovoProduto() {
        FabricaDAO.criarProdutoDAO().inserir(this);
    }

    public static Boolean verificarExistencia(String codigoDeBarras) {
        return FabricaDAO.criarProdutoDAO().verificarSeExiste(codigoDeBarras);
    }

    public static List<Produto> buscarListaProdutos() {
        return FabricaDAO.criarProdutoDAO().buscarTodos();
    }

    public static void exibirTodosProdutosVenda() {
        System.out.println();
        List<Produto> produtos = Produto.buscarListaProdutos();
        produtos.forEach(Produto::exibirParaVenda);
    }

    public static Produto buscarProdutoPorCod(String codigoDeBarras) {
        return FabricaDAO.criarProdutoDAO().procurarPeloCodigoDeBarras(codigoDeBarras);
    }

    public void removerProduto() {
        FabricaDAO.criarProdutoDAO().deletarPeloId(this.getId());
    }

    public void exibirParaVenda() {
        String exib = "Código de Barras: " + getCodigoDeBarras() + "\n" +
                "Descrição do Produto: " + getDescricao() + "\n" +
                "Vendido por: " + getUnidadeMedidaPeso() + "\n" +
                "Valor por " + getPesoUnitario() + " R$: " + String.format("%.2f", getValorDaVenda()) + "\n";
        System.out.println(exib);
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

    public BigDecimal getValorCusto() {
        return valorCusto;
    }

    public void setValorCusto(BigDecimal valorCusto) {
        this.valorCusto = valorCusto;
    }

    public BigDecimal getPesoUnitario() {
        return pesoUnitario;
    }

    public void setPesoUnitario(BigDecimal valorUnitario) {
        this.pesoUnitario = valorUnitario;
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

    public BigDecimal getValorDaVenda() {
        return valorDaVenda;
    }

    public void setValorDaVenda(BigDecimal valorDaVenda) {
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
                ", pesoUnitario=" + pesoUnitario +
                ", unidadeMedidaPeso='" + unidadeMedidaPeso + '\'' +
                ", codigoDeBarras='" + codigoDeBarras + '\'' +
                ", valorDaVenda=" + valorDaVenda +
                '}';
    }
}
