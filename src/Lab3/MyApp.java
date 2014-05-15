/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lab3;

import javax.swing.SwingUtilities;

/**
 *
 * @author DolceVita
 */
public class MyApp {

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {     
                WindowsManager wm = new WindowsManager(1400, 800);
                wm.createNewWindows(0.14, 0.25, 0.1, 0.1, "window1");
                wm.createNewWindows(0.43, 0.5, 0.2, 0.2, "window2"); 
                wm.createNewWindows(0.514, 0.125, 0.3, 0.3, "window3"); 
            }
        });
    }
}
