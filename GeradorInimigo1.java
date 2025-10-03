import java.util.Random;

public class GeradorInimigo1 {

    // Lista de inimigos possíveis para o primeiro encontro
    private static final Inimigo[] INIMIGOS_DO_CAPITULO_1 = {
        // Exemplo 1: Demônio Sombrio (Mais forte)
        new Inimigo("Demônio Sombrio", 30, 8, 4, 3, 1, 15), 
        // Exemplo 2: Fantasma Aéreo (Mais rápido/esquiva)
        new Inimigo("Fantasma Aéreo", 15, 4, 1, 10, 5, 8), 
        // Exemplo 3: Zumbi Desprezível (Mais fraco/médio)
        new Inimigo("Zumbi Desprezível", 20, 5, 3, 5, 2, 5) 
    };
    
    // Objeto Random para gerar o índice aleatório
    private static final Random random = new Random();

    /**
     * Retorna um inimigo aleatório da lista predefinida para o primeiro capítulo.
     * @return Uma instância aleatória da classe Inimigo.
     */
    public static Inimigo gerarPrimeiroInimigo() {
        // Gera um índice aleatório entre 0 (inclusive) e o tamanho do array (exclusive)
        int indiceAleatorio = random.nextInt(INIMIGOS_DO_CAPITULO_1.length);
        
        // Retorna o inimigo correspondente ao índice
        return INIMIGOS_DO_CAPITULO_1[indiceAleatorio];
    }
}
