/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exemplo1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mateu
 */
public class Disputa extends Thread {
    Contador contador = new Contador();
    public void run(){
        this.contador.cont++;
        System.out.println(this.contador.cont);
        System.out.println(Thread.currentThread().getId());
    }
    public static void main(String[] args) {
        
        for (int i = 0; i < 4; i++) {
            new Disputa().start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Disputa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

class Contador{
    int cont = 0;
}