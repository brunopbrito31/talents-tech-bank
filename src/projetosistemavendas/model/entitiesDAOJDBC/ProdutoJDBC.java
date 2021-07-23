package projetosistemavendas.model.entitiesDAOJDBC;

import projetosistemavendas.db.Db;
import projetosistemavendas.db.DbException;
import projetosistemavendas.model.entities.Produto;
import projetosistemavendas.model.entitiesDao.ProdutoDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoJDBC implements ProdutoDAO {

    private Connection conn;

    public ProdutoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void inserir(Produto produto) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "INSERT INTO tb_produto " +
                            "(descricao, valor_custo, peso_unitario, unidade_medida_peso, codigo_de_barras, valor_venda) " +
                            "VALUES " +
                            "(?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            st.setString(1, produto.getDescricao());
            st.setBigDecimal(2, produto.getValorCusto());
            st.setBigDecimal(3, produto.getPesoUnitario());
            st.setString(4, produto.getUnidadeMedidaPeso());
            st.setString(5, produto.getCodigoDeBarras());
            st.setBigDecimal(6, produto.getValorDaVenda());

            int linhasAfetadas = st.executeUpdate();

            if (linhasAfetadas > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    Long id = rs.getLong(1);
                    produto.setId(id);
                }
                Db.closeResultSet(rs);
            } else {
                throw new DbException("Ocorreu um erro. Não houveram linhas afetadas!");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            Db.closeStatement(st);
        }
    }

    @Override
    public void atualizar(Produto produto) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
              "UPDATE tb_produto " +
                      "SET descricao = ?, valor_custo = ?, peso_unitario = ?, unidade_medida_peso = ?, codigo_de_barras = ?, valor_venda =? " +
                      "WHERE id = ?");
            st.setString(1, produto.getDescricao());
            st.setBigDecimal(2, produto.getValorCusto());
            st.setBigDecimal(3, produto.getPesoUnitario());
            st.setString(4, produto.getUnidadeMedidaPeso());
            st.setString(5, produto.getCodigoDeBarras());
            st.setBigDecimal(6, produto.getValorDaVenda());

            st.executeUpdate();
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            Db.closeStatement(st);
        }

    }

    @Override
    public void deletarPeloId(Long id) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("DELETE FROM tb_produto WHERE id = ?");

            st.setLong(1, id);
            st.executeUpdate();
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            Db.closeStatement(st);
        }
    }

    @Override
    public Boolean verificarSeExiste(String codBarras) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(
                    "SELECT count(codigo_de_barras) " +
                            "FROM tb_produto " +
                            "WHERE codigo_de_barras = ?"
            );
            st.setString(1,codBarras);
            rs = st.executeQuery();
            if(rs.next()){
                if (rs.getInt("count") > 0){
                    return true;
                }
                return false;
            }
            return false;
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public Produto procurarPeloId(Long id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(
                    "SELECT * FROM tb_produto " +
                            "WHERE tb_produto.id = ?");
            st.setLong(1, id);
            rs = st.executeQuery();
            if(rs.next()){
                return instanciarProduto(rs);
            }
            return null;
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            Db.closeStatement(st);
            Db.closeResultSet(rs);
        }
    }

    @Override
    public List<Produto> buscarTodos() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT * FROM tb_produto");
            rs = st.executeQuery();
            List<Produto> produtos = new ArrayList<>();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getLong("id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setCodigoDeBarras(rs.getString("codigo_de_barras"));
                produto.setValorCusto(rs.getBigDecimal("valor_custo"));
                produto.setValorDaVenda(rs.getBigDecimal("valor_venda"));
                produto.setPesoUnitario((rs.getBigDecimal("peso_unitario")));
                produto.setUnidadeMedidaPeso(rs.getString("unidade_medida_peso"));
                produtos.add(produto);
            }
            return produtos;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            Db.closeResultSet(rs);
            Db.closeStatement(st);
        }
    }

    public static Produto instanciarProduto(ResultSet rs){
        Produto produto = new Produto();
        try{
            produto.setId(rs.getLong("id"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setValorCusto(rs.getBigDecimal("valor_custo"));
            produto.setPesoUnitario(rs.getBigDecimal("peso_unitario"));
            produto.setUnidadeMedidaPeso(rs.getString("unidade_medida_peso"));
            produto.setCodigoDeBarras(rs.getString("codigo_de_barras"));
            produto.setValorDaVenda(rs.getBigDecimal("valor_venda"));
            return produto;
        }catch (SQLException e){
            throw new DbException("Error: "+e.getMessage());
        }
    }

    @Override
    public Produto procurarPeloCodigoDeBarras(String cod) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(
                    "SELECT * FROM tb_produto " +
                            "WHERE tb_produto.codigo_de_barras = ?");
            st.setString(1, cod);
            rs = st.executeQuery();
            if(rs.next()){
                return instanciarProduto(rs);
            }
            return null;
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            Db.closeStatement(st);
            Db.closeResultSet(rs);
        }
    }

}
