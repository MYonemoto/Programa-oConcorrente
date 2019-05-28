/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

    Atividade 1. Implementar solu¸c˜oes para o problema dos leitores-escritores
que:
              1.3: Priorize os escritores.
 */
package Topico8AtividadesSlide22;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Writers {
    public Buffer buffer;
    int numReaders = 0;
    Semaphore mutex = new Semaphore(1);
    Semaphore wlock = new Semaphore(1);
    
    public Writers(Buffer buffer){
        this.buffer = buffer;
    }

    public void startRead() throws InterruptedException {
        mutex.acquire();
        numReaders++;
        if (numReaders == 1) {
            wlock.acquire();
        }
        mutex.release();
    }

    public void endRead() throws InterruptedException {
        mutex.acquire();
        numReaders--;
        System.out.println(" read");
        if (numReaders == 0) {
            wlock.release();
        }
        buffer.print();
        mutex.release();
    }

    public void startWrite() throws InterruptedException {
        buffer.set(new Random().nextInt(20) + 1);
        wlock.acquire();
    }

    public void endWrite() {
        System.out.println(" write");
        wlock.release();
    }
}