package evaluacion1;

import java.awt.Graphics;

/**
 *
 * @author GokoshiJr
 */

public class Nodo {
    
    private int x, y;
    private String nombre;
    public static final int diametro = 60; // Diametro
    
    public Nodo(int x, int y, String nombre) {
        this.x = x;
        this.y = y;
        this.nombre = nombre;
    }
    
    public void pintar(Graphics g) {
        g.drawOval(x - diametro / 2, y - diametro / 2, diametro, diametro);
        g.drawString(nombre, x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static int getDiametro() {
        return diametro;
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
    
}
