/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

 */
package Topico6aAtividadesSlide12;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadView extends Thread {

    Atividade3 atv3;

    public ThreadView(Atividade3 atv3) {
        this.atv3 = atv3;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Valor: " + this.atv3.getBoundedCounter());
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
