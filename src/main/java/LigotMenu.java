
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.util.ArrayList;


public class LigotMenu extends JPanel implements ActionListener {
    public static final int BUTTON_SPANISH_X = 150, BUTTON_SPANISH_Y = 180, BUTTON_HEIGHT_MARGIN = 55, BUTTON_WIDTH_MARGIN = 130;
    public static final int TITLE_X = 480, TITLE_Y = 25, TITLE_WIDTH = 450, TITLE_HEIGHT = 100, TITLE_FONT_SIZE = 40;

    private ArrayList<JButton> allLigaButtons = createLigaButtons();
    private JLabel title;
    private JLabel backgroundLabel;

    public LigotMenu(int x, int y, int width, int height, ImageIcon background) {
        this.setBounds(x, y, width, height);
        this.setLayout(null);

        for (int i = 0; i < allLigaButtons.size(); i++) {
            this.add(allLigaButtons.get(i));
            allLigaButtons.get(i).addActionListener(this);
        }

        title = new MyJLabel("רשימת הליגות:", TITLE_X, TITLE_Y, TITLE_WIDTH
                , TITLE_HEIGHT, TITLE_FONT_SIZE, Color.pink).getLabel();
        this.add(title);

        backgroundDetails(x, y, width, height, background);

        this.setVisible(true);
    }

    private ArrayList<JButton> createLigaButtons() {
        ArrayList<JButton> allLigaButtons = new ArrayList<>();

        JButton spanishLiga = new MyJButton("ליגה ספרדית", BUTTON_SPANISH_X, BUTTON_SPANISH_Y).getButton();
        allLigaButtons.add(spanishLiga);

        JButton frenchLiga = new MyJButton("ליגה צרפתית",
                spanishLiga.getX() + spanishLiga.getWidth() + BUTTON_WIDTH_MARGIN
                , spanishLiga.getY()).getButton();
        allLigaButtons.add(frenchLiga);

        JButton germanLiga = new MyJButton("ליגה גרמנית",
                frenchLiga.getX() + frenchLiga.getWidth() + BUTTON_WIDTH_MARGIN,
                frenchLiga.getY()).getButton();
        allLigaButtons.add(germanLiga);

        JButton italianLiga = new MyJButton("ליגה איטלקית", spanishLiga.getX(),
                spanishLiga.getY() + spanishLiga.getHeight() + BUTTON_HEIGHT_MARGIN).getButton();
        allLigaButtons.add(italianLiga);

        JButton dutchLiga = new MyJButton("ליגה הולנדית", italianLiga.getX() + italianLiga.getWidth() + BUTTON_WIDTH_MARGIN
                , italianLiga.getY()).getButton();
        allLigaButtons.add(dutchLiga);

        JButton belgianLiga = new MyJButton("ליגה בלגית", dutchLiga.getX() + dutchLiga.getWidth() + BUTTON_WIDTH_MARGIN
                , dutchLiga.getY()).getButton();
        allLigaButtons.add(belgianLiga);

        return allLigaButtons;
    }

    public void actionPerformed(ActionEvent e) {
        try {
            Document web = Jsoup.connect(MainWebWindow.WEB).get();
            Element titleBar = web.getElementById("header").getElementById("nav");
            Element globalFootball = titleBar.child(1).child(1);
            String globalFootballLink = globalFootball.getElementsByTag("a").attr("href");
            Document globalFootballPage = Jsoup.connect(globalFootballLink).get();
            ArrayList<Element> allLigot = globalFootballPage.getElementsByClass("add-nav-liga");

            for (int i = 0; i < allLigaButtons.size(); i++) {
                if (e.getSource() == allLigaButtons.get(i)) {
                    Element currentElement = allLigot.get(0).child(0);
                    for (int j = 0; j < currentElement.childrenSize(); j++) {
                        if (allLigaButtons.get(i).getText().equals(currentElement.child(j).text())) {
                            Element liga = currentElement.child(j);
                            String linkLiga = liga.child(0).attr("href");
                            Document ligaPage = Jsoup.connect(linkLiga).get();
                            hideWindow();

                            LigaInformation ligaInformation = new LigaInformation(0, 0, MainWebWindow.WINDOW_WIDTH,
                                    MainWebWindow.WINDOW_HEIGHT, allLigaButtons.get(i).getText(), ligaPage);
                            this.add(ligaInformation);
                        }
                    }
                }
            }
        } catch (IOException ea) {
            ea.printStackTrace();
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