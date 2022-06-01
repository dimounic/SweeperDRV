package Frames;

import javax.swing.*;
import java.awt.*;
import Panel.ScenePanel;

public class Frame extends JFrame {
    public static int displayHEIGHT;
    public static int displayWIDTH;

    public Frame(){
       // Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize(new Dimension(1920,1080));
        setMinimumSize(new Dimension(1920,1080));
        setMaximumSize(new Dimension(1920,1080));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        displayHEIGHT = getHeight();
        displayWIDTH = getWidth();
        add(new ScenePanel());
        setVisible(true);
    }


    public static int getDisplayHEIGHT() {
        return displayHEIGHT;
    }

    public static int getDisplayWIDTH() {
        return displayWIDTH;
    }
}
