import java.util.Random;

public class GeradorInimigo2 {

    private static final Inimigo[] INIMIGOS_DO_CAPITULO_2 = { 

        new Inimigo("Carniçal de Éter", 45, 15, 6, 4, 15, 25),

        new Inimigo("Espectro da Sombra", 35, 20, 2, 15, 20, 30)
    };
    
    private static final Random random = new Random();
    
    public static Inimigo gerarSegundoInimigo() { 
        int indiceAleatorio = random.nextInt(INIMIGOS_DO_CAPITULO_2.length);
        return INIMIGOS_DO_CAPITULO_2[indiceAleatorio]; 
    }
}
