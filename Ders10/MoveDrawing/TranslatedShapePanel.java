import javax.swing.*;
import java.awt.*;

public class TranslatedShapePanel extends JPanel implements Runnable {
    private int x = 0; // Initial translation value for X
    private final int SPEED = 5; // Speed of translation

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Save the original transformation
        g2d.translate(x, 50); // Translate the shape by (x, 50)

        // Draw a rectangle at (0, 0) after translation
        g2d.setColor(Color.BLUE);
        g2d.fillRect(0, 0, 50, 50);
    }

    // Update translation value
    public void moveShape() {
        x += SPEED; // Increase translation along X
        if (x > getWidth()) { // Reset if it moves out of bounds
            x = -50;
        }
        repaint(); // Request to repaint the panel
    }

    @Override
    public void run() {
        while (true) {
            moveShape(); // Update shape position
            try {
                Thread.sleep(50); // Pause for 50ms between updates
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Moving Shape with Translation");
        TranslatedShapePanel panel = new TranslatedShapePanel();

        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Start the animation in a new thread
        new Thread(panel).start();
    }
}
