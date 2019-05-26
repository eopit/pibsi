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
            } else if (Game.decision.equalsIgnoreCase("B"))  {
                System.out.println("\n\nJogo desenvolvido por:\n");
                System.out.println("Gabryelle Silva Santos");
                System.out.println("Pedro Henrique Barricelli Martins");
                System.out.println("Aperte enter para continuar...");
                Game.sc.nextLine();
                System.out.println("[A] - Novo jogo");
                System.out.println("[B] - Creditos");
                System.out.println("[C] - Sair");
            } else {
                Game.endGame();
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

    public static void lorenReset() throws IOException, InterruptedException {
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
        System.out.println("RESTAURACAO CONCLUIDA COM EXITO. REINICIANDO SISTEMA.");
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
        Thread.sleep(600);
        clearConsole();
    }
}

