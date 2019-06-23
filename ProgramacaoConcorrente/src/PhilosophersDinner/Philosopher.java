/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

 */

package PhilosophersDinner;

class Philosopher implements Runnable {
    int id = 0;
    Resource fork = null;
    
    public Philosopher(int initId, Resource initr) {
        id = initId;
        fork = initr;
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Phil " + id + " thinking");
                Thread.sleep(3000);
                System.out.println("Phil " + id + " hungry");
                fork.pickup(id);
                System.out.println("Phil " + id + " eating");
                Thread.sleep(4000);
                fork.drop(id);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
