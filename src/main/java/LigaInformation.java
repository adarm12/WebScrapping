
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LigaInformation extends JPanel implements ActionListener {

    public static int TITLE_X = 200, TITLE_Y = 0, TITLE_WIDTH = 500, TITLE_HEIGHT = 150, TITLE_FONT_SIZE = 45;
    public static int COMBO_BOX_X = 500, COMBO_BOX_Y = 150, COMBO_BOX_WIDTH = 250, COMBO_BOX_HEIGHT = 35;

    private ImageIcon background;
    private JLabel backgroundLabel;
    private JComboBox groupIndexCombo;

    public LigaInformation(int x, int y, int width, int height, String text) {
        this.setBounds(x, y, width, height);
        this.setLayout(null);

        JLabel title = new MyJLabel(text, TITLE_X, TITLE_Y, TITLE_WIDTH, TITLE_HEIGHT, TITLE_FONT_SIZE, Color.white).getLabel();
        this.add(title);

        comboBoxDetails(20); ////***************************************************

        backgroundDetails(x, y, width, height);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == groupIndexCombo) {
            System.out.println(groupIndexCombo.getSelectedItem());
        }
    }

    public void comboBoxDetails(int size) {
        ArrayList<String> index = new ArrayList<String>();
        for (int i = 1; i < size; i++) {
            index.add("" + i);
        }
        groupIndexCombo = new JComboBox(index.toArray());
        groupIndexCombo.addActionListener(this);
        groupIndexCombo.setBounds(COMBO_BOX_X, COMBO_BOX_Y, COMBO_BOX_WIDTH, COMBO_BOX_HEIGHT);
        groupIndexCombo.setFont(new Font("Gisha", Font.BOLD, 20));
        this.add(groupIndexCombo);
    }

    public void backgroundDetails(int x, int y, int width, int height) {
        background = new ImageIcon("grass1.jpg");
        backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(x, y, width, height);
        this.add(backgroundLabel);
    }

}