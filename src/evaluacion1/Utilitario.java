
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
        System.out.println(" Presione la tecla Space \n para ver los resultados");
        Lienzo lienzo = new Lienzo();
        lienzo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     * Muestra los datos generales de la evaluacion en la consola 
     * @param vectorNodos
     * @param vectorEnlaces 
     */
    public static void mostrarDatos(ArrayList<Nodo> vectorNodos, ArrayList<Enlace> vectorEnlaces) {
        System.out.println(linea);
        System.out.println(" Est. Discretas 2 - Evaluación 1");
        System.out.println(linea);
        System.out.println(" N de elementos/nodos: " + vectorNodos.size());
        System.out.println(" N de aristas/enlaces: " + vectorEnlaces.size());
        System.out.println(linea);
        System.out.println(" Algoritmo de Kruskal");
        System.out.println(linea);
        Kruskal.minimoCoste(vectorNodos, vectorEnlaces);
        // Dijkstra.rutaMinima(vectorNodos, vectorEnlaces);
        /* 
            Maru coloca la llamada a tu clase dentro de este metodo mostrarDatos()
        */
        // Ejemplo: Warshall.matrices(vectorNodos, vectorEnlaces);
        Warshall.cierreTransitivo(vectorNodos, vectorEnlaces);
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
