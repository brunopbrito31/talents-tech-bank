package projetosistemavendas.model.entitiesDao;

import projetosistemavendas.db.Db;
import projetosistemavendas.model.entitiesDAOJDBC.ItemVendaJDBC;
import projetosistemavendas.model.entitiesDAOJDBC.ProdutoJDBC;
import projetosistemavendas.model.entitiesDAOJDBC.VendaJDBC;

public class FabricaDAO {

    public static ProdutoDAO criarProdutoDAO() {
        return new ProdutoJDBC(Db.getConnection());
    }

    public static ItemVendaDAO criarItemVendaDAO() {
        return new ItemVendaJDBC(Db.getConnection());
    }

    public static VendaDAO criarVendaDAO() {
        return new VendaJDBC(Db.getConnection());
    }

}
