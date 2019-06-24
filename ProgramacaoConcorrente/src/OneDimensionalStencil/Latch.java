/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

 */
package OneDimensionalStencil;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Latch extends Thread {

    double[] vetor;
    int numThreads;

    CountDownLatch doneSignal;
    CountDownLatch done;

    public Latch(double[] vetor, CountDownLatch done) {
        this.vetor = vetor;
        this.done = done;
        this.doneSignal = new CountDownLatch(2);
    }

    @Override
    public void run() {
        int count = 0;

        while (verificationMiddlePosition(this.vetor)) {
            try {

                ThreadLatch t1 = new ThreadLatch(1, this.vetor, this.doneSignal);
                ThreadLatch t2 = new ThreadLatch(2, this.vetor, this.doneSignal);

                t1.start();
                t2.start();

                this.doneSignal.await();
                count++;
                this.doneSignal = new CountDownLatch(2);

            } catch (InterruptedException ex) {
                Logger.getLogger(Latch.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.done.countDown();
        System.out.println("Quantidade de iteracoes: " + count);
    }
    
    public boolean verificationMiddlePosition(double array[]) {
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] - array[0] > 0.000000000001) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        double[] vetor = new double[]{1, 2, 2, 1};
        CountDownLatch done = new CountDownLatch(1);
        Latch t = new Latch(vetor, done);

        try {
            t.start();
            done.await();
            System.out.println(Arrays.toString(vetor));
        } catch (InterruptedException ex) {
            Logger.getLogger(Latch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
