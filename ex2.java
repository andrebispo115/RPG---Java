
package app2;

public abstract class Pessoa {
    String nome;
    int idade;
    public Pessoa(){
        this.nome = "Sem nome";
        this.idade = 0;
    }
    public Pessoa(String nome, int idade){
        setNome(nome);
        setIdade(idade);
    }
    public void setNome(String nome) {
        if(nome.length() > 1 ){   
            this.nome = nome;
        }  
    }
    public void setIdade(int idade) {
        if(idade > 5){
            this.idade = idade;
        }
    }

    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }
    
}
