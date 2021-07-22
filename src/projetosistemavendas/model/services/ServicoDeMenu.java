package projetosistemavendas.model.services;

import projetosistemavendas.db.DbException;
import projetosistemavendas.model.entities.ItemVenda;
import projetosistemavendas.model.entities.Produto;
import projetosistemavendas.model.entities.Venda;
import projetosistemavendas.model.entitiesDao.FabricaDAO;
import projetosistemavendas.model.entitiesDao.ItemVendaDAO;
import projetosistemavendas.model.entitiesDao.ProdutoDAO;
import projetosistemavendas.model.entitiesDao.VendaDAO;

import java.time.Instant;
import java.util.Date;
import java.util.List;
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
            System.out.println();
            System.out.print("Digite o código de barras do produto que deseja cadastrar ou 0 para cancelar: ");
            String codBarras = reader.nextLine().trim();
            if(codBarras.equals("0")){
                quantidadeCadastros = 0;
                break;
            }
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
                    System.out.println();
                }
            }catch (DbException e){
                System.out.println("Error: "+e.getMessage());
            }
            quantidadeCadastros --;
        }
    }

    // implementar um estoque e a remoção e adição dos produtos lá
    public static void realizarVenda(){
        Scanner reader = new Scanner(System.in);
        Date momentoVenda1 = Date.from(Instant.now());
        Date momentoVenda = new java.sql.Date(momentoVenda1.getTime());
        VendaDAO vendaDAO = FabricaDAO.criarVendaDAO();
        Venda vendaAtual = new Venda(null,0d,momentoVenda);
        Long idVendaAtual = vendaDAO.inserir(vendaAtual);
        ProdutoDAO prod = FabricaDAO.criarProdutoDAO();
        List<Produto> produtosListados = prod.buscarTodos();
        int n = 0;
        while (n == 0){
            System.out.println("Digite 0 para adcionar produtos ou 1 para sair");
            n = validacaoInteiro(reader);
            if(n !=1 && n != 0) throw new IllegalArgumentException("Opção inválida! ");
            System.out.println("Produtos Disponíveis para Venda: ");
            for(Produto x: produtosListados) System.out.println(x.exibirParaVenda());
            gerarItemVenda(idVendaAtual);
            //Falta imprimir a lista de elementos atualizados do pedido
            ItemVendaDAO itemVendaDAO = FabricaDAO.criarItemVendaDAO();
            for(ItemVenda x: itemVendaDAO.procurarPelaVenda(FabricaDAO.criarVendaDAO().procurarPeloID(idVendaAtual))){
                System.out.println(x);
            }
        }
    }
    public static void gerarItemVenda(Long idVenda) {
        Scanner reader = new Scanner(System.in);
        ProdutoDAO prod = FabricaDAO.criarProdutoDAO();
        System.out.print("Digite o código de barras do produto: ");
        String cod = reader.nextLine().trim();
        if(prod.procurarPeloCodigoDeBarras(cod) == null) {
            throw new IllegalArgumentException("Produto não encontrado ou não esta disponível no estoque!");
        }else{
            System.out.println();
            System.out.println("Dados do produto escolhido: ");
            Produto produtoEscolhido = prod.procurarPeloCodigoDeBarras(cod);
            System.out.println("Teste de retorno do produto "+produtoEscolhido);
            produtoEscolhido.exibirParaVenda();
            System.out.println("Confirma a escolha? (S/N)");
            char opcao = reader.nextLine().toLowerCase().trim().charAt(0);
            if(opcao != 's' && opcao != 'n') throw new IllegalArgumentException("Opção inválida!");
            else if(opcao == 'n') gerarItemVenda(idVenda);
            else{
                System.out.println("Digite a quantidade desejada");
                Double quantidade = validacaoDouble(reader);
                ItemVenda itemVenda = new ItemVenda(null,quantidade,produtoEscolhido.getValorUnitario(),
                        produtoEscolhido.getValorDaVenda() * quantidade, produtoEscolhido );
                ItemVendaDAO itemVendaDAO = FabricaDAO.criarItemVendaDAO();
                VendaDAO vendaDAO = FabricaDAO.criarVendaDAO();
                Venda vendaPersistida = vendaDAO.procurarPeloID(idVenda);
                itemVenda.setVenda(vendaPersistida);
                itemVendaDAO.inserir(itemVenda);
                System.out.println("Item adicionado com sucesso!");
            }

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
