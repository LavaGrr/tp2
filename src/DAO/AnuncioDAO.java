package DAO;

import Model.Anuncio;
import Model.ManipuladorArquivo;
import Model.Usuario;
import java.io.*;
import java.util.ArrayList;

public class AnuncioDAO {
	
	public void escrever(Anuncio a) throws IOException {
		 ManipuladorArquivo ma = new ManipuladorArquivo();
	     ma.escrever("src/anuncio.txt",a.getTitulo() + ";" + a.getDescricao() + ";" + a.getPreco() + ";" +a.getTag() + ";"+a.getData() +";"+a.getUsuario().getNome());
	}
        public static ArrayList<Anuncio> criarLista() throws FileNotFoundException, IOException{
            ArrayList<Anuncio> listaAnuncios = new ArrayList<Anuncio>();
            AnuncioDAO aDao = new AnuncioDAO();
            FileReader fr = new FileReader("src/anuncio.txt");
            BufferedReader br = new BufferedReader(fr);            
            String linha = br.readLine();
            
            while(linha!=null){
                try{
                    listaAnuncios.add(aDao.getAnuncio(linha));
                    linha = br.readLine();
                }catch(IOException e){
                    System.out.println(e.getMessage());
                }
            }
            return listaAnuncios;
        }
        
	public Anuncio getAnuncio(String linha) throws IOException{
            String vetor[] = linha.split(";");
            Anuncio a = new Anuncio();
            
            a.setTitulo(vetor[0]);
            a.setDescricao(vetor[1]);
            a.setPreco(Double.parseDouble(vetor[2]));
            a.setTag(vetor[3]);
            a.setData(vetor[4]);
            UsuarioDAO dao = new UsuarioDAO();
            Usuario us = new Usuario(vetor[5]);           
            a.setUsuario(dao.getUsuario(us));
            
            return a;
        }
        public static ArrayList<Anuncio> anunciosUsuario(Usuario u) throws IOException{            
            ArrayList<Anuncio> anunciosGeral = criarLista();
            ArrayList<Anuncio> anunciosUsuario = new ArrayList<>();
            
            for(int i=0; i<anunciosGeral.size(); i++){
                if(anunciosGeral.get(i).getUsuario().getNome().equals(u.getNome())){
                    anunciosUsuario.add(anunciosGeral.get(i));
                }
            }
            return anunciosUsuario;
        }
}
