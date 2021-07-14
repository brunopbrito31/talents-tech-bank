package projetobanco.model.entities.contas;
import projetobanco.model.entities.Banco;
import projetobanco.model.entities.usuarios.Cliente;
import java.util.stream.Collectors;

public class ContaCorrente extends ContaBancaria{

    private double saldoChequeEspecial;
    private double saldoAdicionalChequeEspecial;
    private double limiteChequeEspecial;
    private double adicionalChequeEspecial;
    private double saldoTotal = getSaldo()+saldoChequeEspecial+saldoAdicionalChequeEspecial;
    private double saldoComCheque = getSaldo() + saldoChequeEspecial;

    public ContaCorrente(int numeroDaConta, Cliente titular, double saldo) {
        super(numeroDaConta, titular, saldo);
        limiteChequeEspecial = 0;
        adicionalChequeEspecial = 0;
        saldoChequeEspecial = 0;
        saldoAdicionalChequeEspecial = 0;
    }

    @Override // Verificar os calculos
    public double sacar(double valor) {
        if(valor > saldoTotal){ // acima do saldo total
            throw new IllegalArgumentException("Saldo insuficiente!");
        }else if(valor < 0){
            throw new IllegalArgumentException("Valor incorreto!");
        }else if(valor > getSaldo() && valor <= saldoComCheque){ // valor abaixo  ou igual do total com cheque
            saldoChequeEspecial = saldoChequeEspecial - (valor - getSaldo());
            setSaldo(0);
            System.out.println("Seu cheque especial foi utilizado");
            return saldoChequeEspecial;
        }else if(valor > saldoComCheque && valor <= saldoTotal){ // valor acima do cheque especial e dentro do adiconal
            saldoAdicionalChequeEspecial = saldoTotal - valor; // verificar esta condição
            saldoChequeEspecial = 0;
            setSaldo(0);
            System.out.println("Seu adicional do cheque foi utilizado");
            return saldoAdicionalChequeEspecial;
        }
        return 0;
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

    // erro na validação
    public void adicionarLimiteChequeEspecial(double valor, int senhaGerente){
        // verificar se há um gerente com a senha
        Boolean condicao = Banco.getGerentes().stream().filter(x -> x.getIdentificador().equals(senhaGerente)).count() > 0;
        if(condicao){
            setLimiteChequeEspecial(valor);
            setSaldoAdicionalChequeEspecial(valor * 0.35);
            saldoChequeEspecial = limiteChequeEspecial;
            saldoAdicionalChequeEspecial = adicionalChequeEspecial;
        }else{
            throw new IllegalArgumentException("Acesso negado!");
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
