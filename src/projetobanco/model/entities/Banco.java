package projetobanco.model.entities;

import projetobanco.model.entities.contas.ContaBancaria;
import projetobanco.model.services.ServicosDaConta;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private static final String NOME_BANCO = "Rainbow Bank";

    public Banco(){
        /*contas = new ArrayList(){{
            ContaBancaria contaInicial = ServicosDaConta.criarContaBancaria();
            add(contaInicial);
        }};*/
        ContaBancaria contaInicial = ServicosDaConta.criarContaBancaria();
        contas.add(contaInicial);
    }

    private static List<ContaBancaria> contas = new ArrayList<>();

    public static List<ContaBancaria> getContas(){
        return contas;
    }









}
