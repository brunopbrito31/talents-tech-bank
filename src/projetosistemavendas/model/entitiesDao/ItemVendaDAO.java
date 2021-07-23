package projetosistemavendas.model.entitiesDao;

import projetosistemavendas.model.entities.ItemVenda;
import projetosistemavendas.model.entities.Venda;

import java.util.List;

public interface ItemVendaDAO {

    void inserir(ItemVenda itemVenda);

    void atualizar(ItemVenda itemVenda);

    void deletarPeloId(Long id);

    List<ItemVenda> procurarPelaVenda(Venda venda);


}
