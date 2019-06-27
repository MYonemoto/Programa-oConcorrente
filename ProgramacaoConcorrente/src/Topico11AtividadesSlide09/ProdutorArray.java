/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

 */
package Topico11AtividadesSlide09;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutorArray implements Runnable {

    ArrayBlockingQueue<Integer> array;

    public ProdutorArray(ArrayBlockingQueue<Integer> array) {
        this.array = array;
    }

    @Override
    public void run() {
        Random rnd = new Random();
        int value;
        int i = 0;

        while (i < 50) {
            value = rnd.nextInt(10) + 1;
            try {
                System.out.println("Produzi o valor " + value);
                array.put(value);
            } catch (InterruptedException ex) {
                Logger.getLogger(ProdutorArray.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;

        }
    }

}
