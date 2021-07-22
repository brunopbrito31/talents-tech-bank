package projetosistemavendas;

import projetosistemavendas.db.Db;
import projetosistemavendas.model.entities.Produto;
import projetosistemavendas.model.entitiesDao.FabricaDAO;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Db.getConnection();
        /*System.out.print("Digite a descrição do produto: ");
        String descricao = reader.nextLine();
        System.out.print("Digite o valor de custo: ");
        Double valorCusto = reader.nextDouble();
        reader.nextLine();
        System.out.print("Digite o peso unitário: ");
        Double valorUnitario = reader.nextDouble();
        reader.nextLine();
        System.out.print("Digite a unidade de medida de peso: ");
        String unidadeMedida = reader.nextLine();
        System.out.print("Digite o código de barras: ");
        String codigoDeBarras = reader.nextLine();
        System.out.print("Digite o valor de venda: ");
        Double valorVenda = reader.nextDouble();
        reader.nextLine();
        Produto produto = new Produto(null,descricao,valorCusto,valorUnitario,unidadeMedida,codigoDeBarras,valorVenda);*/

        //FabricaDAO.criarProdutoDAO().inserir(produto);

        System.out.println(FabricaDAO.criarProdutoDAO().procurarPeloId(1l));

        /*System.out.println("Agora vamos verificar esse produto lá no banco de dados: ");
        FabricaDAO.criarProdutoDAO().buscarTodos().forEach(System.out::println);*/


    }
}
