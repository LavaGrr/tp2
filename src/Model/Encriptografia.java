/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author aluno
 */
public class Encriptografia {
    
    protected static String encriptografar(String s) {
        char[] chave = s.toCharArray();
        for(int i=0; i<(chave.length)/2; i++){
            char aux = chave[chave.length-1-i];
            chave[chave.length-1-i] = (char) (chave[i]+6);
            chave[i] =(char)(aux-6);                      
            
        }
        
        return new String(chave);
    }
}
