/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Usuario;
import DAO.UsuarioDAO;
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
public class TelaLogin extends JFrame{
  
	Usuario usuario;
	
    public TelaLogin() {
       this.setTitle("CLIENTE - inicio"); 
       
       this.setSize(300,150);
       this.setLayout(new FlowLayout());
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//panel para nome
       JPanel panName = new JPanel();
       panName.add(new JLabel("Nome:"));
       JTextField txtName = new JTextField(15);
       panName.add(txtName);
//panel para senha
       JPanel panPass = new JPanel();
       //panPass.setLayout(new FlowLayout());
       panPass.add(new JLabel("Senha:"));
       JPasswordField txtPass = new JPasswordField(15);
       panPass.add(txtPass);
//botao login e cadastro
       JButton login = new JButton("Login");
       JButton cadastro = new JButton("Cadastro"); 
//adicionando os panels
       this.add(panName);
       this.add(panPass);
//adicionando botao
       JPanel botoes = new JPanel();
       
       botoes.add(login);
       botoes.add(cadastro);
       this.add(botoes);
       this.setVisible(true);
//metodos botoes
       //LOGIN
       login.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Usuario dados = new Usuario(txtName.getText());
                dados.setSenha(dados.encriptografarDesencapsulado(txtPass.getText()));
                
                try {
                    UsuarioDAO u = new UsuarioDAO();
                    if(u.verificaLogin(dados)==true){
                        JFrame telaAnuncios = new TelaAnuncios(u.getUsuario(dados), null);
                        telaAnuncios.setVisible(true);
                        JOptionPane.showMessageDialog(null, "Bem Vindo, " + dados.getNome());
                    } else{
                        JOptionPane.showMessageDialog(null, "Login Invalido", "FAIOU", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(TelaLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
                dispose();
            }
           
       });
       //CADASTRO
       cadastro.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               TelaCadastro telaCadastro = new TelaCadastro();
               telaCadastro.setVisible(true);
               //fecha o this
               dispose();             
           }
           
       });


    }
  
        
}        
    

