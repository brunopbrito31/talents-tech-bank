package projetosistemavendas.model.entitiesDao;

import projetosistemavendas.model.entities.Produto;

import java.util.List;

public interface ProdutoDAO {

    void inserir(Produto produto);
    void atualizar(Produto produto);
    void deletarPeloId(Long id);
    Produto procurarPeloId(Long id);
    List<Produto> buscarTodos();
    Produto procurarPeloCodigoDeBarras(String cod);

}
