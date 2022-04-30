import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LigaInformation extends JPanel implements ActionListener {

    ImageIcon background;
    JLabel backgroundLabel;
    JComboBox teamIndex;

    public LigaInformation(int x, int y, int width, int height, String t) {
        this.setBounds(x, y, width, height);
        this.setLayout(null);

        JLabel title = new MyJLabel(t, 200, 0, 500, 150, 45, Color.white).getLabel();
        this.add(title);

        ArrayList<String> index = new ArrayList<String>();
        index.add("1");
        index.add("2");
        index.add("3");
        teamIndex = new JComboBox(index.toArray());
        teamIndex.addActionListener(this);
        teamIndex.setBounds(500,150,250,30);
        this.add(teamIndex);

        background = new ImageIcon("grass1.jpg");
        backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(x, y, width, height);
        this.add(backgroundLabel);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == teamIndex) {
            System.out.println(teamIndex.getSelectedItem());
        }
    }
}
