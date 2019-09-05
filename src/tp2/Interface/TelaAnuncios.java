/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.Interface;


import java.awt.*;
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
       aframe.setLayout(new FlowLayout());
       aframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//botoes 
       JButton postAnuncio = new JButton("Anunciar!");
       JButton meuPerfil = new JButton("Euzinhx");
       //postAnuncio.setPreferredSize(new Dimension(100, 30));
       JButton ordenar = new JButton("Ordenar Anunciozitos");
       aframe.add(ordenar, BorderLayout.SOUTH);
       aframe.add(meuPerfil);
       aframe.add(postAnuncio);
       
       return aframe;
    }
    
    
}
