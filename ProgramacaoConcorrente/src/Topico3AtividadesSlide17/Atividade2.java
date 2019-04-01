/*
Programação Concorrente
Aluno: Mateus Tomoo Yonemoto Peixoto
RA: 1602055

    Atividade 2. Faça uma thread Java que realize a leitura de um arquivo
texto com frases e exiba as frases a cada 10 segundos.

 */
package Topico3AtividadesSlide17;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Atividade2 implements Runnable {

    public Stream<String> linhas;

    @Override
    public void run() {
        Path caminho = Paths.get("C:\\Users\\Mateu\\Desktop\\UTFPR-BCC\\Programação Concorrente\\text.txt");
        try {
            linhas = Files.lines(caminho);
        } catch (IOException ex) {
            Logger.getLogger(Atividade2.class.getName()).log(Level.SEVERE, null, ex);
        }
        linhas.forEach((i) -> {
            System.out.println(i);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Atividade2.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Atividade2());
        thread.start();
    }

}
