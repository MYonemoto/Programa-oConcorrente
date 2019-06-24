/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

 */
package Topico07Semaforos;

public class ThreadAtv4 extends Thread{
    
    Atividade4 atv4;
    String name;
    
    public ThreadAtv4(Atividade4 atv4, String name){
        this.atv4 = atv4;
        this.name = name;
    }
    
    @Override
    public void run(){
        while(true){
            atv4.verification(name);
        }
    }
    
}
