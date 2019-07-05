/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

 */
package Topico11AtividadeSlide17;

import java.util.concurrent.ConcurrentHashMap;

public class ThreadAtv implements Runnable {

    ConcurrentHashMap<String, Integer> map;
    String text;

    public ThreadAtv(ConcurrentHashMap<String, Integer> map, String text) {
        this.map = map;
        this.text = text;
    }

    @Override
    public void run() {
        String split[] = text.split("");
        for (int i = 0; i < split.length; i++) {
            map.putIfAbsent(split[i], 0);
            map.compute(split[i], (k, v) -> v += 1);
        }
    }

}
