package projetosistemavendas.model.entitiesDao;

import projetosistemavendas.model.entities.ItemVenda;

import java.util.List;

public interface ItemVendaDAO {

    void inserir(ItemVenda itemVenda);
    void atualizar(ItemVenda itemVenda);
    void deletarPeloId(Long id);
    ItemVenda procurarPeloId(Long id);


}
