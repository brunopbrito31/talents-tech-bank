package projetobanco.model.entities.contas;
import projetobanco.model.entities.usuarios.Cliente;

public class ContaPoupanca extends ContaBancaria{

    public ContaPoupanca(int numeroDaConta, Cliente titular, double saldo) {
        super(numeroDaConta, titular, saldo);
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
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append("\n")
                .append(" Tipo de Conta: ")
                .append("Poupança");
        return sb.toString();
    }
}
