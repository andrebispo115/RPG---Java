import java.util.Random;

public class GeradorInimigo2 {


    private static final Inimigo[] INIMIGOS_DO_CAPITULO_1 = {

        new Inimigo("Carniçal de Éter", 45, 12, 6, 4, 2, 25),
        
        new Inimigo("Espectro da Sombra", 35, 15, 2, 15, 8, 30)
    };
    
    private static final Random random = new Random();
  
    public static Inimigo gerarPrimeiroInimigo2() {

        int indiceAleatorio = random.nextInt(INIMIGOS_DO_CAPITULO_1.length);

        return INIMIGOS_DO_CAPITULO_1[indiceAleatorio];
    }
}
