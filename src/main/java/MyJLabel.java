import javax.swing.*;
import java.awt.*;

public class MyJLabel extends JLabel {
    Font myFont = new Font("Gisha", Font.BOLD, 30);
    private JLabel label;

    public MyJLabel(String text, int x, int y, int width, int height) {
        this.label = new JLabel(text);
        this.label.setBounds(x, y, width, height);
        this.label.setFont(myFont);
    }

    public MyJLabel(String text, int x, int y, int width, int height, int fontSize) {
        this.label = new JLabel(text);
        this.label.setBounds(x, y, width, height);
        Font newFont = new Font("Gisha", Font.BOLD, fontSize);
        this.label.setFont(newFont);
    }
    public MyJLabel(String text, int x, int y, int width, int height, int fontSize, Color color) {
        this.label = new JLabel(text);
        this.label.setBounds(x, y, width, height);
        Font newFont = new Font("Gisha",Font.BOLD,fontSize);
        this.label.setForeground(color);
        this.label.setFont(newFont);
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }
}
