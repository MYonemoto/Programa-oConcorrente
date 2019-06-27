/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

    Atividade 1. Implemente duas vers˜oes do problema do produtor/consumidor com M
produtores e N consumidores usando ArrayBlockingQueue e LinkedBlockingQueue. 
Compare o desempenho das duas implementa¸c˜oes.

 */
package Topico11AtividadesSlide09;

import java.util.concurrent.LinkedBlockingQueue;

public class Atividade1LinkedBlockingQueue {

    public static void main(String[] args) {
        
        LinkedBlockingQueue<Integer> link = new LinkedBlockingQueue<Integer>(100);

        Thread prod = new Thread(new ProdutorLinked(link));
        prod.start();

        Thread cons = new Thread(new ComsumidorLinked(link));
        cons.start();

    }

}
