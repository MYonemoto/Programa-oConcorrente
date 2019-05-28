/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

    Atividade 1. Enviar sinal para outra thread para indicar que um evento ocorreu.
Faça um código que uma thread t1 e t2 são inicializadas simultaneamente, mas a t2 pode somente
continuar a execução após a sinalização de t1
 */
package Topico7Semaforos;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Atividade1 {
    
    Semaphore semaphore = new Semaphore(1);
    WhateverThread t1;
    WhateverThread t2;
    
    public Atividade1(){
        this.t1 = new WhateverThread(this, "Thread 1");
        this.t2 = new WhateverThread(this, "Thread 2");
    }
    
    public void sinal(String msg){
        try {
            this.semaphore.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Atividade1.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(msg);
        this.semaphore.release();
    }
    
    public void init(){
        this.t1.start();
        this.t2.start();
    }
    
    public static void main(String[] args) {
        Atividade1 atv1 = new Atividade1();
        atv1.init();
    }
}
