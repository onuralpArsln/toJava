import java.awt.*;
import javax.swing.*;

// runnable ile thread işimiz kolaylaşacak bu bir thread tarafından işleri yapılır kılar
public class MovingShapePanel extends JPanel implements Runnable {
    // başlangıç noktaları
    private int x = 0;
    private int y = 50;
    // hız değeri
    private final int SPEED = 2;

    // özel çizme mantığı
    @Override
    protected void paintComponent(Graphics g) {
        // alttaki iki satır standart yaklaşım
        // methodun eski işlevselliğini korur
        super.paintComponent(g);
        // Graphics nesnesinin ondan daha gelişmiş garphics2d ye dönüş
        Graphics2D g2d = (Graphics2D) g;

        // bir kutu çiziyor
        g2d.setColor(Color.RED);
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
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Moving Shape Example");
        MovingShapePanel panel = new MovingShapePanel();

        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Start the animation in a new thread
        new Thread(panel).start();
    }
}
