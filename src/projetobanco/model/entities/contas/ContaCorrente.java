package projetobanco.model.entities.contas;

import com.sun.org.apache.bcel.internal.generic.ATHROW;
import projetobanco.model.entities.usuarios.Cliente;

public class ContaCorrente extends ContaBancaria{


    private double saldoChequeEspecial;
    private double saldoAdicionalChequeEspecial;
    private double limiteChequeEspecial;
    private double adicionalChequeEspecial;
    private double debitoAdicionalChequeEspecial = adicionalChequeEspecial - saldoAdicionalChequeEspecial;
    private double debitoChequeEspecial = limiteChequeEspecial-saldoChequeEspecial;
    private double saldoTotal = super.getSaldo()+saldoChequeEspecial+saldoAdicionalChequeEspecial;


    public ContaCorrente(int numeroDaConta, Cliente titular, double saldo) {
        super(numeroDaConta, titular, saldo);
        limiteChequeEspecial = 0;
        adicionalChequeEspecial = 0;
        saldoChequeEspecial = 0;
        debitoChequeEspecial = 0;
    }

    @Override // Verificar os calculos
    public double sacar(double valor) {
        if(valor <= getSaldo()){
            setSaldo(getSaldo()-valor);
            return getSaldo();
        }else if(valor > getSaldo() && valor <= getSaldo()+saldoChequeEspecial){
            double result = saldoChequeEspecial - (valor - getSaldo());
            saldoChequeEspecial = result;
            System.out.println("Você utilizou R$:"+String.format("%.2f",result)+" do seu cheque especial");
            setSaldo(0);
            return -1 * saldoChequeEspecial;
        }else if(valor > getSaldo()+saldoChequeEspecial+saldoAdicionalChequeEspecial){
            double result = saldoChequeEspecial+saldoAdicionalChequeEspecial+getSaldo()-valor;
            System.out.println("Você utilizou R$:"+String.format("%.2f",result)+" do seu limite emergencial de crédito");
            saldoAdicionalChequeEspecial = result;
            saldoChequeEspecial = 0;
            setSaldo(0);
            return -1 * (saldoAdicionalChequeEspecial+limiteChequeEspecial);
        }else{
            throw new IllegalArgumentException("Saldo insuficiente!");
        }
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }


    public double getSaldoChequeEspecial() {
        return saldoChequeEspecial;
    }

    public void setSaldoChequeEspecial(double saldoChequeEspecial) {
        this.saldoChequeEspecial = saldoChequeEspecial;
    }

    public double getSaldoAdicionalChequeEspecial() {
        return saldoAdicionalChequeEspecial;
    }

    public void setSaldoAdicionalChequeEspecial(double saldoAdicionalChequeEspecial) {
        this.saldoAdicionalChequeEspecial = saldoAdicionalChequeEspecial;
    }

    public double getDebitoChequeEspecial() {
        return debitoChequeEspecial;
    }

    public void setDebitoChequeEspecial(double debitoChequeEspecial) {
        this.debitoChequeEspecial = debitoChequeEspecial;
    }

    public void setLimiteChequeEspecial(double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public double getAdicionalChequeEspecial() {
        return adicionalChequeEspecial;
    }

    public void setAdicionalChequeEspecial(double adicionalChequeEspecial) {
        this.adicionalChequeEspecial = adicionalChequeEspecial;
    }

    public double getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(double saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    public void adicionarLimiteChequeEspecial(double valor, String senhaGerente){
        if(senhaGerente.equals("gerenteRainbow123")){
            limiteChequeEspecial = limiteChequeEspecial + valor;
            adicionalChequeEspecial = limiteChequeEspecial * 0.35; // clientes do Rainbow possuem um limite adicional de 35% do cheque especial
        }else{
            throw new IllegalArgumentException("Acesso Negado!");
        }
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString())
                .append("\n")
                .append(" Tipo de Conta: ")
                .append("Corrente");
        return sb.toString();
    }
}
