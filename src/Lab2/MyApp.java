
import Lab3.WindowsManager;
import javax.swing.SwingUtilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author DolceVita
 */
public class MyApp {
    
    public static void main(String args[])
    {
            SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {     
                WindowSystem w = new WindowSystem(500, 500);
            }
        });
        
        
    }    
}
