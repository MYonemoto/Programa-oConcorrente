/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

 */
package Topico7Semaforos;

public class TrechoAtv2 extends Thread {

    Atividade2 atv2;
    String name;
    int trecho;

    public TrechoAtv2(Atividade2 atv2, String name) {
        this.atv2 = atv2;
        this.trecho = 0;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            this.trecho += 1;
            atv2.trecho("Trecho" + this.name + "." + this.trecho);
        }
    }

}