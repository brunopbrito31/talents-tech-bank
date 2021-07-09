package dia8;

import sun.java2d.pipe.SpanShapeRenderer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Pessoa {

    private String nome;
    private float altura;
    private Date dataNascimento;

    public Pessoa() {

    }

    public Pessoa(String nome, float altura, Date dataNascimento) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.nome = nome;
        this.altura = altura;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int calcularIdadeAtual(){
        Calendar cal = Calendar.getInstance(), cal2 = Calendar.getInstance();
        cal2.setTime(this.dataNascimento);
        cal.setTime(new Date());
        return cal.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);
    }

    @Override
    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(nome).append("\n");
        sb.append("Altura: ").append(altura).append("\n");
        sb.append("Data de Nascimento: ").append(sdf.format(dataNascimento)).append("\n");
        sb.append("Idade: ").append(calcularIdadeAtual());
        return sb.toString();
    }


}

