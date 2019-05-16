/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

    Atividade 2. Escreva uma monitor Counter que possibilita um processo
dormir até o contador alcançar um valor. A classe Counter
permite duas operações: increment() e sleepUntil(int x).

 */
package Topico6aAtividadesSlide12;

public class Atividade2 {

    int wakeUp;
    int inc;
    WhateverThread wt;

    public Atividade2(int time) {
        this.wakeUp = time;
        this.inc = 0;
        this.wt = new WhateverThread(this);
    }

    public synchronized void increment() {
        this.inc++;
    }

    public synchronized void sleepUntil() {
        System.out.println("sleep");
        while (this.inc <= this.wakeUp) {
            this.wt.sleep(500);
            increment();
        }
        System.out.println("wakeup");
        this.inc = 0;
        notifyAll();
    }

    public void init() {
        this.wt.start();
    }

    public static void main(String[] args) {
        Atividade2 atv2 = new Atividade2(10);
        atv2.init();
    }
}
