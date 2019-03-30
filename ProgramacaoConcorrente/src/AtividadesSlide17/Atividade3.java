/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AtividadesSlide17;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mateu
 */
public class Atividade3 extends Thread{
    
    @Override
    public void run(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            System.out.println("era pra estar interrompendo");
            Logger.getLogger(Atividade3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void main(String[] args) {
        Thread thread = new Thread(new Atividade2());
        thread.start();
        thread.interrupt();
    }
}
