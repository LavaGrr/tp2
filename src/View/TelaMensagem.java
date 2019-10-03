/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.ConversaDAO;
import Model.Conversa;
import Model.Mensagem;
import Model.Usuario;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

/**
 *
 * @author aluno
 */
public class TelaMensagem extends JFrame{
    private Usuario usuario;
    
    public TelaMensagem(Usuario usuario){
        super();
        
        this.setTitle("Mensagens");
        this.setSize(300,400);
        this.usuario = usuario;
       
        JPanel conversas = new JPanel(new GridBagLayout());
        ConversaDAO cDAO = new ConversaDAO();
        ArrayList<Conversa> ArrayConversa = cDAO.getConversasUsuario(usuario);
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.insets = new Insets(2, 2, 0, 0);
        constraint.gridx = 1;
        for(int i=0;i<ArrayConversa.size();i++) {
        		constraint.gridy = i+1;
        		Conversa cv = ArrayConversa.get(i); 
        		conversas.add(colocarMensagem(cv),constraint);
        	
        }
        JScrollPane scroll = new JScrollPane(conversas);
        this.add(scroll);
        
        
        
        
    }
    
    public JPanel colocarMensagem(Conversa cv){
       
        Usuario[] u = cv.getUsuarios();
        Usuario amigao = usuario;
       
        if(u[0].getNome().equals(usuario.getNome())){
            amigao = u[1];
        } else {
            amigao = u[0];
        }
        
        GridBagConstraints c = new GridBagConstraints();
    	c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 2, 0, 0);
       
    	JPanel mensagem = new JPanel(new GridBagLayout());
        mensagem.setBorder(new TitledBorder(amigao.getNome()));
        
       
        JEditorPane txtMensagem = new JEditorPane();
        ArrayList<Mensagem> msgs = cv.getMensagens();
       
        txtMensagem.setText(msgs.get(msgs.size() -1 ).getMensagem());
        txtMensagem.setEditable(false);
        c.gridx = 1;
        c.gridy = 1;       
        mensagem.add(txtMensagem,c);
        
        JButton responder = new JButton("Responder");       
        c.gridy = 2; 
        mensagem.add(responder, c);
        
        responder.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaConversa tela = new TelaConversa(usuario,cv);
                tela.setVisible(true);
                dispose();
            }
            
        });
        return mensagem;
    } 
    
}
