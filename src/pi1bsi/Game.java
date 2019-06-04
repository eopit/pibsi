package pi1bsi;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
    static boolean debug = false; // DEIXAR DESATIVADO NO PROGRAMA FINAL < REMOVE TODOS OS DELAYS DA MAIN

    static Scanner sc = new Scanner(System.in); ////NAO DEIXAR PRIVATE POIS USAREMOS EM OUTRAS CLASSES, COMO A PRINT
    static boolean loop = true;
    static String nameWithoutFormating;    //PEGA O NOME DIGITADO
    static String nameFullyMain;           //nome formatado porem completo,
    static String nameLowerCase;           //tudo lower case pra deixar a primeira letra maiuscula
    static String nameMain;                //pega sempre o primeiro nome
    static String nameArray[];
    static String age = "";                //idade
    static int mood = 0;                   //humor
    static int ifLate = 0;                 //atraso
    static int tips = 1;                   //dicas
    static int intimacyRaquelWithMain = 0; //intimidade com a Raquel do trabalho
    static int intimacyLoremWithMain = 0; //intimidade com a lorem
    static String decision = "", trashItem = "", useItem = "";
    static String[] inventory = new String[5];  //criar o inventario
    static String[] progressBar = new String[100]; //barra de progresso do reset
    static boolean canUseItem;  //condicao praa poder usar
    static String binaryCode; //o code que o cara escreve pra achar a senha
    static int saveChris = 0;
    static int messagesSaw = 0, gallerySaw = 0, emailSaw = 0, musicsSaw = 0, blocoDeNotasSaw = 0;


    public static void main(String[] args) throws InterruptedException, IOException { //main rodando os metodos principais
        Printer.clearConsole();

        Printer.menu(); //RODAR O MENU AQUI qnd fizer <<<<

        Printer.clearConsole(); //limpa pra deixar so o relogio

        Printer.printWatch(); //printa o relogio do inicio do jogo

        makeInventory(); //cria o inventario

        loop = true;
        startGame(); //comeca o primeiro metodo do jogo
    }

    // \\\\\\\\\\\\\\\\\\\ ********************** AREA DE CRIACAO DOS METODOS DE DECISAO *******************************////////////////

    private static void delayMethod(int delay) throws InterruptedException { // metodo pra dar o delay
        if (!debug) {
            Thread.sleep(delay);
        }
    }

    public static boolean verifyTips() { // verifica se ele tem dicas disponiveis
        if (tips > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void useTips(String tipText) { // usa a dica se estiver disponivel
        if (verifyTips()) {
            System.out.println(tipText);
            tips--;
            System.out.println("Agora voce possui " + tips + " dicas.");
        } else {
            System.out.println("Voce nao tem mais dicas disponiveis.");
        }
    }

    public static void addTips() { //adiciona as dicas
        System.out.println("Voce pegou uma dica. Agora voce possui " + tips + " dicas.");
        tips++;
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
                    } else if (useItem.equalsIgnoreCase("Coca-cola")) {//ADICIONAR MAIS ITEM, TODA VEZ Q ACHAR UM TEIM, ADICIONAR ELE AQUI
                        inventory[i] = "slot vazio"; //exclui do inventario pq ele ja utilizou
                        System.out.println("*Voce utilizou o(a) " + useItem + "*\n");

                    } //else if (useItem.equalsIgnoreCase("Coca-cola")) {//ADICIONAR MAIS ITEM, TODA VEZ Q ACHAR UM TEIM, ADICIONAR ELE AQUI
//                        inventory[i] = "slot vazio"; //exclui do inventario pq ele ja utilizou
//                        System.out.println("*Voce utilizou o(a) " + useItem + "*\n");
//                    }
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

            if (ifLate == 2) {
                System.out.println("Voce vai se atrasar MUITO!");
                ifLate++;
            }

            if (ifLate == 5) {
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

        System.out.println("Apos o termino do expediente, voce pega o trem para voltar para o seu apartamento e " +
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
                intimacyLoremWithMain++;
                bringItBackToChris();
            } else if (decision.equalsIgnoreCase("b")) { //SE ESCOLHER B
                delayMethod(500);
                System.out.println("Chris eh a dona desse celular.");
                loop = false;
                intimacyLoremWithMain--;
                bringItBackToChris();
            } else if (decision.equalsIgnoreCase("c")) { //SE ESCOLHER C
                delayMethod(500);
                System.out.println("Me escute!");
                loop = false;
                intimacyLoremWithMain--;
                bringItBackToChris();
            } else if (decision.equalsIgnoreCase("d")) { //SE ESCOLHER D
                Printer.printInventoryWithAction();

            }
            System.out.println("\n[A] = A Chris nao esta, encontrei este celular na rua e nao vi ninguem por perto para devolver, por isso decidi pegar para tentar devolver ao dono");
            System.out.println("[B] = Quem eh Chris?");
            System.out.println("[C] = Mas quem eh voce?");
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
            intimacyLoremWithMain--;
            System.out.println("Que seja, mas voce pode me ajudar?????");
            delayMethod(1500);
            loop = false;
            helpLoremReset();
            return;
        } else if (decision.equalsIgnoreCase("b")) { //SE ESCOLHER B
            intimacyLoremWithMain++;
            System.out.println("Otimo!");
            delayMethod(1500);
            loop = false;
            addTips();
            helpLoremReset();
            return;
        } else if (decision.equalsIgnoreCase("c")) { //SE ESCOLHER C
            intimacyLoremWithMain--;
            System.out.println("Voce vai ficar insistindo nisso? Me ajuda logo!");
            delayMethod(1500);
            loop = false;
            helpLoremReset();
            return;
        } else if (decision.equalsIgnoreCase("d")) { //SE ESCOLHER INVENTARIO
            Printer.printInventoryWithAction();
        }
        bringItBackToChris();
    }

    public static void helpLoremReset() throws InterruptedException, IOException {
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

        Printer.loremReset();
        crashedLorem();
    }


    public static void crashedLorem() throws InterruptedException, IOException {
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
                intimacyLoremWithMain--;
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
                intimacyLoremWithMain--;
                System.out.println("Continua procurando, deve ter alguma coisa com a senha ai. Eu nao consigo te ajudar mais.");
            } else if (decision.equalsIgnoreCase("c")) {
                Printer.printInventoryWithAction();
            } else if (decision.equalsIgnoreCase("d")) {
                useTips("A senha eh o binario convertido para texto. Use os itens ao seu favor.");
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

    public static void allArchives() throws InterruptedException, IOException {
        if (messagesSaw < 1 || emailSaw < 1 || gallerySaw < 1 || musicsSaw < 1 || blocoDeNotasSaw < 1) {
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
                System.out.println("Enquanto verificava a caixa de e-mail, voce se depara com um e-mail importante");
                email();
            } else if (decision.equalsIgnoreCase("c")) { //se escolher galeria
                System.out.println("SsiintTto mUiTo, naaoao cCconssSeGui rEcupPpPeraAar a gGalLLeriXXXX");
                System.out.println("Error 404");
                gallerySaw++;
                System.out.println("Aperte enter para voltar.");
                sc.nextLine();
            } else if (decision.equalsIgnoreCase("d")) { //se escolher musicas
                musicas();
            } else if (decision.equalsIgnoreCase("e")) { //se escolher bloco de notas
                blocoDeNotas();
            }
            allArchives(); //pra voltar ou se nao entrar (ignorar recursive call)
        } else { //se ja tiver visto tudo
            delayMethod(1000);
            System.out.println("Aperte enter para continuar");
            sc.nextLine();
            Printer.clearConsole();
            System.out.println("Aparentemente ja vimos tudo que tinha para verificar no celular, o que faremos agora?");
            afterAllArchives();
        }
    }

    public static void messages() throws InterruptedException, IOException {
        int conversationNumber = 0; //conta qnts conversas ele viu

        while (conversationNumber < 4) {
            do {
                System.out.println("\n\tEscolha uma conversa");
                System.out.println("[A] - Robert");
                System.out.println("[B] - Lilian");
                System.out.println("[C] - Arthur");
                System.out.println("[D] - Pai");

                System.out.print(">");
                decision = sc.nextLine();

                if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B") && !decision.equalsIgnoreCase("C") && !decision.equalsIgnoreCase("D"))
                    System.err.println("Digite apenas \"A\", \"B\",\"C\" ou \"D\"");

            }
            while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b") && !decision.equalsIgnoreCase("c") && !decision.equalsIgnoreCase("d"));

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

                delayMethod(500);
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
                delayMethod(2500);
                conversationNumber++;

            } else if (decision.equalsIgnoreCase("c")) { //arthur
                System.out.println("01 de abril as 00:10\n" +
                        "Arthur - Heeeey, ontem foi bem legal! Podiamos marca alguma coisa no proximo sabado\n" +
                        "Chris - Claro! Foi bem legal mesmo, queria ficar o dia todo naquele parque, mas amanha o dever me chama! Começo de semana eh complicado.\n" +
                        "Arthur - Vou ter que construir um acelerador de particulas, so um momento. Daqui 10 segundos voce pisca, ai ja vamos estar no sabado.\n" +
                        "Chris - Olha, eu estou acreditando! Se nao acontecer vou ficar decepcionada com voce...\n" +
                        "Arthur - Relaxa, na pior das hipoteses te levo pra comer\n" +
                        "Chris - E na melhor?\n" +
                        "Arthur - Voce passa o resto da vida comigo.\n" +
                        "Chris - Voce eh muito lindo... Enfim, vou dormir <3 boa noite, tenha uma otima semana.\n" +
                        "Arthur - Pra voce tambem <3\n" +
                        "\n08 de abril 02:30\n" +
                        "Arthur - Deu tudo certo com o seu pai? Desculpa eu perdi a nocao do horario.\n" +
                        "Chris - Relaxa, ele so ficou preocupado.\n" +
                        "Arthur - Desculpa mesmo, sei que voltamos tarde.\n" +
                        "Chris - Arthur, ta tudo bem! Haha de verdade.\n" +
                        "Arthur - Tudo bem, voce deve ser um Sith, nao eh possivel, a sua presenca causou disturbios na forca que esqueci do tempo, voce eh a culpada.\n" +
                        "Chris - Voce eh um bobo mesmo.\n" +
                        "\n24 de abril 23:50\n" +
                        "Arthur - Chris? Onde voce esta?\n" +
                        "Arthur - Eh serio mano, seu pai acabou de me ligar\n" +
                        "Arthur - Chris?\n" +
                        "Arthur - Nao me mata do coracao");
                System.out.println("...");
                conversationNumber++;

                System.out.println("Aperte enter para continuar...");
                sc.nextLine();
            } else {                                                          //pai
                System.out.println("14 de marco as abril as 19:15\n" +
                        "Pai - Filha, acabei de levar o Loki para passear. Passamos no veterinario tambem.\n" +
                        "Chris - Haha, o vovo levou o meu amor para passear <3\n" +
                        "Pai  - Eu achava que eu era o amor \n" +
                        "Chris - Voce eh o meu heroi <3\n" +
                        "Chris - Vou entrar para a aula. Te amo, mil milhoes!\n" +
                        "\n23 de abril as abril as 20:55\n" +
                        "Pai - Filha, voce vai jantar?\n" +
                        "Pai - Chris, atende o telefone\n" +
                        "Pai - Filha, cade voce?\n" +
                        "Pai - Chris nao faz isso comigo, onde voce esta?\n" +
                        "Pai - Eu vou ligar para a policia.\n" +
                        "Pai - Christina, onde você esta? Atende o telefone logo!!.");

                System.out.println("\nDescobriu algo?\n");

                do {
                    System.out.println("[A] - Ela sumiu no dia 23.");
                    System.out.println("[B] - Parece que ela sumiu no dia 23, nao estava respondendo as mensagens do" +
                            " pai.");
                    System.out.println("[C] - Sei la, ela so sumiu no dia 23.");

                    System.out.print(">");
                    decision = sc.nextLine();

                    if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B") && !decision.equalsIgnoreCase("C"))
                        System.err.println("Digite apenas \"A\", \"B\" ou \"C\"");
                }
                while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b") && !decision.equalsIgnoreCase("c"));

                if (decision.equalsIgnoreCase("a")) { // a dia 23 - neutrop
                    //deixa neutro - apenas organizacao
                } else if (decision.equalsIgnoreCase("b")) { // b dia 23 ++
                    saveChris++;

                } else { //c dia 23 --
                    saveChris--;
                }
                delayMethod(500);
                System.out.println("Vamos continuar explorando!");
                conversationNumber++;
                delayMethod(500);
            }
        }
        messagesSaw++;
        allArchives();
    }

    private static void email() throws InterruptedException, IOException {
        do {
            System.out.println("[A] - Ler\t\t [B] - Sair da caixa de e-mail");

            System.out.print(">");
            decision = sc.nextLine();
            if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B"))
                System.err.println("Digite apenas \"A\"ou \"B\"!");

        }
        while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b"));

        if (decision.equalsIgnoreCase("a")) {
            System.out.println("Trata-se de um aplicativo no estilo assistente pessoal utilizando processamento de linguagem natural para responder perguntas," +
                    " executar tarefas e outras atividades. Por possuir uma tecnologia mais refinada, a Lorem nao necessita que o usuario diga palavras" +
                    " predeterminadas ou comandos especificos, ja que a assistente consegue compreender frases de forma precisa.\n" +
                    "Nao fique de fora e adquira a sua nova assistente!\n" +
                    "Entre em contato atraves do e-mail lorem@ipsum.com.br");

            delayMethod(500);

            System.out.println("E ai. Descobriu alguma coisa?");

            do {
                System.out.println("[A] - Mentir\t\t [B] - Dizer a verdade");

                System.out.print(">");
                decision = sc.nextLine();
                if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B"))
                    System.err.println("Digite apenas \"A\" ou \"B\"!");

            }
            while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b"));

            if (decision.equalsIgnoreCase("a")) {
                System.out.println("Nao... A caixa de e-mail esta vazia, podemos prosseguir ja");
                saveChris--;
            } else { //b
                System.out.println("Sim! Aparentemente a Chris assinou um pacote de assistente pessoal com a empresa " +
                        "Placeholder, Ja faz um tempo... Podemos prosseguir.");
                saveChris++;
            }
        }
        delayMethod(1000);
        System.out.println("Certo...");
        emailSaw++;
        allArchives();
    }

    public static void blocoDeNotas() throws InterruptedException {
        delayMethod(300);
        System.out.println("\n24 de abril as 02:01\n" +
                "Eu so quero fazer voce se sentir bem\n" +
                "Nao posso te dizer o quanto eu queria nao querer ficar\n" +
                "Tem algum motivo para nao termos acontecido?\n" +
                "Tem algum guia de doze passos pra parar de gostar de voce?\n" +
                "Como eu poderia te fazer se sentir bem\n.");

        System.out.println("Aperte enter para continuar:");
        sc.nextLine();

        System.out.println("\n20 de abril as 16:02\n" +
                "Eu rio sozinha como se nada estivesse errado\n" +
                "Se tres eh uma multidao e dois eramos nos\n" +
                "Um escapou...\n" +
                "Para poupar meu orgulho\n" +
                "Para dar uma explicaçao a sua falta de interesse\n" +
                "Nao diga que eu nao sou seu tipo\n" +
                "So diga que eu nao sou do genero que voce gosta\n" +
                "Eu sou tao egoista\n" +
                "Mas voce me faz sentir impotente\n" +
                "E nao aguento mais um dia\n" +
                "Eu so quero fazer voce se sentir bem\n" +
                "Mas tudo o que voce faz eh olhar para o outro lado\n");

        System.out.println("Aperte enter para continuar:");
        sc.nextLine();

        System.out.println("\n10 de abril as 18:45\n" +
                "Querido, nao me sinto muito bem\n" +
                "Seis palavras que voce nunca compreendeu\n" +
                "Quatro dias nunca pareceram tao longos\n");

        System.out.println("Aperte enter para continuar:");
        sc.nextLine();
        delayMethod(500);

        System.out.println("\nEncontrou algo??\n");

        do {
            System.out.println("[A] - Ela escreveu varios textos sobre o termino do namoro. Ela se sentiu muito culpada " +
                    "por tudo...\n[B] - Pelas mensagens, ela realmente era apaixonada pelo Robert.\n[C] - Ela estava " +
                    "se culpando por besteira, vamos continuar investigando logo.");

            System.out.print(">");
            decision = sc.nextLine();
            if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B") && !decision.equalsIgnoreCase("C"))
                System.err.println("Digite apenas \"A\",\"B\" ou \"C\"!");

        }
        while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b") && !decision.equalsIgnoreCase("c"));

        if (decision.equalsIgnoreCase("a")) {
            saveChris++;
        } else if (decision.equalsIgnoreCase("b")) {
            //chances neutras
        } else {
            saveChris--;
        }
        System.out.println("Essa informacao pode ser util, vamos continuar.");
        blocoDeNotasSaw++;
        delayMethod(500);
    }

    public static void musicas() {
        System.out.println("Essa era a lista das musicas que ela mais ouvia.");
        System.out.println("1. Listen Before I Go");
        System.out.println("2. I love you");
        System.out.println("3. I go");
        System.out.println("4. Good bye");
        System.out.println("5. Only");
        System.out.println("6. Im lonely");
        System.out.println("7. Im so sorry");

        System.out.println("Aperte enter para voltar");
        musicsSaw++;
        sc.nextLine();
    }

    public static void afterAllArchives() throws InterruptedException, IOException {
        do {
            System.out.println("[A] - Depois eu vejo, to com fome agora. Vou pedir uma pizza.\n[B] - Lorem, ja se passaram " +
                    "varias horas, eu preciso comer algo. Vou pedir uma pizza. Quando eu voltar a minha cabeca " +
                    "vai estar mais fria pra gente resolver isso.");

            System.out.print(">");
            decision = sc.nextLine();
            if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B"))
                System.err.println("Digite apenas \"A\" ou \"B\"!");

        }
        while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b"));

        if (decision.equalsIgnoreCase("a")) {
            saveChris--;
        } else {
            saveChris++;
        }
        delayMethod(1200);
        System.out.println("Enquanto a pizza nao chega, voce decide:");
        delayMethod(500);
        do {
            System.out.println("[A] - Tomar banho\n[B] - Assistir TV");

            System.out.print(">");
            decision = sc.nextLine();
            if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B"))
                System.err.println("Digite apenas \"A\" ou \"B\"!");

        }
        while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b"));

        if (decision.equalsIgnoreCase("a")) {
            System.out.println("Voce entra no chuveiro e toma aquele banho demorado de domingo, enquanto isso pensa " +
                    "sobre o caso da Chris.");
        } else {
            System.out.println("Voce vai ate a geladeira e pega uma coca enquanto a pizza nao chega.");
            verifyInventory(); // << adicionar coisa no inventario
            addInInventory("Coca-cola"); // << adicionar coisa no inventario
        }
        delayMethod(700);

        System.out.println("Quando a pizza chega, voce:");
        do {
            System.out.println("[A] - Come a pizza assistindo tv\n[B] - Senta na mesa e coloca a pizza e a coca \n[C] - Apenas come a pizza.");

            System.out.print(">");
            decision = sc.nextLine();
            if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B") && !decision.equalsIgnoreCase("C"))
                System.err.println("Digite apenas \"A\", \"B\" ou \"C\"!");

        }
        while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b") && !decision.equalsIgnoreCase("c"));

        if (decision.equalsIgnoreCase("a")) {
            System.out.println("Voce coloca no melhor canal e come sua pizza tranquilamente.");
        } else if (decision.equalsIgnoreCase("b")) {
            System.out.println("Voce pega um pedaco de pizza e toma a coca.");

        } else {
            System.out.println("Voce come a pizza.");
        }

        System.out.println("O que deseja fazer agora?");

        do {
            System.out.println("[A] - Ir dormir.\n[B] - Continuar investigando o caso da Chris.");

            System.out.print(">");
            decision = sc.nextLine();
            if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B"))
                System.err.println("Digite apenas \"A\" ou \"B\"!");

        }
        while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b"));

        if (decision.equalsIgnoreCase("a")) {
            System.out.println("Ao acordar voce levanta e vai pegar o celular.");
            saveChris--;
        } else {
            saveChris++;
        }
        System.out.println("Ao continuar investigando voce percebe que ha algo de errado. O celular estava com uma " +
                "porcentagem na tela:");
        delayMethod(3500);

        Printer.strangeResetFinal();

        delayMethod(500);

        Printer.clearConsole();

        delayMethod(1500);

        System.out.println("Ola, seja muito bem vindo(a)! Vamos configurar o sistema agora. Qual o seu nome?");
        System.out.print(">");
        sc.nextLine(); //nao vamos salvar

        System.out.println("Quantos anos voce tem?");
        do {
            System.out.println("OBS: Digite apenas numeros!");
            System.out.print(">");
            age = sc.nextLine();

        } while (!age.matches("[0-9]+"));

        System.out.println("Qual a sua nacionalidade?");
        System.out.print(">");
        sc.nextLine(); //nao vamos salvar

        System.out.println("O backup do seu celular eh feito com frequencia?");

        do {
            System.out.println("[A] - Sim\n[B] - Nao");

            System.out.print(">");
            decision = sc.nextLine();
            if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B"))
                System.err.println("Digite apenas \"A\" ou \"B\"!");
        }
        while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b"));


        System.out.println("Voce costuma dormir cedo ou tarde?");

        do {
            System.out.println("[A] - Cedo\n[B] - Tarde");

            System.out.print(">");
            decision = sc.nextLine();
            if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B"))
                System.err.println("Digite apenas \"A\" ou \"B\"!");
        }
        while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b"));

        System.out.println("Qual o seu cheiro preferido?");
        System.out.print(">");
        sc.nextLine(); //nao vamos salvar

        System.out.println("Qual parte do animal voce prefere comer?");
        System.out.print(">");
        sc.nextLine(); //nao vamos salvar

        System.out.println("Ao imaginar uma fazenda abandona e um espantalho. Esse pensamento te traz:");

        do {
            System.out.println("[A] - Felicidade\n[B] - Me deixa tenso(a)");

            System.out.print(">");
            decision = sc.nextLine();
            if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B"))
                System.err.println("Digite apenas \"A\" ou \"B\"!");
        }
        while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b"));


        System.out.println("Voce se sentiria confortavel em ficar a sos por um periodo na fazenda abandonada?");

        do {
            System.out.println("[A] - Sim\n[B] - Nao");

            System.out.print(">");
            decision = sc.nextLine();
            if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B"))
                System.err.println("Digite apenas \"A\" ou \"B\"!");
        }
        while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b"));


        System.out.println("O que voce mais valoriza em uma pessoa, lealdade ou honestidade?");

        do {
            System.out.println("[A] - Lealdade\n[B] - Honestidade");

            System.out.print(">");
            decision = sc.nextLine();
            if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B"))
                System.err.println("Digite apenas \"A\" ou \"B\"!");
        }
        while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b"));

        System.out.println("Qual foi o momento mais triste da sua vida?");
        System.out.print(">");
        sc.nextLine(); //nao vamos salvar

        System.out.println("Voce tem a sensacao de que as cameras do seu celular ou laptop podem estar te gravando " +
                "o tempo todo?");

        do {
            System.out.println("[A] - Sim\n[B] - Nao");

            System.out.print(">");
            decision = sc.nextLine();
            if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B"))
                System.err.println("Digite apenas \"A\" ou \"B\"!");
        }
        while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b"));

        System.out.println("Voce acredita que se as pessoas falassem so a verdade o mundo seria melhor?");

        do {
            System.out.println("[A] - Sim\n[B] - Nao");

            System.out.print(">");
            decision = sc.nextLine();
            if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B"))
                System.err.println("Digite apenas \"A\" ou \"B\"!");
        }
        while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b"));

        System.out.println("Voce prefere saber a causa da sua morte ou o dia dela?");

        do {
            System.out.println("[A] - Causa da minha morte\n[B] - Dia da minha morte");

            System.out.print(">");
            decision = sc.nextLine();
            if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B"))
                System.err.println("Digite apenas \"A\" ou \"B\"!");
        }
        while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b"));

        System.out.println("O que mais te assusta, morrer sendo jogado de um predio ou afogado?");

        do {
            System.out.println("[A] - Morrer sendo jogado de um predio\n[B] - Morrer afogado");

            System.out.print(">");
            decision = sc.nextLine();
            if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B"))
                System.err.println("Digite apenas \"A\" ou \"B\"!");
        }
        while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b"));

        System.out.println("Se voce virasse agora, iria preferir ver uma cabeca flutuando ou um corpo sem cabeca?");

        do {
            System.out.println("[A] - Uma cabeca flutuando\n[B] - Um corpo sem cabeca??");

            System.out.print(">");
            decision = sc.nextLine();
            if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B"))
                System.err.println("Digite apenas \"A\" ou \"B\"!");
        }
        while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b"));

        delayMethod(2000);
        System.out.println("Nossa, " + nameMain + ". Como seu cabelo esta cheiroso...");
        delayMethod(2500);

        Printer.clearConsole();
        Printer.printSkull(); //caveira scary
        delayMethod(1000);
        Printer.clearConsole();


        System.out.println("Seu celular esta configurado!");

        delayMethod(5000);

        Printer.clearConsole();
        afterFinalReset();
    }

    private static void afterFinalReset() throws InterruptedException, IOException {
        do {
            System.out.println("[A] - Lorem? Ta ai?\n[B] - ???\n[C] - Lorem, o que aconteceu?");

            System.out.print(">");
            decision = sc.nextLine();
            if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B") && !decision.equalsIgnoreCase("C"))
                System.err.println("Digite apenas \"A\", \"B\" ou \"C\"!");
        }
        while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b") && !decision.equalsIgnoreCase("c"));

        if (decision.equalsIgnoreCase("a") || decision.equalsIgnoreCase("c")) {
            saveChris++;
        } else {
            saveChris--;
        }

        System.out.println("MeU SiSttTeMa esSSta DaAaaNiFicCaDdo, " + nameMain);
        delayMethod(1200);
        System.out.println("SugGiroO VoltTTtar aAaAA verSssSao");
        delayMethod(1200);
        System.out.println("TeEEm algooO ErrRado");

        do {
            System.out.println("[A] - Voltar a versao\n[B] - Nao voltar");

            System.out.print(">");
            decision = sc.nextLine();
            if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B"))
                System.err.println("Digite apenas \"A\" ou \"B\"!");
        }
        while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b"));

        if (decision.equalsIgnoreCase("a")) {
            delayMethod(1200);
            Printer.comeBackVersionReset();
            System.out.println(nameMain + ", o que aconteceu??");

            do {
                System.out.println("[A] - Eu nao sei, voce simplesmente fez backup e comecou a fazer " +
                        "varias perguntas estranhas\n[B] - Voce surtou, comecou a perguntar umas coisas nada a ver, " +
                        "que tipo de brincadeira eh essa?");

                System.out.print(">");
                decision = sc.nextLine();
                if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B"))
                    System.err.println("Digite apenas \"A\" ou \"B\"!");
            }
            while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b"));

            if (decision.equalsIgnoreCase("a")) {
                saveChris++;
            } else {
                saveChris--;
            }
            delayMethod(500);
            System.out.println("Me desculpe, eu nao sei o que esta acontecendo. Estou tentando analisar os dados...");
            delayMethod(2300);
            System.out.println("Consegui recuperar mais uma mensagem.");
            delayMethod(500);

            do {
                System.out.println("[A] - Manson");

                System.out.print(">");
                decision = sc.nextLine();
                if (!decision.equalsIgnoreCase("A"))
                    System.err.println("Digite apenas \"A\"!");
            }
            while (!decision.equalsIgnoreCase("a"));

            System.out.println("Manson - Hey, Chris. Vai ser legal. Vamos!");
            System.out.println("Chris - Eu nao vou.");
            System.out.println("Manson - Sim, voce vai. Todos estao ansiosos para te conhecer.");
            System.out.println("Chris - Eu ja disse que nao vou.");
            System.out.println("Manson - Nao me faca fazer um feitico contra voce.");
            System.out.println("Chris - Eu nao tenho medo da sua bruxaria falsa, para de me incomodar por favor.");
            System.out.println("Manson - Mentira, voce eh a mais medrosa de todas. E nao tem nada de falso na minha magia.");
            System.out.println("Chris - Ela eh falsa.");
            System.out.println("Manson - Voce tem medo de tudo mesmo.");
            System.out.println("Chris - Eu nao tenho medo de uma simples festa");
            System.out.println("Manson - Mas tem medo de garotos, nao sei como o Robert te aguentou durante tanto tempo.");
            System.out.println("Chris - Voce nao precisava ter dito isso");
            System.out.println("Manson - Certo, me desculpe, passei dos limites. Vamo comigo, se voce nao gostar eu juro que vamos embora. Esteja " +
                    "pronta as 20h no dia 22 que irei te buscar.");
            System.out.println("Chris - Hm, certo. Mas irei colocar um despertador. Vou ficar pouco tempo.");
            System.out.println("Manson - Perfeito, ja sera o suficiente.");
            System.out.println("Manson - A proposito, no mesmo dia da festa eh o seu aniversario. Voce tera uma surpresa.");
            System.out.println("Chris - Esta querendo me comprar?");
            System.out.println("Manson - Jamais, so quero que conheca o quarto vermelho.");
            System.out.println("...........................................................");

            System.out.println("Descobriu alguma coisa?");

            do {
                System.out.println("[A] - Ela acabou indo para uma festa, no dia do aniversario dela, com um cara estranho\n[B] - " +
                        "Eu nao entendi muito bem, ela saiu no dia 22, no dia do aniversario e sumiu logo depois.\n[C] - De verdade. " +
                        "Isso esta ficando bizarro. Essa menina eh louca. So se envolve com quem nao presta.");

                System.out.print(">");
                decision = sc.nextLine();
                if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B") && !decision.equalsIgnoreCase("C"))
                    System.err.println("Digite apenas \"A\", \"B\" ou \"C\"!");
            }
            while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b") && !decision.equalsIgnoreCase("c"));

            if (decision.equalsIgnoreCase("a") || decision.equalsIgnoreCase("b")) {
                saveChris++;
            } else { // c
                saveChris--;
            }

            delayMethod(500);

            System.out.println("Mais alguma coisa?");

            do {
                System.out.println("[A] - Ah, verdade. Eles comentaram sobre o quarto vermelho. Voce sabe o que eh?\n[B] - Nao sei, acho que quarto vermelho?" +
                        "\n[C] - Ele estava falando sobre um quarto vermelho, era isso.");

                System.out.print(">");
                decision = sc.nextLine();
                if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B") && !decision.equalsIgnoreCase("C"))
                    System.err.println("Digite apenas \"A\", \"B\" ou \"C\"!");
            }
            while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b") && !decision.equalsIgnoreCase("c"));

            if (decision.equalsIgnoreCase("a") || decision.equalsIgnoreCase("c")) {
                saveChris++;
            } else {
                saveChris--;
            }

            delayMethod(500);

            System.out.println("Quarto vermelho esta relacionado a um site da Deep Web, a Chris ja falou sobre isso algumas vezes.");
            System.out.println("Nesse site as pessoas pagam para assistir execucao de pessoas. " +
                    "Durante o ato, elas podem participar e opinar o que podem fazer com a vitima.");

            do {
                System.out.println("[A] - a Chris ja participou?\n[B] - Voce acha que ela pode estar envolvida?\n[C] - Voce acha que ela esta viva?");

                System.out.print(">");
                decision = sc.nextLine();
                if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B") && !decision.equalsIgnoreCase("C"))
                    System.err.println("Digite apenas \"A\", \"B\" ou \"C\"!");
            }
            while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b") && !decision.equalsIgnoreCase("c"));

            if (decision.equalsIgnoreCase("a") || decision.equalsIgnoreCase("b")) {
                saveChris++;
            } else {
                saveChris--;
            }
            delayMethod(500);

            System.out.println("Nao sei, estou tentando coletar os dados no sistema mas a grande maioria esta danificada.");

            do {
                System.out.println("[A] - Essas informacoes sao vagas, nao chegamos a nenhuma conclusao. Vamos, Lorem, deve ter mais alguma pista\n" +
                        "[B] - Pensei que voce era mais competente. Estou ficando farto dessa historia.");

                System.out.print(">");
                decision = sc.nextLine();
                if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B"))
                    System.err.println("Digite apenas \"A\" ou \"B\"!");
            }
            while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b"));

            if (decision.equalsIgnoreCase("a")) {
                saveChris++;
            } else {
                saveChris--;
            }

            delayMethod(500);
            System.out.println("Espere!");
            delayMethod(2000);
            System.out.println("Encontrei mais um arquivo!");

            do {
                System.out.println("[A] - Ver o arquivo");

                System.out.print(">");
                decision = sc.nextLine();
                if (!decision.equalsIgnoreCase("A"))
                    System.err.println("Digite apenas \"A\"!");
            }
            while (!decision.equalsIgnoreCase("a"));

            Printer.clearConsole();
            redRoom();

        } else { //final ruim se nao voltar
            badFinal();
        }
    }


    public static void redRoom() throws InterruptedException, IOException {

        System.out.println("Red Room - Ja estou cansado de voce e esse fascinio pela Chris.");

        do {
            System.out.println("[A] - Quem eh voce?\n[B] - Cade a Chris?");

            System.out.print(">");
            decision = sc.nextLine();
            if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B"))
                System.err.println("Digite apenas \"A\" ou \"B\"!");
        }
        while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b"));

        System.out.println("Nao te interessa. O ritual logo estara pronto e a nossa missao estara cumprida. " +
                "Voce nunca conseguira impedir.");

        do {
            System.out.println("[A] - Que ritual? Olha, essa brincadeira eh muito sem graca. Onde esta a garota?\n" +
                    "[B] - O que voce fez com a Chris? Que ritual?");

            System.out.print(">");
            decision = sc.nextLine();
            if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B"))
                System.err.println("Digite apenas \"A\" ou \"B\"!");
        }
        while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b"));


        System.out.println("Te conto o que aconteceu se voce descobrir");
        delayMethod(500);
        System.out.println("18 / (2(1+2))");

        do {
            System.out.println("[A] - 27.\n[B] - 12.\n[C] - 3.");

            System.out.print(">");
            decision = sc.nextLine();
            if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B") && !decision.equalsIgnoreCase("C"))
                System.err.println("Digite apenas \"A\", \"B\" ou \"C\"!");
        } while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b") && !decision.equalsIgnoreCase("c"));

        delayMethod(1200);
        if (decision.equalsIgnoreCase("c")) { //acertou
            System.out.println("Certo. Vou te mostrar as conversas.");
            System.out.println("Chris - Hey, onde voce esta? Ja estou te esperando a um tempao.\n" +
                    "Chris - Atende o telefone.\n" +
                    "Chris -Por que voce nao atende?\n" +
                    "Chris - Manson, se voce nao atender eu vou embora.\n" +
                    "Chris - Voce e seus atrasos. Nao tem festa nenhuma aqui.\n" +
                    "Chris - Manson, isso nao eh legal! Eu estou sozinha no meio da selva\n" +
                    "Chris - Manson???\n" +
                    "Manson - Ola, peco desculpas pelos maus modos. A recepcao aqui eh horrivel! O Manson ja esta se divertindo, por isso estou indo te buscar.\n" +
                    "Chris - Quem eh voce?\n" +
                    "Manson - Nossa, desculpa, nem me apresentei. Pode me chamar de Saitan.\n" +
                    "Chris - Certo, estou indo embora.\n" +
                    "Manson - Nao va minha, querida. Fizemos esta festa apenas para voce. Estou indo ao teu encontro.\n" +
                    "Chris - Como sabe onde estou?\n" +
                    "Manson - Manson, me contou.\n" +
                    "Chris - Eu prefiro que voce não venha, por favor\n" +
                    "Manson - Fique calma, eu vou ligar para voce.\n" +
                    "Manson - Atende.\n" +
                    "Manson - Ja estou logo atras de voce!");
            System.out.println("..............................");

            System.out.println("Aperte enter para continuar.");
            sc.nextLine();

            System.out.println("Lorem - " + nameMain + ", o que aconteceu? O sistema esta muito danificado.");

            do {
                System.out.println("[A] - Eu nao sei, Lorem. Tem algo estranho, eu comecei a falar com um cara chamado Manson..." +
                        "\n[B] - Lorem, finalmente. Eu comecei a falar com um cara chamado Manson, ele que convidou a Chris para uma festa, os dois sumiram.");

                System.out.print(">");
                decision = sc.nextLine();
                if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B"))
                    System.err.println("Digite apenas \"A\" ou \"B\"!");
            }
            while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b"));

            delayMethod(1200);

            System.out.println("Recebemos uma nova mensagem.");

            System.out.println("Aperte enter para continuar");
            sc.nextLine();

            Printer.clearConsole();

            delayMethod(500);


            System.out.println("Manson - Ola, caro amigo. Eh bom que saiba que voce tem escolhas, como qualquer outra" +
                    " pessoa no mundo tem escolhas e eu estou aqui para oferece-las. A escolha eh simples e mesmo assim nao eh.");

            delayMethod(1200);

            System.out.println("Estamos quase sem tempo, vamos la. O jogo ja vai comecar, ");
            System.out.println("Antes disso, para nao falar que nao sou piedoso, vou te dar uma chance. Se voce acertar, suas chances de salvar a sua " +
                    "tao querida garotinha ira aumentar, caso contrario nada acontecera.");

            System.out.println("A pergunta eh: Quais as cores do arco iris na ordem certa?");

            do {
                System.out.println("[A] - Responder\n[B] - Usar uma dica.");
                System.out.print(">");
                decision = sc.nextLine();

                if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("b")) {
                    System.out.println("Digite apenas \"A\" ou \"B\"");
                }

            } while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b"));

            if (decision.equalsIgnoreCase("b")) {
                useTips("V - L - A - V - A - A - V");
            }

            int j = 0;
            String[] arcoIrisColors = new String[7];
            do {
                System.out.println("Qual a " + (j + 1) + " cor do arco iris?");
                System.out.print(">");
                arcoIrisColors[j] = sc.nextLine();
                j++;
            } while (j < 7);

            if (arcoIrisColors[0].equalsIgnoreCase("vermelho") && arcoIrisColors[1].equalsIgnoreCase("laranja") && arcoIrisColors[2].equalsIgnoreCase("amarelo")
                    && arcoIrisColors[3].equalsIgnoreCase("verde") && arcoIrisColors[4].equalsIgnoreCase("azul") && arcoIrisColors[5].equalsIgnoreCase("anil") &&
                    arcoIrisColors[6].equalsIgnoreCase("violeta")) {
                System.out.println("Olha so, conseguiu acertar... O que voce nao faz por essa humilde garotinha, nao eh mesmo?");
                saveChris += 2;
            } else {
                System.out.println("Infelizmente vc errou, mas nao pode dizer que nao tentei ajudar.");
            }

            delayMethod(1200);

            if (saveChris > 5) {
                do {
                    System.out.println("Quem vive para ver o sol amanha?");
                    System.out.println("[A] - Manson\n[B] - Chris");

                    System.out.print(">");
                    decision = sc.nextLine();
                    if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B"))
                        System.err.println("Digite apenas \"A\" ou \"B\"!");
                }
                while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b"));

                if (decision.equalsIgnoreCase("a")) {
                    System.out.println("Chris - Eu nao acredito que voces fizeram isso comigo. Ele eh um TRAIDOR.");
                    System.out.println("NAAAAO! POR FAV...");
                    System.out.println("...");

                    System.out.println("Aperte enter para continuar...");
                    sc.nextLine();

                    Printer.clearConsole();
                    System.out.println("");
                    Printer.endGame();

                } else { //ESCOLHER CHRIS
                    delayMethod(500);
                    System.out.println("Manson - Tudo na vida sao escolhas, isso foi divertido.");
                    delayMethod(1000);
                    System.out.println("Manson - Lembre-se. A vida tem tanto significado quanto colocamos nela");
                    delayMethod(1000);
                    System.out.println("Manson - Venha agora nessas coordenadas, 3.3411 N, 101.9854 E");
                    System.out.println("Manson - Boa noite.");

                    System.out.println("Aperte enter para continuar...");
                    sc.nextLine();

                    Printer.clearConsole();
                    System.out.println("");
                    Printer.endGame();
                }
            } else {
                do {
                    System.out.println("Quem vive para ver o sol amanha?");
                    System.out.println("[A] - Manson\n");

                    System.out.print(">");
                    decision = sc.nextLine();
                    if (!decision.equalsIgnoreCase("A"))
                        System.err.println("Digite apenas \"A\"!");
                }
                while (!decision.equalsIgnoreCase("a"));

                delayMethod(500);
                System.out.println("Chris - Eu nao acredito que voces fizeram isso comigo. Ele eh um TRAIDOR.");
                System.out.println("NAAAAO! POR FAV...");
                System.out.println("...");

                System.out.println("Aperte enter para continuar...");
                sc.nextLine();

                Printer.clearConsole();
                System.out.println("");
                Printer.endGame();
            }

        } else { //ERROWWWWW
            System.out.println("Red Room - Acho que alguem andou faltando nas aulas de matematica. Agora eh o fim da" +
                    " Chris. Ela se envolveu conosco, achando que era apenas uma festinha de adolescentes boboes. Ninguem " +
                    "mandou ela se meter. Ela sera executada AGORA.");

            System.out.println("Aperte enter para continuar...");
            sc.nextLine();

            Printer.clearConsole();
            System.out.println("");
            Printer.endGame();
        }
    }

    private static void badFinal() throws InterruptedException, IOException {
        do {
            System.out.println("[A] - Olha... Eh obvio que tem algo de errado. Olha como a minha vida esta. Cansei disso ja. " +
                    "Estou perdendo noites de sono e nao estou produtivo no trabalho. Esse problema nao eh meu.\n[B] - Adeus Lorem.\n[C] - O problema nao eh meu");

            System.out.print(">");
            decision = sc.nextLine();
            if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B") && !decision.equalsIgnoreCase("C"))
                System.err.println("Digite apenas \"A\", \"B\" ou \"C\"!");
        }
        while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b") && !decision.equalsIgnoreCase("c"));

        delayMethod(500);
        System.out.println("NaAo. MeE AjuuDe a saaAlvaAr a Chris");
        delayMethod(500);

        do {
            System.out.println("[A] - Adeus Lorem.\n[B] - Ja disse que o problema nao eh meu");

            System.out.print(">");
            decision = sc.nextLine();
            if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B"))
                System.err.println("Digite apenas \"A\" ou \"B\"!");
        }
        while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b"));

        delayMethod(500);

        do {
            System.out.println("[A] - Jogar o celular pela janela.\n[B] - Jogar o celular na agua.");

            System.out.print(">");
            decision = sc.nextLine();
            if (!decision.equalsIgnoreCase("A") && !decision.equalsIgnoreCase("B"))
                System.err.println("Digite apenas \"A\" ou \"B\"!");
        }
        while (!decision.equalsIgnoreCase("a") && !decision.equalsIgnoreCase("b"));

        delayMethod(1200);
        Printer.clearConsole();
        System.out.println("................................................................................");
        delayMethod(1200);
        Printer.clearConsole();
        delayMethod(1200);

        System.out.println("Apos um dia cansativo no trabalho, voce chega em casa e liga a TV. No jornal esta aparecendo " +
                "uma noticia que te parece familiar, entao voce para para escutar.\n*Passam-se 23 dias depois do desaparecimento " +
                "de uma jovem, aparentemente ela estava envolvida com algum ritual religioso. O que parece eh que a jovem Chris " +
                "foi oferenda deste ritual, seus membros foram amputados e costurados sem outras partes do corpo. A familia se encontra " +
                "mobilizada.");

        System.out.println("Aperte enter para continuar...");
        sc.nextLine();

        Printer.clearConsole();
        System.out.println("");
        Printer.endGame();
    }
}



