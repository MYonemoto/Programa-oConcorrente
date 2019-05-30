/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

    Atividade 2. Enviar sinalização para um ponto de encontro entre threads.
Faça um código que uma thread t1 e t2 são inicializadas e t1 espera por t2 e vice-versa.
Exemplo:
t1:
trecho1.1
trecho1.2
t2:
trecho2.1
trecho2.2

thecho1.1 ocorre antes trecho2.2 e threcho2.1 ocorre antes de trecho1.2.
 */
package Topico7Semaforos;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Atividade2 {

    Semaphore semaphore = new Semaphore(1);
    TrechoAtv2 t1;
    TrechoAtv2 t2;

    public Atividade2() {
        this.t1 = new TrechoAtv2(this, "1");
        this.t2 = new TrechoAtv2(this, "2");
    }

    public void trecho(String message) {
        try {
            this.semaphore.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Atividade2.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(message);
        this.semaphore.release();
    }

    public void init() {
        this.t1.start();
        this.t2.start();
    }

    public static void main(String[] args) {
        Atividade2 atv2 = new Atividade2();
        atv2.init();
    }
}