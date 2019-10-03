/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class Ordenavel<T extends Comparavel> {
	
    public ArrayList<T> ordenar(ArrayList<T> ordenados){
    for(int i=0;i<ordenados.size()-1;i++){
    	T aux;
    	for(int j=i+1;j<ordenados.size();j++) {
            if(!ordenados.get(i).maior(ordenados.get(j))) {   			
                aux = ordenados.get(i);
                ordenados.set(i, ordenados.get(j));
                ordenados.set(j, aux);           
            
            }
    	}
    }
    return ordenados;
}
}
