/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

    Atividade 3. Faça um programa em Java com threads que exiba os
números primos entre 0 e 100000.
 */
package Topico03AtividadesSlide28;

import java.util.ArrayList;
import java.util.List;

public class Atividade3 implements Runnable {

    @Override
    public void run() {
        List<Integer> numeros = new ArrayList<Integer>();
        for (int i = 0; i <= 1000; i++) {
            numeros.add(i);
        }
        int contador;
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
                System.out.println("O Número: " + numero + " é primo e seus primos são: 1 e " + numero);
            }
        }
    }
    
    public static void main(String[] args) {
        Thread t = new Thread(new Atividade3());
        t.start();
    }
}
