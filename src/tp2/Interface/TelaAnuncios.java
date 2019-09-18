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
public class TelaAnuncios implements Tela{
    JFrame aframe;
    @Override
    public JFrame montaJanela() {
        this.aframe = new JFrame("CLIENTE - Lista de Anuncios");
//configurações janela       
       aframe.setSize(300,400);
       //aframe.setLayout(new FlowLayout());
       aframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
       //panel cabecalho
       JPanel panTop = new JPanel();
       //botoes
       JButton postAnuncio = new JButton("Anunciar!");
       panTop.add(postAnuncio);
       //muda tamanho botao
       postAnuncio.setPreferredSize(new Dimension(100, 30));
       JButton meuPerfil = new JButton("Euzinhx");
       panTop.add(meuPerfil);
       
       //panel rodape
       JPanel panBot = new JPanel();
       //botoes
       JButton sair = new JButton("Sair");
       panBot.add(sair);
       JButton ordenar = new JButton("Ordenar Anunciozitos");
       panBot.add(ordenar);
       
       //panel anuncios
       JPanel anuncios = new JPanel();
       anuncios.setBorder(BorderFactory.createLineBorder(Color.black));
       
       
       //adicionando panels
       aframe.add(panTop, BorderLayout.BEFORE_FIRST_LINE);
       aframe.add(panBot, BorderLayout.AFTER_LAST_LINE);
       aframe.add(anuncios);
       //métodos
        postAnuncio.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame postFrame = new TelaPost().montaJanela();
                postFrame.setVisible(true);
                
                
            }
            
            
        });
        ordenar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "ordenado.");
            }      
        });
        meuPerfil.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame pframe = new TelaPerfil().montaJanela();
                pframe.setVisible(true);
                
                aframe.dispose();
            }
            
        });
        sair.addActionListener(new ActionListener(){
            //sai do frame
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame lframe = new TelaLogin().montaJanela();
                lframe.setVisible(true);
                aframe.dispose();
            }         
        });
       return aframe;
    }
    
    
}
