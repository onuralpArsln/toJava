import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MovingMultipleShapesPanel extends JPanel implements Runnable {
    private ArrayList<Integer> xs; // List of x-coordinates for multiple shapes
    private final int SPEED = 5;

    public MovingMultipleShapesPanel() {
        xs = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            xs.add(i * 60); // Initialize with starting positions
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        for (int i = 0; i < xs.size(); i++) {
            g2d.setColor(new Color(100 + i * 30, 50 + i * 30, 150));
            g2d.fillRect(xs.get(i), 50, 50, 50);
        }
    }

    public void moveShapes() {
        for (int i = 0; i < xs.size(); i++) {
            xs.set(i, xs.get(i) + SPEED); // Move each shape to the right
            if (xs.get(i) > getWidth()) {
                xs.set(i, -50); // Reset position if it goes off screen
            }
        }
        repaint(); // Repaint with updated positions
    }

    @Override
    public void run() {
        while (true) {
            moveShapes(); // Update positions
            try {
                Thread.sleep(50); // Pause for animation
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Multiple Moving Shapes Example");
        MovingMultipleShapesPanel panel = new MovingMultipleShapesPanel();

        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        new Thread(panel).start();
    }
}
