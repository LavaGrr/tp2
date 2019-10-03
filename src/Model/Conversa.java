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
    public ArrayList<Mensagem> mensagens;
    public Usuario[] usuarios = new Usuario[2];

    public Conversa(Mensagem mensagem){
        this.mensagens = new ArrayList<>();
        mensagens.add(mensagem);
        usuarios[0] = mensagem.getDestinatario();
        usuarios[1] = mensagem.getRemetente();
    }
	
	public Conversa(ArrayList<Mensagem> mensagens) {
		this.mensagens = mensagens;
		if(mensagens.size()>0) {
			usuarios[0] = mensagens.get(0).getRemetente();
			usuarios[1] = mensagens.get(0).getDestinatario();
		}
	}
	public ArrayList<Mensagem> getMensagens() {
		return mensagens;
	}
	public void setMensagens(ArrayList<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}
	public void addMensagem(Mensagem m) {
		mensagens.add(m);
	}
	public Usuario[] getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(Usuario[] usuarios) {
		this.usuarios = usuarios;
	}
    
    
 }
