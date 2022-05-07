
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LigaInformation extends JPanel implements ActionListener {

    public static int TITLE_X = 800, TITLE_Y = 0, TITLE_WIDTH = 500, TITLE_HEIGHT = 150, TITLE_FONT_SIZE = 50;
    public static int COMBO_BOX_X = 500, COMBO_BOX_Y = 170, COMBO_BOX_WIDTH = 200, COMBO_BOX_HEIGHT = 35, FONT_SIZE_COMBO = 20;
    public static int DESCRIPTION_COMBO_X = 750, DESCRIPTION_COMBO_Y = 150, DESCRIPTION_COMBO_WIDTH = 600,
            DESCRIPTION_COMBO_HEIGHT = 70, FONT_SIZE_DESCRIPTION_COMBO_ = 30;

    private ImageIcon background;
    private JLabel backgroundLabel;
    private JComboBox groupIndexCombo;
    private Document ligaPage;

    public LigaInformation(int x, int y, int width, int height, String text, Document ligaPage) {
        this.setBounds(x, y, width, height);
        this.setLayout(null);

        JLabel title = new MyJLabel(text, TITLE_X, TITLE_Y, TITLE_WIDTH, TITLE_HEIGHT, TITLE_FONT_SIZE, Color.white).getLabel();
        this.add(title);
        JLabel descriptionCombo = new MyJLabel("בחר את המיקום הרצוי מתוך הרשימה הבאה:", DESCRIPTION_COMBO_X, DESCRIPTION_COMBO_Y,
                DESCRIPTION_COMBO_WIDTH, DESCRIPTION_COMBO_HEIGHT, FONT_SIZE_DESCRIPTION_COMBO_, Color.white).getLabel();
        this.add(descriptionCombo);

        this.ligaPage = ligaPage;
        comboBoxDetails(amountOfGroups(scoreTable(ligaPage)));

        backgroundDetails(x, y, width, height);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == groupIndexCombo) {
            System.out.println(groupIndexCombo.getSelectedItem() + " index:" + groupIndexCombo.getSelectedIndex());
            showSelectedGroup(this.ligaPage, groupIndexCombo.getSelectedIndex());
        }
    }

    private ArrayList<Element> scoreTable(Document ligaPage) {
        ArrayList<Element> allTable = ligaPage.getElementsByClass("score-list");
        ArrayList<Element> table = allTable.get(0).getElementsByTag("table").get(0).getElementsByTag("tbody");
        return table;
    }

    private int amountOfGroups(ArrayList<Element> table) {
        int num = table.get(0).childrenSize();
        return num;
    }

    private void showSelectedGroup(Document ligaPage, int index) {
        if (index != 0) {
            ArrayList<Element> table = scoreTable(ligaPage);
            Element group = table.get(0).child(index);
            String groupName = group.getElementsByClass("big").text();
            String groupScore = group.child(8).text();
            String groupInformation = (groupName + "     " + groupScore);
            System.out.println(groupInformation);
            scoreBored(groupInformation);
        }
    }

    private void scoreBored(String groupInformation) {
        JLabel showGroupInformation = new MyJLabel(groupInformation, 0,  0,
                500, 500, FONT_SIZE_DESCRIPTION_COMBO_, Color.white).getLabel();
        this.add(showGroupInformation);
    }

    private void comboBoxDetails(int size) {
        ArrayList<String> index = new ArrayList<String>();
        index.add("");
        for (int i = 1; i < size; i++) {
            index.add("" + i);
        }
        groupIndexCombo = new JComboBox(index.toArray());
        groupIndexCombo.addActionListener(this);
        groupIndexCombo.setBounds(COMBO_BOX_X, COMBO_BOX_Y, COMBO_BOX_WIDTH, COMBO_BOX_HEIGHT);
        groupIndexCombo.setFont(new Font("Gisha", Font.BOLD, FONT_SIZE_COMBO));
        this.add(groupIndexCombo);
    }

    private void backgroundDetails(int x, int y, int width, int height) {
        background = new ImageIcon("A.jpg");
        backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(x, y, width, height);
        this.add(backgroundLabel);
    }
}