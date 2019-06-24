/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055
 */
package Topico08AtividadesSlide22;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Buffer buffer = new Buffer();
        
        //priorizando leitores
        Readers r1 = new Readers(buffer);
        Readers r2 = new Readers(buffer);
        Readers r3 = new Readers(buffer);

        int flag = 0;

        for (int i = 0; i < 10; i++) {
            r1.startRead();
            flag = 1;
            r2.startWrite();
            flag = 0;
            r3.startRead();
            flag = 1;

            if (flag == 1) {
                r1.endRead();
                r3.endRead();
            }

            r2.endWrite();

        }
        
        //priorizando escritores
//        Writers w1 = new Writers(buffer);
//        Writers w2 = new Writers(buffer);
//        Writers w3 = new Writers(buffer);
//
//        int flagW = 0;
//
//        for (int i = 0; i < 10; i++) {
//            w2.startWrite();
//            flagW = 1;
//            w1.startRead();
//            flagW = 0;
//            w3.startWrite();
//            flagW = 1;
//
//            if (flagW == 1) {
//                w1.endWrite();
//                w3.endWrite();
//            }
//
//            w2.endRead();
//
//        }
    }
}
