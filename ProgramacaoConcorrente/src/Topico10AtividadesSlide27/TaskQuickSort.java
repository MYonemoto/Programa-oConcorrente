/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

 */
package Topico10AtividadesSlide27;

import java.util.concurrent.Callable;

public class TaskQuickSort implements Callable<VetorThingsAtv6> {
    
    int[] vetor;
    int inicio;
    int fim;
    VetorThingsAtv6 things;

    public TaskQuickSort(int[] vet) {
        this.vetor = vet;
        this.inicio = 0;
        this.fim = this.vetor.length - 1;
        this.things = new VetorThingsAtv6();
    }

    @Override
    public VetorThingsAtv6 call() throws Exception {
        quickSort(this.vetor, this.inicio, this.fim);

        this.things.setNomeFunc("QuickSort");
        this.things.setVet(this.vetor);
        return things;
    }

    private static void quickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = separar(vetor, inicio, fim);
            quickSort(vetor, inicio, posicaoPivo - 1);
            quickSort(vetor, posicaoPivo + 1, fim);
        }
    }

    private static int separar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[inicio];
        int i = inicio + 1, f = fim;
        while (i <= f) {
            if (vetor[i] <= pivo) {
                i++;
            } else if (pivo < vetor[f]) {
                f--;
            } else {
                int troca = vetor[i];
                vetor[i] = vetor[f];
                vetor[f] = troca;
                i++;
                f--;
            }
        }
        vetor[inicio] = vetor[f];
        vetor[f] = pivo;
        return f;
    }
    
}
