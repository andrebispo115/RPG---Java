import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Escolher classe do herói
        System.out.println("ESCOLHA SUA CLASSE: GUERREIRO, ELFO, LADRAO"); 
        String escolha = sc.nextLine().toLowerCase();

        Criar heroi;

        switch (escolha) {
            case "guerreiro":
                heroi = new Criar("Guerreiro", 80, 20, 10, 2);
                break;
            case "elfo":
                heroi = new Criar("Elfo", 55, 17, 15, 10);
                break;
            case "ladrao":
                heroi = new Criar("Ladrao", 75, 10, 9, 30);
                break;
            default:
                System.out.println("Classe inválida! Você será um Bastardo.");
                heroi = new Criar("Bastardo", 30, 5, 2, 4);
        }

        // Criar inimigo
        Criar orc = new Criar("Orc", 60, 15, 5, 5);

        System.out.println("\n-- INICIO DA BATALHA --");
        heroi.mostrarStatus();
        orc.mostrarStatus();

        // Loop de combate
        while (heroi.estaVivo() && orc.estaVivo()) {
            System.out.println("\nSeu turno! (1 - Atacar)");
            int acao = sc.nextInt();

            if (acao == 1) {
                heroi.atacar(orc);
            }

            if (orc.estaVivo()) {
                orc.atacar(heroi);
            }

            // Mostrar status após cada turno
            heroi.mostrarStatus();
            orc.mostrarStatus();
        }

        // Resultado final
        if (heroi.estaVivo()) {
            System.out.println("\nVocê venceu!");
        } else {
            System.out.println("\nVocê foi derrotado!");
        }

        sc.close();
    }
}
