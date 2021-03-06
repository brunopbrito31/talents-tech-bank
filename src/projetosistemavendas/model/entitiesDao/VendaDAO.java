package projetosistemavendas.model.entitiesDao;

import projetosistemavendas.model.entities.ItemVenda;
import projetosistemavendas.model.entities.Venda;

import java.util.List;

public interface VendaDAO {

    Long inserir(Venda venda);

    Long inserirAberturaVenda(Venda venda);

    void atualizar(Venda venda);

    void deletarPeloId(Long id);

    Venda procurarPeloID(Long id);

    List<Venda> buscarTodasVendas();

    List<ItemVenda> buscarItensDeVenda(Venda venda);

}
