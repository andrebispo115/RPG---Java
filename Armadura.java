public class Armadura{
    private String nome;
    private int defesa;
    
    Armadura(String nome){
        this.nome = nome;
    }
    
    public double getdefesa {
        return this.defesa;
    }
    
    public void calcularDefesa(){
        this.defesa = 10 + (1,5 * this.constituicao);
    }
}
