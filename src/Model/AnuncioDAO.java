package Model;

import java.io.*;

public class AnuncioDAO {
	
	public void escrever(Anuncio a) throws IOException {
		 ManipuladorArquivo ma = new ManipuladorArquivo();
	     ma.escrever("src/anuncio.txt",a.getTitulo() + ";" + a.getDescricao() + ";" + a.getPreco() + ";" +a.getTag() + ";"+a.getData() +";"+a.getUsuario().getNome());
	}
	
}
