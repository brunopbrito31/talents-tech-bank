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
        System.out.print("Digite quantos produtos deseja cadastrar: ");
        int quantidadeCadastros = validacaoInteiro(reader);
        while(quantidadeCadastros > 0){
            System.out.print("Digite o código de barras do produto que deseja cadastrar: ");
            String codBarras = reader.nextLine().trim();
            try{
                if(prod.procurarPeloCodigoDeBarras(codBarras) != null) throw new DbException("Produto já cadastrado na base de dados!");
                else{
                    System.out.print("Digite a descrição do produto: ");
                    String descricao = reader.nextLine();
                    System.out.print("Digite o valor de custo: ");
                    Double valorCusto = validacaoDouble(reader);
                    System.out.print("Digite o peso unitário: ");
                    Double pesoUnitario = validacaoDouble(reader);
                    System.out.print("Digite a unidade de medida de peso: ");
                    String unidadeMedidaPeso = reader.nextLine();
                    System.out.print("Digite o valor de venda: ");
                    Double valorVenda = validacaoDouble(reader);
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

    public static Integer validacaoInteiro(Scanner reader){
        Integer numero;
        if(!reader.hasNextInt())throw new IllegalArgumentException("Entrada deve ser um número inteiro");
        numero = reader.nextInt();
        reader.nextLine();
        if(numero < 0) throw new IllegalArgumentException("Entrada deve ser 0 ou positiva");
        return numero;
    }

    public static Double validacaoDouble(Scanner reader){
        Double numero;
        if(!reader.hasNextDouble())throw new IllegalArgumentException("Entrada deve ser um número");
        numero = reader.nextDouble();
        reader.nextLine();
        if(numero < 0) throw new IllegalArgumentException("Entrada deve ser 0 ou positiva");
        return numero;
    }
}
