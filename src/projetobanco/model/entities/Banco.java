package projetobanco.model.entities;

import projetobanco.model.entities.contas.ContaBancaria;
import projetobanco.model.services.ServicosDaConta;
import projetobanco.model.services.ServicosDoMenu;


import java.util.ArrayList;
import java.util.List;

public class Banco {

    private static final String NOME_BANCO = "Rainbow Bank";

    public Banco(){
        System.out.println("BANCO: "+NOME_BANCO+"  ***********************************");
        contas = new ArrayList<>();
        ContaBancaria contaInicial = ServicosDaConta.criarContaBancaria();
        contas.add(contaInicial);
        ServicosDoMenu.exibirMenu();
    }

    private static List<ContaBancaria> contas ;

    public static List<ContaBancaria> getContas(){
        return contas;
    }









}
