/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

 */
package Topico07Semaforos;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadAtv7F2 extends Thread {
    
    Atividade7 atv7;
    String msg;
    
    public ThreadAtv7F2(Atividade7 atv7, String msg){
        this.atv7 = atv7;
        this. msg = msg;
    }
    
    @Override
    public void run(){
        while(true){
            atv7.Sem02(msg);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadAtv7F1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
