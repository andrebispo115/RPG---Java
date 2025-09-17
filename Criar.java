import java.util.Scanner;

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
        this.defesa = agilidade;
    }

    // Mostrar o status
    public void mostrarStatus() {
        System.out.println(nome + " | Vida: " + vida + " | Ataque: " + ataque + " | Defesa: " + defesa);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("ESCOLHA SUA CLASSE: GUERREIRO, ELFO, LADRAO"); 
        String escolha = sc.nextLine(); // lê a classe escolhida
        escolha = escolha.toLowerCase(); // transforma em minúsculas

        Criar heroi;

        switch (escolha) {
            case "guerreiro":
                heroi = new Criar("Guerreiro", 80, 20, 10,2);
                break;
            case "elfo":
                heroi = new Criar("Elfo", 55, 17, 15, 10);
                break;
            case "ladrao":
                heroi = new Criar("Ladrao", 75, 10, 9,30);
                break;
            default:
                System.out.println("CLASSE INVALIDA! VOCE SERA UM BASTARDO");
                heroi = new Criar("Bastardo", 30, 5, 2, 4);
                break;
        }

        System.out.println("VOCE ESCOLHEU:");
        heroi.mostrarStatus();

        sc.close();
    }
}
