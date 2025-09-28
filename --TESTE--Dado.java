import java.util.Random;

public class Dado {
    public int rolarDado(int lado) {
        Random gerador = new Random();
        int resultado = gerador.nextInt(lado) + 1;
        System.out.println("Rolou um D" + lado + ": " + resultado);
        return resultado;
    }
}
