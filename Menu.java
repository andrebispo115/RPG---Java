import java.util.Scanner;
import java.util.Random; 

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
            
            if (teclado.hasNextInt()) {
                escolha = teclado.nextInt();
            } else {
                System.out.println("\nEntrada inválida. Tente novamente.\n");
                teclado.next(); // Limpa a entrada inválida
                continue;
            }
            
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
 
        System.out.println("\n----------------------------------------");
        System.out.println("        Capitulo ..: .....");
        System.out.println("----------------------------------------");
        System.out.println("Após anos com lutas intermináveis você descobre um jeito de sair do dark aether.");
        System.out.println("Porém na primeira parte do seu trajeto você se depara com um inimigo.");
        System.out.println("----------------------------------------\n");
   

        Personagem heroi = criarPersonagem(teclado); 
     
        Arma arma = escolherArma(teclado, heroi);
        Armadura armadura = escolherArmadura(teclado, heroi);
        
        heroi.defesa = armadura.getDefesa(); 
        
        System.out.println("\n" + heroi.nome + " parte em direção ao primeiro inimigo!");
        System.out.println("Você está equipado com " + arma.getNome() + " e " + armadura.getNome() + ".");
        
        heroi.mostrarStatus();

        Inimigo inimigoDoCapitulo1 = GeradorInimigo1.gerarPrimeiroInimigo();
        batalha(teclado, heroi, arma, armadura, inimigoDoCapitulo1);
        
        if (heroi.estaVivo()) {
            subirDeNivel(teclado, heroi);
        }
    }

    public static void batalha(Scanner teclado, Personagem heroi, Arma arma, Armadura armadura, Inimigo inimigo) {
        System.out.println("\n----------------------------------------");
        System.out.println("      Encontro: Um " + inimigo.nome + " Feroz!");
        System.out.println("----------------------------------------");
        
        // Salva a defesa base de ambos para reajuste de defesa
        int defesaBaseHeroi = heroi.defesa; 
        int defesaBaseInimigo = inimigo.defesa;
        
        // Variáveis de controle de status
        boolean heroiDefendendo;
        boolean inimigoDefendendo;
        
        inimigo.mostrarStatus();

        while (heroi.estaVivo() && inimigo.estaVivo()) {
            
            heroiDefendendo = false;
            inimigoDefendendo = false;
            
            // Reajusta a defesa para o valor base no início da rodada
            heroi.defesa = defesaBaseHeroi;
            inimigo.defesa = defesaBaseInimigo;
            
            System.out.println("\n--- Rodada de Combate ---");
            
            // 1. Determinar quem ataca primeiro (Agilidade)
            Personagem atacantePrimario = (heroi.agilidade >= inimigo.agilidade) ? heroi : inimigo;
            
            // 2. Turno do Jogador
            if (atacantePrimario == heroi) {
                if (executarTurnoHeroi(teclado, heroi, inimigo, arma, armadura, heroiDefendendo, inimigoDefendendo)) return;
            }

            if (!inimigo.estaVivo()) break; 

            // 3. Turno do Inimigo
            if (executarTurnoInimigo(heroi, inimigo)) return;

            if (!heroi.estaVivo()) break; 

            // 4. Turno do Jogador (Caso não tenha atacado primeiro)
            if (atacantePrimario == inimigo) {
                if (executarTurnoHeroi(teclado, heroi, inimigo, arma, armadura, heroiDefendendo, inimigoDefendendo)) return;
            }
            
            if (!inimigo.estaVivo()) break; 
            
            // 5. Exibir status da Rodada
            System.out.println("\n--- Status Final da Rodada ---");
            System.out.println(heroi.nome + " Vida: " + heroi.vida + " | Defesa: " + (heroiDefendendo ? heroi.defesa + " (DEFESA)" : heroi.defesa));
            System.out.println(inimigo.nome + " Vida: " + inimigo.vida + " | Defesa: " + (inimigoDefendendo ? inimigo.defesa + " (DEFESA)" : inimigo.defesa));
        }
        
        // FIM DA BATALHA
        if (heroi.estaVivo()) {
            System.out.println("\nParabéns! Você venceu o combate contra o " + inimigo.nome + "!");
        } else {
            System.out.println("\nVocê foi derrotado. Fim de jogo.");
        }
    }
    
    // --- Métodos Auxiliares de Combate ---
    
    private static boolean executarTurnoHeroi(Scanner teclado, Personagem heroi, Inimigo inimigo, Arma arma, Armadura armadura, boolean heroiDefendendo, boolean inimigoDefendendo) {
        System.out.println("\nSeu turno, " + heroi.nome + "!");
        System.out.println("Escolha sua ação: 1- Atacar | 2- Defender | 3- Usar Poção (" + heroi.porcoesRestantes + ")");
        System.out.print("Ação: ");
        
        int acao = teclado.nextInt();
        
        switch (acao) {
            case 1: // Atacar
                realizarAtaque(heroi, inimigo, arma);
                break;
            case 2: // Defender
                // Dobra o valor da defesa da armadura + constituição
                heroi.defesa = armadura.getDefesa() * 2; 
                heroiDefendendo = true;
                System.out.println(heroi.nome + " se prepara para a defesa! Defesa atual: " + heroi.defesa);
                break;
            case 3: // Poção
                Pocao.efeitoAleatorio(heroi);
                break;
            default:
                System.out.println("Opção inválida! " + heroi.nome + " se atrapalha e perde o turno.");
                break;
        }
        
        return !inimigo.estaVivo(); // Retorna true se a batalha acabar
    }
    
    private static boolean executarTurnoInimigo(Personagem heroi, Inimigo inimigo) {
        System.out.println("\nTurno do Inimigo, " + inimigo.nome + "!");
        int acaoInimigo = inimigo.decidirAcao();
        
        switch (acaoInimigo) {
            case 1: // Atacar
                realizarAtaque(inimigo, heroi, new Arma("Garra", "Leve"));
                break;
            case 2: // Defender
                inimigo.defesa *= 2; // Dobra a defesa do inimigo
                System.out.println(inimigo.nome + " se defende! Defesa atual: " + inimigo.defesa);
                break;
            case 3: // Poção
                 Pocao.efeitoAleatorio(inimigo);
                break;
        }
        
        return !heroi.estaVivo(); // Retorna true se a batalha acabar
    }
    
    private static void realizarAtaque(Personagem atacante, Personagem alvo, Arma arma) {
        arma.calcularDano(atacante.forca, atacante.destreza); 
        double dano = arma.getDano() - alvo.defesa;
        
        if (dano < 0) {
            dano = 0;
        }

        alvo.vida -= dano;
        if (alvo.vida < 0) {
            alvo.vida = 0;
        }

        System.out.println(atacante.nome + " atacou " + alvo.nome + " com " + arma.getNome() + " causando " + String.format("%.1f", dano) + " de dano!");
    }

    // --- LÓGICA DE NÍVEL ---
    public static void subirDeNivel(Scanner teclado, Personagem heroi) {
        heroi.nivel++;
        System.out.println("\n****************************************");
        System.out.println("!!! PARABÉNS! " + heroi.nome + " subiu para o NÍVEL " + heroi.nivel + " !!!");
        System.out.println("****************************************");

        // Aumento de Atributos Fixo
        heroi.forca += 5;
        System.out.println("-> Força aumentada em 5 pontos! Força: " + heroi.forca);
        
        // Aumento de Vida 
        int ganhoVida = heroi.constituicao;
        heroi.vidaMaxima += ganhoVida;
        heroi.vida += ganhoVida; 
        System.out.println("-> Vida Máxima aumentada em " + ganhoVida + " (igual à Constituição)! Vida Máxima: " + heroi.vidaMaxima);
        
        // Escolha de Arma Extra (Apenas para registro, a Arma 'ativa' é a que foi escolhida antes)
        System.out.println("\nVocê encontrou um novo arsenal. Escolha uma das novas armas (4-6) para o futuro:");
        System.out.println("4- Lança-chamas (Pesada)");
        System.out.println("5- Machado de Guerra (Pesada)");
        System.out.println("6- Arco de Fogo (Leve)");
        System.out.print("Sua escolha: ");
        int armaExtra = teclado.nextInt();
        
        // Apenas para consumir a entrada, não muda a arma atual 'arma'
        switch (armaExtra) {
            case 4: new Arma("Lança-chamas", "Pesada"); break;
            case 5: new Arma("Machado de Guerra", "Pesada"); break;
            case 6: new Arma("Arco de Fogo", "Leve"); break;
            default: System.out.println("Opção inválida. Nenhuma arma extra escolhida."); break;
        }
        
        heroi.mostrarStatus();
    }

    public static Personagem criarPersonagem(Scanner teclado) {
        System.out.println("Escolha seu personagem:");
        System.out.println("1- Dempsey");
        System.out.println("2- Nikolai");
        System.out.println("3- Takeo");
        System.out.print("Sua escolha: ");
        int classeEscolha = teclado.nextInt();
        
        switch (classeEscolha) {
            case 1: return new Dempsey();
            case 2: return new Nikolai();
            case 3: return new Takeo();
            default: 
                System.out.println("Opção inválida. Você será um o Claus por padrão.");
                return new Claus();
        }
    }

    public static Arma escolherArma(Scanner teclado, Personagem heroi) {
        System.out.println("\nEscolha sua arma:");
        System.out.println("1- Hagnarok DG4 (Pesada)");
        System.out.println("2- Arco elétrico (Leve)");
        System.out.println("3- Cajado de gelo (Pesada)");
        System.out.print("Sua escolha: ");
        int armaEscolha = teclado.nextInt();
        
        switch (armaEscolha) {
            case 1: return new Arma("Hagnarok DG4", "Pesada");
            case 2: return new Arma("Arco elétrico", "Leve");
            case 3: return new Arma("Cajado de gelo", "Pesada");
            default:
                System.out.println("Opção inválida. Você pega uma Adaga (Leve) por padrão.");
                return new Arma("Adaga", "Leve");
        }
    }

    public static Armadura escolherArmadura(Scanner teclado, Personagem heroi) {
        System.out.println("\nEscolha sua armadura:");
        System.out.println("1- Armadura de Couro");
        System.out.println("2- Cota de Malha");
        System.out.println("3- Placas de Aço");
        System.out.print("Sua escolha: ");
        int armaduraEscolha = teclado.nextInt();
        
        Armadura armadura;
        switch (armaduraEscolha) {
            case 1: armadura = new Armadura("Armadura de Couro"); break;
            case 2: armadura = new Armadura("Cota de Malha"); break;
            case 3: armadura = new Armadura("Placas de Aço"); break;
            default:
                System.out.println("Opção inválida. Você veste uma Túnica Velha por padrão.");
                armadura = new Armadura("Túnica Velha"); break;
        }
        
        armadura.calcularDefesa(heroi.constituicao); 
        return armadura;
    }
}


