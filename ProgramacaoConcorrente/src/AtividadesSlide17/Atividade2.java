/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AtividadesSlide17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author Mateu
 */
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
            new Thread( () -> linhas.forEach(i->{
                System.out.println(i);
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Atividade2.class.getName()).log(Level.SEVERE, null, ex);
                }
        })).start();
	}
        
        public static void main(String[] args) {
            Thread thread = new Thread(new Atividade2());
            thread.start();
    }
	
}
