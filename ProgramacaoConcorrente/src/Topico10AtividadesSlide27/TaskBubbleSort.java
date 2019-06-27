/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

 */
package Topico10AtividadesSlide27;

import java.util.concurrent.Callable;

public class TaskBubbleSort implements Callable<VetorThingsAtv6>{
    
    int[] vetor;
    VetorThingsAtv6 things;
    

    public TaskBubbleSort(int[] vet) {
        this.vetor = vet;
        this.things = new VetorThingsAtv6();
    }

    @Override
    public VetorThingsAtv6 call() throws Exception {

        for (int i = vetor.length; i >= 1; i--) {
            for (int j = 1; j < i; j++) {
                if (vetor[j - 1] > vetor[j]) {
                    int aux = vetor[j];
                    vetor[j] = vetor[j - 1];
                    vetor[j - 1] = aux;
                }
            }
        }
        
        this.things.setNomeFunc("BubbleSort");
        this.things.setVet(this.vetor);
        return this.things;
    }
    
}
