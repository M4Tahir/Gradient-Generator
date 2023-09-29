import javax.swing.*;

public class Main extends JFrame {

    Main() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1300, 700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.add(new PanelSide());
        this.add(new PanelDisplay());

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
