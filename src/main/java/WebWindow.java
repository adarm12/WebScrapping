import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class WebWindow extends JPanel implements ActionListener{
    public static final int BUTTON_WIDTH = 270, BUTTON_HEIGHT = 100, BUTTON_HEIGHT_MARGIN = 55, BUTTON_WIDTH_MARGIN = 130;
    public static final int TITLE_X = 480, TITLE_Y = 25, TITLE_WIDTH = 450, TITLE_HEIGHT = 100, TITLE_FONT_SIZE = 40;
    public Font myFont = new Font("Gisha", Font.BOLD, 30);

    ArrayList<JButton> allLigaButtons = createLigaButtons();

    public WebWindow(int x, int y, int width, int height, ImageIcon background) {
        this.setBounds(x, y, width, height);
        this.setLayout(null);

        for (int i = 0; i < allLigaButtons.size(); i++) {
            this.add(allLigaButtons.get(i));
        }

        JLabel title = new MyJLabel("Football Leagues List", TITLE_X, TITLE_Y, TITLE_WIDTH
                , TITLE_HEIGHT, TITLE_FONT_SIZE, Color.pink).getLabel();
        this.add(title);

        JLabel backgroundLabel = new JLabel(background);
        backgroundLabel.setBounds(x, y, width, height);
        this.add(backgroundLabel);

        this.setVisible(true);
    }

    public JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, BUTTON_WIDTH, BUTTON_HEIGHT);
        button.setFont(myFont);
        button.setFocusable(false);
        return button;
    }

    public ArrayList<JButton> createLigaButtons() {
        ArrayList<JButton> allLigaButtons = new ArrayList<>();

        JButton spanishLiga = createButton("Spanish Liga", 150, 180); // ליגה ספרדית
        allLigaButtons.add(spanishLiga);

        JButton frenchLiga = createButton("French Liga",
                spanishLiga.getX() + spanishLiga.getWidth() + BUTTON_WIDTH_MARGIN
                , spanishLiga.getY()); // ליגה צרפתית
        allLigaButtons.add(frenchLiga);

        JButton germanLiga = createButton("German Liga",
                frenchLiga.getX() + frenchLiga.getWidth() + BUTTON_WIDTH_MARGIN,
                frenchLiga.getY()); //ליגה גרמנית
        allLigaButtons.add(germanLiga);

        JButton italianLiga = createButton("Italian Liga", spanishLiga.getX(),
                spanishLiga.getY() + spanishLiga.getHeight() + BUTTON_HEIGHT_MARGIN); // ליגה איטלקית
        allLigaButtons.add(italianLiga);

        JButton dutchLiga = createButton("Dutch Liga", italianLiga.getX() + italianLiga.getWidth() + BUTTON_WIDTH_MARGIN
                , italianLiga.getY()); // ליגה הולנדית
        allLigaButtons.add(dutchLiga);

        JButton belgianLiga = createButton("Belgian Liga", dutchLiga.getX() + dutchLiga.getWidth() + BUTTON_WIDTH_MARGIN
                , dutchLiga.getY()); // ליגה בלגית
        allLigaButtons.add(belgianLiga);

        return allLigaButtons;
    }

    public void actionPerformed(ActionEvent e) {
        JButton selected = new JButton();
        for (int i = 0; i < allLigaButtons.size(); i++) {
            if (e.getSource() == allLigaButtons.get(i))
            {
                System.out.println(allLigaButtons.get(i));
            }
        }

    }
}