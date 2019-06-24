/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

    Atividade 1. Faça um programa em Java que use Threads para encontrar
os números primos dentro de um intervalo. O método que contabiliza os números 
primos deve possuir como entrada: valor inicial e final do intervalo,
número de threads.
 */
package Topico04AtividadesSlide18;

import java.util.ArrayList;
import java.util.List;

public class Atividade1 implements Runnable {

    private int inicio;
    private int fim;

    public Atividade1(int inicio, int fim) {
        this.inicio = inicio;
        this.fim = fim;
    }

    @Override
    public void run() {
//        System.out.println("teste");
        List<Integer> numeros = new ArrayList<Integer>();
        List<Integer> numerosPrimos = new ArrayList<Integer>();
        for (int i = inicio; i < fim; i++) {
            numeros.add(i);
        }
//        System.out.println("asfasfas");
        int contador;
        int countPrimo = 0;
        int numero = 0;

        for (Integer i : numeros) {
            contador = 0;
            for (int u = 1; u <= i; u++) {
                if (i % u == 0) {
                    contador++;
                    numero = u;
                }
            }
            if (contador == 2) {
                System.out.println("primao " + numero);
                countPrimo++;
            }
        }
//        System.out.println(countPrimo);
    }

    private static void countPrimo(int inicio, int fim, int qtdThreads) {
        int itensPorThread = 1;

        List<Thread> threadList = new ArrayList<Thread>();
        ThreadGroup group = new ThreadGroup("ThreadGroup Busca");

        for (int i = 0; i < qtdThreads; i++) {
            threadList.add(new Thread("T" + i));
            inicio = ++fim;
            fim += itensPorThread;
        Runnable runnable = new Atividade1(inicio, fim);
            threadList.add(new Thread(group, runnable, "T" + i));
            inicio = ++fim;
            fim += itensPorThread;
        }
        

        start(threadList);
    }

    private static void start(List<Thread> threads) {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    public static void main(String[] args) {
        final int QTD_THREADS = 2;
        final int INICIO = 0;
        final int FIM = 10;
        
        countPrimo(INICIO, FIM, QTD_THREADS);
    }

}
