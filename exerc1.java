package com.mycompany.app2;
public class Aluno {
    private String nome;
    private double nota;
    private int idade;

    public Aluno(String nome, int idade, double nota) {
        this.nome = nome;
        this.nota = nota;
        this.idade = idade;
    }

    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }

    public double getNota() {
        return nota;
    }

    public void setIdade(int idade) {
        if(idade > 5){
            this.idade = idade;
        }
    }

    public void setNome(String nome) {
        if(nome.length() > 1 ){   
            this.nome = nome;
        }  
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
    
}
