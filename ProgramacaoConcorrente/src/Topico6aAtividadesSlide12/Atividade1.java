/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

    Atividade 1. Implemente uma solução com monitor para o problema do
Produtor-Consumidor usando um buffer circular.
 */
package Topico6aAtividadesSlide12;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Atividade1 {

    int[] buffer;
    int position;
    int size;

    public Atividade1(int size) {
        this.buffer = new int[size];
        this.position = 0;
        this.size = size;
    }

    public synchronized void put(int value) {
        while (position >= size) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Atividade1.class.getName()).log(Level.SEVERE, null, ex);
            }
            position = 0;
        }
        buffer[position] = value;
        position += 1;
        notifyAll();
    }

    public synchronized int take() {
        int returned;
        while (position <= 0) {
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Atividade1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        returned = buffer[position - 1];
        position -= 1;
        notifyAll();

        return returned;
    }

    public void init() {
        Thread threadCons = new Thread(new Consumidor(this));
        Thread threadProd = new Thread(new Produtor(this));
        
        threadProd.start();
        threadCons.start();

    }
    
    public static void main(String[] args) {
        Atividade1 atv1 = new Atividade1(10);
        atv1.init();
    }

}
