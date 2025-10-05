import java.util.Random;

public abstract class Personagem {

    public String nome;
    public int vida;
    public int vidaMaxima;
    public int forca;
    public int defesa; // Defesa base atual
    public int agilidade;
    public int destreza;
    public int constituicao;
    public int porcoesRestantes;
    public int nivel;
    
    // Apenas para que as classes Inimigo e Boss possam usar o Dado
    protected Dado dado = new Dado(); 

    public Personagem(String nome, int vida, int forca, int defesa, int agilidade, int destreza, int constituicao) {
        this.nome = nome;
        this.vida = vida;
        this.vidaMaxima = vida;
        this.forca = forca;
        this.defesa = defesa;
        this.agilidade = agilidade;
        this.destreza = destreza;
        this.constituicao = constituicao;
        this.porcoesRestantes = 3; 
        this.nivel = 1;
    }

    public void mostrarStatus() {
        System.out.println("----------------------------------------");
        System.out.println("Personagem: " + nome + " (Nível: " + nivel + ")");
        System.out.println("Vida: " + vida + "/" + vidaMaxima);
        System.out.println("Força: " + forca + " | Agilidade: " + agilidade + " | Destreza: " + destreza);
        System.out.println("Defesa Base: " + defesa + " | Constituição: " + constituicao);
        System.out.println("Poções Restantes: " + porcoesRestantes);
        System.out.println("----------------------------------------");
    }

    public boolean estaVivo() {
        return vida > 0;
    }
    
    // O método usarPocao foi movido para a classe Pocao
}
