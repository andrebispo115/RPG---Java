public class Armadura {
    private String nome;
    private int defesa;

    public Armadura(String nome) {
        this.nome = nome;
        this.defesa = 0; 
    }

    public int getDefesa() {
        return this.defesa;
    }
  
    public void calcularDefesa(int constituicao) {

        this.defesa = (int) (10 + (1.5 * constituicao));
    }
    
    public String getNome() {
        return this.nome;
    }
}
