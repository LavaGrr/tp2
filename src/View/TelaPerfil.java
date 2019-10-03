/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.AnuncioDAO;
import Model.Anuncio;
import Model.Ordenavel;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

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
            uAnuncios = AnuncioDAO.anunciosUsuario(this.usuario);
            Ordenavel ordenavel = new Ordenavel();
            ordenavel.ordenar(uAnuncios);
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
      
        JPanel anuncios = new JPanel(new GridBagLayout());
        
        
        GridBagConstraints constraintAnuncios = new GridBagConstraints();
        constraintAnuncios.insets = new Insets(2, 2, 0, 0);

        for (int i = 0; i < this.uAnuncios.size(); i++) {
        	anuncios.add(this.colocarAnuncio(uAnuncios.get(i)),constraintAnuncios);
            constraintAnuncios.gridy = i + 1;
            
           

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
        mensagens.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    TelaMensagem tela = new TelaMensagem(usuario);
                    tela.setVisible(true);
                }
            
        });
        
        JScrollPane scroll = new JScrollPane(anuncios);
        this.add(scroll);
        
        this.add(panBot, BorderLayout.AFTER_LAST_LINE);
        this.add(panTop, BorderLayout.BEFORE_FIRST_LINE);
    }
    
    public JPanel colocarAnuncio(Anuncio a) {
    	GridBagConstraints c = new GridBagConstraints();
    	c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 9, 0, 9);

        GridBagConstraints constraintAnuncios = new GridBagConstraints();
        constraintAnuncios.insets = new Insets(2, 2, 0, 0);

    	JPanel anuncio = new JPanel(new GridBagLayout());
        anuncio.setBorder(new TitledBorder(a.getTitulo()));
        JEditorPane txtDesc = new JEditorPane();
     
        String txtDaDescricao = a.getDescricao();
        txtDesc.setText(txtDaDescricao);
        //txtDesc.setRows(((int)txtDesc.getPreferredSize().getWidth())/txtDesc.getText().length);


        txtDesc.setEditable(false);
        JLabel descricao = new JLabel("Descricao: ");

        JLabel preco = new JLabel("Preço:");
        JTextArea txtPrec = new JTextArea();

        txtPrec.setText("RS:" + a.getPreco());
        txtPrec.setEditable(false);
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;

        anuncio.add(descricao, c);

        c.gridx = 2;
        c.gridwidth = 2;
        
        anuncio.add(txtDesc, c);

        c.gridy = 2;
        anuncio.add(txtPrec, c);
        c.gridx = 1;
        c.gridwidth = 1;
        anuncio.add(preco, c);
        
        c.gridy = 3;
        JLabel data = new JLabel("Data:");
        anuncio.add(data, c);
        c.gridx = 2;
        JTextArea txtData = new JTextArea();
        txtData.setText(a.getData());
        c.gridwidth = 2;
        anuncio.add(txtData, c);
        
       
        
        JButton deletar = new JButton("Deletar");
        c.gridy = 4;
        c.gridx = 2;
       
        anuncio.add(deletar, c);
        
        deletar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               
                
                
            }
            
        });
        return anuncio;
    }
    
}
