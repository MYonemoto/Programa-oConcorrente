/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

 */
package Topico10AtividadesSlide27;

import java.util.concurrent.Callable;

public class TaskMergeSort implements Callable<VetorThingsAtv6> {
    
    int vetor[];
    int vetorB[];
    int inicio;
    int fim;
    VetorThingsAtv6 things;
    
    public TaskMergeSort(int[] vet){
        this.vetor = vet;
        this.inicio = 0;
        this.fim = this.vetor.length - 1;
        this.things = new VetorThingsAtv6();
    }

 
    public void mergeSort(int vetor[], int inicio, int fim) {
        int meio;
        if (inicio < fim) {
            meio = (inicio + fim) / 2;
            mergeSort(vetor, inicio, meio);
            mergeSort(vetor, meio + 1, fim);
            intercala(vetor, inicio, meio, fim);
        }
    }
 
    public static void intercala(int vetor[], int inicio, int meio, int fim) {
        int i, j, k;
        int vetorB[] = new int[vetor.length];
        for (i = inicio; i < meio; i++) {
            vetorB[i] = vetor[i];
        }
        for (j = meio + 1; j < fim; j++) {
            vetorB[fim + meio + 1 - j] = vetor[j];
        }
        i = inicio;
        j = fim;
        for (k = inicio; k < fim; k++) {
            if (vetorB[i] <= vetorB[j]) {
                vetor[k] = vetorB[i];
                i = i + 1;
            } else {
                vetor[k] = vetorB[j];
                j = j - 1;
            }
        }
    }

    @Override
    public VetorThingsAtv6 call() throws Exception {
        mergeSort(this.vetor, this.inicio, this.fim);

        this.things.setNomeFunc("MergeSort");
        this.things.setVet(this.vetor);
        return things;
    }
    
}
