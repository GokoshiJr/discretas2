
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
        JFrame ventana = new JFrame("Grafo");
        ventana.add(new Lienzo());
        ventana.setSize(600, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
    
    /**
     * Muestra los datos generales de la evaluacion 
     * @param vectorNodos
     * @param vectorEnlaces 
     */
    public static void mostrarDatos(ArrayList<Nodo> vectorNodos, ArrayList<Enlace> vectorEnlaces) {
        System.out.println(linea);
        System.out.println(" Estructuras Discretas 2 - Evaluación 1");
        System.out.println(linea);
        System.out.println(" N de elementos/nodos: " + vectorNodos.size());
        System.out.println(" N de aristas/enlaces: " + vectorEnlaces.size());
        System.out.println(linea);
        System.out.println(" Algoritmo de Kruskal");
        System.out.println(linea);
        Kruskal.minimoCoste(vectorNodos, vectorEnlaces);
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
