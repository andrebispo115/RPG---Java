import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {
        
        System.out.println("Escolha a sua classe");
        

        
        while (heroi.estaVivo() && orc.estaVivo()) {
            // Lógica do turno do herói
            // Solicitar a ação do jogador (atacar ou defender)

            // Lógica do turno do inimigo
            // Gerar aleatoriamente a ação do inimigo (atacar ou defender)

            // Exibir o estado da batalha (vida, etc.)
        }

        // Lógica para determinar quem venceu
        if (heroi.estaVivo()) {
            System.out.println("Parabéns, você derrotou o orc!");
        } else {
            System.out.println("Você foi derrotado!");
        }
    }
}
