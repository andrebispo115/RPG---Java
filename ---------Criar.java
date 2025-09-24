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
}
