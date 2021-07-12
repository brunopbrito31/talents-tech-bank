package dia12.exerciciodatv;


import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int opcao = 0;
        ControleRemoto contr = criarControle();

        while(opcao != 8){
            exibirDisplay();
            opcao = reader.nextInt();
            reader.nextLine(); // Limpeza de buffer
            processarEntrada(opcao,contr,reader);
        }
    }
    public static ControleRemoto criarControle(){
        ControleRemoto contr = new ControleRemoto(new Televisao());
        return contr;
    }

    public static void exibirDisplay(){
        System.out.println();
        System.out.println("-----------Menu do controle, Opções Disponíveis: ");
        System.out.println("Volume:    1. Aumentar o volume  2. Diminuir o volume              3. Consultar o volume ");
        System.out.println("Canal:     4. Próximo canal      5. Trocar para o canal indicado   6. Consultar o canal atual ");
        System.out.println("Controle:  7. Ligar a TV         8. Desligar a TV                  9. Sair do programa Controle Remoto");
        System.out.println();
    }

    public static void processarEntrada(int opcao, ControleRemoto contr, Scanner reader){
        switch (opcao){
            case 1:
                contr.aumentarVolumeTV();
                break;
            case 2:
                contr.diminuirVolumeTV();
                break;
            case 3:
                contr.consultarVolumeTV();
                break;
            case 4:
                contr.trocarProximoCanalTV();
                break;
            case 5:
                System.out.println("Digite o número do canal: ");
                int canal = reader.nextInt();
                reader.nextLine(); // limpeza de buffer
                contr.trocarCanalIndicadoTv(canal);
                break;
            case 6:
                contr.consultarCanalTV();
                break;
            case 7:
                contr.ligarTV();
                break;
            case 8:
                contr.desligarTV();
                break;
            case 9:
                break;
        }
    }
}
