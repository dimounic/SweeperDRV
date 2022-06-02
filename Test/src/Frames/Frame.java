package Frames;

import javax.swing.*;
import java.awt.*;
import Panel.ScenePanel;

public class Frame extends JFrame {
    public static double displayHEIGHT;
    public static double displayWIDTH;
    public static double displayScaleX;
    public static double displayScaleY;

    public Frame(){
       Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize(DimMax);
        setMinimumSize(DimMax);
        setMaximumSize(DimMax);
       /* setPreferredSize(new Dimension(1920,1080));
        setMinimumSize(new Dimension(1920,1080));
        setMaximumSize(new Dimension(1920,1080));*/
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLocationRelativeTo(null);
        displayHEIGHT = getHeight();
        displayWIDTH = getWidth();
setBackground(Color.BLACK);



        displayScaleX = 1920 / displayWIDTH;
        displayScaleY = 1080 / displayHEIGHT;

        System.out.println(displayHEIGHT);
        System.out.println(displayWIDTH);
        System.out.println(displayScaleX);
        System.out.println(displayScaleY);

        add(new ScenePanel());
        setVisible(true);
    }


    public static double getDisplayHEIGHT() {
        return displayHEIGHT;
    }

    public static double getDisplayWIDTH() {
        return displayWIDTH;
    }
}
