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
public class TelaAnuncios extends JFrame {

    public TelaAnuncios() {
        super();

        this.setTitle("CLIENTE - Lista de Anuncios");
        //configurações janela       
        this.setSize(300, 400);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
        //panel principal
        JPanel principal = new JPanel();
        principal.setLayout(new GridBagLayout());
        
        //botoes
        JButton sair = new JButton("Sair");
        panBot.add(sair);
        JButton ordenar = new JButton("Ordenar Anunciozitos");
        panBot.add(ordenar);

        //panel anuncios
        Anuncio a = new Anuncio();
        Usuario u = new Usuario("bebe");
        a.setUsuario(u);
        a.setTitulo("Barriga de Aluguel");
        a.setDescricao("quero uma barriga de aluguel");
        a.setPreco(800);

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 0, 0);
        
        GridBagConstraints constraintAnuncios = new GridBagConstraints();
        constraintAnuncios.insets = new Insets(5, 5, 0, 0);
        for (int i = 0; i < 56; i++) {
            JPanel anuncio = new JPanel(new GridBagLayout());
            anuncio.setBorder(new TitledBorder(a.getTitulo()));
            JTextArea txtDesc = new JTextArea();
            
            txtDesc.setText("asdasd");
            txtDesc.setEditable(false);
            JLabel descricao = new JLabel("Descricao: ");

            JLabel preco = new JLabel("Preço:");
            JTextField txtPrec = new JTextField("RS:" + a.getPreco(), 15);
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

            JLabel nome = new JLabel(a.getUsuario().getNome());
            c.gridx = 3;
            c.gridy = 3;
            c.gridwidth = 3;
            anuncio.add(nome, c);

            constraintAnuncios.gridy = i + 1;
            
            principal.add(anuncio, constraintAnuncios);

        }
        JScrollPane scroll = new JScrollPane(principal);
        this.add(scroll);
        //adicionando panels
        
        this.add(panTop, BorderLayout.BEFORE_FIRST_LINE);
        this.add(panBot, BorderLayout.AFTER_LAST_LINE);
        //métodos
        postAnuncio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame postFrame = new TelaPost();
                postFrame.setVisible(true);

            }

        });
        ordenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "ordenado.");
            }
        });
        meuPerfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame pframe = new TelaPerfil();
                pframe.setVisible(true);

                dispose();
            }

        });
        sair.addActionListener(new ActionListener() {
            //sai do frame
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame lframe = new TelaLogin();
                lframe.setVisible(true);
                dispose();
            }
        });

    }

}
