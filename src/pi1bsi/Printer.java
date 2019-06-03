package pi1bsi;

import java.io.IOException;

public class Printer {

    public static void menu() {
        System.out.println("*******************************************************");
        System.out.println("");
        System.out.println("888      .d88888b.  8888888b.  8888888888 888b     d888 ");
        System.out.println("888     d88P\" \"Y88b 888   Y88b 888        8888b   d8888 ");
        System.out.println("888     888     888 888    888 888        88888b.d88888 ");
        System.out.println("888     888     888 888   d88P 8888888    888Y88888P888 ");
        System.out.println("888     888     888 8888888P\"  888        888 Y888P 888 ");
        System.out.println("888     888     888 888 T88b   888        888  Y8P  888 ");
        System.out.println("888     Y88b. .d88P 888  T88b  888        888   \"   888 ");
        System.out.println("88888888 \"Y88888P\"  888   T88b 8888888888 888       888");
        System.out.println("");
        System.out.println("*******************************************************");
        System.out.println("\nversion 2.0\n\n\n");

        System.out.println("[A] - Novo jogo");
        System.out.println("[B] - Creditos");
        System.out.println("[C] - Sair");

        Game.loop = true;
        while (Game.loop) {
            do {
                System.out.print(">");
                Game.decision = Game.sc.nextLine();
                if (!Game.decision.equalsIgnoreCase("a") && !Game.decision.equalsIgnoreCase("b") && !Game.decision.equalsIgnoreCase("c")) { // ESSE IF SERVE APENAS PARA ESCREVER O QUE O USUARIO DEVE FAZER
                    System.err.println("Digite apenas \"A\", \"B\" ou \"C\"!");
                }
            } while (!Game.decision.equalsIgnoreCase("a") && !Game.decision.equalsIgnoreCase("b") && !Game.decision.equalsIgnoreCase("c")); //enquanto nao acertar as palavras ele vai continaur roadndo

            if (Game.decision.equalsIgnoreCase("a")) {
                Game.loop = false;
                return;
            } else if (Game.decision.equalsIgnoreCase("B")) {
                System.out.println("\nJogo desenvolvido por:\n");
                System.out.println("Gabryelle Silva Santos");
                System.out.println("Pedro Henrique Barricelli Martins");
                System.out.println("\nAperte enter para continuar...");
                Game.sc.nextLine();
                System.out.println("[A] - Novo jogo");
                System.out.println("[B] - Creditos");
                System.out.println("[C] - Sair");
            } else {
                System.out.println("Obrigado por jogar.");
                System.exit(1);
            }
        }
    }


    public static void printWatch() throws InterruptedException, IOException { //throws InterruptedExpection para usar o thread.sleep
        System.out.println("       .-.-.");
        System.out.println("      (__I__)    ");
        System.out.println("    .'_....._'.");

        System.out.println("   / / .12 . \\ \\");
        System.out.println("  | | '     ' | |");
        System.out.println("  | | 9     3 | |");
        System.out.println("   \\ \\ '.6.' / /");
        System.out.println("    '.`-...-'.'");
        System.out.println("     /'-- --'\\");
        System.out.println("    `\"\"\"\"\"\"\"\"\"`");

        Thread.sleep(3000); //espera 3s para rodar o codigo abaixo

        clearConsole();

        System.out.println("       .-.-.");
        System.out.println("    ( (__I__) )  ");
        System.out.println("    .'_....._'.");
        System.out.println("   / / .12 . \\ \\");
        System.out.println("  | | '     ' | |");
        System.out.println("  | | 9     3 | |          sexta-feira!");
        System.out.println("   \\ \\ '.6.' / /");
        System.out.println("    '.`-...-'.'");
        System.out.println("     /'-- --'\\");
        System.out.println("    `\"\"\"\"\"\"\"\"\"`");

        Thread.sleep(600); //espera 0,6s pra limpar rodar o comando abaixo

        clearConsole();

        System.out.println("       .-.-.");
        System.out.println("   (( (__I__) )) ");
        System.out.println("    .'_....._'.");
        System.out.println("   / / .12 . \\ \\");
        System.out.println("  | | '     ' | |");
        System.out.println("  | | 9     3 | |");
        System.out.println("   \\ \\ '.6.' / /");
        System.out.println("    '.`-...-'.'");
        System.out.println("     /'-- --'\\");
        System.out.println("    `\"\"\"\"\"\"\"\"\"`");

        Thread.sleep(600); //espera 0,6s pra limpar rodar o comando abaixo

        clearConsole();

        System.out.println("       .-.-.");
        System.out.println("  ((( (__I__) )))");
        System.out.println("    .'_....._'.");
        System.out.println("   / / .12 . \\ \\");
        System.out.println("  | | '     ' | |");
        System.out.println("  | | 9     3 | |          sexta-feira!");
        System.out.println("   \\ \\ '.6.' / /");
        System.out.println("    '.`-...-'.'");
        System.out.println("     /'-- --'\\");
        System.out.println("    `\"\"\"\"\"\"\"\"\"`");

        Thread.sleep(600); //espera 0,6s pra limpar rodar o comando abaixo

        clearConsole();


        System.out.println("       .-.-.");
        System.out.println("    ( (__I__) )  ");
        System.out.println("    .'_....._'.");
        System.out.println("   / / .12 . \\ \\");
        System.out.println("  | | '     ' | |");
        System.out.println("  | | 9     3 | |");
        System.out.println("   \\ \\ '.6.' / /");
        System.out.println("    '.`-...-'.'");
        System.out.println("     /'-- --'\\");
        System.out.println("    `\"\"\"\"\"\"\"\"\"`");

        Thread.sleep(600); //espera 0,6s pra limpar rodar o comando abaixo

        clearConsole();

        System.out.println("       .-.-.");
        System.out.println("   (( (__I__) )) ");
        System.out.println("    .'_....._'.");
        System.out.println("   / / .12 . \\ \\");
        System.out.println("  | | '     ' | |");
        System.out.println("  | | 9     3 | |          sexta-feira!");
        System.out.println("   \\ \\ '.6.' / /");
        System.out.println("    '.`-...-'.'");
        System.out.println("     /'-- --'\\");
        System.out.println("    `\"\"\"\"\"\"\"\"\"`");

        Thread.sleep(600); //espera 0,8s pra limpar rodar o comando abaixo

        clearConsole();

        System.out.println("       .-.-.");
        System.out.println("  ((( (__I__) )))");
        System.out.println("    .'_....._'.");
        System.out.println("   / / .12 . \\ \\");
        System.out.println("  | | '     ' | |");
        System.out.println("  | | 9     3 | |");
        System.out.println("   \\ \\ '.6.' / /");
        System.out.println("    '.`-...-'.'");
        System.out.println("     /'-- --'\\");
        System.out.println("    `\"\"\"\"\"\"\"\"\"`");

        Thread.sleep(600); //espera 0,6s pra limpar rodar o comando abaixo

        clearConsole();

        System.out.println("       .-.-.");
        System.out.println("    ( (__I__) )  ");
        System.out.println("    .'_....._'.");
        System.out.println("   / / .12 . \\ \\");
        System.out.println("  | | '     ' | |");
        System.out.println("  | | 9     3 | |          sexta-feira!");
        System.out.println("   \\ \\ '.6.' / /");
        System.out.println("    '.`-...-'.'");
        System.out.println("     /'-- --'\\");
        System.out.println("    `\"\"\"\"\"\"\"\"\"`");

        Thread.sleep(600); //espera 0,6s pra limpar rodar o comando abaixo

        clearConsole();

        System.out.println("       .-.-.");
        System.out.println("   (( (__I__) )) ");
        System.out.println("    .'_....._'.");
        System.out.println("   / / .12 . \\ \\");
        System.out.println("  | | '     ' | |");
        System.out.println("  | | 9     3 | |");
        System.out.println("   \\ \\ '.6.' / /");
        System.out.println("    '.`-...-'.'");
        System.out.println("     /'-- --'\\");
        System.out.println("    `\"\"\"\"\"\"\"\"\"`");

        Thread.sleep(600); //espera 0,6s pra limpar rodar o comando abaixo

        clearConsole();

        System.out.println("       .-.-.");
        System.out.println("  ((( (__I__) )))");
        System.out.println("    .'_....._'.");
        System.out.println("   / / .12 . \\ \\");
        System.out.println("  | | '     ' | |");
        System.out.println("  | | 9     3 | |          sexta-feira!");
        System.out.println("   \\ \\ '.6.' / /");
        System.out.println("    '.`-...-'.'");
        System.out.println("     /'-- --'\\");
        System.out.println("    `\"\"\"\"\"\"\"\"\"`");

        Thread.sleep(600); //espera 0,6s pra limpar rodar o comando abaixo
    }

    public static void clearConsole() throws InterruptedException, IOException { //metodo que limpa o console
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); //limpa o console
        else
            Runtime.getRuntime().exec("clear");
    }

    public static void printInventory() {
        System.out.println("----SEU INVENTARIO----");
        for (int i = 0; i < Game.inventory.length; i++) {

            System.out.println((i + 1) + ". " + Game.inventory[i]);
        }
        System.out.println("----------------------");
    }


    public static void printInventoryWithAction() {
        System.out.println("----SEU INVENTARIO----");
        for (int i = 0; i < Game.inventory.length; i++) {

            System.out.println((i + 1) + ". " + Game.inventory[i]);
        }
        System.out.println("----------------------");

        System.out.println("O que deseja fazer?\n[A] = Jogar algum item fora\t\t\t[B] = Usar algum item\t\t\t [C] = Voltar");

        do {
            System.out.print(">");
            Game.decision = Game.sc.nextLine();
            if (!Game.decision.equalsIgnoreCase("a") && !Game.decision.equalsIgnoreCase("b") && !Game.decision.equalsIgnoreCase("c")) {
                System.err.println("Digite apenas \"A\", \"B\" ou \"C\"!");
            }

        } while (!Game.decision.equalsIgnoreCase("a") && !Game.decision.equalsIgnoreCase("b") && !Game.decision.equalsIgnoreCase("c"));

        if (Game.decision.equalsIgnoreCase("a")) { //se quiser deletar
            Game.deleteItemInventory();

        } else if (Game.decision.equalsIgnoreCase("b")) { //se quiser usar
            if (!Game.canUseItem) {
                System.out.println("Voce nao pode utilizar nenhum item agora!\n");
            } else {
                Game.useItemInventory();
            }
        }
    }

    public static void loremReset() throws IOException, InterruptedException {
        clearConsole();

        for (int i = 0; i < Game.progressBar.length; i++) { //cria a barra de loading
            Game.progressBar[i] = "-";
            if (i == 0) {
                Game.progressBar[i] = "[";
            } else if (i == 99) {
                Game.progressBar[i] = "]";
            }
        }


        for (int i = 0; i < Game.progressBar.length; i++) { //PRINTA A BARRA EM SI (VAI REPETIR 100 VEZES)
            System.out.println("RESTAURANDO SISTEMA PARA VERSAO ANTERIOR\t\t\t\tCARREGANDO..." + (i) + "%");
            printProgressBar();
            if (i >= 1 && i <= 99)
                Game.progressBar[i] = "#";

            //PRA APARECER OS GLITCHS NA TELA

            int randomNumber = (int) (Math.random() * ((30 - 1) + 1)) + 1; //ENTRE 1 E 30//

            if (randomNumber == 1 || randomNumber == 2) {
                System.out.println("\n\n\n\t\t\t\tIM CRASHING");
                Thread.sleep(80);
            } else if (randomNumber == 3) {
                System.out.println("\n\n\t\t\t\t\t\t\tHELP ME");
                Thread.sleep(90);
            } else if (randomNumber == 5) {
                System.out.println("\n\n\n\t\tPLEASE");
                Thread.sleep(90);
            }
            Thread.sleep(60);
            clearConsole();
        }
        System.out.println("RESTAURACAO CONCLUIDA COM EXITO. REINICIANDO SISTEMA.");
        Thread.sleep(600);
        clearConsole();
        System.out.println("RESTAURACAO CONCLUIDA COM EXITO. REINICIANDO SISTEMA..");
        Thread.sleep(600);
        clearConsole();
        System.out.println("RESTAURACAO CONCLUIDA COM EXITO. REINICIANDO SISTEMA...");
        Thread.sleep(600);
        clearConsole();
        System.out.println("RESTAURACAO CONCLUIDA COM EXITO. REINICIANDO SISTEMA.");
        Thread.sleep(600);
        clearConsole();
        System.out.println("RESTAURACAO CONCLUIDA COM EXITO. REINICIANDO SISTEMA..");
        Thread.sleep(600);
        clearConsole();
        System.out.println("RESTAURACAO CONCLUIDA COM EXITO. REINICIANDO SISTEMA...");
        Thread.sleep(600);
        clearConsole();
        System.out.println("RESTAURACAO CONCLUIDA COM EXITO. REINICIANDO SISTEMA.");
        Thread.sleep(600);
        clearConsole();
        System.out.println("RESTAURACAO CONCLUIDA COM EXITO. REINICIANDO SISTEMA..");
        Thread.sleep(600);
        clearConsole();
        System.out.println("RESTAURACAO CONCLUIDA COM EXITO. REINICIANDO SISTEMA...");
        Thread.sleep(1200);
        clearConsole();
    }

    public static void printProgressBar() { //printa o vetor do processo
        for (int i = 0; i < Game.progressBar.length; i++) {
            System.out.print(Game.progressBar[i]);
        }
    }


    public static void crashedContent() throws IOException, InterruptedException {
        clearConsole();
        System.out.println("|-----------------------------------|");
        System.out.println("|VIVO           08:40PM         12% |");
        System.out.println("|                                   |");
        System.out.println("|                                   |");
        System.out.println("|   myPassword.txt                  |");
        System.out.println("|                                   |");
        System.out.println("|                                   |");
        System.out.println("|                                   |");
        System.out.println("|                                   |");
        System.out.println("| 01101100011011110110101101101001  |");
        System.out.println("|                                   |");
        System.out.println("|                                   |");
        System.out.println("|                                   |");
        System.out.println("|                                   |");
        System.out.println("|                                   |");
        System.out.println("|                                   |");
        System.out.println("|                                   |");
        System.out.println("|                                   |");
        System.out.println("|                                   |");
        System.out.println("|                                   |");
        System.out.println("|                                   |");
        System.out.println("|                                   |");
        System.out.println("|                                   |");
        System.out.println("|                                   |");
        System.out.println("|                                   |");
        System.out.println("|                                   |");
        System.out.println("|---------------- O ----------------|");
        System.out.println("|-----------------------------------|");
    }

    public static void filesRestoring() throws IOException, InterruptedException {
        clearConsole();
        System.out.println(".");
        Thread.sleep(600);
        clearConsole();
        System.out.println("..");
        Thread.sleep(600);
        clearConsole();
        System.out.println("...");
        Thread.sleep(600);
        clearConsole();
        System.out.println(".");
        Thread.sleep(600);
        clearConsole();
        System.out.println("..");
        Thread.sleep(600);
        clearConsole();
        System.out.println("...");
        Thread.sleep(600);
        clearConsole();
        System.out.println(".");
        Thread.sleep(600);
        clearConsole();
        System.out.println("..");
        Thread.sleep(600);
        clearConsole();
        System.out.println("...");
        Thread.sleep(600);
        clearConsole();
        System.out.println(".");
        Thread.sleep(600);
        clearConsole();
        System.out.println("..");
        Thread.sleep(600);
        clearConsole();
        System.out.println("...");
        Thread.sleep(600);
        clearConsole();
        System.out.println(".");
        Thread.sleep(1200);
        clearConsole();
    }


    public static void strangeResetFinal() throws IOException, InterruptedException {
        clearConsole();

        for (int i = 0; i < Game.progressBar.length; i++) { //cria a barra de loading
            Game.progressBar[i] = "-";
            if (i == 0) {
                Game.progressBar[i] = "[";
            } else if (i == 99) {
                Game.progressBar[i] = "]";
            } else if (i > 0 && i < 97) {
                Game.progressBar[i] = "#";
            }
        }


        for (int i = 96; i < Game.progressBar.length; i++) { //PRINTA A BARRA EM SI (VAI REPETIR 4 VEZES)
            System.out.println("INICIALIZANDO SISTEMA NA VERSAO DE FABRICA\t\t\t\tCARREGANDO..." + (i) + "%");
            printProgressBar();
            if (i >= 1 && i <= 99)
                Game.progressBar[i] = "#";
            Thread.sleep(2300);
            clearConsole();
        }
        System.out.println("REBOOTING...");
        Thread.sleep(2000);
    }

    public static void printSkull() {
        System.out.println("                                                                                                    \n" +
                "                         oMNMMNMmhhyhyhyyhyhshhyhyhhmMNMNNMNMNMMNMNMNMMmMNMNhh-    X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "                     ....sMNNNmNdyyssssshhssshhhhhhhNMNmymNmNmNNNMNMMMMNMNMNhh-`   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "                    -NNmNNMNyysyyyy-````-.````.::+osyhd+ ```-syyMMNMNMNMMNMNMNss-  X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "                    -MMNMNMNhhyhhhh-                 ``     `shhMMNMNMNMMNMMMNhh:          X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "                  /hdMMyyyyysyosso-:--.```                  `+shddyhhMNMMNMMMMNNdhhhhhh/   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "                  +MNMMyyyyyyy++/    ```                       ```.hyMNMMNMNMMNMNMNMMmMs       X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "                ++yMNdhosssoyyosyo/oohs+ys-                  -/+sodNNMNddNMNMMMMNMNMNdhs:/ss`  X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "                NMmMmhh//.``.-:-:-.``-`-MM:                    -:-....oysNMNMNMMNMNMm..--+MN`  X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "             `::MMmNdyyyh/` /Nms:-.----:dd-                    `+hh/ -dddNMmmmMMNMNMNhyyyyhy`  X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "             :MNMMhys+oo..`  /. .ssdNmNmNN:                     +o. .+ssyyys+oMMNMNMNMMNMh     X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "             :MMNMhhy+:h+/:     .sshdddddd:                      `ooooo+/: -ssMNNMNMNMMNMh     X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "           sdmMMyyooo. -..` yddddmmdmmmmmmddddh`                 `yyyyyyys  -syymMNMNMMNMh     X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "           yMNMMhyo+`       dMNMNMNNMNMNNMNMNMm`                   `-/://::.`ohhdMNMNMMNMh     X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "        `ssmMmhhyyy+     -soyhhhhhhyhhhhhhhhhhh.                :o:.`------smmmNhhdMMNMNMmss`  X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "        `MMmMmhhshy. `   +MNNMNMNMMmMNMNNMNMNMN:                ``..     -:sMNy::-+MMNMNMNMM-  X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "      /MMMMNMh+` .s -NNmNmNmNNmNmNmmNmNmNNmNmNmNN:       `:/. `yMNMMNMNMMMMNMdo`    .mNmNmNmmN/    X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "    oyhMNhhyhy:  .- .ddddddddddddddhddddddddddddd:       .mm/  sMMMMNMNMMMMNMNNd:    --sdddddd+..  X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "    mMNMNyyd     `  :mmmNmNmmNmNmssossssmNmmh            `+./yNNMMNNNMNyydMNMMNMho.  /   `mNmNmNm. X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "    mMNMNys+        ```yddddddhddddddhdhdd-          .   `yMNs:/ss/omMNMNNMNMNMMmmd: `   :ddddddh++`   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "    mMNMm++-           dNNNNNNmMNMNNNNNNNN-               yMN+ `.  .dMNMNMMNMNMNh:/o     oNNNNNNmhh`   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                " .ssNMNMd++//-.        :::::hhhhyssos+::::`              `dNN: +y  -oydhdddmMNddddd+     .//yhhhhsy-   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                " -MMNMNMmo:```-             dMNMmyysh+                    ---`          .ohdMN-::``.        hMNMNNM/   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                " :MMNMNMN-   :.`            shyso////-                                   :/ohy``            shhhhhh-   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                " -MMNMNMm-          .       dM/                                            sMm.`            mMNMNMM.   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                " -MMNMNMm:          `       hN:                                            oNd.`            mNNNmNN.   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                " :MMNMNMN:               /dy                .dy..yd+               `         -dd`          `hdhdddd    X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                " -MMNMNMN:          `    oNm`               `Nm..dNs                         :NN-          `mNNNNNN`   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                " :MMNMNMN:               .--              +oody``sdo::                       `::`           hdhdhdh`   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                " -MMNMNMm:                   `           `mMNMm``dMdhh`                                     mMNMNMM.   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                " :MMNMmmd:                `             --yhyso``shsso``                                    yhhhhhh`   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                " -MMNMhyy/                             .MMNMy..  hMNMM:.`                                   mMNMNMM.   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                " :MMNMdhh/                             `ssos/``  odhdd-.`                                   hdddddd`   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                " -MMNMhys:                                                                                  dNmNmNN.   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                " -MMNMNMm                                         `          ```                           `mNmNNNN`   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                " :MMNMNMN`                             .//yh/    ohyhhhh:    shyhyhh-    /+-`              `hdhdhdd-   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                " -MMNMNMm`                             :hymMy    yMNMMMM+    mMmMNMM:    yhss:`             mMNMNMM-   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                " :ddNMNMN+--:-.        .`    ..-:    +hdmmNMh    hMNMMMMo    dMNMMMM/   `dmmmmy.         `--yhhhhoo.   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                " .hhmMNMNyhy. `     `.       /ohs    oMNNMNMy    yMNMMNMo    hMNMMNM/   -dMNMNo+         :hhmMNMNyh:   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                " `/+mMNMNhdh/  -o/.  .     ++yhds    yMNNMNMy    hMNMMMM+   `dMNMMNM:   -mMNMNhdh+      -ydhmMNMNss:   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "    mMNMMMMh/  `.`         /MMNMd    yMNMMMMo    dMNMNMM/    mMNMNMM-   .NMNMNMNy`     .ohMNNMNMh``    X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "    shdMNNMNMd.  `    /mMNMNNMNMy    hMNMMNMo   `hMNMMMM/   -mMmMNMM-   -NMNMNMMo-   `shMNMNNMdhs      X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "    /ohMMMMNdh+  `    ymMNMNNMNMh    hMNMMNMo   `ymdmyyh:   `ydhdmNN:   :hddmdddo-  -++sdhNNNMdys      X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "      +MMMMNNh:       /dMNMNMMNMh    yMNMMMM+   `sho+:```       `.--`   ```.....`   +yydNNMNNMo``      X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "      oNNMMNMds+:..   +dNmNmNNmNy    yMNNNNN+    ss+.  ``.`             `::+o+ss- -`:hhdMNMNNNo        X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "      /yyNMNMNMMy-    +/-.------.    yyyyssy/    -.`   ./:`             `yydMNMM: /`-MMNMNMNyy/        X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "      ``:MMNMNMMmNs+/++o//:/++/:::-   `+oohh/   //dhddddo.  :ohhhhhho.  +hmhdh+-:/ymmMMNMNMN-.`        X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "        .MMmMNMMMMys.    `           . :hhmMs   /hMNMMMMs-  +mMmMNMMo-  +NMNMd `  oMNMMNMNMN`          X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "        `+oNMNMMMMdmdo   :/::::/:` `--/hddNMs   :dMNMMMMh:  /mMNMNMMy/  +dmddh`+yhdMMMMNMdss`          X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "          `dMNMMMMmMh`   sMNMMNMh. `:hMNMMMMy.  `dMmMNMMs-  +mMNMNMM+.  +yh/`. `dMNMNMMNMs             X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "           ohmMMMMNMd+/``yMNmmNMd/:-.hMNMMMMh.  /dMNMNMMy:  /mMNMNmm+/` -oso:-++mMNMNMMmmo             X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "             +MMMMNMNMM- -/:.-dMmyy- dMNMMNMh`  /hMNMMMMy-  /mMNMNmmso+. .-syyMMNMNMMNMo               X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "             +NNMMNMNMM/-...``hMmhy/ hMNMMNMh.``hhMNMMMMy/` +mMmMNMMhhy: .oyhhMMNMNMMmN+               X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "             .-:NMNMMMMmNdyy/.:/:::. sMNMMNMdy+dMdMNMMNMdys:`yhhMMs+/::` yNNNNMMNMNMM--.               X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "               `mMNMMMMmMmhh:.``  `  sMNNMNMmhhNMdMNMMNMdhh/`shhMM:  ````yMNMMNMNMNMM                  X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "                :/mMMMMNMNmmshsso`.: /yyyyyysoosdhmddddmhs+: :++oo. sddhdmMNMMMMNMmoo                  X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "                  yMNMMNMNMNMMyyo` -.           oyyyyyyyo- . .-..   sMNMMNMNMMNMNMh                    X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "                  +yhMMNMNMNMMddyo+ys+/:`   `..-yyyyyyyys/-ss////+oshMNMMNMMMNmmmmh                    X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "                    -MMNMNMNMMNMNMNNMhys.              ` `.yymMNMMMMmMNMMMMmMm                         X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "                    -NNmNNNNNNmNNNNNNhyo`   ``            .yymNmNNNNmNNNNNNmNd                         X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "                         +dhddhdhdhhdhdhhhhhhhhhhhhyhhhhhhyddhdhdhddhdhdddd:                           X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "                         oNNNNmNNNNNNNNmNNNNNNmNNNNmNNNNNNmNNNNmNNNNNNmNNNN:                           X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "                         .::::::+hhhhhhhhhhhhhhhhhhyhhhhhhyhhhhhhhhh+::::::`                           X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X\n" +
                "                                   sssssmmmmdmmdmmmdmmdmdmdssssoss.                                    X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X   X");
    }

    public static void endGame() {
        System.out.println("FFFFFFFFFFFFFFFFFFFFFF     IIIIIIIIII     MMMMMMMM               MMMMMMMM");
        System.out.println("F::::::::::::::::::::F     I::::::::I     M:::::::M             M:::::::M");
        System.out.println("F::::::::::::::::::::F     I::::::::I     M::::::::M           M::::::::M");
        System.out.println("FF::::::FFFFFFFFF::::F     II::::::II     M:::::::::M         M:::::::::M");
        System.out.println("  F:::::F       FFFFFF       I::::I       M::::::::::M       M::::::::::M");
        System.out.println("  F:::::F                    I::::I       M:::::::::::M     M:::::::::::M");
        System.out.println("  F::::::FFFFFFFFFF          I::::I       M:::::::M::::M   M::::M:::::::M");
        System.out.println("  F:::::::::::::::F          I::::I       M::::::M M::::M M::::M M::::::M");
        System.out.println("  F:::::::::::::::F          I::::I       M::::::M  M::::M::::M  M::::::M");
        System.out.println("  F::::::FFFFFFFFFF          I::::I       M::::::M   M:::::::M   M::::::M");
        System.out.println("  F:::::F                    I::::I       M::::::M    M:::::M    M::::::M");
        System.out.println("  F:::::F                    I::::I       M::::::M     MMMMM     M::::::M");
        System.out.println("FF:::::::FF                II::::::II     M::::::M               M::::::M");
        System.out.println("F::::::::FF                I::::::::I     M::::::M               M::::::M");
        System.out.println("F::::::::FF                I::::::::I     M::::::M               M::::::M");
        System.out.println("FFFFFFFFFFF                IIIIIIIIII     MMMMMMMM               MMMMMMMM");

        System.out.println("\nAlgumas decisoes feitas por voce:\n");

        System.out.print("Seu nome: ");
        for (int i = 0; i < Game.nameArray.length; i++) { //PRINTA O NOME
            System.out.print(Game.nameArray[i] + " ");
        }
        System.out.println("\nSua idade: " + Game.age);
        System.out.println("Seu humor: " + Game.mood);
        System.out.println("Nivel de atraso (quantas vezes escolheu dormir no comeco): " + Game.ifLate);
        System.out.println("Nivel de intimidade com A Raquel: " + Game.intimacyRaquelWithMain);
        System.out.println("Nivel de intimidade com A Lorem: " + Game.intimacyLoremWithMain);

        System.out.println("\nObrigado por jogar!");
        System.exit(1);
    }
}

