import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Frame extends JFrame{
    private int dx = 2, dy = 2;
    private JPanel panel;
    private JLabel Label;
    private Timer timer;

    public Frame() {
        InicializarComponentes();
        MoverEtiqueta();
    }

    private void InicializarComponentes() {
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel(null);
        Label = new JLabel("Hola mundo!!");
        Label.setBounds(0, 0, 100, 30);
        Label.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(Label);

        add(panel);
        setVisible(true);
    }

    private void MoverEtiqueta() {
        timer = new Timer(10, e -> {
            int nextX = Label.getX() + dx;
            int nextY = Label.getY() + dy;

            if (nextX <= 0 || nextX + Label.getWidth() >= panel.getWidth()) {
                dx *= -1; // Cambiar dirección horizontal
            }
            if (nextY <= 0 || nextY + Label.getHeight() >= panel.getHeight()) {
                dy *= -1; // Cambiar dirección vertical
            }

            Label.setLocation(nextX, nextY);
        });

        timer.start();
    }

    public static void main(String[] args) {
        new Frame();
    }
}