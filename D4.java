import java.util.Random;

public class D4 {

    public int rolarDado4() {
        // Cria um objeto da classe Random
        Random gerador = new Random();

        // Gera um número aleatório entre 0 (inclusive) e 12 (exclusive)
        // ou seja, de 0 a 3.
        int numeroAleatorio = gerador.nextInt(4);

        // Para obter o intervalo de 1 a 4, somamos 1 ao resultado.
        int resultado = numeroAleatorio + 1;

        System.out.println("D4: " + resultado);
    }
