package pi1bsi;

import java.io.IOException;
import java.util.Scanner;

public class Game {
    static Scanner sc = new Scanner(System.in); ////NAO DEIXAR PRIVATE POIS USAREMOS EM OUTRAS CLASSES, COMO A PRINT
    static boolean loop = true;
    static String nameWithoutFormating;   //serve para pegar o primeiro nome
    static String nameMain;               //nome real utilizado depois de formatar
    static String nameLowerCase;          //formatar
    static int age = 0;
    static int mood = 0;
    static int ifLate = 0;
    static int intimacyRaquelWithMain = 0;
    static int intimacyLorenWithMain = 0;
    static String decision = "", trashItem = "";
    static String[] inventory = new String[5];
    static String[] progressBar = new String [100];

    public static void main(String[] args) throws InterruptedException, IOException { // main com o Thread to sleep
        System.out.println("Envie qualquer tecla para comecar");
        sc.nextLine();
        Printer.clearConsole();
        Printer.printWatch(); //DEIXAR ATIVO
        makeInventory();
        startGame();
    }

    // \\\\\\\\\\\\\\\\\\\ ********************** AREA DE CRIACAO DOS METODOS DE DECISAO *******************************////////////////


    public static void endGame() {
        System.exit(1);
    }

    public static void makeInventory() {

        for (int i = 0; i < inventory.length; i++) {
            inventory[i] = "slot vazio"; // "slot vazio" = vazio, sem nada.
        }
    }

    public static void verifyInventory() {
        int notSpaceEnough = 0;
        for (int i = 0; i < inventory.length; i++) {
            if (!inventory[i].equalsIgnoreCase("slot vazio")) {
                notSpaceEnough++; //se cair aqui eh pq ta cheio = diferente de "slotvazio"
            }
        }

        if (notSpaceEnough == inventory.length) { // igual a inventory.length pq se ele ver que todos estao diferentes de vazio, esta cheio
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

            if (trashItem.equalsIgnoreCase("sair")) { //caso queira sair
                return; //sai do metodo
            }

            if (trashItem.equalsIgnoreCase("Celular")) {  //caso tente jogar o celular fora (nao pode)
                System.err.println("Voce nao pode jogar o celular fora!");
                deleteItemInventory(); //roda de novo pra escolher
                return; //sai do metodo
            }

            if (trashItem.equalsIgnoreCase("slot vazio")) { //caso esteja vazio
                System.err.println("Este slot ja esta vazio");
                deleteItemInventory();
                return;
            }
            System.out.println(""); //pular uma linha pra nao ficar feio

            for (int i = 0; i < inventory.length; i++) {
                itemFound = 0;
                if (trashItem.equalsIgnoreCase(inventory[i])) { //se ele achar no array o que o cara quis jogar fora, ele deixa como slot vazio, ou seja, vazio
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

            if (ifLate == 5) {
                System.out.println("Voce vai se atrasar MUITO!");
                ifLate++;
            }

            if (ifLate == 10) {
                System.out.println("Seu chefe ja esta ligando reclamando do  atraso");
                ifLate++;
            }
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
                " equipe.\nQuando voce esta indo em direcao a sua mesa, a nova funcionaria te cumprimenta dizendo:\n");

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
                System.out.println("\n-Claro! Eu topo!!!");
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

        verifyInventory(); // << adicionar coisa no inventario
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
        while (loop) {
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
                System.out.println("Escolha outra das alternativas disponiveis");

            } else if (decision.equalsIgnoreCase("c")) {
                Printer.printInventoryWithAction();
            }
            System.out.println("[A] = Fazer a recuperacao do sistema\t\t[B] = Tentar achar outra maneira para nao resetar o celular \t\t[C] = Olhar o inventario");
        }
    }

    public static void phoneReset() throws InterruptedException, IOException {
        Printer.clearConsole();
        Thread.sleep(500);

        System.out.println("Ao realizar a recuperacao do sistema, a Lorem eh ativada e comecam a surgir diversas " +
                "perguntas na tela.");
        System.out.println("\nOla, Chris! Vi que na sua festa de aniversario, dia 26 de abril, voce estava muito euforica. O que aconteceu?");

        Thread.sleep(5000);

        System.out.println("Chris????");

        Thread.sleep(4000);

        System.out.println("Ei, espera. Voce nao eh a Chris. Onde ela esta? Passe o celular para ela imediatamente!!!");

        System.out.println("\n[A] = A Chris nao esta, encontrei este celular na rua e nao vi ninguem por perto para devolver, por isso decidi pegar para tentar devolver ao dono");
        System.out.println("[B] = Quem eh Chris?");
        System.out.println("[C] = Quem eh voce?");
        System.out.println("[D] = Olhar o inventario");

        while (loop) {
            do {
                System.out.print(">");
                decision = sc.nextLine();

                if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B") && !decision.equalsIgnoreCase("C") && !decision.equalsIgnoreCase("D")) {
                    System.err.println("Digite apenas \"A\", \"B\", \"C\" ou \"D\"");
                }
            }

            while (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B") &&
                    !decision.equalsIgnoreCase("C") && !decision.equalsIgnoreCase("D"));

            if (decision.equalsIgnoreCase("a")) { //SE ESCOLHER A
                Thread.sleep(500);
                loop = false;
                intimacyLorenWithMain++;
                bringItBackToChris();
            } else if (decision.equalsIgnoreCase("b")) { //SE ESCOLHER B
                Thread.sleep(500);
                System.out.println("Chris eh a dona desse celular.");
                loop = false;
                intimacyLorenWithMain--;
                bringItBackToChris();
            } else if (decision.equalsIgnoreCase("c")) { //SE ESCOLHER C
                Thread.sleep(500);
                System.out.println("Me escute!");
                loop = false;
                intimacyLorenWithMain--;
                bringItBackToChris();
            } else if (decision.equalsIgnoreCase("d")) { //SE ESCOLHER D
                Printer.printInventoryWithAction();

            }
            System.out.println("\n[A] = A Chris nao esta, encontrei este celular na rua e nao vi ninguem por perto para devolver, por isso decidi pegar para tentar devolver ao dono");
            System.out.println("[B] = Quem eh Chris?");
            System.out.println("[C] = Quem eh voce?");
            System.out.println("[D] = Olhar o inventario");
        }
    }

    public static void bringItBackToChris() throws InterruptedException, IOException {
        System.out.println("Voce precisa devolver esse celular para a Chris o quanto antes.");
        System.out.println("[A] - Mas eu nao a conheco\t\t[B] - Eu nao a conheco mas se precisar de algo eu topo\t\t[C] - Quem eh voce?\t\t [D] - Olhar o inventario");


        do {
            System.out.print(">");
            decision = sc.nextLine();

            if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B") && !decision.equalsIgnoreCase("C") && !decision.equalsIgnoreCase("D")) {
                System.err.println("Digite apenas \"A\", \"B\", \"C\" ou \"D\"");
            }
        }

        while (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B") &&
                !decision.equalsIgnoreCase("C") && !decision.equalsIgnoreCase("D"));

        Thread.sleep(500);
        if (decision.equalsIgnoreCase("a")) { //SE ESCOLHER A
            intimacyLorenWithMain--;
            System.out.println("Que seja, mas voce pode me ajudar?????");
            Thread.sleep(1500);
            loop = false;
            helpLorenReset();
            return;
        } else if (decision.equalsIgnoreCase("b")) { //SE ESCOLHER B
            intimacyLorenWithMain++;
            System.out.println("Otimo!");
            Thread.sleep(1500);
            loop = false;
            helpLorenReset();
            return;
        } else if (decision.equalsIgnoreCase("c")) { //SE ESCOLHER C
            intimacyLorenWithMain--;
            System.out.println("Voce vai ficar insistindo nisso? Me ajuda logo!");
            Thread.sleep(1500);
            loop = false;
            helpLorenReset();
            return;
        } else if (decision.equalsIgnoreCase("d")) { //SE ESCOLHER INVENTARIO
            Printer.printInventoryWithAction();
        }
        //ENUNCIADO - QUESTAO
        System.out.println("Voce precisa devolver esse celular para a Chris o quanto antes.");
        System.out.println("[A] - Mas eu nao a conheco\t\t[B] - Eu nao a conheco mas se precisar de algo eu topo\t\t[C] - Quem eh voce?");
    }

    public static void helpLorenReset() throws InterruptedException, IOException {
        System.out.println("Antes do celular dela ficar corrompido, foi registrada uma foto na camera frontal em que a Chris esta muito assustada" +
                ". Sou uma inteligencia artificial e assistente dela. Acredito que consiga recuperar algumas informacoes. " +
                "\nPosso tentar?");

        System.out.println("[A] - Sim\t\t[B] - Nao");

        do {
            System.out.print(">");
            decision = sc.nextLine();

            if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B")) {
                System.err.println("Digite apenas \"A\" ou \"B\"");
            }
        }

        while (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B"));

        if (decision.equalsIgnoreCase("A"))
            System.out.println("Vou tentar recuperar!");
        else
            System.out.println("Eu preciso! Quero saber aonde a Chis esta! Eu vou fazer de qualquer jeito!");
        Thread.sleep(4500);

        Printer.lorenReset();

        //ADICIONAR ENDGAME(); NO FINAL DO PROGRAMA!! << SENAO VAI RETORNAR TODAS AS FUNCOES
    }
}
