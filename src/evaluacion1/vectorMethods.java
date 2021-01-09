/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evaluacion1;
import java.util.ArrayList;

/**
 * Clase para imprimir vectores y matrices
 * @author Maru
 */
public class vectorMethods {
    
    public static void showMatrix(ArrayList<ArrayList<Integer>> matrix){
        for(ArrayList<Integer> e: matrix){
            for(int e2 : e){
                System.out.printf("%5s",e2);
            }
            System.out.println(' ');
          
        }
    }
}
