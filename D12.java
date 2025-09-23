import java.util.Random;

public class D12 {

    public void rolarDado12() {
        // Cria um objeto da classe Random
        Random gerador = new Random();

        // Gera um número aleatório entre 0 (inclusive) e 12 (exclusive)
        // ou seja, de 0 a 11.
        int numeroAleatorio = gerador.nextInt(12);

        // Para obter o intervalo de 1 a 12, somamos 1 ao resultado.
        int resultado = numeroAleatorio + 1;

        System.out.println("D12: " + resultado);
    }
