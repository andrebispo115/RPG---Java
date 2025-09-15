 import java.util.Scanner;
  
 public class Menu {


    public static void main(String[] args){
    
        Scanner teclado = new Scanner(System.in);
        int escolha = 3;
        do{
        System.out.println("1-jogar");
        System.out.println("2-creditos");
        System.out.println("3-sair");
        escolha = teclado.nextInt();
        } while(escolha != 3);

    }

}   
