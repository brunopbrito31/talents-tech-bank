package projetosistemavendas.model.entitiesDAOJDBC;

import projetosistemavendas.db.Db;
import projetosistemavendas.db.DbException;
import projetosistemavendas.model.entities.ItemVenda;
import projetosistemavendas.model.entitiesDao.ItemVendaDAO;

import javax.xml.transform.Result;
import java.sql.*;

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
}
