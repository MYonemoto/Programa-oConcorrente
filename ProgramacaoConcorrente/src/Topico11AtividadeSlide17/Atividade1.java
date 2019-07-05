/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

    Atividade 1. Fa¸ca um programa usando Threads e ConcurrentMap para
calcular a frequˆencia de cada letra em um texto.

 */
package Topico11AtividadeSlide17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

public class Atividade1 {

    BufferedReader br = null;
    FileReader fr = null;

    public ConcurrentHashMap<String, Integer> readFile(String fileName) throws IOException, InterruptedException {
        
        ConcurrentHashMap<String, Integer> myMap = new ConcurrentHashMap<>();
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        int linhas = 0;
        String data = "";
        int nThreads = 0;
        
        while (br.ready()) {
            
            data += br.readLine();
            linhas++;
            
            if (linhas >= 10) {
                nThreads++;
                Thread t = new Thread(new ThreadAtv(myMap, data));
                t.start();
                data = "";
                linhas = 0;
            }
        }
        
        Thread t = new Thread(new ThreadAtv(myMap, data));
        t.start();
        
        nThreads++;
        Thread.sleep(2000);
        
        System.out.println("Threads: " + nThreads);
        
        data = "";
        linhas = 0;
        
        return myMap;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        
        Atividade1 atv1 = new Atividade1();
        
        ConcurrentHashMap<String, Integer> map = atv1.readFile("C:\\Users\\Mateu\\Desktop\\UTFPR-BCC\\Programação Concorrente\\text.txt");
        Thread.sleep(5000);
        
        map.keySet().forEach((letra) -> {
            System.out.println(letra + ": " + map.get(letra));
        });
    }

}
