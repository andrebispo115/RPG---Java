import java.util.Random;

public class Arma extends Dado {
    private String nome;
    private String categoria;
    private double constanteDeDano;
    private double dano;

    public Arma(String nome, String categoria, double constanteDeDano) {
        this.nome = nome;
        this.categoria = categoria;
        this.constanteDeDano = constanteDeDano;
    }

    public double getDano() {
        return this.dano;
    }

    public void calcularDano(d) {
        if (this.categoria.equals("Pesada")) {
            int resultadoDado = rolarDado(12);
            this.dano = (this.forca * 1.5) + this.constanteDeDano + resultadoDado;
        } else { // Categoria "Leve"
            int resultadoD6_1 = rolarDado(6);
            int resultadoD6_2 = rolarDado(6);
            int resultadoD4 = rolarDado(4);
            this.dano = resultadoD6_1 + resultadoD6_2 + resultadoD4 + this.destreza + this.constanteDeDano;
        }
    }
}
