import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

// runnable ile thread işimiz kolaylaşacak bu bir thread tarafından işleri yapılır kılar
public class GravityPanel extends JPanel implements Runnable, KeyListener {
    // başlangıç noktaları
    private int x = 0;
    private int y = 50;

    private int cube_height = 50;
    private int cube_width = 50;
    // hız değeri
    private int speed_x = 1;
    private int speed_y = 1;
    private int acceleration = 1;
    private int jump_strength = 20;

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
        g2d.fillRect(this.x, this.y, cube_height, cube_width);
    }

    // koordinat değişimi
    public void moveShape() {
        this.x += speed_x; // speed değişkeni kadar hareket et
        if (this.x > this.getWidth()) { // eğer sınırdan çıkarsa geri dön
            this.x = -50; // geri dönmek için -50 git
            this.y = 50;
            this.speed_x = 1;

        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // bu method keylistener interfacesinde tanımlı olduğu için buraya tanımlandı

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) { // Space tuşuna basıldıysa

            // Yukarı hareket
            this.speed_y = jump_strength * -1; // yukarı gitmek için eksi yönde hareket
            this.speed_x = 3;

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        // bu method keylistener interfacesinde tanımlı olduğu için buraya tanımlandı

    }

    public void gravitonalFall() {

        this.y += speed_y;
        this.speed_y += acceleration;

        if (this.y + cube_height >= this.getHeight()) {
            this.speed_y = 0;
            this.y = this.getHeight() - this.cube_height;
            this.speed_x = 1;

        }

    }

    @Override
    public void run() {
        while (true) {
            moveShape(); // Poziysonu güncellee ekranı yeniden çizdir
            gravitonalFall();
            repaint(); // Paneli yeniden boyama isteği oluştur.
            try {
                Thread.sleep(33); // sahneler arası bekle
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gravity Example");
        GravityPanel panel = new GravityPanel();

        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // tuşları çalışması için önemli
        frame.addKeyListener(panel);
        frame.setFocusable(true);

        // Start the animation in a new thread
        new Thread(panel).start();
        System.out.println("selam");
    }
}
