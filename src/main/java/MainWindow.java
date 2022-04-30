import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainWindow extends JFrame {
    public static final String WEB = "https://www.sport5.co.il/";
    public static final int WINDOW_X = 0, WINDOW_Y = 0, WINDOW_HEIGHT = 955, WINDOW_WIDTH = 1400;
    public static final int TITLE_MARGIN = 125, TITLE_Y = 200, TITLE_HEIGHT = 100, TITLE_FONT_SIZE = 38;
    public static final int ENTER_BUTTON_WIDTH = 400, ENTER_BUTTON_HEIGHT = 75;

    JLabel backgroundLabel;
    JButton enterButton;
    JLabel title;
    ImageIcon background;

    public MainWindow() {
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setTitle("Sport web scrapping by adar & shanit");

        try {
            Document web = Jsoup.connect(WEB).get();
            title = new MyJLabel(web.title(), TITLE_MARGIN,
                    TITLE_Y, WINDOW_WIDTH, TITLE_HEIGHT, TITLE_FONT_SIZE, Color.black).getLabel();
            this.add(title);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ImageIcon ballIcon = new ImageIcon("ballIcon.png");
        this.setIconImage(ballIcon.getImage());

        enterButton = new JButton("Enter to the menu");
        enterButton.setBounds(WINDOW_WIDTH / 2 - ENTER_BUTTON_WIDTH / 2, WINDOW_HEIGHT / 2 - ENTER_BUTTON_HEIGHT / 2,
                ENTER_BUTTON_WIDTH, ENTER_BUTTON_HEIGHT);
        enterButton.setFont(new Font("Gisha", Font.BOLD, 35));
        enterButton.setFocusable(false);
        this.add(enterButton);

        menuAllLigot();

        background = new ImageIcon("footballGate.png");
        backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(WINDOW_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        this.add(backgroundLabel);

        this.setVisible(true);
    }

    private void menuAllLigot() {
        enterButton.addActionListener((event ->
        {
            enterButton.setVisible(false);
            title.setVisible(false);
            backgroundLabel.setVisible(false);
            WebWindow webWindow = new WebWindow(WINDOW_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT, background);
            this.add(webWindow);
        }));
    }

    public static void main(String[] args) {
        new MainWindow();
       // WebSite.web();
    }
}