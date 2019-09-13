/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.Interface;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Classes.*;
import java.awt.Component;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luiza
 */
public class TelaCadastro implements Tela{
    private JFrame cframe;
    @Override
    public JFrame montaJanela() {
       this.cframe = new JFrame("CLIENTE - cadastro");
       
       cframe.setSize(300,200);
       cframe.setLayout(new FlowLayout());
       cframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
//panel para nome
       JPanel panName = new JPanel();
       panName.add(new JLabel("Nome:"));
       JTextField txtName = new JTextField(15);
       panName.add(txtName);
//panel para email
       JPanel panEm = new JPanel();
       panEm.add(new JLabel("Email:"));
       JTextField txtEm = new JTextField(15);
       panEm.add(txtEm);
//panel para senha
       JPanel panPass = new JPanel();
       panPass.add(new JLabel("Senha:"));
       JPasswordField txtPass = new JPasswordField(15);
       panPass.add(txtPass);
//adicionando panels 
       cframe.add(panName);
       cframe.add(panEm);
       cframe.add(panPass);
//add botao
       JButton cadastrar = new JButton("Cadastrar!");
       cframe.add(cadastrar);
       JButton pronto = new JButton("Pronto!");
       cframe.add(pronto);
       
       
//metodos botao
    cadastrar.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {    
                   Usuario u =  new Usuario(txtName.getText());
                   u.setEmail(txtEm.getText());
                   u.setSenha(txtPass.getText());
                   
                   UsuarioDAO uDao = new UsuarioDAO();
                   
                try {
                    if(u.getEmail().equals("")||u.getNome().equals("")||u.getSenha().equals("")){
                        JOptionPane.showMessageDialog(null,"Preencha todos os campos.", "Erro!",JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                    	if(uDao.seExiste(u)==false){
                        uDao.cadastrar(u);
                        JOptionPane.showMessageDialog(null,"Usuario Cadastrado.", "Sucesso!",JOptionPane.INFORMATION_MESSAGE);
                    	}
                        else {
                        	JOptionPane.showMessageDialog(null,"Nome ou email ja cadastrado.", "Erro!",JOptionPane.ERROR_MESSAGE);
                        }
                    }                    
                   
                    
               } catch (IOException ex) {
                   Logger.getLogger(TelaCadastro.class.getName()).log(Level.SEVERE, null, ex);
               }
       
           }
           
       });
    
    pronto.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               JFrame tl = new TelaLogin().montaJanela();              
               cframe.dispose();
               
           }            
    });
    
       return cframe;
    }
    
}
