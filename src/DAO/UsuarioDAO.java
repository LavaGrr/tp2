/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.UsuarioException;
import Model.Anuncio;
import Model.ManipuladorArquivo;
import Model.Usuario;


import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public class UsuarioDAO {

    public boolean verificaLogin(Usuario dados) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("src/cadastro.txt");
        BufferedReader br = new BufferedReader(fr);
        String linha = br.readLine();
        
        while(linha!=null){
         
            Usuario usuario = getUsuario(linha);
            
            if((usuario.getNome().equals(dados.getNome())||usuario.getNome().equals(dados.getEmail()))&& usuario.getSenha().equals(dados.getSenha())){               
                return true;
            }
            linha = br.readLine(); 
        }
        br.close();
    return false;
    }

    private ManipuladorArquivo ma = new ManipuladorArquivo();
    
    
    public boolean seExiste(Usuario u) throws FileNotFoundException, IOException{
        FileReader fr = new FileReader("src/cadastro.txt");
        BufferedReader br = new BufferedReader(fr);
        String linha = br.readLine();
        
        while (linha != null) {
        	Usuario usuario = this.getUsuario(linha);
        	if(usuario.getNome().equals(u.getNome())||usuario.getEmail().equals(u.getEmail()) ) {
        		br.close();
        		return true;
        	}
        	linha = br.readLine();
        	

        	}
        	br.close();
       
        return false;
    }
    public void cadastrar(Usuario u) throws IOException {
        ManipuladorArquivo ma = new ManipuladorArquivo();
        ma.escrever("src/cadastro.txt", u.getNome() + ";" + u.getEmail() + ";" + u.getSenha());
       
    }
    
    public Usuario getUsuario(String linha) {
		String vetor[] = linha.split(";");		
		Usuario u = new Usuario(vetor[0]);
		u.setEmail(vetor[1]);
		u.setSenha(vetor[2]);
		return u;
	}
    
    public Usuario getUsuario(Usuario u) throws IOException {    	
    	 FileReader fr = new FileReader("src/cadastro.txt");
         BufferedReader br = new BufferedReader(fr);
         String linha = br.readLine();
         
         while (linha != null) {
         	Usuario usuario = this.getUsuario(linha);
         	if(usuario.getNome().equals(u.getNome())||usuario.getEmail().equals(u.getEmail()) ) {
         		br.close();
         		return usuario;
         	}
         	linha = br.readLine();
         	

         	}
         	br.close();
         	return null;
    }
    
    
}
