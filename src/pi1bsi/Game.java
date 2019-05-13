package pi1bsi;

import java.io.IOException;
import java.util.Scanner;

public class Game {
    static Scanner sc = new Scanner(System.in);
    static String nameWithoutFormating;
    static String nameMain;
    static String nameLowerCase;
    static int age;                      //NAO DEIXAR PRIVATE POIS USAREMOS EM OUTRAS CLASSES, COMO A PRINT
    static int mood = 0;
    static int ifLate = 0;
    static int intimacyRaquelWithMain = 0;
    static int intimacyLorenWithMain = 0;
    static String decision = "", objectDecision = "", trashItem = "";
    static String[] inventory = new String[6];

    public static void main(String[] args) throws InterruptedException, IOException { // main com o Thread to sleep

        Printer.clearConsole();
        Printer.printWatch(); //debug
        makeInventory();
        startGame();
        //BEGINNING
    }


    // \\\\\\\\\\\\\\\\\\\ ********************** AREA DE CRIACAO DOS METODOS DE DECISAO *******************************////////////////

    public static void makeInventory() throws InterruptedException { // CRIAÇÃO DO INVENTÁRIO

        for (int i = 0; i < 6; i++) {
            inventory[i] = "vazio"; //deixar vazio
        }
    }

    private static boolean addInventory(String object) {
        for (int i = 0; i < inventory.length; i++) { //adiciona o celular no inventario
            if (inventory[i].equalsIgnoreCase("vazio")) {
                inventory[i] = object;
                System.out.println(object + " foi adicionado ao seu inventario");
                return true; // senao ele vai colocar em todos
            }
        }
        System.out.println("Seu inventario esta cheio.");
        deleteItemIventory();
        return false;
    }

    private static void deleteItemIventory() {
        System.out.println("Deseja deletar algum item do seu inventario?");
        Printer.printInventory();
        System.out.println("[A] - Sim\t\t\t[B] - Nao");

        do {
            System.out.print(">");
            objectDecision = sc.nextLine();
            if (!objectDecision.equalsIgnoreCase("a") && !objectDecision.equalsIgnoreCase("b")) {
                System.err.println("Digite apenas \"A\" ou \"B\"!");
            }
        } while (!objectDecision.equalsIgnoreCase("a") && !objectDecision.equalsIgnoreCase("b"));

        if (objectDecision.equalsIgnoreCase("a")) {
            System.out.println("Digite o nome do item que deseja jogar fora:");
            trashItem = sc.nextLine();

            for (int i = 0; i < inventory.length; i++) {
                if (trashItem.equalsIgnoreCase(inventory[i])) {
                    inventory[i] = "";
                }
            }

        } else {
            System.out.println("Voce nao jogou nenhum item fora.");
            return;
        }
    }

    public static void startGame() throws InterruptedException {
        System.out.println("Voce acorda com o barulho do despertador para ir trabalhar, o que deseja fazer?");
        System.out.println("[A] =  Levantar\t\t\t[B] = Continuar dormindo");

        do {
            System.out.print(">");
            decision = sc.nextLine();
            if (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b")) { // ESSE IF SERVE APENAS PARA ESCREVER O QUE O USUARIO DEVE FAZER
                System.err.println("Digite apenas \"A\" ou \"B\"!");
            }
        } while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b")); //enquanto nao acertar as palavras ele vai continaur roadndo

        if (decision.equalsIgnoreCase("a")) {
            wakeUpBed(); //vai ter que passar por esse alguma hora, senão o jogo não começa
            // codigo se for levantar
        } else {
            System.out.println("Voce dormiu mais um pouco. O que deseja fazer agora?");
            System.out.println("[A] =  Levantar\t\t\t[B] = Continuar dormindo");
            //codigo se continuar dormindo
            ifLate++;
        }
    }

    public static void wakeUpBed() throws InterruptedException {
        if (ifLate >= 1) { //se estiver atrasado
            System.out.println("Voce acorda atrasado, toma um banho rapido e se arruma correndo para ir trabalhar.");
            mood--; //mood valendo -1

        } else { //se nao estiver atrasado
            System.out.println("Voce acorda, tira um momento para se alongar, toma um banho e prepara o melhor cafe" +
                    " da manha pois voce sente que o hoje o dia sera um dos melhores.");
            mood++; //mood valendo +1
        }
        getToWork();
    }


    public static void getToWork() throws InterruptedException {
        Thread.sleep(3800); //pausar por 3,8s
        System.out.println("Ao chegar ao trabalho, recebe a noticia de que uma nova funcionaria fara parte de sua" +
                " equipe. Quando voce esta indo em direcao a sua mesa, a nova funcionaria te cumprimenta dizendo:\n");

        Thread.sleep(5000); //pausar por 5,0s

        System.out.print("Bom dia!! Prazer, eu sou a Raquel. Fui contratada recentemente aqui. Qual o seu nome?\n\n");

        Thread.sleep(800);

        if (mood >= 1) { //se estiver com o mood 1
            System.out.println("[A] =  Bom dia!! Prazer, meu nome eh <seu nome aqui>, Seja muito bem vinda, Raquel!");
            System.out.println("[B] =  Oi, meu nome eh <seu nome aqui>.");

            do {
                System.out.print(">");
                decision = sc.nextLine();
                if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B")) { // ESSE IF SERVE APENAS PARA ESCREVER O QUE O USUARIO DEVE FAZER
                    System.err.println("Digite apenas \"A\" ou \"B\"!");
                }
            }
            while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b"));

            if (decision.equalsIgnoreCase("a")) { // SE ESCOLHER A COM MOOD 1
                System.out.print("Bom dia!! Prazer, meu nome eh ");
                nameWithoutFormating = sc.nextLine(); //FAZER O ESQUEMA DE ESCREVER COM LETRA MINUSCULA E SALVAR A PRIMEIRA MAIUSCULA
                nameLowerCase = nameWithoutFormating.toLowerCase();
                nameMain = ((nameLowerCase.substring(0, 1).toUpperCase()) + nameLowerCase.substring(1));//reduzido para a funcao abaixo
//                nameMain = StringUtils.capitalize(nameLowerCase);
                Thread.sleep(200);
                System.out.println("Seja muito bem vinda, Raquel!");
                intimacyRaquelWithMain += 2;

            } else { //SE ESCOLHER B
                System.out.print("Oi, meu nome eh ");
                nameWithoutFormating = sc.nextLine();
                nameLowerCase = nameWithoutFormating.toLowerCase();
                nameMain = ((nameLowerCase.substring(0, 1).toUpperCase()) + nameLowerCase.substring(1));
//                nameMain = StringUtils.capitalize(nameLowerCase);
                intimacyRaquelWithMain++;
            }

        } else { //se estiver com o mood baixo
            System.out.println("[A] =  Oi, meu nome eh <seu nome aqui>.");
            System.out.println("[B] = Me chamo <seu nome aqui>. Raquel, se puder fazer silencio eu agradeco.");

            do {
                System.out.print(">");
                decision = sc.nextLine();
                if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B")) { // ESSE IF SERVE APENAS PARA ESCREVER O QUE O USUARIO DEVE FAZER
                    System.err.println("Digite apenas \"A\" ou \"B\"!");
                }
            }
            while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b"));

            if (decision.equalsIgnoreCase("a")) {
                System.out.print("Oi, meu nome eh ");
                nameWithoutFormating = sc.nextLine();
                nameLowerCase = nameWithoutFormating.toLowerCase();
//                nameMain = StringUtils.capitalize(nameLowerCase);
                nameMain = ((nameLowerCase.substring(0, 1).toUpperCase()) + nameLowerCase.substring(1));
                intimacyRaquelWithMain++;

            } else {
                System.out.print("Me chamo ");
                nameWithoutFormating = sc.nextLine();
                nameLowerCase = nameWithoutFormating.toLowerCase();
//                nameMain = StringUtils.capitalize(nameLowerCase);
                nameMain = ((nameLowerCase.substring(0, 1).toUpperCase()) + nameLowerCase.substring(1));
                System.out.println("Raquel, se puder fazer silencio eu agradeco.");
                intimacyRaquelWithMain -= 2;
            }
        }
        searchInPhone();
    }

    public static void searchInPhone() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("\n\nApos o termino do expediente, voce pega o trem para voltar para o seu apartamento e " +
                "durante o percurso voce se depara com um celular jogado na rua. Voce olha aos arredores para ver se " +
                "o dono nao esta por perto, porem nao encontra ninguem. Entao voce pega o celular e leva para o seu " +
                "apartamento.");
        addInventory("Celular");

        System.out.println("\nQuando chega em casa, voce liga o celular e se depara com uma tela de bloqueio por senha, " +
                "nada fora do comum. Tentando descobrir alguma maneira de burlar a senha, voce ve que no plano de " +
                "fundo tem uma garota com um cachorro. Ao deslizar o dedo sobre a tela, o plano de fundo muda e o celular " +
                "trava e pede para seja feito uma recuperacao do sistema.");
        Thread.sleep(5000);


        System.out.println("\nO que voce deseja fazer?");
        Thread.sleep(400);
        System.out.println("[A] = Fazer a recuperacao do sistema\t\t[B] = Tentar achar outra maneira para nao resetar o celular" +
                " \t\t[C] = Olhar o inventario");

        do {
            System.out.print(">");
            decision = sc.nextLine();
            if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B") && !decision.equalsIgnoreCase("C"))
                System.err.println("Digite apenas \"A\", \"B\" ou \"C\"!");
            if (decision.equalsIgnoreCase("C")) {
                Printer.printInventory();
                System.out.println("[A] = Fazer a recuperacao do sistema\t\t[B] = Tentar achar outra maneira para nao resetar o celular" +
                        " \t\t[C] = Olhar o inventario");
            }
        }
        while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b"));

        if (decision.equalsIgnoreCase("a")) { //escolheu A
            phoneReset();

        } else { //escolheu B
            System.out.println("Voce tenta achar outra maneira porem nao consegue.");
            System.out.println("[A] = Fazer a recuperacao do sistema\t\t[B] = Tentar achar outra maneira para nao resetar o celular");
        }
    }

    public static void phoneReset() throws InterruptedException {
        Thread.sleep(500);

        System.out.println("Ao realizar a recuperacao do sistema, a Lorem eh ativada e comecam a surgir diversas " +
                "perguntas na tela.");
        System.out.println("\nOla, Raquel! Verifiquei em meu sistema que nos ultimos dados voce estava muito euforica " +
                "e de repente nao consegui mais te contatar. O que aconteceu?");

        Thread.sleep(6000);

        System.out.println("Ei, espere um momento! Voce nao eh a Raquel! Onde ela esta? Passe o celular para ela " +
                "IMEDIATAMENTE!!!!!");

        Thread.sleep(1000);

        System.out.println("\n[A] = Claro que eu sou a Raquel, Lorem. Por que esta dizendo isso?");
        System.out.println("[B] = A Raquel nao esta, encontrei este celular na rua e nao vi ninguem por perto " +
                "para devolver, por isso decidi pegar para tentar devolver ao dono.");
        System.out.println("[C] = Quem eh Raquel?");
        System.out.println("[D] = Quem eh voce?");

        do {
            System.out.print(">");
            decision = sc.nextLine();

            if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B") && !decision.equalsIgnoreCase("C") && !decision.equalsIgnoreCase("D")) {
                System.err.println("Digite apenas \"A\", \"B\", \"C\" ou \"D\"!");
            }
        }

        while (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B") &&
                !decision.equalsIgnoreCase("C") && !decision.equalsIgnoreCase("D"));

        if (decision.equalsIgnoreCase("a")) { //SE ESCOLHER A
            imRaquel();
        } else if (decision.equalsIgnoreCase("b")) { //SE ESCOLHER B
            imNotRaquel();
        } else if (decision.equalsIgnoreCase("c")) { //SE ESCOLHER C
            whoAreRaquel();
        } else if (decision.equalsIgnoreCase("d")) { // SE ESCOLEHR D
            whoAreYou();
        }
    }

    public static void imRaquel() {
        System.out.println("Raquel, o que aconteceu com voce no dia 26? Notei que voce estava em panico");


    }

    public static void imNotRaquel() {

    }

    public static void whoAreRaquel() {

    }

    public static void whoAreYou() {

    }
}
