/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class Conversa implements Serializable {
    public ArrayList<Mensagem> conversa;
    public Usuario[] usuarios = new Usuario[2];

    public Conversa(Mensagem mensagem){
        this.conversa = new ArrayList<>();
        conversa.add(mensagem);
        usuarios[0] = mensagem.getDestinatario();
        usuarios[1] = mensagem.getRemetente();
    }
    public Conversa(ArrayList<Mensagem> conversa){
        this.conversa = conversa;
        if(conversa.size()>0){
            usuarios[0] = conversa.get(0).getDestinatario();
            usuarios[1] = conversa.get(0).getRemetente();
            
        }
        
    }
    public ArrayList<Mensagem> getConversa() {
        return conversa;
    }

    public void setConversa(ArrayList<Mensagem> conversa) {
        this.conversa = conversa;
    }

    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario[] usuarios) {
        this.usuarios = usuarios;
    }
    
    
 }
