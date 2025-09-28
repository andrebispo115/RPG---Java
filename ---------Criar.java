public class Criar {
    public String nome;
    public int vida;
    public int forca;
    public int defesa;
    public int agilidade;
    public int destreza;
    public int constituicao;

    public Criar(String nome, int vida, int forca, int defesa, int agilidade, int destreza, int constituicao) {
        this.nome = nome;
        this.vida = vida;
        this.forca = forca;
        this.defesa = defesa;
        this.agilidade = agilidade;
        this.destreza = destreza;
        this.constituicao = constituicao;
    }

    // Método para exibir o status do personagem
    public void mostrarStatus() {
        System.out.println("----------------------------------------");
        System.out.println("Personagem: " + nome);
        System.out.println("Vida: " + vida);
        System.out.println("Força: " + forca);
        System.out.println("Defesa: " + defesa);
        System.out.println("Agilidade: " + agilidade);
        System.out.println("Destreza: " + destreza);
        System.out.println("Constituição: " + constituicao);
        System.out.println("----------------------------------------");
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void atacar(Criar inimigo, Arma arma) {
        // Cálculo do dano da arma, que agora recebe a força/destreza do atacante
        arma.calcularDano(this.forca, this.destreza);
        double dano = arma.getDano() - inimigo.defesa;
        
        if (dano < 0) {
            dano = 0;
        }

        inimigo.vida -= dano;
        if (inimigo.vida < 0) {
            inimigo.vida = 0;
        }

        System.out.println(this.nome + " atacou " + inimigo.nome + " causando " + String.format("%.1f", dano) + " de dano!");
    }
}
