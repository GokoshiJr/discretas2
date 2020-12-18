package evaluacion1;

import javax.swing.JFrame;

public class Utilitario {
    
    public static void menu() {
        System.out.println("Menu Evaluación 1");
        JFrame ventana = new JFrame("Grafo");
        ventana.add(new Lienzo());
        ventana.setSize(600, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
    
}
