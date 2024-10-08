
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class UserInputMove extends JPanel implements Runnable, KeyListener {
    // başlangıç noktaları
    private int x = 0;
    private int y = 50;
    // hız değerleri
    private final int X_SPEED = 5;
    private final int Y_SPEED = 5; // Y ekseni için hız
    private boolean upPressed = false;
    private boolean downPressed = false;
    private boolean leftPressed = false;
    private boolean rightPressed = false;

    // özel çizme mantığı
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // bir kutu çiziyor
        g2d.setColor(Color.RED);
        g2d.fillRect(x, y, 50, 50);

        g2d.setColor(Color.BLACK); // Yazı rengi
        if (upPressed) {
            g2d.drawString("up pressed", 10, 20);
        } else if (downPressed) {
            g2d.drawString("down pressed", 10, 20);
        } else if (leftPressed) {
            g2d.drawString("left pressed", 10, 20);
        } else if (rightPressed) {
            g2d.drawString("right pressed", 10, 20);
        } else {
            g2d.drawString("X: " + x + ", Y: " + y, 10, 20); // Pozisyon bilgisi
        }
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

    // x eksenindeki hareketi kontrol eden metot
    public void moveShapeX(int direction) {
        this.x += X_SPEED * direction; // Y ekseninde hareket ettir
        // Panele sığması için sınırlandırma
        if (this.x < 0) {
            this.x = 0;
        }
        if (this.x + 50 > this.getHeight()) {
            this.x = this.getHeight() - 50;
        }
        repaint(); // Paneli yeniden boyama isteği oluştur.
    }

    // bu geçen hafta ki fonksiyon
    public void moveShape() {
        this.x += X_SPEED; // speed değişkeni kadar hareket et
        if (this.x > this.getWidth()) { // eğer sınırdan çıkarsa geri dön
            this.x = -50; // geri dönmek için -50 git
        }
        // Paneli yeniden boyama isteği oluştur.
    }

    @Override
    public void run() {
        while (true) {
            moveShapebyBool();
            repaint(); // Pozisyonu güncelle, ekranı yeniden çizdir
            try {
                Thread.sleep(33); // sahneler arası bekle ( 33ms refresh yaklaşık 30 FPS)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // bu method keylistener interfacesinde tanımlı olduğu için buraya tanımlandı

    }

    public void moveShapebyBool() {
        if (upPressed) { // W tuşuna basıldıysa
            moveShapeY(-1); // Yukarı hareket
        }
        if (downPressed) { // S tuşuna basıldıysa
            moveShapeY(1);
        }
        if (leftPressed) {
            moveShapeX(-1); // Yukarı hareket
        }
        if (rightPressed) { // S tuşuna basıldıysa
            moveShapeX(1);
        }

    }

    // burası tuşa basılınca otomatik aktif olacak
    // iki taraftada ister if ister switch case kullanılır
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) { // W tuşuna basıldıysa

            upPressed = true; // Yukarı hareket
        }
        if (e.getKeyCode() == KeyEvent.VK_S) { // S tuşuna basıldıysa
            downPressed = true; // Aşağı hareket
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            leftPressed = true; // W tuşuna basıldıysa
        }
        if (e.getKeyCode() == KeyEvent.VK_D) { // S tuşuna basıldıysa
            rightPressed = true; // Aşağı hareket
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_W -> upPressed = false;
            case KeyEvent.VK_S -> downPressed = false;
            case KeyEvent.VK_A -> leftPressed = false;
            case KeyEvent.VK_D -> rightPressed = false;
        }
        System.out.println("key released");
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
