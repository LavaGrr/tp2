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
       JTextField txtPass = new JTextField(15);
       panPass.add(txtPass);
//adicionando panels 
       cframe.add(panName);
       cframe.add(panEm);
       cframe.add(panPass);
//add botao
       JButton cadastrar = new JButton("Cadastrar!");
       cframe.add(cadastrar);
       
       
//metodos botao
    cadastrar.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
                 JOptionPane.showMessageDialog(null, "OPAAA");         
           }
           
       });
    
       return cframe;
    }
    
}
