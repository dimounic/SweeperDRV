package Panels;



import Extra.Images;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    public ImagePanel(){
        setLayout(new BorderLayout());
        this.setBackground(new Color(1,1,1,0));
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(Images.SIGN.image("Sign"), 0, 0, null);
    }
}