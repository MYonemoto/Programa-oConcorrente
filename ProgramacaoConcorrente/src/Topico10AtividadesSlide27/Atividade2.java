/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

    Atividade 2.  Faça um programa que calcule a soma dos elementos de uma matriz
MxN. Divida o programa em tarefas que somam as linhas. O programa
deve possibilitar especificar o número de threads para resolver o problema.

 */
package Topico10AtividadesSlide27;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Atividade2 implements Runnable {
    
    int matrizA[][];
    int matrizB[][];
    int matrizResult[][];
    int linha;
    
    public Atividade2(int matrizA[][], int matrizB[][], int matrizResult[][], int linha){
        this.matrizA = matrizA;
        this.matrizB = matrizB;
        this.matrizResult = matrizResult;
        this.linha = linha;
    }
    
    private static int[][] matrizGenerator(int linha, int coluna){
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
        int coluna = matrizA[0].length;
        for (int i = 0; i < coluna; i++) {
            matrizResult[linha][i] = matrizA[linha][i] + matrizB[linha][i];
        }
    }
    
    public static void main(String[] args) {
        
        int n = 3;
        
        int[][] matrizA = matrizGenerator(3, 3);
        int[][] matrizB = matrizGenerator(3, 3);
        
        int[][] matriz = new int[3][3];
        
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
            Atividade2 atv2 = new Atividade2(matrizA, matrizB, matriz, i);
            es.execute(atv2);
        }
        es.shutdown();
        
        System.out.println("Matriz Resultante:");
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(matriz[i]));
        }
    }
    
}
