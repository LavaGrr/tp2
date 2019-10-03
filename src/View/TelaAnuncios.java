/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Anuncio;
import DAO.AnuncioDAO;
import Model.Ordenavel;
import Model.Usuario;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 *
 * @author luiza
 */
public class TelaAnuncios extends JFrame {
        
        private final ArrayList<Anuncio> anuncios = new ArrayList<>();
	private JFrame principal;
	private Usuario usuario;
        public TelaAnuncios(Usuario usuario, ArrayList<Anuncio> anuncios) {
        super();
        this.usuario = usuario;
        
        this.setTitle("CLIENTE - Lista de Anuncios");
        //configurações janela
        this.setSize(300, 400);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if(anuncios == null){
            try{
                ArrayList<Anuncio> a = AnuncioDAO.criarLista();
                for(int i=0;i<a.size();i++){
                    this.anuncios.add(a.get(i));
                }
            }catch(FileNotFoundException e){
                System.out.println(e.getMessage());
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        } else {
            for(int i=0;i<anuncios.size();i++){
                this.anuncios.add(anuncios.get(i));
            }
        }

        //panel cabecalho
        JPanel panTop = new JPanel();
        //botoes
        JButton postAnuncio = new JButton("Anunciar!");
        panTop.add(postAnuncio);
        //muda tamanho botao
        postAnuncio.setPreferredSize(new Dimension(100, 30));
        JButton meuPerfil = new JButton("Perfil");
        panTop.add(meuPerfil);

        //panel rodape
        JPanel panBot = new JPanel();
        //panel principal
        JPanel principal = new JPanel();
        principal.setLayout(new GridBagLayout());

        //botoes
        JButton ordenar = new JButton("Ordenar Anunciozitos");
        panBot.add(ordenar);
        JButton sair = new JButton("Sair");
        panBot.add(sair);

        //panel anuncios       
        
        GridBagConstraints constraintAnuncios = new GridBagConstraints();
        constraintAnuncios.insets = new Insets(2, 2, 0, 0);

        for (int i = 0; i < this.anuncios.size(); i++) {
            constraintAnuncios.gridy = i + 1;
            principal.add(colocarAnuncio(this.anuncios.get(i)), constraintAnuncios);
            
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
            	dispose();
                JFrame postFrame = new TelaPost(usuario);
                postFrame.setVisible(true);

            }

        });
        ordenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Ordenavel ordenavel = new Ordenavel();
                JFrame telaAnuncios = new TelaAnuncios(usuario, ordenavel.ordenar(getAnuncios()));
                telaAnuncios.setVisible(true);
               
                
                
            }
        });
        meuPerfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame pframe = new TelaPerfil(usuario);
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
        
        JLabel nome = new JLabel(a.getUsuario().getNome());
        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 1;
        anuncio.add(nome, c);
        
        JButton responder = new JButton("Responder");
        c.gridx = 2;
        c.gridwidth = 2;
        if(!usuario.getNome().equals(a.getUsuario().getNome())) {
        	anuncio.add(responder, c);
        }
        responder.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaResponder tela = new TelaResponder(usuario,a.getUsuario());
                tela.setVisible(true);
                
                
            }
            
        });
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
    public ArrayList<Anuncio> getAnuncios(){
        return this.anuncios;
    }
}
