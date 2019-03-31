/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AtividadesSlide17;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mateu
 */
public class Atividade5 implements Runnable{
    
    int seq, tamSeq, somaSeq = 0;
    

    public Atividade5(int seq) {
        this.seq = seq;
    }
    
    @Override
    public void run(){
        new Thread( () -> {
            
            Scanner scanner = new Scanner(System.in);

            System.out.println("Iniciando a Thread... ");
            
            System.out.println("Digite o tamanho da sequencia: ");
            tamSeq = scanner.nextInt();
            
            int [] vetor = new int[tamSeq];
            
            for (int i = 0; i < tamSeq; i++) {
                System.out.println("Entre com os valores: ");
                this.seq = scanner.nextInt();
                vetor[i] = seq;
            }
            
            for (int i = 0; i < tamSeq; i++) {
                somaSeq += vetor[i];
            }
            System.out.println("Soma total: " + somaSeq);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Atividade4.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Interrupted.");
            }
        }).start();
    }
    
    public static void main(String[] args) {
        int value = 0;
        Thread t = new Thread(new Atividade5(value));
        t.start();
        try {
            t.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Atividade5.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
