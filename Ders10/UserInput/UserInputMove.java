
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

// runnable ile thread işimiz kolaylaşacak bu bir thread tarafından işleri yapılır kılar
// key listeneri implement ederek klacye tuşlarını dinleyen bir obje yarattın
public class UserInputMove extends JPanel implements Runnable, KeyListener {
    // başlangıç noktaları
    private int x = 0;
    private int y = 50;
    // hız değerleri
    private final int SPEED = 2;
    private final int Y_SPEED = 5; // Y ekseni için hız

    // özel çizme mantığı
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // bir kutu çiziyor
        g2d.setColor(Color.RED);
        g2d.fillRect(x, y, 50, 50);
    }

    // koordinat değişimi her sahnede otomatik olan
    public void moveShape() {
        this.x += SPEED; // x ekseninde otomatik hareket et
        if (this.x > this.getWidth()) { // eğer sınırdan çıkarsa geri dön
            this.x = -50; // geri dönmek için -50 git
        }
        repaint(); // Paneli yeniden boyama isteği oluştur.
    }

    // Y eksenindeki hareketi kontrol eden metot
    public void moveShapeY(int direction) {
        this.y += Y_SPEED * direction; // Y ekseninde hareket ettir
        // Panele sığması için sınırlandırma
        if (this.y < 0) {
            this.y = 0;
        }
        if (this.y + 50 > this.getHeight()) {
            this.y = this.getHeight() - 50;
        }
        repaint(); // Paneli yeniden boyama isteği oluştur.
    }

    @Override
    public void run() {
        while (true) {
            moveShape(); // Pozisyonu güncelle, ekranı yeniden çizdir
            try {
                Thread.sleep(33); // sahneler arası bekle (yaklaşık 30 FPS)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // bu method keylistener interfacesinde tanımlı olduğu için buraya tanımlandı

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // bu method keylistener interfacesinde tanımlı olduğu için buraya tanımlandı
    }

    // burası tuşa basılınca otomatik aktif olacak
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) { // W tuşuna basıldıysa
            moveShapeY(-1); // Yukarı hareket
        }
        if (e.getKeyCode() == KeyEvent.VK_S) { // S tuşuna basıldıysa
            moveShapeY(1); // Aşağı hareket
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Moving Shape Example");
        UserInputMove panel = new UserInputMove();

        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Panel için tuş dinleyicisi ekle
        frame.addKeyListener(panel);
        frame.setFocusable(true);

        // Animasyonu yeni bir thread'de başlat
        new Thread(panel).start();
    }
}
