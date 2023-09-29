import javax.swing.*;
import java.awt.*;

public class PanelDisplay extends JPanel {
    int r1, b1, g1, r2, b2, g2;
    int height = 700;
    int width = 1000;
    Color color1, color2;

    PanelDisplay() {
        this.setBounds(300, 0, 1000, 700);
        color1 = Color.black;
        color2 = Color.black;
    }

    public void Display(int r1, int g1, int b1, int r2, int g2, int b2) {
        this.r1 = r1;
        this.b1 = b1;
        this.g1 = g1;
        this.r2 = r2;
        this.b2 = b2;
        this.g2 = g2;
        color1 = new Color(r1, g1, b1);
        color2 = new Color(r2, g2, b2);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(0, 0, color1, width - 1, height - 1, color2);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width - 1, height - 1);
    }
}
