
package evaluacion1;

import java.util.ArrayList;
import javax.swing.JFrame;

/**
 * 
 * @author GokoshiJr
 */

public class Utilitario {
    
    public static String linea = "-----------------------------------";
    
    public static void menu() {
        System.out.println(linea);
        System.out.println(" Primero cargue el arbol de nodos");
        System.out.println(linea);
        System.out.println(" Tecla J: Algoritmos Kruskal y Dijkstra");
        System.out.println(" Tecla M: Algoritmo de Warshall");
        System.out.println(linea);
        Lienzo lienzo = new Lienzo();
        lienzo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     * Muestra los datos generales de la evaluacion en la consola 
     * @param vectorNodos
     * @param vectorEnlaces 
     * @param tecla 
     */
    public static void mostrarDatos(ArrayList<Nodo> vectorNodos, ArrayList<Enlace> vectorEnlaces, int tecla) {
        
        System.out.println(" Est. Discretas 2 - Evaluación 1");
        System.out.println(linea);
        System.out.println(" N de elementos/nodos: " + vectorNodos.size());
        System.out.println(" N de aristas/enlaces: " + vectorEnlaces.size());
        System.out.println(linea);
        
        if (tecla == 74) {
            System.out.println(" Algoritmo de Kruskal");
            System.out.println(linea);
            Kruskal.minimoCoste(vectorNodos, vectorEnlaces);
            int origen, destino, peso;
            Dijkstra dijkstraAlgorithm = new Dijkstra(vectorNodos.size());
            for (Enlace enlaces : vectorEnlaces) {
                String data[] = getOrigen(enlaces, vectorNodos);
                origen = Integer.parseInt(data[0]);
                destino = Integer.parseInt(data[1]);
                peso = Integer.parseInt(data[2]);
                dijkstraAlgorithm.addEdge(origen, destino, peso, false);
            }
            System.out.println(linea);
            System.out.println(" Algoritmo de Dijkstra");
            System.out.println(linea);
            dijkstraAlgorithm.dijkstra(0);
            dijkstraAlgorithm.printShortestPath(vectorNodos.size()-1);
        }
        
        if (tecla == 77) {
            System.out.println(" Algoritmo de Warshall");
            System.out.println(linea);
            Warshall.cierreTransitivo(vectorNodos, vectorEnlaces);
        }
        
    }
    
    /**
     * Metodo que nos da informacion sobre un enlace
     * @param enlace
     * @param vectorNodo
     * @return un array con el origen-destino-peso
     */
    public static String[] getOrigen(Enlace enlace, ArrayList<Nodo> vectorNodo) {
        String result[] = new String[3];
        for (Nodo nodos : vectorNodo) {
            if (enlace.getX1() == nodos.getX() && enlace.getY1() == nodos.getY()) {
                result[0] = nodos.getNombre();
            } 
            if (enlace.getX2() == nodos.getX() && enlace.getY2() == nodos.getY()) {
                result[1] = nodos.getNombre();
            }
            result[2] = enlace.getNombre();
        }
        return result;
    }
    
}
