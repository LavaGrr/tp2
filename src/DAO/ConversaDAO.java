package DAO;

import Model.Conversa;
import Model.Usuario;

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
			if(c.getUsuarios()[0]!=null&&c.getUsuarios()[1]!=null) {
			ArrayList<Conversa> conversas = this.getConversas();
			int index = this.conversaExiste(c);
			if(index==-1) {
			conversas.add(c);
			} else {
				conversas.get(index).addMensagem(c.getMensagens().get(c.getMensagens().size()-1));
			}
			FileOutputStream f = new FileOutputStream("src/conversas.txt");
			ObjectOutputStream fobj = new ObjectOutputStream(f);
			for (Conversa conversa : conversas) {
				fobj.writeObject(conversa);
			}
			fobj.close();
			f.close();
			this.setTamanhoConversas(conversas.size());
			} else {
				System.out.println("nao cadastrado");
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

	protected ArrayList<Conversa> getConversas() {
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

	public int conversaExiste(Conversa c) {
		
    	 ArrayList<Conversa> conversas = this.getConversas();
		 for(Conversa conversa : conversas) {
			 Usuario[] usuarios = c.getUsuarios();
			 Usuario[] usuarios2 = conversa.getUsuarios();
			 if(this.acharElemento(usuarios2, usuarios)) {
				 return conversas.indexOf(conversa);
			 }
		 }
		 
		
		return -1;
    }

	public int getTamanhoConversas() throws FileNotFoundException, IOException {
		int quantidade = 0;
		if (new File("src/quantidadeConversas.txt").exists()) {
			FileReader reader = new FileReader("src/quantidadeConversas.txt");
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
		FileWriter writer = new FileWriter("src/quantidadeConversas.txt");
		BufferedWriter bw = new BufferedWriter(writer);
		bw.write(String.valueOf(tamanhoConversas));
		bw.close();

	}

	public boolean acharElemento(Usuario[] u,Usuario[] u2) {
    	int contador = 0;
    	Usuario aux = new Usuario("Aux");
		for(int i=0;i<u.length;i++) {
    		for(int j=0;j<u.length;j++) {
    			if(!u2[j].equals(aux)) {
    				if(u[i].getNome().equals(u2[j].getNome())){
    					aux = u2[j];
    					contador++;
    				}
    			}
    		}
    	}
		if(contador == u.length) {
			return true;
		} return false;
    }
	
	public ArrayList<Conversa> getConversasUsuario(Usuario u){
		ArrayList<Conversa> conversas = this.getConversas();
		ArrayList<Conversa> filtrada = new ArrayList<>();
		for(Conversa cv: conversas) {
			if(cv.getUsuarios()[0].getNome().equals(u.getNome())||cv.getUsuarios()[1].getNome().equals(u.getNome())) {
				filtrada.add(cv);
			}
		}
		return filtrada;
	}
	
	public Conversa atualizarConversa(Conversa c) {
		ArrayList<Conversa> conversas = this.getConversas();
		int index = this.conversaExiste(c);
		if(index==-1) {
			return c;
		} else {
			return conversas.get(index);
		}
	}
}
