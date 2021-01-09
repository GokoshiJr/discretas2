package evaluacion1;

import java.util.*;

/**
 *
 * @author Maru
 */
public class Warshall {
    
    
    
    public static void cierreTransitivo (ArrayList<Nodo> vectorNodos, ArrayList<Enlace> vectorEnlaces) {
        
        ArrayList<Camino> caminoArray = new ArrayList<>();
        int nodos = 0; 
        int aristas = 0; 
        int peso = 0; 
        int origen = 0;
        int destino = 0;
        String datos[] = new String[3];
        
        nodos = vectorNodos.size();
        ArrayList<ArrayList<Integer>> matriz = new ArrayList<>(); // Inicializacion de matriz de cierre transitivo
        aristas = vectorEnlaces.size();
        
        // Encontrar caminos
        
        for (int i=0; i<aristas; i++) {
            datos = Utilitario.getOrigen(vectorEnlaces.get(i), vectorNodos);
            origen = Integer.parseInt(datos[0]) ;
            destino = Integer.parseInt(datos[1]);
            peso = Integer.parseInt(datos[2]);
            Camino camino = new Camino(peso, origen, destino);
            caminoArray.add(camino);
        }
        
        // Matriz de adyacencia
        
        for (Nodo e: vectorNodos) {
            ArrayList<Integer> auxFilas = new ArrayList<>(); // Array que guarda una fila entera
            for(Nodo e2: vectorNodos){
                int aux = 0;
                for(Camino camino : caminoArray){
                    if(Integer.parseInt(e.getNombre()) == camino.getOrigen() && Integer.parseInt(e2.getNombre()) == camino.getDestino()){
                        aux = 1;
                    }
                }
               auxFilas.add(aux);
            }
             matriz.add(auxFilas);
        }
        System.out.println("\n Matriz de adyacencia");
        vectorMethods.showMatrix(matriz);
        System.out.println("");
        
        // Matrices de cierre transitivo
        
        for (int k = 0; k<nodos; k++){
            for (int i=0; i<nodos; i++){
                for (int j = 0; j < nodos; j++) {
                    if(i == k || j == k){
                        continue;
                    }
                    if(matriz.get(k).get(i) == 1 && matriz.get(j).get(k) == 1 ){
                        ArrayList<Integer> aux = new ArrayList<>(matriz.get(j));
                        aux.set(i,1);
                        matriz.set(j, aux);
                    }
                }
                
            }
            System.out.printf("Nodo %s \n",k);
            vectorMethods.showMatrix(matriz);
            System.out.println("");
        }
        
    }
    
}
