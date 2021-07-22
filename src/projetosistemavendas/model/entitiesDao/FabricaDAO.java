package projetosistemavendas.model.entitiesDao;

import projetosistemavendas.db.Db;
import projetosistemavendas.model.entitiesDAOJDBC.ProdutoJDBC;

public class FabricaDAO {

    public static ProdutoDAO criarProdutoDAO (){
        return new ProdutoJDBC(Db.getConnection());
    }
}
