
package evaluacion1;

/**
 *
 * @author GokoshiJr
 */

public class Kruskal {
    
    int MAX = 100;
    int padres[] = new int[MAX];
    
    public int encontrarPadre(int x) {
        if (padres[x] == x) {
            return x;
        }
        return encontrarPadre(padres[x]);
    }
    
    public void unirNodos(int x, int y) {
        int fx = encontrarPadre(x);
        int fy = encontrarPadre(y);
        padres[fx] = fy;
    }

}
