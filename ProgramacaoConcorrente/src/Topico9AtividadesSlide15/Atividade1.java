/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

    Atividade 1. Fa¸ca um programa usando Lock para simular a atualiza¸c˜ao de
um contador que ´e acessado por m´ultiplas threads. O contador pode diminuir e aumentar.
 */
package Topico9AtividadesSlide15;

import java.util.concurrent.locks.ReentrantLock;

public class Atividade1 {
    
    int count;
    ReentrantLock lock;
    
    public Atividade1(){
        this.count = 0;
        this.lock = new ReentrantLock();
    }
    
    public void IncDec(int n){
        this.lock.lock();
        try {
            if(n == 1){
                this.count++;
            } else {
                this.count--;
            }
        } finally {
            this.lock.unlock();
        }
    }
    
    public void print(){
        System.out.println("Value: " + count);
    }
    
    public void init(){
        ThreadAtv1 t1 = new ThreadAtv1(this, 1);
        ThreadAtv1 t2 = new ThreadAtv1(this, 2);
        
        t1.start();
        t2.start();
    }
    
    public static void main(String[] args) {
        Atividade1 atv1 = new Atividade1();
        atv1.init();
    }
}
