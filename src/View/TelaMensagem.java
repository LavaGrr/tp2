/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.ConversaDAO;
import Model.Conversa;
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
        
        JPanel conversas = new JPanel();
        ConversaDAO cDAO = new ConversaDAO();
        ArrayList<Conversa> ArrayConversa = cDAO.getConversas();
        System.out.println(ArrayConversa.size());
        this.add(conversas);
        
        
        
    }
    
    public JPanel colocarMensagem(Conversa cv){
        
        Usuario[] u = cv.getUsuarios();
        Usuario amigao;
        if(u[0].equals(usuario)){
            amigao = u[1];
        } else {
            amigao = u[0];
        }
       
        GridBagConstraints c = new GridBagConstraints();
    	c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 9, 0, 9);
       
    	JPanel mensagem = new JPanel(new GridBagLayout());
        mensagem.setBorder(new TitledBorder(amigao.getNome()));
        JEditorPane txtDesc = new JEditorPane();

        JTextArea txtMensagem = new JTextArea();
        txtMensagem.setEditable(false);
        c.gridx = 1;
        c.gridy = 1;       
        mensagem.add(txtMensagem);
        
        JButton responder = new JButton("Responder");       
       
        mensagem.add(responder, c);
        
        responder.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ainda nao funciona");
            }
            
        });
        return mensagem;
    } 
    
}
