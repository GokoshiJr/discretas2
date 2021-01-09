
package evaluacion1;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author GokoshiJr
 */

public class Lienzo extends JFrame implements MouseListener, MouseMotionListener {

    private ArrayList<Nodo> vectorNodos;
    private ArrayList<Enlace> vectorEnlaces;
    private Point p1, p2;
    private Nodo nodoMover;
    private int contadorNodo;
    
    public Lienzo() {
        vectorNodos = new ArrayList<>();
        vectorEnlaces = new ArrayList<>();
        addMouseListener(this);
        addMouseMotionListener(this);
        setVisible(true);
        setBounds(0, 0, 600, 500);
        EventoTeclado tecla = new EventoTeclado();
        addKeyListener(tecla);
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
        if (e.getButton() == MouseEvent.BUTTON1) { // Click Derecho 
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del Nodo");
            this.vectorNodos.add(new Nodo(e.getX(), e.getY(), nombre));
            repaint();
        }
        if (e.getButton() == MouseEvent.BUTTON3) { // Click Izquierdo
            for (Nodo nodos : vectorNodos) {
                if (new Rectangle(nodos.getX() - (Nodo.DIAMETRO / 2), nodos.getY() - (Nodo.DIAMETRO / 2), Nodo.DIAMETRO, Nodo.DIAMETRO).contains(e.getPoint())) {
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
            if (new Rectangle(nodo.getX() - Nodo.DIAMETRO/2, nodo.getY() - Nodo.DIAMETRO/2, Nodo.DIAMETRO, Nodo.DIAMETRO).contains(e.getPoint())) {
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
    public void mouseDragged(MouseEvent e) {
        /**
         * Cuando arrastramos un nodo, este evento reajusta las coordenadas
         */
        if (nodoMover != null) {
            this.vectorNodos.set(contadorNodo, new Nodo(e.getX(), e.getY(), nodoMover.getNombre()));
            int contadorEnlace = 0;
            for (Enlace enlace : vectorEnlaces) {
                if (new Rectangle(enlace.getX1() - Nodo.DIAMETRO/2, enlace.getY1() - Nodo.DIAMETRO/2, Nodo.DIAMETRO, Nodo.DIAMETRO).contains(e.getPoint())) {
                    this.vectorEnlaces.set(contadorEnlace, new Enlace(e.getX(), e.getY(), enlace.getX2(), enlace.getY2(), enlace.getNombre()));
                } else if (new Rectangle(enlace.getX2() - Nodo.DIAMETRO/2, enlace.getY2() - Nodo.DIAMETRO/2, Nodo.DIAMETRO, Nodo.DIAMETRO).contains(e.getPoint())) {
                    this.vectorEnlaces.set(contadorEnlace, new Enlace(enlace.getX1(), enlace.getY1(), e.getX(), e.getY(), enlace.getNombre()));
                }
                contadorEnlace++;
            }
        }
        repaint();
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
    @Override
    public void mouseMoved(MouseEvent e) {}
    
    class EventoTeclado implements KeyListener {
        /**
         * Metodo de evento para que al presionar el espacio, muestre los datos de la evaluacion 
         * @param e 
         */
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == 74 || e.getKeyCode() == 77) {
                Utilitario.mostrarDatos(vectorNodos, vectorEnlaces, e.getKeyCode());
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {}
        
        @Override
        public void keyTyped(KeyEvent e) {}

    }

}
