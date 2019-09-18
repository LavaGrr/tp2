/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Classes.Anuncio;
import Classes.Usuario;
import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author luiza
 */
public class TelaPost extends JFrame {

    public TelaPost() {
        super();
        this.setTitle("CLIENTE - anunciar");

        this.setSize(300, 170);
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //panel anuncio      
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 0, 0);

        GridBagConstraints constraintAnuncios = new GridBagConstraints();
        constraintAnuncios.insets = new Insets(5, 5, 0, 0);

        JPanel anuncio = new JPanel(new GridBagLayout());
        anuncio.setBorder(new TitledBorder("Cadastrar Anuncio"));
        JTextField txtTitulo = new JTextField(15);
        JLabel titulo = new JLabel("Titulo");
        
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        
        anuncio.add(titulo, c);
        c.gridx = 2;
        c.gridwidth = 2;
        
        anuncio.add(txtTitulo, c);
        
        JTextField txtDesc = new JTextField(15);      
        JLabel descricao = new JLabel("Descricao: ");

        JLabel preco = new JLabel("Preço:");
        JTextField txtPrec = new JTextField(15);
       
        c.gridx = 1;
        c.gridwidth = 1;
        c.gridy = 1;       

        anuncio.add(descricao, c);

        c.gridx = 2;
        c.gridwidth = 2;

        anuncio.add(txtDesc, c);

        c.gridy = 2;
        anuncio.add(txtPrec, c);
        c.gridx = 1;
        c.gridwidth = 1;
        anuncio.add(preco, c);


        //panBot
        JPanel panBot = new JPanel();
        //botoes
        JButton sair = new JButton("Sair");
        panBot.add(sair);
        sair.addActionListener(new ActionListener() {
            //sai do frame
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame aframe = new TelaAnuncios();
                aframe.setVisible(true);
                dispose();
            }
        });
        this.add(anuncio);
        this.add(panBot, BorderLayout.AFTER_LAST_LINE);

    }

}
