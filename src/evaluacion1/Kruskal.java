
package evaluacion1;

import java.util.*;

/**
 *
 * @author GokoshiJr
 */

public class Kruskal {
    
    private static int MAX = 100;
    private static int padres[] = new int[MAX];
    
    private static int encontrarPadre(int x) {
        if (padres[x] == x) {
            return x;
        }
        return encontrarPadre(padres[x]);
    }
    
    private static void unirNodos(int x, int y) {
        int fx = encontrarPadre(x);
        int fy = encontrarPadre(y);
        padres[fx] = fy;
    }
    
    /**
     * Calcula el minimo coste de un arbol de nodos, Algoritmo de Kruskal
     * @param vectorNodos
     * @param vectorEnlaces 
     */
    public static void minimoCoste(ArrayList<Nodo> vectorNodos, ArrayList<Enlace> vectorEnlaces) {
        
        ArrayList<Camino> caminoArray = new ArrayList<>();
        int arbolPeso = 0;
        int arbolArcos = 0;
        int arbolContador = 0;
        int nodos = 0; 
        int aristas = 0; 
        int peso = 0; 
        int origen = 0;
        int destino = 0;
        String datos[] = new String[3];
        
        for (int i=0; i<100; i++) {
            padres[i] = i;
        }
        
        nodos = vectorNodos.size();
        aristas = vectorEnlaces.size();
        
        for (int i=0; i<aristas; i++) {
            datos = Utilitario.getOrigen(vectorEnlaces.get(i), vectorNodos);
            origen = Integer.parseInt(datos[0]) ;
            destino = Integer.parseInt(datos[1]);
            peso = Integer.parseInt(datos[2]);
            Camino camino = new Camino(peso, origen, destino);
            caminoArray.add(camino);
        }
        
        System.out.println(" Arbol de coste minimo:");
        
        Collections.sort(caminoArray, new Comparator<Camino>() {
            @Override
            public int compare(Camino o1, Camino o2) {
                return o1.getPeso() - o2.getPeso();
            }
        });
        
        while (arbolArcos < nodos-1 && arbolContador < aristas) {
            origen = caminoArray.get(arbolContador).getOrigen();
            destino = caminoArray.get(arbolContador).getDestino();
            peso = caminoArray.get(arbolContador).getPeso();
            if (encontrarPadre(origen) != encontrarPadre(destino)) {
                unirNodos(origen, destino);
                arbolPeso += peso;
                System.out.println(" " + origen + " -> " + destino + ": " + peso);
                arbolArcos++;
            }
            arbolContador++;
        }
        System.out.println(" El coste minimo es: " + arbolPeso);
    }
    
}
