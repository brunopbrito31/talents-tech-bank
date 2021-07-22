package projetosistemavendas.model.entitiesDao;

import projetosistemavendas.model.entities.ItemVenda;
import projetosistemavendas.model.entities.Venda;

import java.util.List;

public interface ItemVendaDAO {

    ItemVenda procurarPeloId(Long id);

    List<ItemVenda> procurarTodosPelaVenda(Long id);

    void inserirVenda(Venda venda);

    


}
