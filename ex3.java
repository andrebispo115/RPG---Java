
package app2;

public class Professor extends Pessoa {
    private int tempo;

    public Professor() {
    }

    public Professor(String nome, int idade, int tempo) {
        super(nome, idade);
        setTempo(tempo);
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        if(tempo > 0){
            this.tempo = tempo;
        }
    }
    @Override
    public String toString(){
        return "nome: " + nome + "\n" + "idade: " + idade + "\n" + "tempo de trabalho: " + tempo; 
    }
}
