/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

import Model.Usuario;

/**
 *
 * @author luiza
 */
public class TelaPerfil extends JFrame{
    private Usuario usuario;
    public TelaPerfil(Usuario usuario) {
    	this.usuario =usuario;
        this.setTitle("CLIENTE - perfil");
        
        this.setSize(300,400);
        //aframe.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panBot = new JPanel();
       //botoes
        JButton sair = new JButton("Sair");
        panBot.add(sair);
        sair.addActionListener(new ActionListener(){
            //sai do frame
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame aframe = new TelaAnuncios(usuario);
                aframe.setVisible(true);
                dispose();
            }         
        });
       
        this.add(panBot, BorderLayout.AFTER_LAST_LINE);
     
    }
    
}
