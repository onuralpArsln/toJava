import java.awt.*;
import javax.swing.*;

public class CrashingShapes extends JPanel implements Runnable {
    // başlangıç noktaları
    private int x = 0;
    private int y = 20;
    private final int shapeSizeX = 50;
    private final int shapeSizeY = 50;
    private final int obstacleSizeX = 50;
    private final int obstacleSizeY = 50;
    private final int obstacleX = 200;
    private final int obstacleY = 50;

    // hız değeri
    private int SPEED = 3;

    // özel çizme mantığı
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // engel
        g2d.setColor(Color.RED);
        g2d.fillRect(obstacleX, obstacleY, obstacleSizeX, obstacleSizeY);

        // Hareketli parça
        g2d.setColor(Color.GREEN);
        g2d.fillRect(x, y, shapeSizeX, shapeSizeY);

        g2d.setColor(Color.BLACK); // Yazı rengi
        g2d.drawString("X: " + x + ", Y: " + y, 10, 20); // Pozisyon bilgisi

    }

    // koordinat değişimi
    public void moveShape() {
        // üst köşe obstacle y sınırları içinde mi ve ya alt köşe obstacle y sınırları
        // içinde mi
        if ((obstacleY <= y && y <= obstacleY + obstacleSizeY) || (obstacleY <= y + shapeSizeY && y
                + shapeSizeY <= obstacleY + obstacleSizeY)) {
            // sağdan çarpma
            if (x + shapeSizeX >= obstacleX && x + shapeSizeX <= obstacleX + obstacleSizeX) {
                this.SPEED = -3;
            } // soldan çarpma
            else if (obstacleX + obstacleSizeX >= x && obstacleX <= x) {
                this.SPEED = 0;
            }
        }
        this.x += SPEED; // speed değişkeni kadar hareket et
        if (this.x > this.getWidth()) { // eğer sınırdan çıkarsa geri dön
            this.x = -50; // geri dönmek için -50 git
        } else if (this.x < -55) {
            this.x = getWidth();
        }
        repaint(); // Paneli yeniden boyama isteği oluştur.
    }

    @Override
    public void run() {
        while (true) {
            moveShape(); // Poziysonu güncelle ekranı yeniden çizdir
            try {
                Thread.sleep(33); // sahneler arası bekle
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Moving Shape Example");
        CrashingShapes panel = new CrashingShapes();

        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Start the animation in a new thread
        new Thread(panel).start();
    }
}
