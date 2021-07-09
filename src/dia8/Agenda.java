package dia8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Agenda {
    /*Crie uma classe Agenda que pode armazenar 10 pessoas e que seja capaz de realizar as seguintes operações:
    void armazenaPessoa(String nome, int idade, float altura);
    void removePessoa(String nome);
    int buscaPessoa(String nome); // informa em que posição da agenda está a pessoa
    void imprimeAgenda(); // imprime os dados de todas as pessoas da agenda
    void imprimePessoa(int index); // imprime os dados da pessoa que está na posição “i” da agenda.*/

    private List<Pessoa> contatos = new ArrayList<>();
    private int limiteAgenda = 10; // Como não quero que haja a possibilidade de se alterar o limite, não vou disponibilizar os métodos get e set

    public void armazenarPessoa(String nome, String dataDeNascimento,float altura) throws ParseException {
        if(contatos.size() <10){
            contatos.add(new Pessoa(nome, altura, converterStringParaData(dataDeNascimento)));
        }else{
            System.out.println("Operação não permitida, agenda está lotada!");
        }
    }
    public void removerPessoa(String nome){
        Predicate<Pessoa> cond = x -> x.getNome().equals(nome);
        if(contatos.stream().filter(cond).collect(Collectors.toList()).isEmpty()){
            System.out.println("Contato inexistente!");
        }else{
            contatos.removeIf(cond);
        }
    }
    public Integer buscarContato(String nome){
        if(contatos.stream().filter(x -> x.getNome() == nome).collect(Collectors.toList()).isEmpty()){
            System.out.println("Contato inexistente!");
        }else{
            for(Pessoa x: contatos){
                if (x.getNome().equals(nome)) return contatos.indexOf(x);
            }
        }
        return null;
    }

    public void imprimirAgenda(){
        System.out.println("Contatos da Agenda: ");
        contatos.forEach(System.out::println);
    }

    public void imprimirPessoa(int index){
        if(index > 10){
            System.out.println("Posição inválida: ");
        }else{
            System.out.println("Contato procurado: ");
            System.out.println(contatos.get(index));
        }
    }


    public Date converterStringParaData(String data) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date dataPronta = sdf.parse(data);
        return dataPronta;
    }


}
