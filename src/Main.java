
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import tp2.Interface.*;

public class Main {

    public static void main(String[] args) {
        JFrame teste = new TelaAnuncios().montaJanela();
        teste.setVisible(true);
        
//LOGIN
       JFrame lframe = new JFrame("CLIENTE - login");
       
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



    }
}
