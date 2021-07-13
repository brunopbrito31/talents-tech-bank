package projetobanco.model.entities.contas;

import projetobanco.model.entities.usuarios.Cliente;

public class ContaPoupanca extends ContaBancaria{

    public ContaPoupanca(int numeroDaConta, Cliente titular, double saldo) {
        super(numeroDaConta, titular, saldo);
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
}
