/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

    Atividade 4. Faça um programa em Java que realize uma busca paralela
em um vetor de inteiros. Informe para o método: valor procurado, vetor 
de inteiros e o número de threads.

 */
package Topico3AtividadesSlide28;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Atividade4 implements Runnable {

    private Object[] array;
    private Object target;
    private int inicio, fim;
    
    //construtor
    //inicio e fim equivalem ao começo e final do vetor
    Atividade4(Object[] array, Object target, int inicio, int fim) {
        this.array = array;
        this.target = target;
        this.inicio = inicio;
        this.fim = fim;
    }

    @Override
    public void run() {
        //print que mostra de que numero a que numero determinada thread está buscando
        System.out.println("Iniciando busca de " + inicio + " - " + fim);
        for (int i = inicio; i <= fim; i++) {
            if (target.equals(array[i])) {
                System.out.println("\"'" + target
                        + "' achado na posição " + i + " pela thread '"
                        + Thread.currentThread().getName() + "'"
                        );
                return;
            }
        }
        System.out.println("Thread '" + Thread.currentThread().getName()
                + "' terminou a busca sem sucesso.");
    }
    
    //método que gera um array
    private static Object[] getArray(int totalElementos) {
        List<Integer> lista = new ArrayList<Integer>();
        Random rand = new Random();
        for (int i = 0; i < totalElementos; i++) {
            Integer num = i;
            lista.add(num);
        }

        return lista.toArray();
    }
    
    //método que realiza a busca, passando por parametro a quantidade de threads,
    // o array e o numero alvo da busca
    private static void buscar(int qtdThreads, Object[] array, Object target) {
        //determinando a divisão para cada thread fazer a busca
        int itensPorThread = (int) Math.ceil((double) array.length / qtdThreads);
        ThreadGroup group = new ThreadGroup("ThreadGroup Busca");
        int inicio = 0;
        int fim = itensPorThread;
        List<Thread> threadList = new ArrayList<Thread>();

        for (int i = 0; i < qtdThreads; i++) {
            if (fim >= array.length) {
                fim = (array.length - 1);
            }
            Runnable runnable = new Atividade4(array, target, inicio, fim);
            threadList.add(new Thread(group, runnable, "T" + i));
            inicio = ++fim;
            fim += itensPorThread;
        }

        start(threadList);

    }
    
    //método para iniciar as threads
    private static void start(List<Thread> threads) {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    public static void main(String[] args) {
        //valores fixos para a quantidade de elementos do vetor, quantidade de threads
        //e o elemento procurado
        final int QUANTIDADE_ITENS = 20000;
        final int QTD_THREADS = 2;
        final int VALOR_PROCURADO = 50;

        Object[] array = getArray(QUANTIDADE_ITENS);

        buscar(QTD_THREADS, array, VALOR_PROCURADO);
    }

}
