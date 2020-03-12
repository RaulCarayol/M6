/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m6_uf2_actividad5;

import java.awt.Frame;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

/**
 *
 * @author Alumne
 */
public class M6_UF2_Actividad5 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
                    Actividad5GUI frame;
                    Frame frame1 = new MainMenu();
                    frame1.setVisible(true);
                    frame1.setLocationRelativeTo(null);
                    frame1.pack(); 
        }
       });
        t.start();

 
    }
}
