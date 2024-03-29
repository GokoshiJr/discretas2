
package evaluacion1;

import java.awt.Graphics;

/**
 *
 * @author GokoshiJr
 */
         
public class Enlace {
   
    private int x1, y1, x2, y2;
    private String nombre;

    public Enlace(int x1, int y1, int x2, int y2, String nombre) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.nombre = nombre;
    }
    
    public void pintar(Graphics g) {
        g.drawLine(x1, y1, x2, y2);
        if (x1 > x2 && y1 > y2) {
            g.drawString(nombre, x1 - Math.abs((x1 - x2) / 2), y1 - Math.abs((y1 - y2) / 2));
        }
        if (x1 < x2 && y1 < y2) {
            g.drawString(nombre, x2 - Math.abs((x1 - x2) / 2), y2 - Math.abs((y1 - y2) / 2));
        }
        if (x1 > x2 && y1 < y2) {
            g.drawString(nombre, x1 - Math.abs((x1 - x2) / 2), y2 - Math.abs((y1 - y2) / 2));
        }
        if (x1 < x2 && y1 > y2) {
            g.drawString(nombre, x2 - Math.abs((x1 - x2) / 2), y1 - Math.abs((y1 - y2) / 2));
        }
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Enlace{" + "x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + ", nombre=" + nombre + '}';
    }
    
}
