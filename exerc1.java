
package app2;

public class Aluno extends Pessoa implements Fazer {
    private double nota;

    public Aluno(String nome, int idade, double nota) {
        super(nome, idade);
        this.nota = nota;
    }

    public double getNota() {
        return nota;
    }
    
    public void setNota(double nota) {
        if(nota >= 0){
            this.nota = nota;
        }
    }
    @Override
    public String toString(){
        return "dinossauro  " + nome + "\n" + "idade: " + idade + "\n" + "nota: " + nota;
    }
    @Override
    public void fazendo(){
        System.out.println("esta estudadando");
    }
    
}
