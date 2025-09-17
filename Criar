import java.util.Scanner;

public class Criar {
    String nome; 
    int vida;
    int ataque;
    int defesa;

    // Construtor
    public Criar(String nome, int vida, int ataque, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
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
                heroi = new Criar("Guerreiro", 80, 20, 4);
                break;
            case "elfo":
                heroi = new Criar("Elfo", 55, 17, 15);
                break;
            case "ladrao":
                heroi = new Criar("Ladrao", 75, 10, 9);
                break;
            default:
                System.out.println("CLASSE INVALIDA! VOCE SERA UM BASTARDO");
                heroi = new Criar("Bastardo", 30, 5, 2);
                break;
        }

        System.out.println("VOCE ESCOLHEU:");
        heroi.mostrarStatus();

        sc.close();
    }
}
