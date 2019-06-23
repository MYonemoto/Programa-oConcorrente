/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

 */
package Topico9AtividadesSlide15;

public class ThreadAtv1 extends Thread {
    
    Atividade1 atv1;
    int n;
    
    public ThreadAtv1(Atividade1 atv1, int n){
        this.atv1 = atv1;
        this.n = n;
    }
    
    @Override
    public void run(){
        while(true){
            this.atv1.IncDec(n);
            this.atv1.print();
        }
    }
    
}
