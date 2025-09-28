import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int escolha = 0;
        
        do {
            System.out.println("----------------------------------------");
            System.out.println("----------- Bem-vindo ao Jogo ----------");
            System.out.println("----------------------------------------");
            System.out.println("1- Jogar");
            System.out.println("2- Créditos");
            System.out.println("3- Sair");
            System.out.println("----------------------------------------");
            System.out.print("Escolha uma opção: ");
            escolha = teclado.nextInt();
            
            switch (escolha) {
                case 1:
                    jogar(teclado);
                    break;
                case 2:
                    System.out.println("\nCriado por: Seu Nome");
                    System.out.println("Versão: 1.0\n");
                    break;
                case 3:
                    System.out.println("\nObrigado por jogar!");
                    break;
                default:
                    System.out.println("\nOpção inválida. Tente novamente.\n");
                    break;
            }
        } while (escolha != 3);
        
        teclado.close();
    }

    public static void jogar(Scanner teclado) {
        // --- INÍCIO DA HISTÓRIA ---
        // Este é um local que pode ser alterado para mudar a história.
        // Adicione ou remova linhas de System.out.println() conforme desejar.
        System.out.println("\n----------------------------------------");
        System.out.println("        Capítulo I: A Névoa da Desolação");
        System.out.println("----------------------------------------");
        System.out.println("Uma névoa estranha e escura cobriu a terra. As plantações secaram e as");
        System.out.println("pessoas adoeceram. Você, um jovem herói, foi escolhido para entrar na");
        System.out.println("Floresta das Lamentações e encontrar a fonte dessa maldição.");
        System.out.println("Para sobreviver, você precisa se preparar.");
        System.out.println("----------------------------------------\n");
        // --- FIM DA HISTÓRIA ---

        // CRIAÇÃO DO PERSONAGEM
        Criar heroi = criarPersonagem(teclado);
        
        // ESCOLHA DE EQUIPAMENTOS
        Arma arma = escolherArma(teclado, heroi);
        Armadura armadura = escolherArmadura(teclado, heroi);
        
        System.out.println("\nSua jornada começa agora, " + heroi.nome + "!");
        System.out.println("Você está equipado com " + arma.nome + " e " + armadura.nome + ".");
        
        heroi.mostrarStatus();
        
        // EXEMPLO DE COMBATE
        // A lógica de combate é simplificada e pode ser expandida.
        // Ela está diretamente no método 'jogar' por simplicidade.
        System.out.println("\n----------------------------------------");
        System.out.println("        Primeiro Encontro: Um Inimigo!");
        System.out.println("----------------------------------------");
        Inimigo inimigo = new Inimigo("Goblin", 20, 5, 3, 5, 2, 5);
        inimigo.mostrarStatus();

        while (heroi.estaVivo() && inimigo.estaVivo()) {
            System.out.println("\n--- Rodada de Combate ---");
            heroi.atacar(inimigo, arma);
            if (inimigo.estaVivo()) {
                inimigo.atacar(heroi, new Arma("Garra", "Leve"));
            }
        }
        
        if (heroi.estaVivo()) {
            System.out.println("\nParabéns! Você venceu o combate!");
        } else {
            System.out.println("\nVocê foi derrotado. Fim de jogo.");
        }
    }

    public static Criar criarPersonagem(Scanner teclado) {
        System.out.println("Escolha sua classe:");
        System.out.println("1- Elfo");
        System.out.println("2- Guerreiro");
        System.out.println("3- Ladrão");
        System.out.print("Sua escolha: ");
        int classeEscolha = teclado.nextInt();
        
        switch (classeEscolha) {
            case 1:
                return new Elfo();
            case 2:
                return new Guerreiro();
            case 3:
                return new Ladrao();
            default:
                System.out.println("Opção inválida. Você será um Bastardo por padrão.");
                return new Bastardo();
        }
    }

    public static Arma escolherArma(Scanner teclado, Criar heroi) {
        System.out.println("\nEscolha sua arma:");
        System.out.println("1- Espada Longa (Pesada)");
        System.out.println("2- Arco Élfico (Leve)");
        System.out.println("3- Machado de Batalha (Pesada)");
        System.out.print("Sua escolha: ");
        int armaEscolha = teclado.nextInt();
        
        switch (armaEscolha) {
            case 1:
                return new Arma("Espada Longa", "Pesada");
            case 2:
                return new Arma("Arco Élfico", "Leve");
            case 3:
                return new Arma("Machado de Batalha", "Pesada");
            default:
                System.out.println("Opção inválida. Você pega uma Adaga (Leve) por padrão.");
                return new Arma("Adaga", "Leve");
        }
    }

    public static Armadura escolherArmadura(Scanner teclado, Criar heroi) {
        System.out.println("\nEscolha sua armadura:");
        System.out.println("1- Armadura de Couro");
        System.out.println("2- Cota de Malha");
        System.out.println("3- Placas de Aço");
        System.out.print("Sua escolha: ");
        int armaduraEscolha = teclado.nextInt();
        
        Armadura armadura;
        switch (armaduraEscolha) {
            case 1:
                armadura = new Armadura("Armadura de Couro");
                break;
            case 2:
                armadura = new Armadura("Cota de Malha");
                break;
            case 3:
                armadura = new Armadura("Placas de Aço");
                break;
            default:
                System.out.println("Opção inválida. Você veste uma Túnica Velha por padrão.");
                armadura = new Armadura("Túnica Velha");
                break;
        }
        armadura.calcularDefesa(heroi.constituicao); // Calcula a defesa com base na constituição do herói
        return armadura;
    }
}
