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
                "                         oMNMMNMmhhyhyhyyhyhshhyhyhhmMNMNNMNMNMMNMNMNMMmMNMNhh-    \n" +
                "                     ....sMNNNmNdyyssssshhssshhhhhhhNMNmymNmNmNNNMNMMMMNMNMNhh-`   \n" +
                "                    -NNmNNMNyysyyyy-````-.````.::+osyhd+ ```-syyMMNMNMNMMNMNMNss-  \n" +
                "                    -MMNMNMNhhyhhhh-                 ``     `shhMMNMNMNMMNMMMNhh:          \n" +
                "                  /hdMMyyyyysyosso-:--.```                  `+shddyhhMNMMNMMMMNNdhhhhhh/   \n" +
                "                  +MNMMyyyyyyy++/    ```                       ```.hyMNMMNMNMMNMNMNMMmMs       \n" +
                "                ++yMNdhosssoyyosyo/oohs+ys-                  -/+sodNNMNddNMNMMMMNMNMNdhs:/ss`  \n" +
                "                NMmMmhh//.``.-:-:-.``-`-MM:                    -:-....oysNMNMNMMNMNMm..--+MN`  \n" +
                "             `::MMmNdyyyh/` /Nms:-.----:dd-                    `+hh/ -dddNMmmmMMNMNMNhyyyyhy`  \n" +
                "             :MNMMhys+oo..`  /. .ssdNmNmNN:                     +o. .+ssyyys+oMMNMNMNMMNMh     \n" +
                "             :MMNMhhy+:h+/:     .sshdddddd:                      `ooooo+/: -ssMNNMNMNMMNMh     \n" +
                "           sdmMMyyooo. -..` yddddmmdmmmmmmddddh`                 `yyyyyyys  -syymMNMNMMNMh     \n" +
                "           yMNMMhyo+`       dMNMNMNNMNMNNMNMNMm`                   `-/://::.`ohhdMNMNMMNMh     \n" +
                "        `ssmMmhhyyy+     -soyhhhhhhyhhhhhhhhhhh.                :o:.`------smmmNhhdMMNMNMmss`  \n" +
                "        `MMmMmhhshy. `   +MNNMNMNMMmMNMNNMNMNMN:                ``..     -:sMNy::-+MMNMNMNMM-  \n" +
                "      /MMMMNMh+` .s -NNmNmNmNNmNmNmmNmNmNNmNmNmNN:       `:/. `yMNMMNMNMMMMNMdo`    .mNmNmNmmN/    \n" +
                "    oyhMNhhyhy:  .- .ddddddddddddddhddddddddddddd:       .mm/  sMMMMNMNMMMMNMNNd:    --sdddddd+..  \n" +
                "    mMNMNyyd     `  :mmmNmNmmNmNmssossssmNmmh            `+./yNNMMNNNMNyydMNMMNMho.  /   `mNmNmNm. \n" +
                "    mMNMNys+        ```yddddddhddddddhdhdd-          .   `yMNs:/ss/omMNMNNMNMNMMmmd: `   :ddddddh++`   \n" +
                "    mMNMm++-           dNNNNNNmMNMNNNNNNNN-               yMN+ `.  .dMNMNMMNMNMNh:/o     oNNNNNNmhh`   \n" +
                " .ssNMNMd++//-.        :::::hhhhyssos+::::`              `dNN: +y  -oydhdddmMNddddd+     .//yhhhhsy-   \n" +
                " -MMNMNMmo:```-             dMNMmyysh+                    ---`          .ohdMN-::``.        hMNMNNM/   \n" +
                " :MMNMNMN-   :.`            shyso////-                                   :/ohy``            shhhhhh-   \n" +
                " -MMNMNMm-          .       dM/                                            sMm.`            mMNMNMM.  \n" +
                " -MMNMNMm:          `       hN:                                            oNd.`            mNNNmNN.   \n" +
                " :MMNMNMN:               /dy                .dy..yd+               `         -dd`          `hdhdddd    \n" +
                " -MMNMNMN:          `    oNm`               `Nm..dNs                         :NN-          `mNNNNNN`   \n" +
                " :MMNMNMN:               .--              +oody``sdo::                       `::`           hdhdhdh`   \n" +
                " -MMNMNMm:                   `           `mMNMm``dMdhh`                                     mMNMNMM.   \n" +
                " :MMNMmmd:                `             --yhyso``shsso``                                    yhhhhhh`   \n" +
                " -MMNMhyy/                             .MMNMy..  hMNMM:.`                                   mMNMNMM.   \n" +
                " :MMNMdhh/                             `ssos/``  odhdd-.`                                   hdddddd`   \n" +
                " -MMNMhys:                                                                                  dNmNmNN.   \n" +
                " -MMNMNMm                                         `          ```                           `mNmNNNN`   \n" +
                " :MMNMNMN`                             .//yh/    ohyhhhh:    shyhyhh-    /+-`              `hdhdhdd-   \n" +
                " -MMNMNMm`                             :hymMy    yMNMMMM+    mMmMNMM:    yhss:`             mMNMNMM-   \n" +
                " :ddNMNMN+--:-.        .`    ..-:    +hdmmNMh    hMNMMMMo    dMNMMMM/   `dmmmmy.         `--yhhhhoo.   \n" +
                " .hhmMNMNyhy. `     `.       /ohs    oMNNMNMy    yMNMMNMo    hMNMMNM/   -dMNMNo+         :hhmMNMNyh:   \n" +
                " `/+mMNMNhdh/  -o/.  .     ++yhds    yMNNMNMy    hMNMMMM+   `dMNMMNM:   -mMNMNhdh+      -ydhmMNMNss:   \n" +
                "    mMNMMMMh/  `.`         /MMNMd    yMNMMMMo    dMNMNMM/    mMNMNMM-   .NMNMNMNy`     .ohMNNMNMh``    \n" +
                "    shdMNNMNMd.  `    /mMNMNNMNMy    hMNMMNMo   `hMNMMMM/   -mMmMNMM-   -NMNMNMMo-   `shMNMNNMdhs      \n" +
                "    /ohMMMMNdh+  `    ymMNMNNMNMh    hMNMMNMo   `ymdmyyh:   `ydhdmNN:   :hddmdddo-  -++sdhNNNMdys      \n" +
                "      +MMMMNNh:       /dMNMNMMNMh    yMNMMMM+   `sho+:```       `.--`   ```.....`   +yydNNMNNMo``      \n" +
                "      oNNMMNMds+:..   +dNmNmNNmNy    yMNNNNN+    ss+.  ``.`             `::+o+ss- -`:hhdMNMNNNo        \n" +
                "      /yyNMNMNMMy-    +/-.------.    yyyyssy/    -.`   ./:`             `yydMNMM: /`-MMNMNMNyy/        \n" +
                "      ``:MMNMNMMmNs+/++o//:/++/:::-   `+oohh/   //dhddddo.  :ohhhhhho.  +hmhdh+-:/ymmMMNMNMN-.`        \n" +
                "        .MMmMNMMMMys.    `           . :hhmMs   /hMNMMMMs-  +mMmMNMMo-  +NMNMd `  oMNMMNMNMN`          \n" +
                "        `+oNMNMMMMdmdo   :/::::/:` `--/hddNMs   :dMNMMMMh:  /mMNMNMMy/  +dmddh`+yhdMMMMNMdss`          \n" +
                "          `dMNMMMMmMh`   sMNMMNMh. `:hMNMMMMy.  `dMmMNMMs-  +mMNMNMM+.  +yh/`. `dMNMNMMNMs             \n" +
                "           ohmMMMMNMd+/``yMNmmNMd/:-.hMNMMMMh.  /dMNMNMMy:  /mMNMNmm+/` -oso:-++mMNMNMMmmo             \n" +
                "             +MMMMNMNMM- -/:.-dMmyy- dMNMMNMh`  /hMNMMMMy-  /mMNMNmmso+. .-syyMMNMNMMNMo               \n" +
                "             +NNMMNMNMM/-...``hMmhy/ hMNMMNMh.``hhMNMMMMy/` +mMmMNMMhhy: .oyhhMMNMNMMmN+               \n" +
                "             .-:NMNMMMMmNdyy/.:/:::. sMNMMNMdy+dMdMNMMNMdys:`yhhMMs+/::` yNNNNMMNMNMM--.               \n" +
                "               `mMNMMMMmMmhh:.``  `  sMNNMNMmhhNMdMNMMNMdhh/`shhMM:  ````yMNMMNMNMNMM                  \n" +
                "                :/mMMMMNMNmmshsso`.: /yyyyyysoosdhmddddmhs+: :++oo. sddhdmMNMMMMNMmoo                  \n" +
                "                  yMNMMNMNMNMMyyo` -.           oyyyyyyyo- . .-..   sMNMMNMNMMNMNMh                    \n" +
                "                  +yhMMNMNMNMMddyo+ys+/:`   `..-yyyyyyyys/-ss////+oshMNMMNMMMNmmmmh                    \n" +
                "                    -MMNMNMNMMNMNMNNMhys.              ` `.yymMNMMMMmMNMMMMmMm                         \n" +
                "                    -NNmNNNNNNmNNNNNNhyo`   ``            .yymNmNNNNmNNNNNNmNd                         \n" +
                "                         +dhddhdhdhhdhdhhhhhhhhhhhhyhhhhhhyddhdhdhddhdhdddd:                           \n" +
                "                         oNNNNmNNNNNNNNmNNNNNNmNNNNmNNNNNNmNNNNmNNNNNNmNNNN:                           \n" +
                "                         .::::::+hhhhhhhhhhhhhhhhhhyhhhhhhyhhhhhhhhh+::::::`                           \n" +
                "                                   sssssmmmmdmmdmmmdmmdmdmdssssoss.                                    \n");
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

    public static void comeBackVersionReset() throws IOException, InterruptedException {
        clearConsole();

        for (int i = 0; i < Game.progressBar.length; i++) { //cria a barra de loading
            Game.progressBar[i] = "-";
            if (i == 0) {
                Game.progressBar[i] = "[";
            } else if (i == 99) {
                Game.progressBar[i] = "]";
            } else if (i > 0 && i < 98) {
                Game.progressBar[i] = "#";
            }
        }


        for (int i = 96; i < Game.progressBar.length; i++) { //PRINTA A BARRA EM SI (VAI REPETIR 4 VEZES)
            System.out.println("DOWNGRADE IN PROGRESS\t\t\t\tLOAADING..." + (i) + "%");
            printProgressBar();
            if (i >= 1 && i <= 99)
                Game.progressBar[i] = "#";
            Thread.sleep(3000);
            clearConsole();
        }
        System.out.println("REBOOTING...");
        Thread.sleep(2000);
    }
}


