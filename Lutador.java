public class Lutador {
    private String nome;
    private int vida;
    private int forca;
    private int defesa;
    private int agilidade;

    public Lutador(String nome, int vida, int forca, int defesa ,int agilidade) {
        this.nome = nome;
        this.vida = vida;
        this.forca = forca;
        this.defesa = defesa;
        this.agilidade = agilidade;
    }
    
    public String getnome(){
        return this.nome;
    }
    
    public void setnome(String nome){
        this.nome = nome ;
    }

    public int getvida(){
        return this.;
    }
    
    public void setvida(int vida ){
        this.vida = vida ;
    }
    
    public int getforca(){
        return this.forca;
    }
    
    public void setforca(int forca){
        this.forca = forca ;
    }
    
    public int getdefesa(){
        return this.defesa;
    }
    
    public void set(int defesa){
        this.defesa = defesa ;
    }
    
    public int getagilidade(){
        return this.agilidade;
    }
    
    public void setagilidade(int agilidade){
        this.agilidade = agilidade;
    }
    
    public void atacar(Lutador alvo) {
        //logica de ataque
    }

    public void defender() {
        // Lógica da defesa
    }

    public boolean estaVivo() {
        return this.vida > 0;
    }
}
