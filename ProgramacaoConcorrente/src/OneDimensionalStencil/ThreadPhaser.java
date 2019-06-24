/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

 */
package OneDimensionalStencil;

import java.util.Arrays;
import java.util.concurrent.Phaser;

public class ThreadPhaser extends Thread {

    int position;
    double[] vetor;

    Phaser phaserblock;

    public ThreadPhaser(int position, double[] vetor, Phaser phaserblock) {
        this.position = position;
        this.vetor = vetor;
        this.phaserblock = phaserblock;
    }

    @Override
    public void run() {
        if ((this.position != 0) && this.position != (this.vetor.length - 1)) {
            double valor = (this.vetor[this.position - 1] + this.vetor[this.position + 1]) / 2;

            this.vetor[this.position] = valor;
            System.out.println(Arrays.toString(vetor));
        }
        this.phaserblock.arrive();
    }

}
