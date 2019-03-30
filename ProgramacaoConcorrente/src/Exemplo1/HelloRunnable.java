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



public class HelloRunnable{
    
    public static void main(String[] args) {
        new Thread( () -> {
            System.out.println("Hello from a thread. LAMBDA, LAMBDA.");
            System.out.println("My ID is: " + Thread.currentThread().getId());
        }).start();
    }
    
}