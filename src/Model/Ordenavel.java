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
    for(int i=0;i<ordenados.size();i++){
        if(ordenados.get(i+1).maior(ordenados.get(i))) {
            T aux = ordenados.get(i);
            ordenados.set(i, ordenados.get(i+1));
            ordenados.set(i+1,aux);
        }
    }
    return ordenados;
}
}
