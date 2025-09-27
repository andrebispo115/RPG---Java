public class Criar {
    String nome; 
    int vida;
    int ataque;
    int defesa;
    int agilidade;
    int destreza;
    int constituica;

    // Construtor
    public Criar(String nome, int vida, int ataque, int defesa, int agilidade, int destreza, int constituicao) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.agilidade = agilidade;
        this.destreza = destreza;
        this.constituicao = constituicao;
    }

    // Mostrar o status
    public void mostrarStatus() {
        System.out.println(nome + 
            " | Vida: " + vida + 
            " | Ataque: " + ataque + 
            " | Defesa: " + defesa + 
            " | Agilidade: " + agilidade;
            " | Destreza: " + destreza;
            " | Constituicao: " + constituicao;
    }

    // Verifica se está vivo
    public boolean estaVivo() {
        return vida > 0;
    }

    // Atacar outro personagem
    public void atacar(Criar inimigo) {
        int dano = this.ataque - inimigo.defesa;
        if (dano < 0) dano = 0; // impede dano negativo
        inimigo.vida -= dano;
        if (inimigo.vida < 0) inimigo.vida = 0; // evita vida negativa

        System.out.println(nome + " atacou " + inimigo.nome + " causando " + dano + " de dano!");
    }
}
