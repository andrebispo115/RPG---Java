public class Inimigo {

    private String nome;
    private int vida;
    private int forca;
    private int defesa;
    private int agilidade;

    public Heroi(String nome, int vida, int forca, int defesa, int agilidade) {
        this.nome = nome;
        this.pv = vida;
        this.forca = forca;
        this.defesa = defesa;
        this.agilidade = agilidade;
    }

    public String getnome() {
        return nome;
    }

    public int getvida() {
        return vida;
    }

    public int getforca() {
        return forca;
    }

    public int getdefesa() {
        return constituicao;
    }

    public int getagilidade() {
        return agilidade;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }
    
    public void setvida(int vida) {
        this.vida = vida;
    }
    
    public void setforca(int forca) {
        this.forca = forca;
    }
    
    public void setCdefesa(int defesa) {
        this.defesao = defesa;
    }
    
    public void setagilidade(int agilidade) {
        this.agilidade = agilidade;
    }
    
}
