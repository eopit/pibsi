package pi1bsi;

import java.io.IOException;
import java.util.Scanner;

public class Game {
    static String name;
    static int age;


    public static void main(String[] args) throws InterruptedException, IOException { // main com o Thread para sleep
        Scanner sc = new Scanner(System.in);
        String decision;
        Printer.clearConsole();
        Printer.printWatch();
        System.out.println("Voce acorda com o barulho do despertador para ir trabalhar, o que deseja fazer?");
        System.out.println("A. Levantar\nB. Mexer no celular mais um pouco");

        do {
            decision = sc.nextLine();
            if (!decision.equalsIgnoreCase("Levantar") && !decision.equalsIgnoreCase("Mexer no celular mais um pouco")) { // ESSE IF SERVE APENAS PARA ESCREVER O QUE O USUARIO DEVE FAZER
                System.err.println("Digite apenas exatamente o que aparece nas alternativas!");
            }
        } while (!decision.equalsIgnoreCase("Levantar") && !decision.equalsIgnoreCase("Mexer no celular mais um pouco")); //enquanto nao acertar as palavras ele vai continaur roadndo

        if (decision.equalsIgnoreCase("levantar")) {
            // codigo se for levantar
        } else {
            //codigo se for
        }
    }
}



