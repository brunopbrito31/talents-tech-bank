package projetosistemavendas.model.entitiesDAOJDBC;

import projetosistemavendas.db.Db;
import projetosistemavendas.db.DbException;
import projetosistemavendas.model.entities.ItemVenda;
import projetosistemavendas.model.entities.Produto;
import projetosistemavendas.model.entities.Venda;
import projetosistemavendas.model.entitiesDao.ItemVendaDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemVendaJDBC implements ItemVendaDAO {

    private Connection conn;

    public ItemVendaJDBC(Connection conn) {
        this.conn = conn;
    }


    // O item de venda começa com o atributo venda com um valor nulo, porém quando uma venda é criada
    // e associada ao item de venda, este recebe o objeto do tipo venda, logo apartir desse momento o id de venda é atualizado
    // no banco de dados
    @Override
    public void inserir(ItemVenda itemVenda) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                    "INSERT INTO tb_item_venda " +
                            "(id_venda, id_produto, quantidade, valor_unitario, valor_total) " +
                            "VALUES " +
                            "(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            st.setLong(1, itemVenda.getVenda().getId());//resolver esse impasse na modelagem
            st.setLong(2, itemVenda.getProduto().getId());
            st.setDouble(3, itemVenda.getQuantidade());
            st.setDouble(4, itemVenda.getValorUnitario());
            st.setDouble(5, itemVenda.getValorTotal());

            int linhasAfetadas = st.executeUpdate();

            if (linhasAfetadas > 0){
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    Long id = rs.getLong(1);
                    itemVenda.setId(id);
                }
                Db.closeResultSet(rs);
            }else{
                throw new DbException("Erro inesperado! Sem linhas afetadas");
            }

        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            Db.closeStatement(st);
        }
    }

    @Override
    public void atualizar(ItemVenda itemVenda) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement(
                    "UPDATE tb_item_venda " +
                            "SET id_venda = ?, id_produto = ?, quantidade = ?, valor_unitario = ?, valor_total = ? " +
                            "WHERE id = ?");
            st.setLong(1, itemVenda.getVenda().getId());
            st.setLong(2, itemVenda.getProduto().getId());
            st.setDouble(3, itemVenda.getQuantidade());
            st.setDouble(4, itemVenda.getValorUnitario());
            st.setDouble(5,itemVenda.getValorTotal());
            st.setDouble(6, itemVenda.getId());

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
            st = conn.prepareStatement("DELETE FROM tb_item_venda WHERE id = ?");

            st.setLong(1,id);

            st.executeUpdate();
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            Db.closeStatement(st);
        }
    }


    @Override
    public ItemVenda procurarPeloId(Long id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(
                    "SELECT tb_item_venda.*, "
            );
            return null; /// alterar esse código
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }
    }

    @Override
    public List<ItemVenda> procurarPelaVenda(Venda venda) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement(
                    "SELECT tb_item_venda.*, tb_produto.descricao, tb_produto.valor_custo, " +
                            "tb_produto.peso_unitario, tb_produto.unidade_medida_peso, codigo_de_barras, " +
                            "valor_venda FROM tb_item_venda INNER JOIN tb_produto " +
                            "ON tb_item_venda.id_produto = tb_produto.id " +
                            "WHERE tb.item_venda.id_venda = ?");
            st.setLong(1,venda.getId());
            rs = st.executeQuery();
            List<ItemVenda> itensVendas = new ArrayList<>();

            while (rs.next()) {
                ItemVenda itemVenda = new ItemVenda();
                itemVenda.setId(rs.getLong("id"));
                itemVenda.setVenda(venda);
                Produto produto = new Produto();
                produto.setId(rs.getLong("tb_item_venda.id_produto"));
                produto.setDescricao(rs.getString("tb_produto.descricao")); // talvez precise tirar o tb_produto
                produto.setValorCusto(rs.getDouble("tb_produto.valor_custo"));
                produto.setValorDaVenda(rs.getDouble("tb_produto.valor_venda"));
                produto.setCodigoDeBarras(rs.getString("tb_produto.codigo_de_barras"));
                itemVenda.setProduto(produto);
                itemVenda.setQuantidade(rs.getDouble("tb_item_venda.quantidade"));
                itemVenda.setValorUnitario(rs.getDouble("tb_item_venda.valor_unitario"));
                itemVenda.setValorTotal(rs.getDouble("tb_intem_venda.valor_total"));
                itensVendas.add(itemVenda);
            }
            return itensVendas;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            Db.closeResultSet(rs);
            Db.closeStatement(st);
        }
    }
}
