/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

 */
package Topico07Semaforos;

public class ThreadIncAtv3 extends Thread{
    
    Atividade3 atv3;
    String name;
    
    public ThreadIncAtv3(Atividade3 atv3, String name){
        this.atv3 = atv3;
        this.name = name;
    }
    
    @Override
    public void run(){
        while(true){
            atv3.increment(name);
        }
    }
    
}
