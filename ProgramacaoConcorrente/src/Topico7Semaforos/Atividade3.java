/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

    Atividade 3. Garantir acesso exclusivo à seção crítica.
Faça um código que possibilite que 2 ou mais threads realizem o incremento de um contador. Faça a
exclusão mútua com semáforo.
 */
package Topico7Semaforos;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Atividade3 {

    int count;
    Semaphore semaphore = new Semaphore(1);

    ThreadIncAtv3 t1;
    ThreadIncAtv3 t2;
    ThreadIncAtv3 t3;

    public Atividade3() {
        this.count = 0;

        this.t1 = new ThreadIncAtv3(this, "Thread 1");
        this.t2 = new ThreadIncAtv3(this, "Thread 2");
        this.t3 = new ThreadIncAtv3(this, "Thread 3");
    }

    public void increment(String name) {
        try {
            this.semaphore.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Atividade3.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.count++;
        System.out.println(name + "-> count: " + this.count);

        this.semaphore.release();
    }

    public void init() {
        this.t1.start();
        this.t2.start();
        this.t3.start();
    }

    public static void main(String[] args) {
        Atividade3 atv3 = new Atividade3();
        atv3.init();
    }

}
