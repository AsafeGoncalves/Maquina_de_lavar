import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MaquinaDeLavar m = new MaquinaDeLavar();
        Scanner entrada = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            exibirMenu(m);
            System.out.print("Escolha uma opção: ");

            if (!entrada.hasNextLine()) {
                break;
            }
            String linha = entrada.nextLine().trim();
            try {
                opcao = Integer.parseInt(linha);
            } catch (NumberFormatException e) {
                System.out.println("   [ERRO] Digite apenas o número da opção.\n");
                opcao = -1;
                continue;
            }

            System.out.println();
            switch (opcao) {
                case 1:  m.ligar(); break;
                case 2:  m.desligar(); break;
                case 3:  m.iniciarLavagem(); break;
                case 4:  m.pausarLavagem(); break;
                case 5:  m.retomarLavagem(); break;
                case 6:  m.concluirLavagem(); break;
                case 7:  m.iniciarCentrifugacao(); break;
                case 8:  m.concluirCentrifugacao(); break;
                case 9:  m.abrirTampa(); break;
                case 10: m.fecharTampa(); break;
                case 0:  System.out.println("   Encerrando o programa."); break;
                default: System.out.println("   [ERRO] Opção inválida.");
            }
            System.out.println();
        }
        entrada.close();
    }

    private static void exibirMenu(MaquinaDeLavar m) {
        System.out.println("==========================================");
        System.out.println("          MÁQUINA DE LAVAR");
        System.out.println("   " + m);
        System.out.println("==========================================");
        System.out.println(" 1  - Ligar");
        System.out.println(" 2  - Desligar");
        System.out.println(" 3  - Iniciar lavagem");
        System.out.println(" 4  - Pausar lavagem");
        System.out.println(" 5  - Retomar lavagem");
        System.out.println(" 6  - Concluir lavagem");
        System.out.println(" 7  - Iniciar centrifugação");
        System.out.println(" 8  - Concluir centrifugação");
        System.out.println(" 9  - Abrir tampa");
        System.out.println(" 10 - Fechar tampa");
        System.out.println(" 0  - Sair");
        System.out.println("------------------------------------------");
    }
}