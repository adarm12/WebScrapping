import javax.swing.*;
import java.awt.*;

public class LigaInformation extends JPanel {

    ImageIcon background;
    JLabel backgroundLabel;


    public LigaInformation(int x, int y, int width, int height, String t) {
        this.setBounds(x, y, width, height);
        this.setLayout(null);

        background = new ImageIcon("grass.jpg");
        backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(x, y,width,height);
        this.add(backgroundLabel);

//        JLabel tttt = new JLabel(t);
//        tttt.setBounds(250, 0, 500, 150);
//        this.add(tttt);

        JLabel title = new MyJLabel(t, 250,0, 500,150, 45, Color.pink).getLabel();
        this.add(title);
     //
        this.setVisible(true);
    }
}
