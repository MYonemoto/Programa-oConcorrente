/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055
 */
package Topico08AtividadesSlide22;

public class Buffer {
    private int buffer = 0;
    
    public void set(int setter){
        this.buffer = setter;
    }
    
    public void print(){
        System.out.println(buffer);
    }
}
