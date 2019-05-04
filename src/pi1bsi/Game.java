package pi1bsi;

import com.sun.xml.internal.ws.util.StringUtils;

import java.io.IOException;
import java.util.Scanner;

public class Game {
    static Scanner sc = new Scanner(System.in);
    static String nameWithoutFormating;
    static String nameMain; static String nameLowerCase;
    static int age;
    static boolean loop = true;
    static int mood = 0;
    static int ifLate = 0;
    static int intimacy = 0;
    static String decision = "";

    public static void main(String[] args) throws InterruptedException, IOException { // main com o Thread to sleep

        Printer.clearConsole();
        Printer.printWatch();
        //BEGINNING
        System.out.println("Voce acorda com o barulho do despertador para ir trabalhar, o que deseja fazer?");
        System.out.println("[A] =  Levantar\t\t\t[B] = Continuar dormindo");

        while (loop) {
            do {
                System.out.print(">");
                decision = sc.nextLine();
                if (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b")) { // ESSE IF SERVE APENAS PARA ESCREVER O QUE O USUARIO DEVE FAZER
                    System.err.println("Digite apenas [A] ou [B]!");
                }
            } while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b")); //enquanto nao acertar as palavras ele vai continaur roadndo

            if (decision.equalsIgnoreCase("a")) {
                loop = false;
                wakeUpBed(); //vai ter que passar por esse alguma hora, senão o jogo não começa
                // codigo se for levantar
            } else {
                System.out.println("Voce dormiu mais um pouco.");
                System.out.println("Deseja [levantar] ou [continuar dormindo]?");
                //codigo se continuar dormindo
                ifLate++;
            }
        }
    }

    // \\\\\\\\\\\\\\\\\\\ ********************** AREA DE CRIACAO DOS METODOS DE DECISAO *******************************///////////////
    public static void wakeUpBed() throws InterruptedException {
        if (ifLate >= 1) {
            System.out.println("Voce acorda atrasado, toma um banho rapido e se arruma correndo para ir trabalhar.");
            mood--; //mood valendo -1
            //se estiver atrasado
        } else {
            System.out.println("Voce acorda, tira um momento para se alongar, toma um banho e prepara o melhor cafe" +
                    " da manha pois voce sente que o hoje o dia sera um dos melhores.");
            mood++; //mood valendo +1
            //se nao estiver atrasado
        }
        Thread.sleep(3800); //pausar por 3,8s
        System.out.println("Ao chegar ao trabalho, recebe a noticia de que uma nova funcionaria fara parte de sua" +
                " equipe. Quando voce esta indo em direcao a sua mesa, a nova funcionaria te cumprimenta dizendo:\n");
        Thread.sleep(5000); //pausar por 5,0s
        System.out.print("Bom dia!! Prazer, eu sou a Raquel. Fui contratada recentemente aqui. Qual o seu nome?\n\n");

        Thread.sleep(800);

        if (mood >= 1) { //se estiver com o mood 1
            System.out.println("[A] =  Bom dia!! Prazer, meu nome eh <seu nome aqui>, Seja muito bem vinda, Raquel!");
            System.out.println("[B] =  Oi, meu nome é <seu nome aqui>.");

            do {
                System.out.print(">");
                decision = sc.nextLine();
                if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B")) { // ESSE IF SERVE APENAS PARA ESCREVER O QUE O USUARIO DEVE FAZER
                    System.err.println("Digite apenas [A] ou [B]!");
                }
            }
            while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b"));


            if (decision.equalsIgnoreCase("a")) { // SE ESCOLHER A COM MOOD 1
                System.out.print("Bom dia!! Prazer, meu nome eh ");
                nameWithoutFormating = sc.next(); //FAZER O ESQUEMA DE ESCREVER COM LETRA MINUSCULA E SALVAR A PRIMEIRA MAIUSCULA
                nameLowerCase = nameWithoutFormating.toLowerCase();
//              nameMain = ((nameLowerCase.substring(0, 1).toUpperCase()) + nameLowerCase.substring(1));
                System.out.println(StringUtils.capitalize(nameLowerCase));
                Thread.sleep(200);
                System.out.println("Seja muito bem vinda, Raquel!");
                intimacy += 2;

            } else {
                System.out.print("Oi, meu nome eh ");
                nameWithoutFormating = sc.next();
                intimacy++;
            }

        } else { //se estiver com o mood baixo
            System.out.println("Escolher primeiramente entre [A] e [B]");
            System.out.println("A. Oi, meu nome é <seu nome aqui>.");
            System.out.println("B. Me chamo <seu nome aqui>. Raquel, se puder fazer silencio eu agradeco.");

            do {
                System.out.print(">");
                decision = sc.nextLine();
                if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B")) { // ESSE IF SERVE APENAS PARA ESCREVER O QUE O USUARIO DEVE FAZER
                    System.err.println("Digite apenas [A] ou [B]!");
                }
            }
            while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b"));

            if (decision.equalsIgnoreCase("a")) {
                System.out.print("Oi, meu nome eh ");
                nameWithoutFormating = sc.next();
                intimacy++;

            } else {
                System.out.print("Me chamo ");
                nameWithoutFormating = sc.next();
                System.out.println("Raquel, se puder fazer silencio eu agradeco.");
                intimacy -= 2;
            }
        }
        System.out.println("=============");
        System.out.println(intimacy);
        System.out.println(nameMain);
    }
}



