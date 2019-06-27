/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

    Atividade 1. Implemente duas vers˜oes do problema do produtor/consumidor com M
produtores e N consumidores usando ArrayBlockingQueue e LinkedBlockingQueue. 
Compare o desempenho das duas implementa¸c˜oes.

 */
package Topico11AtividadesSlide09;

import java.util.concurrent.ArrayBlockingQueue;

public class Atividade1ArrayBlockingQueue {

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> array = new ArrayBlockingQueue<>(100);

        Thread prod = new Thread(new ProdutorArray(array));
        prod.start();

        Thread cons = new Thread(new ConsumidorArray(array));
        cons.start();
    }

}
