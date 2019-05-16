/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055
 */
package Topico7AtividadeSlide09;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumidor extends Thread{

    Atividade1 buffer;
    Semaphore semaphore;

    public Consumidor(Atividade1 buffer, Semaphore semaphore) {
        this.buffer = buffer;
        this.semaphore = semaphore;
    }
    
    @Override
    public void run() {
        int value;
        
        while(true){
            value = buffer.take();
            System.out.println("Consumindo. . .");
            System.out.println("Valor: " + value);
            try {
                Thread.sleep(value);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
