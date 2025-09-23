import java.util.Random;

public class D6 {

    public int rolarDado6() {
        // Cria um objeto da classe Random
        Random gerador = new Random();

        // Gera um número aleatório entre 0 (inclusive) e 12 (exclusive)
        // ou seja, de 0 a 5.
        int numeroAleatorio = gerador.nextInt(6);

        // Para obter o intervalo de 1 a 6, somamos 1 ao resultado.
        int resultado = numeroAleatorio + 1;

        System.out.println("D6: " + resultado);
    }
