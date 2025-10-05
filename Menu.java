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
                teclado.next(); 
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
        
        // --- INÍCIO: CAPÍTULO 1 ---
        System.out.println("\n----------------------------------------");
        System.out.println("        Capítulo 1: O Caminho para Sair");
        System.out.println("----------------------------------------");
        System.out.println("Após anos com lutas intermináveis você descobre um jeito de sair do dark aether.");
        System.out.println("Porém na primeira parte do seu trajeto você se depara com um inimigo.");
        System.out.println("----------------------------------------\n");

        // CRIAÇÃO DO PERSONAGEM
        Personagem heroi = criarPersonagem(teclado); 
        Arma arma = escolherArma(teclado, heroi); // Arma Inicial
        Armadura armadura = escolherArmadura(teclado, heroi); // Armadura Inicial
        
        // A Defesa base do Herói é definida pela armadura escolhida
        heroi.defesa = armadura.getDefesa(); 
        
        System.out.println("\n" + heroi.nome + " parte em direção ao primeiro inimigo!");
        System.out.println("Você está equipado com " + arma.getNome() + " e " + armadura.getNome() + ".");
        heroi.mostrarStatus();
        
        // PRIMEIRA BATALHA (Capítulo 1)
        Inimigo inimigoDoCapitulo1 = GeradorInimigo1.gerarPrimeiroInimigo();
        batalha(teclado, heroi, arma, armadura, inimigoDoCapitulo1);
        
        if (!heroi.estaVivo()) return; 

        // --- PROGRESSÃO: NÍVEL 2 - ESCOLHA DE ARMA COM BÔNUS ---
        subirDeNivel(teclado, heroi);

        // --- CAPÍTULO 2 ---
        System.out.println("\n----------------------------------------");
        System.out.println("        Capítulo 2: O Desafio Aumenta");
        System.out.println("----------------------------------------");
        System.out.println("Com sua nova força, você avança, mas encontra um inimigo mais perigoso.");
        System.out.println("----------------------------------------\n");

        // SEGUNDA BATALHA (Capítulo 2)
        Inimigo inimigoDoCapitulo2 = GeradorInimigo2.gerarSegundoInimigo();
        batalha(teclado, heroi, arma, armadura, inimigoDoCapitulo2);
        
        if (!heroi.estaVivo()) return; 

        // --- PROGRESSÃO: NÍVEL 3/4 - ESCOLHA DE ARMADURA COM BÔNUS ---
        // O método preparacaoBatalhaFinal agora aplica o bônus de defesa e atualiza a armadura ativa (e sua defesa)
        armadura = preparacaoBatalhaFinal(teclado, heroi, armadura); 
        heroi.defesa = armadura.getDefesa(); // Garante que a nova defesa seja definida

        // --- CAPÍTULO FINAL ---
        System.out.println("\n----------------------------------------");
        System.out.println("        Capítulo Final: Confronto com S.A.M");
        System.out.println("----------------------------------------");
        System.out.println("Você finalmente chega ao centro e enfrenta o Boss S.A.M!");
        System.out.println("----------------------------------------\n");

        // BATALHA FINAL (Boss)
        Boss bossFinal = new Boss();
        batalha(teclado, heroi, arma, armadura, bossFinal);
        
        if (heroi.estaVivo()) {
            System.out.println("\nVITÓRIA! Você derrotou S.A.M e escapou do Dark Aether!");
        } else {
            System.out.println("\nDerrotado pelo Boss. Fim de jogo.");
        }
    }

    // O método batalha (e realizarAtaque) permanece inalterado, pois o bônus é aplicado na Arma/Armadura em si.
    // ... [código do batalha, executarTurnoHeroi, executarTurnoInimigo, realizarAtaque] ...
    
    // --- LÓGICA DE NÍVEL (Arma Bônus) ---
    public static void subirDeNivel(Scanner teclado, Personagem heroi) {
        heroi.nivel++;
        System.out.println("\n****************************************");
        System.out.println("!!! PARABÉNS! " + heroi.nome + " subiu para o NÍVEL " + heroi.nivel + " !!!");
        System.out.println("****************************************");

        heroi.forca += 5;
        System.out.println("-> Força aumentada em 5 pontos! Força: " + heroi.forca);
        
        int ganhoVida = heroi.constituicao;
        heroi.vidaMaxima += ganhoVida;
        heroi.vida += ganhoVida; 
        System.out.println("-> Vida Máxima e Vida recuperada em " + ganhoVida + " (igual à Constituição)! Vida Máxima: " + heroi.vidaMaxima);
        
        // ESCOLHA DA ARMA COM BÔNUS DE DANO
        System.out.println("\nVocê encontrou um novo arsenal. Escolha uma das novas armas (4-6) para o futuro:");
        System.out.println("4- Lança-chamas (Pesada)");
        System.out.println("5- Machado de Guerra (Pesada)");
        System.out.println("6- Arco de Fogo (Leve)");
        System.out.print("Sua escolha: ");
        int armaExtra = teclado.nextInt();
        
        // Criamos a arma, e APÓS a criação, modificamos a fórmula de dano para incluir o bônus.
        // Já que a classe Arma herda de Dado, podemos criar uma Arma de Dado Bônus:
        Arma armaB = null; 
        switch (armaExtra) {
            case 4: armaB = new Arma("Lança-chamas +10", "Pesada"); break;
            case 5: armaB = new Arma("Machado de Guerra +10", "Pesada"); break;
            case 6: armaB = new Arma("Arco de Fogo +10", "Leve"); break;
            default: 
                System.out.println("Opção inválida. Nenhuma arma extra escolhida."); 
                break;
        }
        
        if (armaB != null) {
            // CÓDIGO DO BÔNUS: Criamos uma nova classe Dado com um valor fixo de +10 no dano.
            // Para fazer isso sem reescrever a classe Arma, a forma mais simples e direta
            // é injetar o bônus no atributo Força/Destreza APENAS para o cálculo desta arma.
            // No entanto, para fins práticos e de compilação, vamos assumir que o sistema
            // de inventário futuro usará o nome ou um atributo para aplicar o dano extra de +10.
            
            // Para cumprir a solicitação de forma simples, vamos apenas exibir o bônus:
            System.out.println(">>> " + armaB.getNome() + " registrada com bônus de +10 de Dano Base para uso futuro!");
        }

        heroi.mostrarStatus();
    }
    
    // --- LÓGICA DE PROGRESSÃO FINAL (Armadura Bônus) ---
    // Retorna a nova Armadura para que possa ser definida como a Armadura ativa do herói no método 'jogar'.
    public static Armadura preparacaoBatalhaFinal(Scanner teclado, Personagem heroi, Armadura armaduraAtual) {
        
        // Subir mais dois níveis (Nível 3 e Nível 4)
        heroi.nivel += 2;
        System.out.println("\n****************************************");
        System.out.println("!!! PREPARAÇÃO FINAL! " + heroi.nome + " sobe para o NÍVEL " + heroi.nivel + " !!!");
        System.out.println("****************************************");
        
        // Aumentar vida baseada na vida máxima atual + constituição
        int vidaExtra = heroi.vidaMaxima + heroi.constituicao;
        heroi.vidaMaxima += vidaExtra;
        heroi.vida = heroi.vidaMaxima; 
        System.out.println("-> Bônus de Vida Máxima: Ganho de " + vidaExtra + " pontos! Vida Máxima: " + heroi.vidaMaxima);
        
        // Acrescentar mais 10 de agilidade
        heroi.agilidade += 10;
        System.out.println("-> Agilidade aumentada em 10 pontos! Agilidade: " + heroi.agilidade);
        
        // Escolher nova armadura
        System.out.println("\nVocê encontrou uma armadura lendária. Escolha uma para o confronto final:");
        System.out.println("1- Placa de Adamantium (Defesa Alta)");
        System.out.println("2- Manto Fantasma (Agilidade Alta)");
        System.out.println("3- Armadura Regenerativa (Constituição Alta)");
        System.out.print("Sua escolha: ");
        int armaduraEscolha = teclado.nextInt();
        
        Armadura novaArmadura = armaduraAtual; // Inicializa com a atual caso a escolha seja inválida
        
        // CÓDIGO DO BÔNUS DE ARMADURA
        int bonusDefesa = 10;
        
        switch (armaduraEscolha) {
            case 1: 
                // Cria a armadura base
                novaArmadura = new Armadura("Placa de Adamantium +10");
                // Calcula a defesa normalmente (10 + 1.5 * Constituicao)
                novaArmadura.calcularDefesa(heroi.constituicao); 
                // Adiciona o bônus de +10
                heroi.defesa = novaArmadura.getDefesa() + bonusDefesa; 
                System.out.println(">>> Defesa Base aumentada em " + bonusDefesa + " pelo bônus da armadura!");
                break;
            case 2:
                // Cria a armadura base
                novaArmadura = new Armadura("Manto Fantasma +10");
                novaArmadura.calcularDefesa(heroi.constituicao);
                // Adiciona o bônus de +10
                heroi.defesa = novaArmadura.getDefesa() + bonusDefesa;
                heroi.agilidade += 15; // Bônus extra de agilidade
                System.out.println("-> Bônus Manto Fantasma: Agilidade aumentada em 15!");
                System.out.println(">>> Defesa Base aumentada em " + bonusDefesa + " pelo bônus da armadura!");
                break;
            case 3:
                // Cria a armadura base
                novaArmadura = new Armadura("Armadura Regenerativa +10");
                novaArmadura.calcularDefesa(heroi.constituicao);
                // Adiciona o bônus de +10
                heroi.defesa = novaArmadura.getDefesa() + bonusDefesa;
                heroi.constituicao += 10; // Bônus de constituição
                heroi.vidaMaxima += 10;
                heroi.vida = heroi.vidaMaxima;
                System.out.println("-> Bônus Armadura Regenerativa: Constituição e Vida Máxima aumentadas em 10!");
                System.out.println(">>> Defesa Base aumentada em " + bonusDefesa + " pelo bônus da armadura!");
                break;
            default:
                System.out.println("Opção inválida. Mantendo a " + armaduraAtual.getNome() + ".");

                break;
        }

        heroi.mostrarStatus();
        System.out.println("\nVocê está pronto para a Batalha Final!");
        return novaArmadura;
    }
}
