import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HolaMundo extends JFrame {
    private int dx = 2;
    private int dy = 2;
    private int Altura = 0;
    private int Longitud = 0;
    private int LadoIzquierdo;
    private int LadoDerecho;
    private int Top;
    private int Bottom;
    private boolean Empezar = true;
    private Boolean GolpeoBordeDerecho = false;
    private Boolean GolpeoBordeIzquierdo = false;
    private Boolean GolpeoBordeAbajo = false;
    private Boolean GolpeoBordeArriba = false;

    public HolaMundo() {
        InicializarComponentes();
        MostrarFrame();
        DeterminarPocisionFrame();
        MoverEtiqueta();
    }

    private void DeterminarPocisionFrame() {
        LadoIzquierdo = this.getLocationOnScreen().x;
        LadoDerecho = LadoIzquierdo + this.getWidth();
        Top = this.getLocationOnScreen().y;
        Bottom = this.getLocationOnScreen().y + this.getHeight();
    }

    private void MostrarFrame() {
        setSize(500, 500);
        setBackground(new Color(134, 200, 135));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        Font newFont = new Font("Arial", Font.PLAIN, 20); // Fuente, estilo, tamaño
        Label.setBounds(0, 0, 130, 30);
        Label.setFont(newFont);

        panel.add(Label);

        add(panel);
        setVisible(true);
    }

    private void MoverEtiqueta() {
        Timer timer = new Timer(10, e -> {
            /*int nextX = Label.getX() + dx;
            int nextY = Label.getY() + dy;

            if (nextX <= 0 || (nextX + Label.getWidth()) >= panel.getWidth()) {
                dx *= -1;
            }

            if (nextY <= 0 || (nextY + Label.getHeight()) >= panel.getHeight()) {
                dy *= -1;
            }
            
            Label.setLocation(nextX,nextY);*/

            ValidarColisionConBordes();
            MovimientoDelLabel();
        });
        timer.start();
    }

    private void ValidarColisionConBordes() {
        if ((Label.getX() - LadoIzquierdo) >= -70) {
            Empezar = false;
            GolpeoBordeArriba = false;
            GolpeoBordeAbajo = false;
            GolpeoBordeDerecho = false;
            GolpeoBordeIzquierdo = true;
        }

        if (((Label.getY() + Label.getHeight()) - Bottom) >= -157) {
            GolpeoBordeIzquierdo = false;
            GolpeoBordeDerecho = false;
            GolpeoBordeArriba = false;
            GolpeoBordeAbajo = true;
        }

        if (((Label.getX() + Label.getWidth()) - LadoDerecho) == -810) {
            GolpeoBordeAbajo = false;
            GolpeoBordeArriba = false;
            GolpeoBordeIzquierdo = false;
            GolpeoBordeDerecho = true;
        }

        if ((Label.getY() - Top) <= -114) {
            GolpeoBordeAbajo = false;
            GolpeoBordeIzquierdo = false;
            GolpeoBordeDerecho = false;
            GolpeoBordeArriba = true;
        }
    }

    private void MovimientoDelLabel() {
        if (Empezar) {
            Label.setLocation(Longitud++, Altura++);
        }

        if (GolpeoBordeIzquierdo) {
            Label.setLocation(Longitud--, Altura++);
        }

        if (GolpeoBordeDerecho) {
            Label.setLocation(Longitud++, Altura--);
        }

        if (GolpeoBordeAbajo) {
            Label.setLocation(Longitud--, Altura--);
        }

        if (GolpeoBordeArriba) {
            Label.setLocation(Longitud++, Altura++);
        }
    }

    public void InicializarComponentes() {
        panel = new JPanel(null);
        Label = new JLabel("Hola mundo!!");
    }

    public static void main(String[] args) {
        new HolaMundo();
    }

    // Declaracion de variables de componentes]
    private JPanel panel;
    private JLabel Label;
}