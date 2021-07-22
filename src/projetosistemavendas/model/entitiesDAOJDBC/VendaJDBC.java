package projetosistemavendas.model.entitiesDAOJDBC;

import projetosistemavendas.db.Db;
import projetosistemavendas.db.DbException;
import projetosistemavendas.model.entities.ItemVenda;
import projetosistemavendas.model.entities.Venda;
import projetosistemavendas.model.entitiesDao.VendaDAO;

import java.sql.*;
import java.util.List;

// Realizar as implementações
public class VendaJDBC implements VendaDAO {

    private Connection conn;

    public VendaJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public Long inserir(Venda venda) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement(
                    "INSERT INTO tb_venda " +
                            "(valor, data_hora) " +
                            "VALUES " +
                            "(?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            st.setDouble(1, venda.getValor());
            st.setDate(2, (Date) venda.getDataHora()); // verificar se o cast vai funcionar ou se precisarei de mais conversões

            int linhasAfetadas = st.executeUpdate();

            if (linhasAfetadas > 0) {
                Long rt = 0l;
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    Long id = rs.getLong(1);
                    venda.setId(id);
                    rt = id;
                }
                Db.closeResultSet(rs);
                return rt;
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
    public void atualizar(Venda venda) {

    }

    @Override
    public void deletarPeloId(Long id) {

    }

    @Override
    public Venda procurarPeloID(Long id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(
                    "SELECT * FROM tb_venda " +
                            "WHERE tb_venda.id = ?");
            st.setLong(1, id);
            rs = st.executeQuery();
            if(rs.next()){
                return instanciarVenda(rs);
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
    public List<Venda> buscarTodasVendas() {
        return null;
    }

    @Override
    public List<ItemVenda> buscarItensDeVenda(Venda venda) {
        return null;
    }

    public static Venda instanciarVenda(ResultSet rs){
        Venda venda = new Venda();
        try{
            venda.setId(rs.getLong("id"));
            venda.setDataHora(rs.getTimestamp("data_hora"));
            venda.setValor(rs.getDouble("valor"));
            return venda;
        }catch (SQLException e){
            throw new DbException("Error: "+e.getMessage());
        }
    }
}
