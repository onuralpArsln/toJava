import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

// runnable ile thread işimiz kolaylaşacak bu bir thread tarafından işleri yapılır kılar
public class Moving_obstacles extends JPanel implements Runnable, KeyListener {
    // başlangıç noktaları
    private int x = 30;
    private int y = 303 ;
    private int xx = 380;
    private int yy = 303;

    private int cube_height = 50;
    private int cube_width = 50;
    private int obstacle_height = 50;
    private int obstacle_width = 50;
    // hız değeri
    private int speed_x = 1;
    private int speed_y = 1;
    private int acceleration = 3;
    private int speed_xx = 10;
    private int speed_yy = 1;
    private int jump_strength = 30;
    private int puan = 0;

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
        

        g2d.setColor(Color.green);
        g2d.fillRect(this.xx, this.yy, obstacle_height, obstacle_width);

        g2d.drawString("mevcut puan:" + puan, 20, 20);

        if (colision()) {
            g2d.setColor(Color.red);
            g2d.drawString("GAME OVER", 150, 150);
        }
        
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
    public void moveObstacle() {
        this.xx -= speed_xx;
        if (this.xx + obstacle_width< 0) {
            this.xx = 380;
            this.yy = 303;
            this.puan += 1;
            if (this.speed_xx < 13) {
            this.speed_xx = this.speed_xx + 1;
            }


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
        while (!colision()) { // Poziysonu güncellee ekranı yeniden çizdir
            gravitonalFall();
            moveObstacle();
            repaint(); // Paneli yeniden boyama isteği oluştur.
            try {
                Thread.sleep(33); // sahneler arası bekle
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    public boolean colision() {

        if (this.x + cube_width >= this.xx && this.x + cube_width < this.xx + obstacle_width && this.y + cube_height >= this.yy) {
        return true ;
        }
        else if (this.y + cube_height >= this.yy && this.x + cube_width >= this.xx && this.x < this.xx + obstacle_width) {
        return true ;

        } 
        return false;
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Gravity Example");
        Moving_obstacles panel = new Moving_obstacles();

        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // tuşları çalışması için önemli
        frame.addKeyListener(panel);
        frame.setFocusable(true); 

        new Thread(panel).start();
        System.out.println("selam"); }

           

            
        

        // Start the animation in a new thread
    
}