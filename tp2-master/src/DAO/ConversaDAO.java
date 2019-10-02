package DAO;

import Model.Conversa;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author aluno
 */
public class ConversaDAO {

    private int tamanhoConversas;

    public void salvarConversa(Conversa c) throws IOException {
        try {
            ArrayList<Conversa> conversas = this.getConversas();
            conversas.add(c);
            FileOutputStream f = new FileOutputStream("src/conversas.txt");
            ObjectOutputStream fobj = new ObjectOutputStream(f);
            for (Conversa conversa : conversas) {
                fobj.writeObject(conversa);
            }
            fobj.close();
            f.close();
            this.setTamanhoConversas(conversas.size());

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ArrayList<Conversa> getConversas() {
        ArrayList<Conversa> conversas = new ArrayList<>();
        String caminhoArquivo = "src/conversas.txt";
        if ((new File(caminhoArquivo)).exists()) {
            try {
                FileInputStream f = new FileInputStream(caminhoArquivo);
                ObjectInputStream fobj = new ObjectInputStream(f);
                int quantidadeConversas = this.getTamanhoConversas();

                for (int i = 0; i < quantidadeConversas; i++) {
                    Conversa c = (Conversa) fobj.readObject();
                    conversas.add(c);
                }
                fobj.close();
                f.close();
            } catch (EOFException eo) {
            } catch (IOException | ClassNotFoundException ex) {
                System.out.println(ex.toString());

            }
        }
        return conversas;
    }

    public int getTamanhoConversas() throws FileNotFoundException, IOException {
        int quantidade = 0;
        if (new File("quantidadeConversas").exists()) {
            FileReader reader = new FileReader("quantidadeConversas");
            BufferedReader br = new BufferedReader(reader);
            String linha = br.readLine();

            if (linha != null) {
                quantidade = Integer.parseInt(linha);
            }

            br.close();
        }
        return quantidade;
    }

    public void setTamanhoConversas(int tamanhoConversas) throws IOException {
        FileWriter writer = new FileWriter("quantidadeConversas");
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write(String.valueOf(tamanhoConversas));
        bw.close();

    }

}
