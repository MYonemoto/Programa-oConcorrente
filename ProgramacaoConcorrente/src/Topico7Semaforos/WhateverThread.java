/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

 */
package Topico7Semaforos;

import java.util.logging.Level;
import java.util.logging.Logger;

public class WhateverThread extends Thread {

    Atividade1 atv1;
    String name;

    public WhateverThread(Atividade1 atv1, String name) {
        this.atv1 = atv1;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            this.atv1.sinal(this.name + " Sign!!!!!!!!!!");
            this.sleep(2000);
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
