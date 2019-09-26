/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Aluno
 */
public class Anuncio implements Comparavel{
    private Usuario usuario;
    private String titulo,descricao, tag, data;
    private double preco;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public boolean maior(Object obj) {
       Anuncio a = (Anuncio) obj;
       String[] dataEsse = this.getData().split("/");
       String[] dataObj = a.getData().split("/");
       if(Integer.parseInt(dataEsse[2])>Integer.parseInt(dataObj[2])){
           return true;
       } else  if(Integer.parseInt(dataEsse[2])==Integer.parseInt(dataObj[2])){
           if(Integer.parseInt(dataEsse[1])>Integer.parseInt(dataObj[1])){
               return true;
           } else if(Integer.parseInt(dataEsse[1])==Integer.parseInt(dataObj[1])){
               if(Integer.parseInt(dataEsse[0])>Integer.parseInt(dataEsse[0])){
                   return true;
               }
           }
       }
       return false;
    }
    
    
    
}
