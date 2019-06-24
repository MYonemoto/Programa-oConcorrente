/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

    Atividade 2. Faça um programa em Java para testar um conjunto de
operações sobre um grupo de threads. Use o ThreadGroup.

 */
package Topico03AtividadesSlide28;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Atividade2 implements Runnable {
    
    @Override
    public void run(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Atividade2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("ThreadGroup");
        
        Thread t = new Thread(group, new Atividade2());
        t.start();

        System.out.println("ActiveCount: " + group.activeCount());
        System.out.println("Nome: " + group.getName());
    }
}
