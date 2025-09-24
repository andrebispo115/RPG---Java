public class Criar {
    String nome; 
    int vida;
    int ataque;
    int defesa;
    int agilidade;

    // Construtor
    public Criar(String nome, int vida, int ataque, int defesa, int agilidade) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.agilidade = agilidade;
    }

    // Mostrar o status
    public void mostrarStatus() {
        System.out.println(nome + 
            " | Vida: " + vida + 
            " | Ataque: " + ataque + 
            " | Defesa: " + defesa + 
            " | Agilidade: " + agilidade);
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
