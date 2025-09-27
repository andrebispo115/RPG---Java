public class Heroi {

    private String nome;
    private int vida;
    private int forca;
    private int agilidade;
    private int constituicao;
    private int destreza;

    public Heroi(String nome, int pv, int forca, int constituicao, int agilidade, int destreza) {
        this.nome = nome;
        this.pv = pv;
        this.forca = forca;
        this.constituicao = constituicao;
        this.agilidade = agilidade;
        this.destreza = destreza;
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
