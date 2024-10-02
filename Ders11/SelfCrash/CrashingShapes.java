import java.awt.*;
import javax.swing.*;

public class CrashingShapes extends JPanel implements Runnable {
    // başlangıç noktaları
    private int x = 0;
    private int y = 50;
    private int obstacleX = 200;
    private int obstacleY = 50;
    // hız değeri
    private final int SPEED = 2;

    // özel çizme mantığı
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // bir kutu çiziyor
        g2d.setColor(Color.RED);
        g2d.fillRect(obstacleX, obstacleY, 50, 50);

        // bir kutu çiziyor
        g2d.setColor(Color.GREEN);
        g2d.fillRect(x, y, 50, 50);

    }

    // koordinat değişimi
    public void moveShape() {
        this.x += SPEED; // speed değişkeni kadar hareket et
        if (this.x > this.getWidth()) { // eğer sınırdan çıkarsa geri dön
            this.x = -50; // geri dönmek için -50 git
        }
        repaint(); // Paneli yeniden boyama isteği oluştur.
    }

    @Override
    public void run() {
        while (true) {
            moveShape(); // Poziysonu güncellee ekranı yeniden çizdir
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
