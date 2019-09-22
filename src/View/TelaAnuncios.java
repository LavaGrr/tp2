/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Anuncio;
import Model.Usuario;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author luiza
 */
public class TelaAnuncios extends JFrame {

	private JFrame principal;

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
        a.setDescricao("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        a.setPreco(800);


        GridBagConstraints constraintAnuncios = new GridBagConstraints();
        constraintAnuncios.insets = new Insets(2, 2, 0, 0);

        for (int i = 0; i < 56; i++) {
        	 constraintAnuncios.gridy = i + 1;
             principal.add(colocarAnuncio(a), constraintAnuncios);

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
        for(int i = 1;i<=(a.getDescricao().length()-1)/13;i++) {
        	 txtDaDescricao = quebraDeLinha(txtDaDescricao,(i*13)+(i-1));
        }
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

        JLabel nome = new JLabel(a.getUsuario().getNome());
        c.gridx = 3;
        c.gridy = 3;
        c.gridwidth = 3;
        anuncio.add(nome, c);


        return anuncio;
    }

    public String quebraDeLinha(String texto,int index) {
    	char[] txt = texto.toCharArray();
    	char[] resultado = new char[txt.length + 2];
    	
		System.arraycopy(txt, 0, resultado, 0, index);
		resultado[index] = '-';
		System.arraycopy(txt, index, resultado, index + 1, txt.length - index);
		
		
    	
		return new String(resultado);
    }
}
