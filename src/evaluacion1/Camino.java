
package evaluacion1;

/**
 *
 * @author GokoshiJr
 */

public class Camino {
    
    private int peso, origen, destino;

    public Camino(int peso, int origen, int destino) {
        this.peso = peso;
        this.origen = origen;
        this.destino = destino;
    }

    public int getPeso() {
        return peso;
    }

    public int getOrigen() {
        return origen;
    }

    public int getDestino() {
        return destino;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void setOrigen(int origen) {
        this.origen = origen;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    @Override
    public String toString() {
        return "Camino{Origen: " + origen + ", Destino: " + destino + ", Peso: " + peso + "}";
    }
    
}
