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
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author aluno
 */
public class TelaResponder extends JFrame {

    public TelaResponder(Usuario u1, Usuario u2) {
        super("");
        this.setSize(300, 120);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//panel para nome

        JPanel principal = new JPanel();
        principal.setBorder(new TitledBorder(u2.getNome()));
        JPanel panMsg = new JPanel();

        JEditorPane txtMsg = new JEditorPane();
        panMsg.add(txtMsg);

        JButton enviar = new JButton("Enviar");
        JPanel botoes = new JPanel();
        botoes.add(enviar);

        principal.add(panMsg);
        principal.add(botoes);
        this.add(principal);
        enviar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Mensagem msg = new Mensagem(txtMsg.getText());
                msg.setDestinatario(u2);
                msg.setRemetente(u1);
                
                Conversa cv = new Conversa(msg);
                ConversaDAO cDAO = new ConversaDAO();
                try {
                cDAO.salvarConversa(cv);
                } catch (IOException ex){
                    System.out.println(ex.getMessage());
                }
            }
            
        });
    }
}
