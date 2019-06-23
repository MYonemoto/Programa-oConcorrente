/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

    Atividade 7. Semáforos podem ser usadas para representar uma fila.
Faça um código que implemente duas filas (F1 e F2) com semáforos. As threads colocadas na F1 só
podem executar se tiver um par na F2. Nesse caso, ambas as threads na primeira fila são executadas.
 */
package Topico7Semaforos;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Atividade7 {

    Semaphore fila01 = new Semaphore(0);
    Semaphore fila02 = new Semaphore(0);
    String msg;
    int nF1;
    int nF2;

    public Atividade7(int nF1, int nF2) {
        this.nF1 = nF1;
        this.nF2 = nF2;
    }

    public void Sem01(String m) {
        this.fila02.release();
        try {
            this.fila01.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Atividade7.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(m + "-" + this.msg);

        this.msg = "";
    }

    public void Sem02(String m) {
        this.fila01.release();
        try {
            this.fila02.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Atividade7.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.msg = m;
    }

    public void init() {
        for (int i = 0; i < nF1; i++) {
            ThreadAtv7F1 t1 = new ThreadAtv7F1(this, "Fila01 " + i);
            t1.start();
        }

        for (int i = 0; i < nF2; i++) {
            ThreadAtv7F2 t2 = new ThreadAtv7F2(this, " Fila02 " + i);
            t2.start();
        }
    }
    
    public static void main(String[] args) {
        Atividade7 atv7 = new Atividade7(5, 3);
        atv7.init();
    }
}
