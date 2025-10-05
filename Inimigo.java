import java.util.Random;

public class Inimigo extends Personagem {
    public Inimigo(String nome, int vida, int forca, int defesa, int agilidade, int destreza, int constituicao) {
        super(nome, vida, forca, defesa, agilidade, destreza, constituicao);
    }
    
    public int decidirAcao() {
        return dado.rolarDado(3); 
    }
}
