/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

 */
package Topico10AtividadesSlide27;

import java.util.concurrent.Callable;

public class TaskAtividade1 implements Callable {

    Object[] array;
    int init;
    int end;

    public TaskAtividade1(Object[] array, int init, int end) {
        this.array = array;
        this.init = init;
        this.end = end;
    }

    @Override
    public Object call() throws Exception {
        int maiorValor = (int) this.array[init];
        for (int i = this.init + 1; i <= this.end; i++) {
            if ((int) this.array[i] > maiorValor) {
                maiorValor = (int) array[i];
            }
        }
        return maiorValor;
    }

}
