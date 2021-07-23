package projetosistemavendas.auxiliar.componentsmenu.componentsmenu;

import projetosistemavendas.model.entities.ItemVenda;
import projetosistemavendas.model.entities.Produto;
import projetosistemavendas.model.entities.Venda;

import java.math.BigDecimal;
import java.util.Scanner;

public class Menu {

    public static void iniciar(){
        Scanner reader = new Scanner(System.in);
        int opcao = 0;
        System.out.println("-*--*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("Bem vindo ao sistema de vendas Bruno31Corp!");
        while(opcao !=3){
            try{
                System.out.println("@## Para venda, digite 1 ");
                System.out.println("@## Para cadastrar produto, digite 2 ");
                System.out.println("@## Para sair do programa digite 3 ");
                System.out.print("Digite aqui a sua opção -> ");
                opcao = validacaoInteiro(reader);
                if(opcao < 1 || opcao > 3) throw new IllegalArgumentException("Entrada inválida!");
                else if(opcao == 3){
                    opcao = 3;
                    break;
                }else{
                    switch (opcao){
                        case 1:
                            realizarVenda(reader);
                            break;
                        case 2:
                            cadastrarNovoProduto(reader);
                    }
                }

            }catch (IllegalArgumentException e){
                System.out.println("Error: "+e.getMessage());
            }
        }
        reader.close();
    }

    private static void cadastrarNovoProduto(Scanner reader) {
        try{
            System.out.println("Cadastro de Produtos -*--*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.print("Digite o código de barras do produto que deseja cadastar: ");
            String cod = reader.nextLine();
            if (Produto.verificarExistencia(cod))
                throw new IllegalArgumentException("Produto já está cadastrado na base de dados!");
            else {
                System.out.print("Digite a descrição do produto: ");
                String descricao = reader.nextLine();
                System.out.print("Digite o valor de custo do produto: ");
                BigDecimal valorCusto = validacaoBigDecimal(reader);
                System.out.print("Digite o peso unitário do produto: ");
                BigDecimal pesoUnitario = validacaoBigDecimal(reader);
                System.out.print("Digite a unidade de medida/peso do produto: ");
                String unidadeMedidaPeso = reader.nextLine();
                System.out.print("Digite o valor de venda do produto: ");
                BigDecimal valorVenda = validacaoBigDecimal(reader);
                Produto produtoCadastrado = new Produto(null, descricao, valorCusto, pesoUnitario, unidadeMedidaPeso, cod, valorVenda);
                produtoCadastrado.cadastrarNovoProduto();
                System.out.println("Produto cadastrado com sucesso!");
                System.out.println();
            }
        }catch (IllegalArgumentException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
    // implementar um estoque e a remoção e adição dos produtos lá
    private static void realizarVenda(Scanner reader) {
        System.out.println();
        System.out.println("Realizar Venda");
        Venda vendaAtual = Venda.AbrirVenda();
        int op = 0;

        while (op == 0) {
            try{
                System.out.println("Produtos disponíveis para venda -*--*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                Produto.exibirTodosProdutosVenda();
                System.out.print("Digite o cód do produto desejado ou 1 para sair: ");
                String codBarras = reader.nextLine();
                if (codBarras.charAt(0) == '1') {
                    System.out.println("Saindo...");
                    op = 1;
                    break;
                } else if (!Produto.verificarExistencia(codBarras)) {
                    throw new IllegalArgumentException("Produto inexistente no estoque!");
                } else {
                    Produto produtoAtual = Produto.buscarProdutoPorCod(codBarras);
                    System.out.println("Produto escolhido: ");
                    produtoAtual.exibirParaVenda();
                    System.out.println("Confirma? (S/N");
                    char resposta = reader.nextLine().toLowerCase().trim().charAt(0);
                    if (resposta == 'n') {
                        // volta para o começo do laço ou chama essa função dnovo
                    } else if (resposta != 'n' && resposta != 's') {
                        throw new IllegalArgumentException("Entrada inválida!");
                    } else {
                        System.out.print("Digite a quantidade: ");
                        BigDecimal quantidade = validacaoBigDecimal(reader);
                        ItemVenda itemVendaAtual = new ItemVenda(null, quantidade,
                                produtoAtual.getPesoUnitario(), produtoAtual.getValorDaVenda().multiply(quantidade), produtoAtual, vendaAtual);
                        ItemVenda.registrarItemVenda(itemVendaAtual);
                        System.out.println("Item adicionado com sucesso ao carrinho!");
                        System.out.println();
                        System.out.println("Itens do carrinho:");
                        vendaAtual.exibirTodosItens();
                        System.out.println("Valor total da Compra R$: "+vendaAtual.calcularTotal());
                        System.out.println();
                    }
                }
            }catch (IllegalArgumentException e){
                System.out.println("Error: "+e.getMessage());
            }
        }
    }

    private static Integer validacaoInteiro(Scanner reader) {
        Integer numero;
        if (!reader.hasNextInt()) throw new IllegalArgumentException("Entrada deve ser um número inteiro");
        numero = reader.nextInt();
        reader.nextLine();
        if (numero < 0) throw new IllegalArgumentException("Entrada deve ser 0 ou positiva");
        return numero;
    }

    private static BigDecimal validacaoBigDecimal(Scanner reader) {
        BigDecimal numero;
        if (!reader.hasNextBigDecimal()) throw new IllegalArgumentException("Entrada deve ser um número");
        numero = reader.nextBigDecimal();
        reader.nextLine();
        if (numero.compareTo(BigDecimal.valueOf(0d)) < 0) throw new IllegalArgumentException("Entrada deve ser 0 ou positiva");
        return numero;
    }
}
