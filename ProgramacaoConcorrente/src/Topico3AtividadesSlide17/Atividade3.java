/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

    Atividade 3. Faça um programa Java que envia interrupções para as
threads dos exercícios anteriores. As threads devem fazer o
tratamento dessas interrup¸c˜oes e realizar uma finalização
limpa.

 */
package Topico3AtividadesSlide17;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Atividade3 extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            System.out.println("era pra estar interrompendo");
            Logger.getLogger(Atividade3.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Atividade2());
        thread.start();
        thread.interrupt();
    }
}
