
package com.mycompany.app2;
import java.util.ArrayList;
import java.util.Scanner;
public class App2 {

    public static void main(String[] args) {
        ArrayList<Aluno>EC2MA =new ArrayList();
        Scanner scanner = new Scanner(System.in);
        int r;
        
        while(true){
            System.out.println("digite o nome do aluno");
            String N = scanner.next();
            System.out.println("digite a idade do aluno");
            int I = scanner.nextInt();
            System.out.println("digite a nota final do aluno");
            double P = scanner.nextDouble();
            Aluno aluno = new Aluno(N, I, P);
            EC2MA.add(aluno);
        
            do{
                System.out.println("deseja adicionar mais um alunos");
                System.out.println("1 - sim, 2 - nao");
                r = scanner.nextInt();
                if(r != 1 && r != 2){
                    System.out.println("digite 1 ou 2");
                }        
            }while(r != 2 && r != 1);
            if (r == 2){
                break;
            } 
        }
            int c;
            int i;
            double n;
            do{
                System.out.println("o que voce quer fazer? \n");
                System.out.println("1 - ver a lista de alunos \n");
                System.out.println("2 - ver a media de nota dos alunos \n");
                System.out.println("3 - ver a media de idade dos alunos \n");
                System.out.println("4 - ver o desvio padrao das notas \n");
                System.out.println("5 - ver a mediana das notas \n");
                System.out.println("6 - sair");
                r = scanner.nextInt();
                
                if(r==1){
                    for(Aluno aluno : EC2MA){
                        System.out.println(aluno);
                    }    
                    }else if(r==2){
                        c = 0;
                        n = 0.00;
                        for(Aluno aluno : EC2MA){
                            n = n + aluno.getNota();
                            c++;
                        }
                        double k = n / c;
                        System.out.println("a media da tuma e: " +k);   
                    }else if(r==3){
                        c = 0;
                        i = 0;
                        for(Aluno aluno : EC2MA){
                            i = i + aluno.getIdade();
                            c++;
                        }
                        int k = i / c;
                        System.out.println("a media de idade da turma e: " +k);
                    }else if(r==4){
                        double x = 0.0;
                        ArrayList<Double>desvioPadrao = new ArrayList();
                        n = 0.00;
                        c = 0;
                        
                        double DP = 0.00;
                        for(Aluno aluno : EC2MA){
                            n = n + aluno.getNota();
                            c++;
                        }
                        double j = n / c;
                        for(Aluno aluno : EC2MA){
                            n = aluno.getNota();
                            x = (n - j) * (n - j);
                            desvioPadrao.add(x);
                        }
                        n = 0.00;
                        for(Double valor : desvioPadrao){
                            n = n + valor;
                        }
                        n = Math.sqrt(n/c);
                        System.out.println("o desvio padrao da turma e:" +n);
                    
                    }
            }while(r != 5);
        scanner.close();
    }    
    
}
