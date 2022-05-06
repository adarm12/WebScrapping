
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;


public class WebWindow extends JPanel implements ActionListener {
    public static final int BUTTON_SPANISH_X = 150, BUTTON_SPANISH_Y = 180, BUTTON_HEIGHT_MARGIN = 55, BUTTON_WIDTH_MARGIN = 130;
    public static final int TITLE_X = 480, TITLE_Y = 25, TITLE_WIDTH = 450, TITLE_HEIGHT = 100, TITLE_FONT_SIZE = 40;
    public static final String SPANISH_LIGA = "Spanish Liga";

    private ArrayList<JButton> allLigaButtons = createLigaButtons();
    private JLabel title;
    private JLabel backgroundLabel;

    public WebWindow(int x, int y, int width, int height, ImageIcon background) {
        this.setBounds(x, y, width, height);
        this.setLayout(null);

        for (int i = 0; i < allLigaButtons.size(); i++) {
            this.add(allLigaButtons.get(i));
            allLigaButtons.get(i).addActionListener(this);
        }

        title = new MyJLabel("Football Leagues List", TITLE_X, TITLE_Y, TITLE_WIDTH
                , TITLE_HEIGHT, TITLE_FONT_SIZE, Color.pink).getLabel();
        this.add(title);

        backgroundDetails(x, y, width, height, background);

        this.setVisible(true);
    }

    private ArrayList<JButton> createLigaButtons() {
        ArrayList<JButton> allLigaButtons = new ArrayList<>();

        JButton spanishLiga = new MyJButton("Spanish Liga", BUTTON_SPANISH_X, BUTTON_SPANISH_Y).getButton(); // ליגה ספרדית
        allLigaButtons.add(spanishLiga);

        JButton frenchLiga = new MyJButton("French Liga",
                spanishLiga.getX() + spanishLiga.getWidth() + BUTTON_WIDTH_MARGIN
                , spanishLiga.getY()).getButton(); // ליגה צרפתית
        allLigaButtons.add(frenchLiga);

        JButton germanLiga = new MyJButton("German Liga",
                frenchLiga.getX() + frenchLiga.getWidth() + BUTTON_WIDTH_MARGIN,
                frenchLiga.getY()).getButton(); //ליגה גרמנית
        allLigaButtons.add(germanLiga);

        JButton italianLiga = new MyJButton("Italian Liga", spanishLiga.getX(),
                spanishLiga.getY() + spanishLiga.getHeight() + BUTTON_HEIGHT_MARGIN).getButton(); // ליגה איטלקית
        allLigaButtons.add(italianLiga);

        JButton dutchLiga = new MyJButton("Dutch Liga", italianLiga.getX() + italianLiga.getWidth() + BUTTON_WIDTH_MARGIN
                , italianLiga.getY()).getButton(); // ליגה הולנדית
        allLigaButtons.add(dutchLiga);

        JButton belgianLiga = new MyJButton("Belgian Liga", dutchLiga.getX() + dutchLiga.getWidth() + BUTTON_WIDTH_MARGIN
                , dutchLiga.getY()).getButton(); // ליגה בלגית
        allLigaButtons.add(belgianLiga);

        return allLigaButtons;
    }

    public void actionPerformed(ActionEvent e) {
        int x;
        for (int i = 0; i < allLigaButtons.size(); i++) {
            if (e.getSource() == allLigaButtons.get(i)) {

                System.out.println(allLigaButtons.get(i).getText());
                hideWindow();


// TODO add choose LIga


                LigaInformation ligaInformation = new LigaInformation(0, 0, MainWindow.WINDOW_WIDTH, MainWindow.WINDOW_HEIGHT
                        , allLigaButtons.get(i).getText());
                this.add(ligaInformation);
            }
        }
    }

    private void hideWindow() {
        title.setVisible(false);
        backgroundLabel.setVisible(false);
        for (int i = 0; i < allLigaButtons.size(); i++) {
            allLigaButtons.get(i).setVisible(false);
        }
    }

    private void backgroundDetails(int x, int y, int width, int height, ImageIcon background) {
        backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(x, y, width, height);
        this.add(backgroundLabel);
    }
}