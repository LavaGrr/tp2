/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.AnuncioDAO;
import DAO.UsuarioDAO;
import Model.Anuncio;
import Model.Ordenavel;
import Model.Usuario;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author luiza
 */
public class TelaPerfisGeral extends JFrame{
    private ArrayList<Usuario> cadastrados = new ArrayList<>();
    
    public TelaPerfisGeral(ArrayList<Usuario> cadastrados) throws IOException{
        super();
        if(cadastrados == null){
            try{
                ArrayList<Usuario> a = gerarListaCadastrados();
                for(int i=0;i<a.size();i++){
                    this.cadastrados.add(a.get(i));
                }
            }catch(FileNotFoundException e){
                System.out.println(e.getMessage());
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        } else {
            for(int i=0;i<cadastrados.size();i++){
                this.cadastrados.add(cadastrados.get(i));
            }
        }
        
        this.setTitle("CLIENTE - Lista de Usuarios");
        //configurações janela
        this.setSize(300, 400);
        
        JPanel principal = new JPanel();
        principal.setLayout(new GridBagLayout());
        
        GridBagConstraints constraintCadastrados = new GridBagConstraints();
        constraintCadastrados.insets = new Insets(2, 2, 0, 0);
        
        for (int i = 0; i < this.cadastrados.size(); i++) {
            constraintCadastrados.gridy = i + 1;
            principal.add(colocarUsuario(this.cadastrados.get(i)), constraintCadastrados);
            
        }
        JScrollPane scroll = new JScrollPane(principal);
        JPanel panBot = new JPanel();
        JButton ordenar = new JButton("Ordenar os caras");
        JButton sair = new JButton("Voltar");
        
        panBot.add(ordenar);
        panBot.add(sair);
        this.add(panBot, BorderLayout.AFTER_LAST_LINE);
        this.add(scroll);
        
        //acoes botoes
        ordenar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Ordenavel ordenavel = new Ordenavel();
                JFrame telaPerfisGeral;
                try {
                    telaPerfisGeral = new TelaPerfisGeral(ordenavel.ordenar(getCadastrados()));
                    telaPerfisGeral.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(TelaPerfisGeral.class.getName()).log(Level.SEVERE, null, ex);
                }              
            }               
           
        });
        sair.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
            
        });
       
    }
    private ArrayList getCadastrados() {
        return this.cadastrados;
    }

    private ArrayList<Usuario> gerarListaCadastrados() throws FileNotFoundException, IOException {
        ArrayList<Usuario> cadastradosLista = new ArrayList<>();
        UsuarioDAO uDao = new UsuarioDAO();
            FileReader fr = new FileReader("src/cadastro.txt");
            BufferedReader br = new BufferedReader(fr);            
            String linha = br.readLine();
            
            while(linha!=null){
                try{
                    cadastradosLista.add(uDao.getUsuario(linha));
                    linha = br.readLine();
                }catch(IOException e){
                    System.out.println(e.getMessage());
                }
            }
            return cadastradosLista;
    }

    private JPanel colocarUsuario(Usuario u) {
        GridBagConstraints c = new GridBagConstraints();
    	c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 9, 0, 9);


    	JPanel usuarioPan = new JPanel(new GridBagLayout());
        
        usuarioPan.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        JLabel nomeLabel = new JLabel("Nome:");
        c.gridx = 1;
        c.gridwidth = 1;
        usuarioPan.add(nomeLabel, c);
        
        JEditorPane nome = new JEditorPane();
        nome.setEditable(false);
        nome.setText(u.getNome());
        c.gridwidth = 2;
        c.gridx = 2;        
        usuarioPan.add(nome, c);
        
        JLabel descLabel = new JLabel("Sobre:");
        c.gridx = 1;
        c.gridy = 2;        
        usuarioPan.add(descLabel, c);
        
        JEditorPane textoDescricao = new JEditorPane();
        textoDescricao.setEditable(false);
        textoDescricao.setText("Usuario bonzinho, esse");
        c.gridwidth = 2;
        c.gridx = 2;
        usuarioPan.add(textoDescricao, c);
        
        JButton visitar = new JButton("Visitar");
        c.gridwidth = 1;
        c.gridy = 3;
        c.gridx = 2;
        usuarioPan.add(visitar, c);
        //System.out.println(u.getNome());   
        //acao botao
        visitar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
        return usuarioPan;    
    }
}
