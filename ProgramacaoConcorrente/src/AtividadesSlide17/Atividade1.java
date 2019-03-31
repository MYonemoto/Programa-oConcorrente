/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

    Atividade 1. Faça um programa em Java que inicie três threads e, cada
thread, espere um tempo aleatório para terminar.

 */
package AtividadesSlide17;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Atividade1 {

    public static void createThread(int valor) throws InterruptedException {
        for (int i = 1; i <= valor; i++) {
            new Thread(() -> {
                try {
                    Random rand = new Random();
                    int value = rand.nextInt(5000 + 1 - 2000) + 2000;
                    Thread.sleep(value);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Atividade1.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Hello from the thread");
            }).start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        createThread(3);
    }
}
