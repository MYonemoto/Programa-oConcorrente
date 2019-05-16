/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055
 */
package Topico6AtividadeSlide16;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Produtor implements Runnable{
    Atividade1 buffer;

    public Produtor(Atividade1 buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        Random rnd = new Random();
        int value;
        
        while(true){
            value = rnd.nextInt(30 + 1) + 1;
            buffer.put(value);
            try {
                Thread.sleep(value);
            } catch (InterruptedException ex) {
                Logger.getLogger(Produtor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
