import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class MouseClick implements MouseListener {

    public void mouseClicked(MouseEvent e) {
        String s= "X-Corrdinate = " + e.getX() + " y-Coordinate = " + e.getY();
        System.out.println("Mouse Clicked");
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public JButton actionPerformed(ActionEvent e, ArrayList<JButton> allButtons) {
        JButton selected = new JButton();
        for (int i = 0; i < allButtons.size(); i++) {
            if (e.getSource() == allButtons.get(i)) ;
            selected = allButtons.get(i);
        }
        return selected;
    }
}
