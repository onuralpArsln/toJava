import java.awt.*;
import javax.swing.*;

// jpanel java swing içinde bir pencere oluşturma containerıdır.
// swing bir gui widget toolkit yani arayüz oluşturma setidir

public class Graphics2DTutorial extends JPanel {
    // component boyama mantığı içine burayı yazacağız

    // boyama yapısını değiştiriyoruz
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g; // Cast Graphics to Graphics2D

        // dikdörtgen çizmek
        g2d.setColor(Color.BLUE);
        g2d.fillRect(50, 50, 100, 50); // x, y, width, height

        // oval çizmek
        g2d.setColor(Color.RED);
        g2d.fillOval(200, 50, 100, 50);

        // daire çizmek
        g2d.setColor(Color.ORANGE);
        g2d.fillOval(50, 120, 50, 50);

        int[] xPoints = { 100, 50, 150 };
        int[] yPoints = { 100, 200, 200 };
        g2d.setColor(Color.YELLOW);
        g2d.fillPolygon(xPoints, yPoints, 3);

        // çizgi çekmek
        g2d.setColor(Color.BLACK);
        g2d.drawLine(50, 200, 150, 300);

    }

    public static void main(String[] args) {
        // bir pencere oluştur
        JFrame frame = new JFrame("Pencere 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(new Graphics2DTutorial()); // yeni bir JPanel oluşturduk ve onu JFrameYapısına ekledik
        frame.setVisible(true);
    }
}
