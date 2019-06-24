/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

 */
package OneDimensionalStencil;

import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CyclicBaarrier extends Thread {

    double[] vetor;
    int numThreads;
    int count;

    CyclicBarrier doneBarrier;

    public CyclicBaarrier(double[] vetor) {
        this.vetor = vetor;
        this.count = 0;
        this.doneBarrier = new CyclicBarrier(2);
    }

    @Override
    public void run() {
        while (verificationMiddlePosition(this.vetor)) {
            ThreadCB t1 = new ThreadCB(1, this.vetor, this.doneBarrier);
            ThreadCB t2 = new ThreadCB(2, this.vetor, this.doneBarrier);

            t1.start();
            t2.start();

            count++;

            try {
                t1.join();
                t2.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(CyclicBarrier.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.doneBarrier.reset();

        }
        System.out.println("Quantidade de iteraçoes: " + count);
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

        CyclicBaarrier cb = new CyclicBaarrier(vetor);

        cb.start();

        try {
            cb.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(CyclicBaarrier.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(Arrays.toString(vetor));
    }

}
