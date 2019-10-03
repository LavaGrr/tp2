package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import DAO.ConversaDAO;
import Model.Conversa;
import Model.Mensagem;
import Model.Usuario;

public class TelaConversa extends JFrame{
	private Usuario usuario;
	public TelaConversa(Usuario usuario,Conversa conversa) {
		super();
		  this.setSize(300,400);
		  Usuario u2;
		  if(conversa.getUsuarios()[0].getNome().equals(usuario.getNome())){
			  u2 = conversa.getUsuarios()[1];
		  } else {
			  u2 = conversa.getUsuarios()[0];
		  }
		  this.setTitle("Conversa com "+u2.getNome());
		JPanel principal = new JPanel(new GridBagLayout());
		ArrayList<Mensagem> mensagens = conversa.getMensagens();
		 GridBagConstraints c = new GridBagConstraints();
	    c.insets = new Insets(2, 2, 0, 0);
	    int i;
		for(i=0;i<mensagens.size();i++) {
			Mensagem msg = mensagens.get(i);
			c.gridy = i + 1;
			c.gridx = 1;
			c.gridwidth = 1;
			String remetente = msg.getRemetente().getNome();
			if(remetente.equals(usuario.getNome())){
				remetente = "Você";
			}
			JLabel nome = new JLabel(remetente + ": ");
			principal.add(nome,c);
			c.gridwidth = 2;
			c.gridx = 2;
			JEditorPane texto = new JEditorPane();
			texto.setText(msg.getMensagem());
			texto.setEditable(false);
			principal.add(texto,c);
			
		}
		JPanel painel = new JPanel(new GridBagLayout());
		 c.insets = new Insets(7, 5, 7, 0);
		c.gridwidth = 1;
		c.gridx = 1;
		JEditorPane txtMsg = new JEditorPane();
		painel.add(txtMsg,c);
		JButton enviar = new JButton("Enviar");
		c.gridx = 3;
		c.gridwidth = 1;
		painel.add(enviar,c);
		this.add(painel, BorderLayout.AFTER_LAST_LINE);
		JScrollPane scroll = new JScrollPane(principal);
	    this.add(scroll);
	    enviar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            	
                Mensagem msg = new Mensagem(txtMsg.getText());
                msg.setDestinatario(u2);
                msg.setRemetente(usuario);
                Conversa cv = new Conversa(msg);
                
                ConversaDAO cDAO = new ConversaDAO();
                try {
                	
                		
                	cDAO.salvarConversa(cv);
                	TelaConversa tela = new TelaConversa(usuario,cDAO.atualizarConversa(conversa));
                	tela.setVisible(true);
                	dispose();
               
                } catch (IOException ex){
                    System.out.println(ex.getMessage());
                }
            }
            
        });
	   
	}
	
}
