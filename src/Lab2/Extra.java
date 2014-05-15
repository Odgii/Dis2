
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author DolceVita
 */
public class Extra {

    public static void main(String[] args) {
        JFrame jf = new JFrame();
        final LineDrawer ld = new LineDrawer();
        jf.add(ld, BorderLayout.CENTER);
        jf.setSize(400, 400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

}

class LineDrawer extends JComponent {

    int originX, originY, destX;

    public LineDrawer() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                originX = e.getX();
                originY = e.getY();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                destX = e.getX();
                repaint();
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawLine(originX, originY, destX, originY);
    }

}
