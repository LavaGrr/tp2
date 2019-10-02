/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.AnuncioDAO;
import Model.Anuncio;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;

import Model.Usuario;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author luiza
 */
public class TelaPerfil extends JFrame{
    private Usuario usuario;
    private ArrayList<Anuncio> uAnuncios;
    public TelaPerfil(Usuario usuario) {
    	this.usuario =usuario;
        this.setTitle("CLIENTE - perfil");
        try{
        uAnuncios = AnuncioDAO.criarLista();
        }catch(IOException e){
            System.out.println("fdc");
        }
        this.setSize(300,400);
        //aframe.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panBot = new JPanel();
       //botoes
        
        JButton mensagens = new JButton("Mensagens");  
        panBot.add(mensagens);
        JButton sair = new JButton("Sair");
        panBot.add(sair);
        
        GridBagConstraints c = new GridBagConstraints();
    	c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 9, 0, 9);
        
        JPanel panTop = new JPanel(new GridBagLayout());
        JLabel nome = new JLabel("Nome:");
        JLabel rank = new JLabel("Rank:");
        JLabel nomeUsuario = new JLabel(usuario.getNome());
        JLabel rankUsuario = new JLabel("****");
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        
        panTop.add(nome, c);
        c.gridx = 2;
        panTop.add(nomeUsuario, c);
        c.gridx = 1;
        c.gridy = 2;
        panTop.add(rank, c);
        c.gridx = 2;
        panTop.add(rankUsuario, c);
      
        JPanel anuncios = new JPanel();
        
        GridBagConstraints constraintAnuncios = new GridBagConstraints();
        constraintAnuncios.insets = new Insets(2, 2, 0, 0);

        for (int i = 0; i < this.uAnuncios.size(); i++) {
            constraintAnuncios.gridy = i + 1;
            TelaAnuncios telaAnuncio = new TelaAnuncios(usuario,null);
            anuncios.add(telaAnuncio.colocarAnuncio(this.uAnuncios.get(i)), constraintAnuncios);

        }
        
        sair.addActionListener(new ActionListener(){
            //sai do frame
            @Override
            public void actionPerformed(ActionEvent e) {
            
                JFrame aframe = new TelaAnuncios(usuario, null);
                aframe.setVisible(true);
                dispose();
            }         
        });
        this.add(anuncios);
        this.add(panBot, BorderLayout.AFTER_LAST_LINE);
        this.add(panTop, BorderLayout.BEFORE_FIRST_LINE);
    }
    
}
