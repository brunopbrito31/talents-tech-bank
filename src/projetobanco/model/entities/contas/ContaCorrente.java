package projetobanco.model.entities.contas;

import projetobanco.model.entities.usuarios.Cliente;

public class ContaCorrente extends ContaBancaria{


    private double limiteChequeEspecial;
    private double adicionalChequeEspecal;


    public ContaCorrente(int numeroDaConta, Cliente titular, double saldo) {
        super(numeroDaConta, titular, saldo);
        limiteChequeEspecial = 0;
        adicionalChequeEspecal = 0;
    }

    @Override
    public void depositar(double valor) {

    }

    @Override
    public double sacar(double valor) {
        return 0;
    }

    @Override
    public void imprimirExtrato() {

    }

    public void adicionarLimiteChequeEspecial(double valor, String senhaGerente){
        if(senhaGerente.equals("gerenteRainbow123")){
            limiteChequeEspecial = limiteChequeEspecial + valor;
            adicionalChequeEspecal = limiteChequeEspecial * 0.35; // clientes do Rainbow possuem um limite adicional de 35% do cheque especial
        }else{
            throw new IllegalArgumentException("Acesso Negado!");
        }
    }
}
