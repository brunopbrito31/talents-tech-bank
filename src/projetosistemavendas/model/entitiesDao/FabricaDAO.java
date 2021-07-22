package projetosistemavendas.model.entitiesDao;

import projetosistemavendas.db.Db;
import projetosistemavendas.model.entitiesDAOJDBC.ItemVendaJDBC;
import projetosistemavendas.model.entitiesDAOJDBC.ProdutoJDBC;

public class FabricaDAO {

    public static ProdutoDAO criarProdutoDAO() {
        return new ProdutoJDBC(Db.getConnection());
    }

    public static ItemVendaDAO criarItemVendaDAO() {
        return new ItemVendaJDBC(Db.getConnection());
    }

}
