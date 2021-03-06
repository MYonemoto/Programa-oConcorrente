/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

    Atividade 5. Faça uma thread Java que fica aguardando uma sequência
    numérica de tamanho arbitrário digitado por usuário para
    realizar uma soma. Use o join().
 */
package Topico03AtividadesSlide17;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Atividade5 implements Runnable {

    int seq, tamSeq, somaSeq = 0;

    public Atividade5(int seq) {
        this.seq = seq;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

            System.out.println("Iniciando a Thread... ");

            System.out.println("Digite o tamanho da sequencia: ");
            tamSeq = scanner.nextInt();

            int[] vetor = new int[tamSeq];

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
        System.out.println("aaaaaaaaaaaaa");
    }
}
