import java.util.Random;

public class Dado {

    public int rolarDado(int lado) {
        // Cria um objeto da classe Random
        Random gerador = new Random();

        // Gera um número aleatório entre 0 (inclusive) e o lado max. do dado (exclusive)
        int numeroAleatorio = gerador.nextInt(lado);

        // Para obter o intervalo de 1 a lado max. do dado, somamos 1 ao resultado.
        int resultado = numeroAleatorio + 1;

        System.out.println("D" + lado": " + resultado);
    }
}    
