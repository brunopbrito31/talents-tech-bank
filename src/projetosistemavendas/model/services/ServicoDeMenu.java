package projetosistemavendas.model.services;

import projetosistemavendas.db.DbException;
import projetosistemavendas.model.entities.Produto;
import projetosistemavendas.model.entitiesDao.FabricaDAO;
import projetosistemavendas.model.entitiesDao.ProdutoDAO;

import java.util.Locale;
import java.util.Scanner;

public class ServicoDeMenu {

    public static void cadastrarNovosProdutos() {
        Locale.setDefault(Locale.US);
        Scanner reader = new Scanner(System.in);
        ProdutoDAO prod = FabricaDAO.criarProdutoDAO();
        System.out.println("Cadastro de Produto*-*-*-*-*-*-*-*-*-*-*-*-*-*-* ");
        //realizar a letura dos dados, a começar pelo código de barras para verificar se já existe um produto
        // com o mesmo código de barras
        System.out.print("Digite quantos produtos deseja cadastrar: ");
        int quantidadeCadastros = reader.nextInt();
        reader.nextLine();
        while(quantidadeCadastros > 0){
            System.out.print("Digite o código de barras do produto que deseja cadastrar: ");
            String codBarras = reader.nextLine().trim();
            try{
                if(prod.procurarPeloCodigoDeBarras(codBarras) != null) throw new DbException("Produto já cadastrado na base de dados!");
                else{
                    System.out.print("Digite a descrição do produto: ");
                    String descricao = reader.nextLine();
                    System.out.print("Digite o valor de custo: ");
                    Double valorCusto = reader.nextDouble();
                    reader.nextLine();
                    System.out.print("Digite o peso unitário: ");
                    Double pesoUnitario = reader.nextDouble();
                    reader.nextLine();
                    System.out.print("Digite a unidade de medida de peso: ");
                    String unidadeMedidaPeso = reader.nextLine();
                    System.out.print("Digite o valor de venda: ");
                    Double valorVenda = reader.nextDouble();
                    reader.nextLine();
                    Produto produto = new Produto(null,descricao,valorCusto,pesoUnitario,unidadeMedidaPeso,codBarras,valorVenda);
                    prod.inserir(produto);
                    System.out.println("Produto cadastrado com sucesso!");
                }
            }catch (DbException e){
                System.out.println("Error: "+e.getMessage());
            }
            quantidadeCadastros --;
        }


    }
}