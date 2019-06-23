/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

 */
package PhilosophersDinner;

import java.util.concurrent.Semaphore;

class PhilosopherDinningAssimetrico implements Resource {

    int n = 0;
    Semaphore[] fork = null;

    public PhilosopherDinningAssimetrico(int initN) {
        n = initN;
        fork = new Semaphore[n];
        for (int i = 0; i < n; i++) {
            fork[i] = new Semaphore(1);
        }
    }

    @Override
    public void pickup(int i) {
        try {
            if (i == n - 1) {
                fork[(i + 1) % n].acquire();
                fork[i].acquire();
            } else {
                fork[i].acquire();
                fork[(i + 1) % n].acquire();
            }

        } catch (InterruptedException ex) {
        }
    }

    @Override
    public void drop(int i) {
        fork[i].release();
        fork[(i + 1) % n].release();
    }

    public static void main(String[] args) {
        PhilosopherDinningAssimetrico philosopher = new PhilosopherDinningAssimetrico(5);
        for (int i = 0; i < 5; i++) {
            new Thread(new Philosopher(i, philosopher)).start();
        }
    }

}
