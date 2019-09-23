/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.*;

import java.awt.*;

import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author luiza
 */
public class TelaPost extends JFrame {
	private Usuario usuario;
    public TelaPost(Usuario usuario) {
        super();
        this.usuario = usuario;
        this.setTitle("CLIENTE - anunciar");

        this.setSize(350, 250);
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
        
        JLabel boxTitle = new JLabel("Escolha uma TAG:");
        c.gridy=3;
        anuncio.add(boxTitle, c);
        
        JComboBox comboBox = new JComboBox();
        comboBox.addItem("Alimentacao");
        comboBox.addItem("Utilidades");
        comboBox.addItem("Servicos");
        c.gridx = 2;
       
        anuncio.add(comboBox, c);
        
        //anuncio.add(boxTitle);
        //panBot
        JPanel panBot = new JPanel();
        //botoes
        JButton anunciar = new JButton("Anunciar!");
        JButton sair = new JButton("Sair");
        panBot.add(sair);
        panBot.add(anunciar);
        sair.addActionListener(new ActionListener() {
            //sai do frame
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame aframe = new TelaAnuncios(usuario);
                aframe.setVisible(true);
                dispose();
            }
        });
        anunciar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Anuncio a = new Anuncio();
                a.setTitulo(txtTitulo.getText());
                a.setDescricao(txtDesc.getText());
                try{
                a.setPreco(Double.parseDouble(txtPrec.getText()));

                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,"Campo de preço vazio.", "Erro!",JOptionPane.ERROR_MESSAGE);
                }
                //a.setUsuario(usuario);

                a.setUsuario(usuario);

                //a.setData(data);
                a.setTag(comboBox.getActionCommand());
                AnuncioDAO aDao = new AnuncioDAO();
                if(a.getTitulo().equals("")||a.getDescricao().equals("")){
                        JOptionPane.showMessageDialog(null,"Preencha todos os campos.", "Erro!",JOptionPane.ERROR_MESSAGE);
                }
                else{
                	try {
                    aDao.escrever(a);
                    JOptionPane.showMessageDialog(null,"Anuncio Cadastrado.", "Sucesso!",JOptionPane.INFORMATION_MESSAGE);
                	} catch (IOException ex){
                		 JOptionPane.showMessageDialog(null, "Erro", "Erro", JOptionPane.ERROR_MESSAGE);
                	}
                    
                }
                
                
                
            }
            
        });
        this.add(anuncio);
        this.add(panBot, BorderLayout.AFTER_LAST_LINE);

    }

}
