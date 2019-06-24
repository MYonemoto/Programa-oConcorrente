/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

    Atividade 4. Faça uma Thread que monitora um conjunto de threads e
exiba quais threads receberam sinais de interrupção.

 */
package Topico03AtividadesSlide17;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Atividade4 implements Runnable {

    @Override
    public void run() {
        System.out.println("The Thread.");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Atividade4.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Atividade4());
        Thread t2 = new Thread(new Atividade4());
        new Thread(() -> {
            System.out.println("The Monitor.");
            try {
                Thread.sleep(2000);

                t1.start();

                t2.start();

                while (true) {
                    if (t1.isInterrupted()) {
                        System.out.println("Thread 1 interrompido.");

                        throw new InterruptedException();
                    }
                    if (t2.isInterrupted()) {
                        System.out.println("Thread 2 interrompido.");
                        throw new InterruptedException();
                    }
                    break;
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Atividade4.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Interrupted.");
            }
        }).start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Atividade4.class.getName()).log(Level.SEVERE, null, ex);
        }

        t1.interrupt();
        t2.interrupt();
    }

}
