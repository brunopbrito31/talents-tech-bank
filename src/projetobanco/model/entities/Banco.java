package projetobanco.model.entities;

import projetobanco.model.entities.contas.ContaBancaria;
import projetobanco.model.entities.usuarios.Gerente;
import projetobanco.model.services.ServicosDaConta;
import projetobanco.model.services.ServicosDoMenu;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Banco {

    private static final String NOME_BANCO = "Rainbow Bank";

    public Banco(){
        System.out.println("BANCO: "+NOME_BANCO+"  ***********************************");
        contas = new ArrayList<>();
        gerentes = new HashSet<>();
        gerentes.add(new Gerente("Virginia","11999995555",1037));
        gerentes.add(new Gerente("Gisele","55988884457",1835));
        gerentes.add(new Gerente("Bruno","75975554444",8899));
        ContaBancaria contaInicial = ServicosDaConta.criarContaBancaria();
        contas.add(contaInicial);
        ServicosDoMenu.exibirMenu();
    }

    private static List<ContaBancaria> contas ;

    private static Set<Gerente> gerentes;

    public static List<ContaBancaria> getContas(){
        return contas;
    }

    public static Set<Gerente> getGerentes() {
        return gerentes;
    }
}
