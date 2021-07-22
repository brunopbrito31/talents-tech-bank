package projetosistemavendas.model.entitiesDAOJDBC;

import projetosistemavendas.model.entities.ItemVenda;
import projetosistemavendas.model.entities.Venda;
import projetosistemavendas.model.entitiesDao.VendaDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

// Realizar as implementações
public class VendaJDBC implements VendaDAO {

    private Connection conn;

    public VendaJDBC(Connection conn){
        this.conn = conn;
    }

    @Override
    public void inserir(Venda venda) {

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
        return null;
    }

    @Override
    public List<Venda> buscarTodasVendas() {
        return null;
    }

    @Override
    public List<ItemVenda> buscarItensDeVenda(Venda venda) {
        return null;
    }
}
