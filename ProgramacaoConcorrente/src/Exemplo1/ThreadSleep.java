/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exemplo1;

/**
 *
 * @author Mateu
 */
public class ThreadSleep {
    public static void createThread(int valor) throws InterruptedException{
        for (int i = 1; i <= valor; i++) {
            new Thread( () -> {
            System.out.println("Hello from the thread");
        }).start();
            Thread.sleep(500);
        }
    }
    public static void main(String[] args) throws InterruptedException {
        createThread(4);
    }
}
