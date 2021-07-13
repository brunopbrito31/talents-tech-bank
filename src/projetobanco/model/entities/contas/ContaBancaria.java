package projetobanco.model.entities.contas;

import projetobanco.model.entities.usuarios.Cliente;


public abstract class ContaBancaria {

    private int numeroDaConta;

    private Cliente titular;

    private double saldo;


    public ContaBancaria(int numeroDaConta, Cliente titular, double saldo) {
        this.numeroDaConta = numeroDaConta;
        this.titular = titular;
        this.saldo = saldo;
    }

    public void depositar(double valor){
        if(valor > 0){
            saldo = saldo + valor;
        }else{
            throw new IllegalArgumentException("valor inválido");
        }
    }

    public abstract double sacar(double valor);


    public abstract void imprimirExtrato();



    public int getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setNumeroDaConta(int numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    //método para finalizar a conta

}
