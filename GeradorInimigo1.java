import java.util.Random;

public class GeradorInimigo1 {


    private static final Inimigo[] INIMIGOS_DO_CAPITULO_1 = {

        new Inimigo("Demônio Sombrio", 30, 3, 4, 3, 2, 15), 
        new Inimigo("Fantasma Aéreo", 15, 3, 1, 10, 2, 8), 
        new Inimigo("Zumbi Desprezível", 20, 5, 3, 5, 2, 5) 
    };
    
    // Objeto Random para gerar o índice aleatório
    private static final Random random = new Random();

    /**
     * Retorna um inimigo aleatório da lista predefinida para o primeiro capítulo.
     * @return Uma instância aleatória da classe Inimigo.
     */
    public static Inimigo gerarPrimeiroInimigo() {
        int indiceAleatorio = random.nextInt(INIMIGOS_DO_CAPITULO_1.length);
        return INIMIGOS_DO_CAPITULO_1[indiceAleatorio];
    }
}
