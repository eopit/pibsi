package pi1bsi;


import java.io.IOException;
import java.util.Scanner;

public class Game {
    static Scanner sc = new Scanner(System.in);
    static boolean loop = true;
    static String nameWithoutFormating;
    static String nameMain;
    static String nameLowerCase;
    static int age = 0;                      //NAO DEIXAR PRIVATE POIS USAREMOS EM OUTRAS CLASSES, COMO A PRINT
    static int mood = 0;
    static int ifLate = 0;
    static int intimacyRaquelWithMain = 0;
    static int intimacyLorenWithMain = 0;
    static String decision = "", objectDecision = "", trashItem2 = "", trashItem = "";
    static String[] inventory = new String[5];

    public static void main(String[] args) throws InterruptedException, IOException { // main com o Thread to sleep

        Printer.clearConsole();
//        Printer.printWatch(); //DEIXAR ATIVO
        makeInventory();
        startGame();
    }

    // \\\\\\\\\\\\\\\\\\\ ********************** AREA DE CRIACAO DOS METODOS DE DECISAO *******************************////////////////

    public static void makeInventory() {

        for (int i = 0; i < inventory.length; i++) {
            inventory[i] = "slot vazio"; // "" = vazio, sem nada.
        }
//        inventory[2] = "b";
    }

    public static void verifyInventory() {
        int notSpaceEnough = 0;
        for (int i = 0; i < inventory.length; i++) {
            if (!inventory[i].equalsIgnoreCase("slot vazio")) {
                notSpaceEnough++;
            }
        }

        if (notSpaceEnough == inventory.length) {
            System.out.println("*Seu inventario esta cheio!*");
            Printer.printInventory();
            deleteItemInventory();
        }
    }

    public static void addInInventory(String object) { //parametro do objeto, ao adicionar objeto escrever addinventory("OBJETO");
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i].equalsIgnoreCase("slot vazio")) {
                inventory[i] = object;
                System.out.println("*" + object + " foi adicionado ao seu inventario*");
                return; // senao ele vai colocar em todos
            }
        }
        System.out.println("*Seu inventario esta cheio.*");
        deleteItemInventory();
        return;
    }

    public static void deleteItemInventory() {
        int itemFound = 0;
        do {
            System.out.print("*Digite o nome do item que deseja jogar fora ou digite [sair]: ");
            trashItem = sc.nextLine();

            if (trashItem.equalsIgnoreCase("sair")) {
                return;
            }

            if (trashItem.equalsIgnoreCase("Celular")) {
                System.err.println("Voce nao pode jogar o celular fora!");
                deleteItemInventory();
                return;
            }

            if (trashItem.equalsIgnoreCase("slot vazio")) {
                System.err.println("Este slot ja esta vazio");
                deleteItemInventory();
                return;
            }
            System.out.println("");

            for (int i = 0; i < inventory.length; i++) {
                itemFound = 0;
                if (trashItem.equalsIgnoreCase(inventory[i])) {
                    inventory[i] = "slot vazio"; //DELETA
                    System.out.println("Voce jogou " + trashItem + " fora.");
                    return;
                } else {
                    itemFound--;
                }
            }
        } while (itemFound <= inventory.length);
    }

    public static void startGame() throws InterruptedException, IOException {
        System.out.println("Voce acorda numa sexta-feira com o barulho do despertador tocando, escolha o que deseja fazer.");
        System.err.println("OBS: Digite apenas o que esta dentro os colchetes!");
        System.out.println("[A] =  Levantar\t\t\t[B] = Continuar dormindo");

        while (loop) {
            do {
                System.out.print(">");
                decision = sc.nextLine();
                if (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b")) { // ESSE IF SERVE APENAS PARA ESCREVER O QUE O USUARIO DEVE FAZER
                    System.err.println("Digite apenas \"A\" ou \"B\"!");
                }
            } while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b")); //enquanto nao acertar as palavras ele vai continaur roadndo

            if (decision.equalsIgnoreCase("a")) { //CODIGO SE LEVANTAR
                wakeUpBed();                                 //vai ter que passar por esse alguma hora, senão o jogo não começa
                loop = false;
            } else {                                             //CODIGO SE CONTINUAR DORMINDO
                System.out.println("Voce dormiu mais um pouco. O que deseja fazer agora?");
                System.out.println("[A] =  Levantar\t\t\t[B] = Continuar dormindo");
                ifLate++;
            }
        }
    }

    public static void wakeUpBed() throws InterruptedException, IOException {
        if (ifLate >= 1) { //se estiver atrasado
            System.out.println("Voce levanta correndo, toma o banho mais rapido da sua vida e se arruma voando para ir para o trabalho.");
            mood--; //mood valendo -1

        } else { //se nao estiver atrasado
            System.out.println("Voce levanta, tira um momento para se alongar, toma um banho e prepara o melhor cafe" +
                    " da manha pois voce sente que o hoje o dia sera um dos melhores.");
            mood++; //mood valendo +1
        }
        getToWork();
    }


    public static void getToWork() throws InterruptedException, IOException {

        Thread.sleep(2500);

        System.out.println("Ao chegar ao trabalho, recebe a noticia de que uma nova funcionaria fara parte de sua" +
                " equipe.\nQuando voce esta indo em direcao a sua mesa, a nova funcionaria te cumprimenta dizendo:\n\n");

        Thread.sleep(3000);

        System.out.print("-Bom dia!! Prazer, eu sou a Raquel. Fui contratada recentemente aqui. Qual o seu nome?\n\n");

        if (mood >= 1) { //se estiver com o mood 1
            System.out.println("[A] =  Bom dia!! Prazer, meu nome eh _____________, Voce vai amar essa empresa, trabalho aqui ha anos. Nos ate podemos ir almocar juntos hoje...");
            System.out.println("[B] =  E ai, meu nome eh _____________.");

            do {
                System.out.print(">");
                decision = sc.nextLine();
                if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B")) { // ESSE IF SERVE APENAS PARA ESCREVER O QUE O USUARIO DEVE FAZER
                    System.err.println("Digite apenas \"A\" ou \"B\"!");
                }
            }
            while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b"));

            if (decision.equalsIgnoreCase("a")) { // ESCOLHA DO A (APENAS COM MOOD > 1)

                System.out.print("Bom dia!! Prazer, meu nome eh ");
                nameWithoutFormating = sc.nextLine();

                nameLowerCase = nameWithoutFormating.toLowerCase();
                nameMain = ((nameLowerCase.substring(0, 1).toUpperCase()) + nameLowerCase.substring(1));

                System.out.println("Voce vai amar essa empresa, trabalho aqui ha anos. Nos ate podemos ir almocar juntos hoje...");
                System.out.println("\n-Claro! Eu topo, por que nao?");
                intimacyRaquelWithMain += 2;

            } else { //SE ESCOLHER B
                System.out.print("E ai, meu nome eh ");
                nameWithoutFormating = sc.nextLine();

                nameLowerCase = nameWithoutFormating.toLowerCase();
                nameMain = ((nameLowerCase.substring(0, 1).toUpperCase()) + nameLowerCase.substring(1));

                System.out.println("Prazer, seja bem vinda.");
                System.out.println("-Muito obrigada!");
                intimacyRaquelWithMain++;
            }

        } else { //se estiver com o mood < 1
            System.out.println("[A] =  Ola, meu nome eh _____________.");
            System.out.println("[B] = Me chamo _____________. Raquel, nao estou em um bom dia. Outra hora conversamos.");

            do {
                System.out.print(">");
                decision = sc.nextLine();
                if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B")) { // ESSE IF SERVE APENAS PARA ESCREVER O QUE O USUARIO DEVE FAZER
                    System.err.println("Digite apenas \"A\" ou \"B\"!");
                }
            }
            while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b"));

            if (decision.equalsIgnoreCase("a")) {
                System.out.print("Ola, meu nome eh ");
                nameWithoutFormating = sc.nextLine();

                nameLowerCase = nameWithoutFormating.toLowerCase();
                nameMain = ((nameLowerCase.substring(0, 1).toUpperCase()) + nameLowerCase.substring(1));

                System.out.println("Prazer, seja bem vinda.");
                intimacyRaquelWithMain++;

            } else {
                System.out.print("Me chamo ");
                nameWithoutFormating = sc.nextLine();

                nameLowerCase = nameWithoutFormating.toLowerCase();
                nameMain = ((nameLowerCase.substring(0, 1).toUpperCase()) + nameLowerCase.substring(1));

                System.out.println("Raquel, nao estou em um bom dia. Outra hora conversamos.");
                System.out.println("-Tudo bem, me desculpe.");
                intimacyRaquelWithMain -= 2;
            }
        }
        searchInPhone();
    }

    public static void searchInPhone() throws InterruptedException, IOException {
        Thread.sleep(2200);
        Printer.clearConsole();

        System.out.println("\nApos o termino do expediente, voce pega o trem para voltar para o seu apartamento e " +
                "durante o percurso voce se depara com um celular jogado na rua.\nVoce olha aos arredores para ver se " +
                "o dono nao esta por perto, porem nao encontra ninguem. Entao voce decide pegar o celular para tentar" +
                " descobrir quem eh o dono.");

        verifyInventory();
        addInInventory("Celular"); // << adicionar coisa no inventario

        System.out.println("\nQuando chega em casa, voce liga o celular e se depara com uma tela de bloqueio por senha, " +
                "nada fora do comum. Tentando descobrir alguma maneira de burlar a senha, voce ve que no plano de " +
                "fundo tem uma garota com um cachorro. Ao deslizar o dedo sobre a tela, o plano de fundo muda e o celular " +
                "trava, pedindo para que seja feito uma restauracao do sistema.");

        Thread.sleep(5000);

        System.out.println("\nO que voce deseja fazer?");
        Thread.sleep(400);
        System.out.println("[A] = Fazer a recuperacao do sistema\t\t[B] = Tentar achar outra maneira para nao resetar o celular" +
                " \t\t[C] = Olhar o inventario");

        loop = true;
        while (true) {
            do {
                System.out.print(">");
                decision = sc.nextLine();
                if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B") && !decision.equalsIgnoreCase("C"))
                    System.err.println("Digite apenas \"A\", \"B\" ou \"C\"!");

            }
            while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b") && !decision.equalsIgnoreCase("c"));

            if (decision.equalsIgnoreCase("a")) { //escolheu A
                phoneReset();
                loop = false;

            } else if (decision.equalsIgnoreCase("b")) { //escolheu B
                System.out.println("Voce tenta achar outra maneira porem nao consegue.");
                System.out.println("Agora escolha uma das alternativas disponiveis");

            } else if (decision.equalsIgnoreCase("c")) {
                Printer.printInventoryWithAction();
//                System.out.println("[A] = Fazer a recuperacao do sistema\t\t[B] = Tentar achar outra maneira para nao resetar o celular" +
//                        " \t\t[C] = Olhar o inventario");
            }
            System.out.println("[A] = Fazer a recuperacao do sistema\t\t[B] = Tentar achar outra maneira para nao resetar o celular \t\t[C] = Olhar o inventario");
        }
    }

    public static void phoneReset() throws InterruptedException, IOException {
        Printer.clearConsole();
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

    public static void whoAreRaquel() {             //ACHO QUE VAI REMOVER TODOS ESSES METODOS < E VAI MUDAR /\

    }

    public static void whoAreYou() {

    }
}
