package pi1bsi;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
    static Scanner sc = new Scanner(System.in); ////NAO DEIXAR PRIVATE POIS USAREMOS EM OUTRAS CLASSES, COMO A PRINT
    static boolean loop = true;
    static String nameWithoutFormating;   //PEGA O NOME DIGITADO
    static String nameFullyMain;          //nome formatado porem completo,
    static String nameLowerCase;          //tudo lower case pra deixar a primeira letra maiuscula
    static String nameMain;               //pega sempre o primeiro nome
    static String nameArray[];
    static int age = 0;
    static int mood = 0;
    static int ifLate = 0;
    static int tips = 3;
    static int intimacyRaquelWithMain = 0;
    static int intimacyLorenWithMain = 0;
    static String decision = "", trashItem = "", useItem = "";
    static String[] inventory = new String[5];
    static String[] progressBar = new String[100];
    static boolean canUseItem;
    static String binaryCode;
    static boolean debug = false; // DEIXAR DESATIVADO NO PROGRAMA FINAL < REMOVE TODOS OS DELAYS DA MAIN

    public static void main(String[] args) throws InterruptedException, IOException { // main com o Thread to sleep
        Printer.clearConsole();

        Printer.menu(); //RODAR O MENU AQUI qnd fizer <<<<

        Printer.clearConsole(); //limpa pra deixar so o relogio

        Printer.printWatch(); //printa o relogio do inicio do jogo

        makeInventory(); //cria o inventario

        loop = true;
        startGame(); //comeca o primeiro metodo do jogo
    }

    // \\\\\\\\\\\\\\\\\\\ ********************** AREA DE CRIACAO DOS METODOS DE DECISAO *******************************////////////////

    private static void delayMethod(int delay) throws InterruptedException {
        if (!debug) {
            Thread.sleep(delay);
        }
    }

    public static boolean verifyTips() {
        if (tips > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void useTips(String tipText) {
        if (verifyTips()) {
            System.out.println(tipText);
            tips--;
        } else {
            System.out.println("Voce nao tem mais dicas disponiveis.");
        }
    }

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

    public static void useItemInventory() {
        int itemFound = 0;
        do {
            System.out.println("*Digite o nome do item que quer usar ou digite [sair]: ");
            System.out.print(">");
            useItem = sc.nextLine();

            if (useItem.equals("sair")) {
                return;
            }

            if (trashItem.equalsIgnoreCase("slot vazio")) { //caso esteja vazio
                System.err.println("Nao eh possivel utilizar esse item pois esta vazio");
                useItemInventory();
                return;
            }

            for (int i = 0; i < inventory.length; i++) {
                itemFound = 0;
                if (useItem.equalsIgnoreCase(inventory[i])) { //SE ACHAR NO ARRAY ELE VEM PRA CA
//                    inventory[i] = "slot vazio"; //exclui do inventario pq ele ja utilizou **************COLOCAR EM CADA ITEM**************
                    System.out.println("*Voce utilizou o(a) " + useItem + "*\n");

                    if (useItem.equalsIgnoreCase("Celular")) {
                        System.out.println("O que voce deseja utilizar no celular?\n");

                        System.out.println("[A] - decodificador de binario para texto.");

                        do {
                            System.out.print(">");
                            decision = sc.nextLine();
                            if (!decision.equalsIgnoreCase("a")) {  //pra aparecer o erro
                                System.err.println("Digite apenas \"A\"!");
                            }
                        } while (!decision.equalsIgnoreCase("a")); //enquanto nao acertar as palavras ele vai continaur rodando

                        loop = true;
                        while (loop) {
                            System.out.println("\nDigite APENAS numeros binarios SEM ESPACOS para fazer a conversao");
                            System.out.print(">");
                            binaryCode = sc.nextLine();

                            if (binaryCode.matches("^[0-1]+$")) {
                                loop = false;
                                System.out.println("A palavra convertida eh:\n");
                                StringBuilder sb = new StringBuilder(); // guardar os char
                                Arrays.stream( //  cria um stream
                                        binaryCode.split("(?<=\\G.{8})") // separa de 8 em 8
                                ).forEach(s -> // vai por esses 8 em 8
                                        sb.append((char) Integer.parseInt(s, 2)) // e casta pra char
                                );
                                Arrays.stream(binaryCode.split("(?<=\\G.{8})")).forEach(s -> System.out.print((char) Integer.parseInt(s, 2)));
                                System.out.print('\n' + "\n");
                            }
                        }
                    }

//                    else if (useItem.equalsIgnoreCase("ADICIONAR MAIS COISAS AQUI")) {//ADICIONAR MAIS ITEM, TODA VEZ Q ACHAR UM TEIM, ADICIONAR ELE AQUI
//                    inventory[i] = "slot vazio"; //exclui do inventario pq ele ja utilizou *COLOCAAR EM TODO ITEM*
//                }


                    return;
                } else {
                    itemFound--;
                }
            }
        }
        while (itemFound <= inventory.length);
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
        }
        while (itemFound <= inventory.length);
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

        delayMethod(2500);

        System.out.println("Ao chegar ao trabalho, recebe a noticia de que uma nova funcionaria fara parte de sua" +
                " equipe.\nQuando voce esta indo em direcao a sua mesa, a nova funcionaria te cumprimenta dizendo:\n");

        delayMethod(3000);

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
                nameFullyMain = ((nameLowerCase.substring(0, 1).toUpperCase()) + nameLowerCase.substring(1));
                nameArray = nameFullyMain.split(" ", 2);
                nameMain = nameArray[0];


                System.out.println("Voce vai amar essa empresa, trabalho aqui ha anos. Nos ate podemos ir almocar juntos hoje...");
                System.out.println("\n-Claro! Eu topo!!!");
                intimacyRaquelWithMain += 2;

            } else { //SE ESCOLHER B
                System.out.print("E ai, meu nome eh ");
                nameWithoutFormating = sc.nextLine();

                nameLowerCase = nameWithoutFormating.toLowerCase();
                nameFullyMain = ((nameLowerCase.substring(0, 1).toUpperCase()) + nameLowerCase.substring(1));
                nameArray = nameFullyMain.split(" ", 2);
                nameMain = nameArray[0];

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
                nameFullyMain = ((nameLowerCase.substring(0, 1).toUpperCase()) + nameLowerCase.substring(1));
                nameArray = nameFullyMain.split(" ", 2);
                nameMain = nameArray[0];

                System.out.println("Prazer, seja bem vinda.");
                intimacyRaquelWithMain++;

            } else {
                System.out.print("Me chamo ");
                nameWithoutFormating = sc.nextLine();

                nameLowerCase = nameWithoutFormating.toLowerCase();
                nameFullyMain = ((nameLowerCase.substring(0, 1).toUpperCase()) + nameLowerCase.substring(1));
                nameArray = nameFullyMain.split(" ", 2);
                nameMain = nameArray[0];

                System.out.println("Raquel, nao estou em um bom dia. Outra hora conversamos.");
                System.out.println("-Tudo bem, me desculpe.");
                intimacyRaquelWithMain -= 2;
            }
        }
        searchInPhone();
    }

    public static void searchInPhone() throws InterruptedException, IOException {
        delayMethod(2200);
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

        delayMethod(5000);

        System.out.println("\nO que voce deseja fazer?");
        delayMethod(400);
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
        delayMethod(500);

        System.out.println("Ao realizar a recuperacao do sistema, a Lorem eh ativada e comecam a surgir diversas " +
                "perguntas na tela.");
        System.out.println("\nOla, Chris! Vi que na sua festa de aniversario, dia 26 de abril, voce estava muito euforica. O que aconteceu?");

        delayMethod(5000);

        System.out.println("Chris????");

        delayMethod(4000);

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
                delayMethod(500);
                loop = false;
                intimacyLorenWithMain++;
                bringItBackToChris();
            } else if (decision.equalsIgnoreCase("b")) { //SE ESCOLHER B
                delayMethod(500);
                System.out.println("Chris eh a dona desse celular.");
                loop = false;
                intimacyLorenWithMain--;
                bringItBackToChris();
            } else if (decision.equalsIgnoreCase("c")) { //SE ESCOLHER C
                delayMethod(500);
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

        delayMethod(500);
        if (decision.equalsIgnoreCase("a")) { //SE ESCOLHER A
            intimacyLorenWithMain--;
            System.out.println("Que seja, mas voce pode me ajudar?????");
            delayMethod(1500);
            loop = false;
            helpLorenReset();
            return;
        } else if (decision.equalsIgnoreCase("b")) { //SE ESCOLHER B
            intimacyLorenWithMain++;
            System.out.println("Otimo!");
            delayMethod(1500);
            loop = false;
            helpLorenReset();
            return;
        } else if (decision.equalsIgnoreCase("c")) { //SE ESCOLHER C
            intimacyLorenWithMain--;
            System.out.println("Voce vai ficar insistindo nisso? Me ajuda logo!");
            delayMethod(1500);
            loop = false;
            helpLorenReset();
            return;
        } else if (decision.equalsIgnoreCase("d")) { //SE ESCOLHER INVENTARIO
            Printer.printInventoryWithAction();
        }
        bringItBackToChris();
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
        delayMethod(3000);

        Printer.lorenReset();
        crashedLoren();
    }


    public static void crashedLoren() throws InterruptedException, IOException {
        delayMethod(1000);
        System.out.println("Espera!");

        delayMethod(800);
        System.out.println("Eu nao sei o que aconteceu comigo, estou danificada. Nunca aconteceu isso antes.");

        delayMethod(2500);
        System.out.println("Eu consegui restaurar, porem algumas coisas estao diferentes, nao consegui recuperar aquela foto que comentei. Esse foi o ultimo relato que encontrei da Chris. " +
                "Parece que os outros conteudos foram protegidos por algum tipo de senha. Nao consigo decifrar isso sozinha.");
        System.out.println("\n*Aperte enter para ver a imagem encontrada*");

        sc.nextLine();

        Printer.crashedContent();

        System.out.println("\n\n");
        System.out.println("Essa eh a ultima print do celular dela que consegui encontrar sem estar protegida por alguma coisa.");
        System.out.println("Eu estou tentando recuperar os outros arquivos mas esta pedindo uma senha que eu nao sei.");
        System.out.println("Voce consegue ver isso pra mim???\n");

        loop = true;
        while (loop) {
            do {
                System.out.println("[A] - Claro que consigo. Como posso ajudar?\t\t[B] - Voce deveria saber, afinal voce que eh a assistente dela." +
                        "\t\t[C] - Olhar o inventario\t\t");

                System.out.print(">");
                decision = sc.nextLine();
                if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B") && !decision.equalsIgnoreCase("C"))
                    System.err.println("Digite apenas \"A\", \"B\" ou \"C\"!");

            }
            while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b") && !decision.equalsIgnoreCase("c"));

            if (decision.equalsIgnoreCase("a")) { //escolheu A
                loop = false;
                delayMethod(600);
                System.out.println("Consigo ver que o nome do arquivo eh myPassword, deve ter alguma senha escondida nela porem " +
                        "nao consigo identificar visualizando. Preciso que descubra qual eh a senha para mim, provavelmente eh " +
                        "a senha que preciso para restaurar os arquivos antigos.");
                findPassword();

            } else if (decision.equalsIgnoreCase("b")) { //escolheu B
                loop = false;
                intimacyLorenWithMain--;
                delayMethod(600);
                System.out.println("Essa senha nao foi eu que coloquei, por isso estou perguntando. Se eu soubesse e pudesse " +
                        "fazer isso sozinha nao falaria com voce.");
                System.out.println("Anda logo!\n");
                findPassword();

            } else if (decision.equalsIgnoreCase("c")) {
                Printer.printInventoryWithAction();
            }
            System.out.println("[A] - Claro que consigo. Como posso ajudar?\t\t[B] - Voce deveria saber, afinal voce que eh a assistente dela." +
                    "\t\t[C] - Olhar o inventario\t\t");
        }
    }


    public static void findPassword() throws InterruptedException, IOException {
        canUseItem = true;
        delayMethod(1200);
        loop = true;
        while (loop) {
            do {
                System.out.println("[A] - *Digitar a senha*\t\t[B] - Eu nao sei qual eh a senha\t\t[C] - Olhar o inventario\t\t[D] Usar uma dica.");

                System.out.print(">");
                decision = sc.nextLine();
                if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B") && !decision.equalsIgnoreCase("C") && !decision.equalsIgnoreCase("D"))
                    System.err.println("Digite apenas \"A\", \"B\", \"C\" ou \"D\"!");

            }
            while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b") && !decision.equalsIgnoreCase("c") && !decision.equalsIgnoreCase("d"));

            if (decision.equalsIgnoreCase("a")) { //escolheu A
                loop = false;
                String correctPassword = "loki";
                String passwordSended;
                System.out.println("Digite a senha:\n");
                System.out.print(">");
                passwordSended = sc.nextLine();

                if (passwordSended.equals(correctPassword)) { //se a senha for certa, ela recupera os arquivos
                    delayMethod(600);
                    System.out.println("Espera um pouco, vou tentar com essa senha.");
                    delayMethod(4000);
                    System.out.println("Perfeito!! Consegui recuperar!");
                    delayMethod(800);
                    System.out.println("Vou colocar para recuperar, agora eh so esperar e assim que estiver pronto te retorno com os arquivos, beleza?");
                    System.out.println("Aperte enter para continuar...");
                    sc.nextLine();
                    filesRestored();
                    //rodar um outro metodo falando que vai recuperar os arquivos e continuar a historia
                } else {
                    delayMethod(600);
                    System.out.println("Espera um pouco, vou tentar com essa senha.");
                    delayMethod(4000);
                    System.out.println("Droga! Acho que essa eh a senha errada. Consegue achar outra?");
                }


            } else if (decision.equalsIgnoreCase("b")) { //escolheu B
                loop = false;
                intimacyLorenWithMain--;
                System.out.println("Voce pode usar a dica se necessario, porem cuidado com o quanto voce utiliza. Ela eh finita!");
            } else if (decision.equalsIgnoreCase("c")) {
                Printer.printInventoryWithAction();
            } else if (decision.equalsIgnoreCase("d")) {
                useTips("A senha eh o binario convertido para texto. Use o celular para converter.");
            }
            findPassword(); //pra retornar sempre que nao colocar as coisas certas
        }
    }

    //COMECO DO CAPITULO 2

    public static void filesRestored() throws IOException, InterruptedException {
        Printer.filesRestoring();
        System.out.println("Pronto, consegui recuperar todos os arquivos. Pelo menos eu acho hehe.");
        delayMethod(600);
        System.out.println("Veja as opcoes que consegui recuperar:");
        allArchives();

    }

    public static void allArchives() throws InterruptedException {
        loop = true;
        while (loop) {
            do {
                System.out.println("O que gostaria de investigar?\n");
                System.out.println("[A] - Mensagens\n[B] - E-mail\n[C] - Galeria\n[D] - Musicas\n[E] - Bloco de notas");
                System.out.print(">");
                decision = sc.nextLine();

                if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B") && !decision.equalsIgnoreCase("C") && !decision.equalsIgnoreCase("D") && !decision.equalsIgnoreCase("E"))
                    System.err.println("Digite apenas \"A\", \"B\", \"C\", \"D\" ou \"E\"!");

            }
            while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b") && !decision.equalsIgnoreCase("c") && !decision.equalsIgnoreCase("d") && !decision.equalsIgnoreCase("e"));

            if (decision.equalsIgnoreCase("a")) { //se escolher mensagens

                System.out.println("\nTemos algumas conversas disponiveis aqui. Qual voce quer ver?");
                messages();

            } else if (decision.equalsIgnoreCase("b")) { //se escolher e-mail

            } else if (decision.equalsIgnoreCase("c")) { //se escolher galeria

            } else if (decision.equalsIgnoreCase("d")) { //se escolher musicas

            } else if (decision.equalsIgnoreCase("e")) { //se escolher bloco de notas

            }
            allArchives(); //se nao for nenhum dos outros
        }
    }

    public static void messages() throws InterruptedException {
        int conversationNumber = 0; //conta qnts conversas ele viu

        while (conversationNumber < 3) {
            do {
                System.out.println("\n\tEscolha uma conversa");
                System.out.println("[A] - Robert");
                System.out.println("[B] - Lilian");
                System.out.println("[C] - Arthur");

                System.out.print(">");
                decision = sc.nextLine();

                if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B") && !decision.equalsIgnoreCase("C"))
                    System.err.println("Digite apenas \"A\", \"B\" ou \"C\"");

            }
            while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b") && !decision.equalsIgnoreCase("c"));

            if (decision.equalsIgnoreCase("a")) { //robert
                System.out.println("\t\t\n24 de abril de 2019 01:58AM\n\n");
                System.out.println("\tRobert - Amor, atende o telefone...");
                System.out.println("\tRobert - Por favor");
                System.out.println("\tRobert - Fala comigo, Chris");
                System.out.println("\tRobert - Vamos, amor");
                System.out.println("\tRobert - Voce que mexeu no meu celular sem a minha permissao");
                System.out.println("\tRobert - Eu posso explicar.");
                System.out.println("\t...\n");

                conversationNumber++;

                System.out.println("Aperte enter para continuar...");
                sc.nextLine();

            } else if (decision.equalsIgnoreCase("b")) { //lilian
                System.out.println("\t\t\n12 de abril de 2019 3:42PM\n\n");
                System.out.println("\tLilian - Oi amiga, tudo bem?");
                System.out.println("\tChris - Oiiii\n\tChris - Tudo e com voce?");
                System.out.println("\tLilian - Estou bem tambem\n\tLilian - Deixa eu te perguntar. Voce ja teve curiosidade de ficar com alguma menina?");
                System.out.println("\tChris - Nao, so teria se a garota fosse o Robert hahahaa");
                System.out.println("\tLilian - Eu acho que ele nao te merece...\n\tLilian - Nao confio nele.");
                System.out.println("\tChris - Nao comeca, amiga. Eu estou bem com ele agora.");
                System.out.println("\t...");
                delayMethod(600);
                System.out.println("\t\t\n23 de abril de 2019 00:36AM\n\n");
                System.out.println("\tLilian - Eu sabia que ele nao prestava! Voce merece mais");
                System.out.println("\tLilian - Queria te contar uma coisa... Acho que estou apaixonada");
                System.out.println("\tLilian - Eu gosto de voce, Chris. Fica comigo. Eu vou te fazer feliz, muito mais do que voce pode imaginar.");
                System.out.println("\tLilian - Eu estou apaixonada por voce, eu nunca senti algo tao genuino por alguem. Me da uma chance.");
                System.out.println("\tLilian - Eu quero passar o resto da minha vida com voce! Nao consigo ver um futuro sem voce...");
                System.out.println("\tLilian - Chris?");
                System.out.println("\tLilian - ???");
                System.out.println("\t...");

                conversationNumber++;

                System.out.println("Aperte enter para continuar...");
                sc.nextLine();

            } else if (decision.equalsIgnoreCase("c")) { //arthur
                System.out.println("FALTA COLOCAR");
                //conversa aqui

                conversationNumber++;
                System.out.println("Aperte enter para continuar...");
                sc.nextLine();
            }
        }

        delayMethod(1000);
        System.out.println("Conseguiu descobrir alguma coisa??");
        do {
            System.out.println("[A] - Ja fazem dias que ela nao conversa com a Lilian");
            System.out.println("[B] - Ela brigou com o namorado e nao responde a mensagem ha dias. Provalvemente foi traicao.");

            System.out.print(">");
            decision = sc.nextLine();

            if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B"))
                System.err.println("Digite apenas \"A\" ou \"B\"");

        }
        while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b"));

        delayMethod(800);
        System.out.println("Hmmmm...");
        delayMethod(1300);
        System.out.println("Essas informacoes sao boas porem nao eh o que precisamos. Veja se consegue mais algo.");
        delayMethod(500);
        allArchives();
    }
}
//ADICIONAR ENDGAME(); NO FINAL DO PROGRAMA!! << SENAO VAI RETORNAR TODAS AS FUNCOES




