
package evaluacion1;

import java.util.*;

/**
 *
 * @author GokoshiJr
 */

public class Test {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        Kruskal kruskal = new Kruskal();
        ArrayList<Camino> arcos = new ArrayList<>();
        int arbolPeso = 0;
        int arbolArcos = 0;
        int arbolContador = 0;
        int nodos = 0; 
        int aristas = 0; 
        int peso = 0; 
        int origen = 0;
        int destino = 0;
        
        for (int i=0; i<100; i++) {
            kruskal.padres[i] = i;
        }
        
        System.out.println("Inicio del Algoritmo Kruskal");
        System.out.println("Ingrese el numero de nodos: ");
        nodos = teclado.nextInt();
        System.out.println("Ingrese el numero de aristas: ");
        aristas = teclado.nextInt();
        System.out.println("Ingrese el origen, destino y peso ej(1 2 3): ");
        
        for (int i=0; i<aristas; i++) {
            origen = teclado.nextInt();
            destino = teclado.nextInt();
            peso = teclado.nextInt();
            arcos.add(new Camino(peso, origen, destino));
        }
        
        System.out.println("El arbol de coste minimo es el siguiente: ");
        
        Collections.sort(arcos, new Comparator<Camino>() {
            @Override
            public int compare(Camino o1, Camino o2) {
                return o1.getPeso() - o2.getPeso();
            }
        });
        
        while (arbolArcos < nodos-1 && arbolContador < aristas) {
            origen = arcos.get(arbolContador).getOrigen();
            destino = arcos.get(arbolContador).getDestino();
            peso = arcos.get(arbolContador).getPeso();
            if (kruskal.encontrarPadre(origen) != kruskal.encontrarPadre(destino)) {
                kruskal.unirNodos(origen, destino);
                arbolPeso += peso;
                System.out.println(origen + "-> " + destino + ": " + peso);
                arbolArcos++;
            }
            arbolContador++;
        }
        
        if (arbolArcos != nodos-1) {
            System.out.println("El arbol no es valido");
        } else {
            System.out.println("El coste minimo es: " + arbolPeso);
        }
        
    }
    
}
