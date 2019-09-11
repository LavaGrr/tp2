/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.Interface;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author luiza
 */
public class TelaPost implements Tela {
    private JFrame postFrame;
    
    @Override
    public JFrame montaJanela() {
        this.postFrame = new JFrame("CLIENTE - anunciar");
         
       postFrame.setSize(300,150);
       postFrame.setLayout(new FlowLayout());
       postFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       JPanel panBot = new JPanel();
       //botoes
        JButton sair = new JButton("Sair");
        panBot.add(sair);
        sair.addActionListener(new ActionListener(){
            //sai do frame
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame aframe = new TelaAnuncios().montaJanela();
                aframe.setVisible(true);
                postFrame.dispose();
            }         
        });
       
        postFrame.add(panBot, BorderLayout.AFTER_LAST_LINE);
        
        return postFrame;
   
    }

}
