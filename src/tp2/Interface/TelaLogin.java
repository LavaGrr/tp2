/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.Interface;

import Classes.*;
import Classes.UsuarioDAO;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author luiza
 */
public class TelaLogin implements Tela{
    private JFrame lframe;

    @Override
    public JFrame montaJanela() {
       this.lframe = new JFrame("CLIENTE - inicio"); 
       
       lframe.setSize(300,150);
       lframe.setLayout(new FlowLayout());
       lframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//panel para nome
       JPanel panName = new JPanel();
       panName.add(new JLabel("Nome:"));
       JTextField txtName = new JTextField(15);
       panName.add(txtName);
//panel para senha
       JPanel panPass = new JPanel();
       //panPass.setLayout(new FlowLayout());
       panPass.add(new JLabel("Senha:"));
       JTextField txtPass = new JTextField(15);
       panPass.add(txtPass);
//botao login e cadastro
       JButton login = new JButton("Login");
       JButton cadastro = new JButton("Cadastro"); 
//adicionando os panels
       lframe.add(panName);
       lframe.add(panPass);
//adicionando botao
       lframe.add(login);
       lframe.add(cadastro);
       lframe.setVisible(true);
//metodos botoes
       //LOGIN
       login.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuario dados = new Usuario(txtName.getText());
                dados.setSenha(txtPass.getText());
                
                try {
                    if(UsuarioDAO.verificaLogin(dados)==true){
                        JFrame telaAnuncios = new TelaAnuncios().montaJanela();
                        telaAnuncios.setVisible(true);
                        JOptionPane.showMessageDialog(null, "Bem Vindo, " + dados.getNome());
                    } else{
                        JOptionPane.showMessageDialog(null, "Login Invalido", "FAIOU", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
                lframe.dispose();
            }
           
       });
       //CADASTRO
       cadastro.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               JFrame telaCadastro = new TelaCadastro().montaJanela();
               telaCadastro.setVisible(true);
               //fecha o lframe
               lframe.dispose();             
           }
           
       });

       return lframe;
    }
  
        
}        
    

