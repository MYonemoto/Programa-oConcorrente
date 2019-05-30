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
    
    public static void main(String[] args) {
        ThreadB b = new ThreadB();
        b.start();

        synchronized (b) {
            try {
                System.out.println("Thread2: Waiting for a sign...");
                b.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread2: Finally I can run!");
        }
    }
}

class ThreadB extends Thread {

    Semaphore sem = new Semaphore(1);
    
    @Override
    public void run() {
        synchronized (this) {
            try {
                sem.acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadB.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Thread1: Sending sign...");
            sem.release();
            notify();
        }
    }
}
