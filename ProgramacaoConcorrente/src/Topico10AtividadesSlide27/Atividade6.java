/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

    Atividade 6.   Fa¸ca um programa que execute trˆes algoritmos de ordena¸c˜ao para um
conjunto de valores e exiba o resultado apenas do algoritmo que finalizar
primeiro (use invokeAny).

 */
package Topico10AtividadesSlide27;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Atividade6 {

    Collection<Callable<VetorThingsAtv6>> taskList;

    ExecutorService es;
    int[] vet;

    public Atividade6(int[] vetor) {
        this.taskList = new ArrayList<>();
        this.es = Executors.newFixedThreadPool(3);
        this.vet = vetor;
    }

    public void init() {
        TaskBubbleSort bubble = new TaskBubbleSort(this.vet);
        TaskMergeSort merge = new TaskMergeSort(this.vet);
        TaskQuickSort quick = new TaskQuickSort(this.vet);

        this.taskList.add(bubble);
        this.taskList.add(merge);
        this.taskList.add(quick);

        VetorThingsAtv6 dados = null;

        while (dados == null) {
            try {
                dados = this.es.invokeAny(this.taskList);
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(Atividade6.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        System.out.println("\n Ordenação completa!");
        System.out.println("O primeiro a terminar foi: " + dados.getNomeFunc());

        this.es.shutdown();
    }

    private static int[] getArray(int totalElementos) {
        int vetor[] = new int[totalElementos];
        Random rnd = new Random();
        for (int i = 0; i < totalElementos; i++) {
            Integer num = rnd.nextInt(10) + 1;
            vetor[i] = num;
            System.out.print(" " + vetor[i]);
        }
        return vetor;
    }

    public static void main(String[] args) {

        int[] vetor = getArray(10);

        Atividade6 atv6 = new Atividade6(vetor);

        atv6.init();
    }

}
