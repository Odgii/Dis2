package Lab1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
/**
 *
 * @author DolceVita
 */
public class HelloWorldConsole {


    public static void main(String[] args) {
        
        int input;
        System.out.println("Select one of the following:");
        System.out.println("   [D]eutsch");
        System.out.println("   [E]nglish");
        System.out.println("   [F]rancais");
        System.out.println("[Q]uit");
        try {
            input = System.in.read();
            if(input == 'd' || input == 'D')
            {
                System.out.println("Guten Tag");
            }
            if(input == 'f' || input == 'F')
            {
                System.out.println("Bonjour");
            }
            if(input == 'e' || input == 'E')
            {
                System.out.println("Hello");
            }
            if(input == 'q' || input == 'Q')
            {
                System.out.println("Quitting");
                System.exit(0);
            }
        }
        catch (IOException e){
            System.out.println("Error reading from user");
        }
    }

}
