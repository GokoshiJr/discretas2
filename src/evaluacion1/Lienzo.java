
package evaluacion1;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author GokoshiJr
 */

public class Lienzo extends JPanel implements MouseListener, MouseMotionListener {
    
    private Vector<Nodo> vectorNodos;
    private Vector<Enlace> vectorEnlaces;
    private Point p1, p2;
    private Nodo nodoMover;
    private int contadorNodo;
    
    public Lienzo() {
        this.vectorNodos = new Vector<>();
        this.vectorEnlaces = new Vector<>();
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Nodo nodos : vectorNodos) {
            nodos.pintar(g);
        }
        for (Enlace enlaces : vectorEnlaces) {
            enlaces.pintar(g);
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del nodo");
            this.vectorNodos.add(new Nodo(e.getX(), e.getY(), nombre));
            repaint();
        }
        if (e.getButton() == MouseEvent.BUTTON3) {
            for (Nodo nodos : vectorNodos) {
                if (new Rectangle(nodos.getX() - (Nodo.diametro / 2), nodos.getY() - (Nodo.diametro / 2), Nodo.diametro, Nodo.diametro).contains(e.getPoint())) {
                    if (p1 == null) {
                        p1 = new Point(nodos.getX(), nodos.getY());
                    } else {
                        p2 = new Point(nodos.getX(), nodos.getY());
                        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del Enlace: ");
                        this.vectorEnlaces.add(new Enlace(p1.x, p1.y, p2.x, p2.y, nombre));
                        repaint();
                        p1 = null;
                        p2 = null;
                    }
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int contador = 0;
        for (Nodo nodo : vectorNodos) {
            if (new Rectangle(nodo.getX() - Nodo.diametro/2, nodo.getY() - Nodo.diametro/2, Nodo.diametro, Nodo.diametro).contains(e.getPoint())) {
                nodoMover = nodo;
                contadorNodo = contador;
                break;
            }
            contador++;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        nodoMover = null;
        contadorNodo = -1;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (nodoMover != null) {
            this.vectorNodos.set(contadorNodo, new Nodo(e.getX(), e.getY(), nodoMover.getNombre()));
            int contadorEnlace = 0;
            for (Enlace enlace : vectorEnlaces) {
                if (new Rectangle(enlace.getX1() - Nodo.diametro/2, enlace.getY1() - Nodo.diametro/2, Nodo.diametro, Nodo.diametro).contains(e.getPoint())) {
                    this.vectorEnlaces.set(contadorEnlace, new Enlace(e.getX(), e.getY(), enlace.getX2(), enlace.getY2(), enlace.getNombre()));
                } else if (new Rectangle(enlace.getX2() - Nodo.diametro/2, enlace.getY2() - Nodo.diametro/2, Nodo.diametro, Nodo.diametro).contains(e.getPoint())) {
                    this.vectorEnlaces.set(contadorEnlace, new Enlace(enlace.getX1(), enlace.getY1(), e.getX(), e.getY(), enlace.getNombre()));
                }
                contadorEnlace++;
            }
        }
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}