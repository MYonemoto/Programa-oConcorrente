/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

 */
package OneDimensionalStencil;

import java.util.Arrays;
import java.util.concurrent.Phaser;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Phaaser extends Thread {

    double[] vetor;
    int numThreads;

    Phaser phaserblock = new Phaser(2);

    public Phaaser(double[] vetor) {
        this.vetor = vetor;
    }

    @Override
    public void run() {
        int count = 0;

        while (verificationMiddlePosition(this.vetor)) {
            ThreadPhaser t1 = new ThreadPhaser(1, vetor, phaserblock);
            ThreadPhaser t2 = new ThreadPhaser(2, vetor, phaserblock);

            t1.start();
            t2.start();

            this.phaserblock.awaitAdvance(this.phaserblock.getPhase());

            count++;
        }
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

        Phaaser p = new Phaaser(vetor);
        p.start();

        try {
            p.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Phaaser.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(Arrays.toString(vetor));
    }

}
