package evaluacion1;

import java.awt.Graphics;

/**
 *
 * @author GokoshiJr
 */

public class Nodo {
    
    private int x, y;
    private String nombre;
    public static final int DIAMETRO = 60;
    
    public Nodo(int x, int y, String nombre) {
        this.x = x;
        this.y = y;
        this.nombre = nombre;
    }
    
    /**
     * Dibuja un circulo/ovalo que es el nodo, donde le indicamos las coordenadas
     * @param g 
     */
    public void pintar(Graphics g) {
        g.drawOval(x - DIAMETRO / 2, y - DIAMETRO / 2, DIAMETRO, DIAMETRO);
        g.drawString(nombre, x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static int getDiametro() {
        return DIAMETRO;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Nodo{" + "x=" + x + ", y=" + y + ", nombre=" + nombre + '}';
    }
    
}
