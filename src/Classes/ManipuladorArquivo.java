/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.*;


/**
 *
 * @author Aluno
 */
public class ManipuladorArquivo {
    public void escrever(String caminho,String linha) throws IOException{
        FileWriter fw = new FileWriter(caminho,true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(linha + "\r\n");
        bw.close();
    }
    
}
