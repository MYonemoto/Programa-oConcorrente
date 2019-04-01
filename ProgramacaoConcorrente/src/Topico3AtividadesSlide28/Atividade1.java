/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

    Atividade 1. Faça um programa em Java que consulte periodicamente o
estado de um conjunto de threads.

 */
package Topico3AtividadesSlide28;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Atividade1 implements Runnable {
    
    @Override
    public void run(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Atividade1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        Thread t1 = new Thread(new Atividade1());
        Thread t2 = new Thread(new Atividade1());
        
        t1.start();
        t2.start();
        while(t1.isAlive() && t2.isAlive()){
            System.out.println("Thread 1: " + t1.getState());
            System.out.println("Thread 2: " + t2.getState());
            
        }
    }
}
