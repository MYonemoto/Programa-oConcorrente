/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055
 */
package Topico06AtividadeSlide16;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumidor implements Runnable{

    Atividade1 buffer;

    public Consumidor(Atividade1 buffer) {
        this.buffer = buffer;
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
