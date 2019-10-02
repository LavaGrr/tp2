/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Arrays;

/**
 *
 * @author Aluno
 */
public class Usuario {
    private String nome, senha, email;
    public int nivel;

    public Usuario(String nome){
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
       
      
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String encriptografar(String s) {
        char[] chave = s.toCharArray();
        for(int i=0; i<(chave.length)/2; i++){
            char aux = chave[chave.length-1-i];
            chave[chave.length-1-i] = (char) (chave[i]+6);
            chave[i] =(char)(aux-6);
            
            
            
        }
        
        return new String(chave);
    }
    
    
}
