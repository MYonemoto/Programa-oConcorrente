/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

    Atividade 3.  Faça um programa concorrente para multiplicar duas matrizes

 */
package Topico10AtividadesSlide27;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Atividade3 implements Runnable {

    int matrizA[][];
    int matrizB[][];
    int matrizResult[][];

    public Atividade3(int matrizA[][], int matrizB[][], int matrizResult[][]) {
        this.matrizA = matrizA;
        this.matrizB = matrizB;
        this.matrizResult = matrizResult;
    }

    private static int[][] matrizGenerator(int linha, int coluna) {
        Random rnd = new Random();
        int[][] matriz = new int[linha][coluna];
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                matriz[i][j] = rnd.nextInt(10) + 1;
            }
        }
        return matriz;
    }

    @Override
    public void run() {

        if (matrizA[0].length != matrizB.length) {
            throw new RuntimeException("Dimensões inconsistentes. Impossível multiplicar as matrizes");
        }
        
        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizB[0].length; j++) {
                int aux = 0;
                for (int k = 0; k < matrizA[0].length; k++) {
                    aux += (matrizA[i][k] * matrizB[k][j]);
                    matrizResult[i][j] += aux;
                }
            }
        }

    }

    public static void main(String[] args) {

        int n = 3;

        int[][] matrizA = matrizGenerator(3, 3);
        int[][] matrizB = matrizGenerator(3, 3);

        int[][] matriz = new int[matrizA.length][matrizB[0].length];

        System.out.println("Matriz A:");
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(matrizA[i]));
        }

        System.out.println("Matriz B:");
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(matrizB[i]));
        }

        ExecutorService es = Executors.newFixedThreadPool(n);

        for (int i = 0; i < n; i++) {
            Atividade3 atv3 = new Atividade3(matrizA, matrizB, matriz);
            es.execute(atv3);
        }
        es.shutdown();

        System.out.println("Matriz Resultante:");
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(matriz[i]));
        }
    }

}
