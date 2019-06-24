/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

    Atividade 4. Garantir acesso à seção crítica para no máximo N threads.
Faça um código que possibilite que N threads estejam na seção crítica simultaneamente.
 */
package Topico07Semaforos;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Atividade4 {
    
    Semaphore semaphore;
    int nThreads;
    int count;
    
    public Atividade4(int n, int nThreads){
        this.semaphore = new Semaphore(n);
        this.nThreads = nThreads;
        this.count = 0;
    }
    
    public void verification(String name){
        try {
            this.semaphore.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(Atividade4.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(name + ": Estou na regiao critica.");
        
        this.semaphore.release();
    }
    
    public void init(){
        for (int i = 0; i < nThreads; i++) {
            ThreadAtv4 t = new ThreadAtv4(this, "Thread" + i);
            t.start();
        }
    }
    
    public static void main(String[] args) {
        Atividade4 atv4 = new Atividade4(3, 6);
        atv4.init();
    }
    
}
