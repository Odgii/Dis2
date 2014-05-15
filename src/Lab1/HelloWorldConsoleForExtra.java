package Lab1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.Console;
import java.io.IOException;
import java.io.Reader;
/**
 *
 * @author DolceVita
 */

public class HelloWorldConsoleForExtra {
//Will work only on Linux or Unix
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Select one of the following:");
        System.out.println("   [D]eutsch");
        System.out.println("   [E]nglish");
        System.out.println("   [F]rancais");
        System.out.println("[Q]uit");
        String[] cmd = {"/bin/sh", "-c", "stty raw </dev/tty"}; 
        Runtime.getRuntime().exec(cmd).waitFor();    //Switchin to raw mode   
        Console console = System.console();
        Reader reader = console.reader();
        int input = reader.read();
        if (input == 'd' || input == 'D') {
            System.out.println("");
            System.out.println("Guten Tag");
        }
        if (input == 'f' || input == 'F') {
            System.out.println("");
            System.out.println("Bonjour");
        }
        if (input == 'e' || input == 'E') {
            System.out.println("");
            System.out.println("Hello");
        }
        if (input == 'q' || input == 'Q') {
            System.out.println("");
            System.out.println("Quitting...");
            System.exit(0);
        }
        cmd = new String[]{"/bin/sh", "-c", "stty sane </dev/tty"};
        Runtime.getRuntime().exec(cmd).waitFor(); //Switching back
    }
}

