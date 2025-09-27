public class Inimigo {

    private String nome;
    private int vida;
    private int forca;
    private int agilidade;

    public Heroi(String nome, int vida, int forca,  int agilidade) {
        this.nome = nome;
        this.pv = vida;
        this.forca = forca;
        this.agilidade = agilidade;
    }

    public String getNome() {
        return nome;
    }

    public int getPv() {
        return pv;
    }

    public int getForca() {
        return forca;
    }

    public int getConstituicao() {
        return constituicao;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setPv(int pv) {
        this.pv = pv;
    }
    
    public void setForca(int forca) {
        this.forca = forca;
    }
    
    public void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
    }
    
    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }
    
    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }
}
