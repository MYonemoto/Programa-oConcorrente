/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

 */
package OneDimensionalStencil;

import java.util.Arrays;

public class Basic {

    public double[] oneDimensionalStencil(double array[]) {
        
        double copy[] = this.copyArray(array);
        int count = 0;
        
        while (verificationMiddlePosition(copy)) {
            for (int i = 1; i < array.length - 1; i++) {
                copy[i] = (array[i - 1] + array[i + 1]) / 2;
            }
            count++;
            
            for (int i = 1; i < array.length - 1; i++) {
                array[i] = copy[i];
            }
            
            System.out.println(count + " - " + Arrays.toString(array));
        }
        
        System.out.println("Quantidade de iteracoes: " + count);
        
        return copy;
    }

    public boolean verificationMiddlePosition(double array[]) {
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] - array[0] > 0.00000001) {
                return true;
            }
        }
        return false;
    }

    public double[] copyArray(double array[]) {
        double copy[] = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }
    
    public static void main(String[] args) {
        double array[] = new double[]{1, 2, 2, 1};

        Basic b = new Basic();
        System.out.println(Arrays.toString(array));
        double result[] = b.oneDimensionalStencil(array);
        for (double d : result) {
            System.out.println(d);
        }
    }

}
