package Panels;



import Extra.Images;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    public MenuPanel() {
        setBackground(Color.BLACK);
        setLayout(new BorderLayout());
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(Images.BACKGROUND.image(""), 0, 0, null);
    }
}