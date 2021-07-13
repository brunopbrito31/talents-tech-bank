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
    public double sacar(double valor){
        if(valor > 0){
            if(valor <= getSaldo()) {
                setSaldo(getSaldo() - valor);
                return getSaldo();
            } else {
                throw new IllegalArgumentException("Saldo insuficiente!");
            }
        }else{
            throw new IllegalArgumentException("Valor inválido");
        }
    }

    @Override
    public void imprimirExtrato() {

    }
}
