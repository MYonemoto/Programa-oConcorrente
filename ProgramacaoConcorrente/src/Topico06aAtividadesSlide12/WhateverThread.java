/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

 */
package Topico06aAtividadesSlide12;

import java.util.logging.Level;
import java.util.logging.Logger;

public class WhateverThread extends Thread {

    Atividade2 atv2;

    public WhateverThread(Atividade2 atv2) {
        this.atv2 = atv2;
    }

    @Override
    public void run() {
        while (true) {
            atv2.sleepUntil();
        }
    }

    public void sleep(int x) {
        try {
            Thread.sleep(x);
        } catch (InterruptedException ex) {
            Logger.getLogger(WhateverThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
