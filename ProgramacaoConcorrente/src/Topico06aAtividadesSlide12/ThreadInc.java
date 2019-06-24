/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

 */
package Topico06aAtividadesSlide12;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadInc extends Thread {

    Atividade3 atv3;

    public ThreadInc(Atividade3 atv3) {
        this.atv3 = atv3;
    }

    @Override
    public void run() {
        while (true) {
            this.atv3.increment();
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadInc.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
