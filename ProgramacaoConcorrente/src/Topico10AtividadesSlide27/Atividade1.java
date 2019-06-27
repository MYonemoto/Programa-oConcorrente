/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

    Atividade 1.  Fa¸ca um programa que localize o maior valor em um vetor. Divida o
programa em tarefas que localizam o maior valor em um segmento do vetor. 
O programa deve possibilitar especificar o n´umero de tarefas e o n´umero de 
threads para resolver o problema

 */
package Topico10AtividadesSlide27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Atividade1 {

    Object[] array;

    public Atividade1(Object[] array) {
        this.array = array;
    }

    private static Object[] getArray(int totalElementos) {
        List<Integer> lista = new ArrayList<Integer>();
        for (int i = 0; i < totalElementos; i++) {
            Integer num = i;
            lista.add(num);
        }

        return lista.toArray();
    }

    public static List<int[]> arrayDivision(Object[] array, int qtdThreads) {

        List<int[]> divisions = new ArrayList<>();

        int currentPos = 0;
        int qtdDivisions = 1;
        int itensPorThread = (int) Math.ceil((double) array.length / qtdThreads);

        while (currentPos < array.length) {
            int intervalo[] = new int[itensPorThread];
            intervalo[0] = currentPos;
            currentPos += itensPorThread;

            if (qtdDivisions == qtdThreads) {
                intervalo[1] = array.length - 1;
                divisions.add(intervalo);
                break;
            } else {
                intervalo[1] = currentPos - 1;
                divisions.add(intervalo);
                qtdDivisions++;
            }
        }

        return divisions;
    }

    public static void main(String[] args) {

        Object[] array = getArray(20);

        List<int[]> intervalos = arrayDivision(array, 4);

        ExecutorService es = Executors.newFixedThreadPool(4);

        List<Future<Integer>> future = new ArrayList<>();

        for (int i = 0; i < intervalos.size(); i++) {
            TaskAtividade1 tk = new TaskAtividade1(array, intervalos.get(i)[0], intervalos.get(i)[1]);

            Future<Integer> f = es.submit(tk);
            future.add(f);
        }
        es.shutdown();
        System.out.println(Arrays.toString(array));
        try {
            int maiorValor = future.get(0).get();
            for (int i = 1; i < future.size(); i++) {
                int valor = future.get(i).get();
                if (valor > maiorValor) {
                    maiorValor = valor;
                }
            }
            System.out.println("Maior valor: " + maiorValor);
        } catch (InterruptedException ex) {
            Logger.getLogger(Atividade1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(Atividade1.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
