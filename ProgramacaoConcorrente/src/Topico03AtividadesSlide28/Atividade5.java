/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

    Atividade 5. Faça um programa multithreaded em Java que ordene um
vetor usando o Merge Sort recursivo. Faça com que a thread
principal dispare duas threads para classificar cada metade do
vetor.


 */
package Topico03AtividadesSlide28;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Atividade5 implements Runnable {

    int min;
    int max;
    int[] vet;

    public Atividade5(int min, int max, int[] vet) {
        this.min = min;
        this.max = max;
        this.vet = vet;
    }

    @Override
    public void run() {
        MergeSort ms = new MergeSort();
        ms.mergeSort(vet, min, max);
    }

    public static void main(String[] args) {

        int vetor[] = new int[100];
        Random rand = new Random();
        for (int i = 0; i < vetor.length; i++) {
            Integer num = rand.nextInt(500);
            vetor[i] = num;
        }

        Thread t1 = new Thread(new Atividade5(0, 100, vetor));
        Thread t2 = new Thread(new Atividade5(0, 50, vetor));
        Thread t3 = new Thread(new Atividade5(50, 100, vetor));

        try {
            t1.start();
            t1.join();

            t2.start();
            t2.join();

            t3.start();
        } catch (InterruptedException ex) {
            Logger.getLogger(Atividade5.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Vetor ordenado utilizando MergeSort recursivo: ");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(" " + i);
        }
    }

}
