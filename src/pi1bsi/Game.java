package pi1bsi;

import java.io.IOException;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) throws InterruptedException, IOException { // main com o Thread para sleep
        Scanner sc = new Scanner(System.in);
        Printer.clearConsole();
        Printer.printWatch();
        System.out.println("Voce acordou com o barulho do despertador, deseja fazer o que?");
        System.out.println("Levantar ou mexer no celular?");
        sc.nextLine();
    }
}


