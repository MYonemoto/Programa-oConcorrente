/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

 */
package OneDimensionalStencil;

import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadCB extends Thread {
    
    int position;
    double[] vetor;
    CyclicBarrier doneBarrier;
    
    

    public ThreadCB(int position, double[] vetor, CyclicBarrier doneBarrier) {
        this.position = position;
        this.vetor = vetor;
        
        this.doneBarrier = doneBarrier;    
    }

    @Override
    public void run() {
        if ((this.position != 0) && this.position != (this.vetor.length - 1)) {
            double valor = (this.vetor[this.position - 1] + this.vetor[this.position + 1]) / 2;
            
            this.vetor[this.position] = valor;
            System.out.println(Arrays.toString(vetor));
        }
        
        
        try {
            this.doneBarrier.await();
        } catch (InterruptedException | BrokenBarrierException ex) {
            Logger.getLogger(ThreadCB.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }

    
}
