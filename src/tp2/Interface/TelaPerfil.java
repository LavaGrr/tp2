/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.Interface;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author luiza
 */
public class TelaPerfil implements Tela{
    private JFrame pframe;
    
    @Override
    public JFrame montaJanela() {
        this.pframe = new JFrame("CLIENTE - perfil");
        
        pframe.setSize(300,400);
        //aframe.setLayout(new FlowLayout());
        pframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
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
                pframe.dispose();
            }         
        });
       
        pframe.add(panBot, BorderLayout.AFTER_LAST_LINE);
        return pframe;
    }
    
}
