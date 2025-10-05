import java.util.Random;

public class Porcao {
    private static final Random random = new Random();

    public static void efeitoAleatorio(Personagem personagem) {
        if (personagem.porcoesRestantes <= 0) {
            System.out.println(personagem.nome + " não tem mais poções para usar!");
            return;
        }

        personagem.porcoesRestantes--;
        int efeito = random.nextInt(2) + 1;
        
        System.out.println("\n*** " + personagem.nome + " bebeu uma poção! (" + personagem.porcoesRestantes + " restantes) ***");

        if (efeito == 1) {
            int ganhoAgilidade = random.nextInt(3) + 1;
            personagem.agilidade += ganhoAgilidade;
            System.out.println(">>> Agilidade aumentada em " + ganhoAgilidade + " ponto(s)! Agilidade atual: " + personagem.agilidade + ".");
        } else {

            int cura = random.nextInt(10) + 5; 
            personagem.vida += cura;
            if (personagem.vida > personagem.vidaMaxima) {
                personagem.vida = personagem.vidaMaxima;
            }
            System.out.println(">>> Vida recuperada em " + cura + " ponto(s)! Vida atual: " + personagem.vida + "/" + personagem.vidaMaxima + ".");
        }
    }
}
