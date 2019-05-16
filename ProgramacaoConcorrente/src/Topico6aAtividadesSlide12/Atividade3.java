/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

    Atividade 3. Escreva um monitor BoundedCounter que possui um valor
minimo e maximo. A classe possui dois metodos: increment()
e decrement(). Ao alcançar os limites minimo ou maximo, a
thread que alcançou deve ser bloqueada.

 */
package Topico6aAtividadesSlide12;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Atividade3 {

    ThreadInc ti;
    ThreadDec td;
    ThreadView tv;
    int boundedCounter;
    int min;
    int max;

    public Atividade3(int min, int max) {
        this.ti = new ThreadInc(this);
        this.td = new ThreadDec(this);
        this.tv = new ThreadView(this);
        this.min = min;
        this.max = max;
        this.boundedCounter = (min + max) / 2;
    }

    public synchronized void increment() {
        while (this.boundedCounter > this.max) {
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Atividade3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.notify();
        this.boundedCounter++;
    }

    public synchronized void decrement() {
        while (this.boundedCounter < this.min) {
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Atividade3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.notify();
        this.boundedCounter--;
    }

    public void init() {
        this.ti.start();
        this.td.start();
        this.tv.start();
    }

    public int getBoundedCounter() {
        return this.boundedCounter;
    }

    public static void main(String[] args) {
        Atividade3 atv3 = new Atividade3(50, 100);
        atv3.init();

    }
}
