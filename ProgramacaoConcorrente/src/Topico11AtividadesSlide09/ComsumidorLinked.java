/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

 */
package Topico11AtividadesSlide09;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComsumidorLinked implements Runnable {
    
    LinkedBlockingQueue<Integer> link;

    public ComsumidorLinked(LinkedBlockingQueue<Integer> link) {
        this.link = link;
    }

    @Override
    public void run() {
        int value = 0;
        int i = 0;

        while (i < 50) {
            try {
                value = link.take();
            } catch (InterruptedException ex) {
                Logger.getLogger(ConsumidorArray.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Valor consumido: " + value);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Topico06aAtividadesSlide12.Consumidor.class.getName()).log(Level.SEVERE, null, ex);
//            }
            i++;
        }
    }
    
}
