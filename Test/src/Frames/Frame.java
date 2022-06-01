package Frames;

import javax.swing.*;
import java.awt.*;
import Panel.ScenePanel;

public class Frame extends JFrame {
    public Frame(){
        setPreferredSize(new Dimension(1920,1080));
        setMinimumSize(new Dimension(1920,1080));
        setMaximumSize(new Dimension(1920,1080));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new ScenePanel());
        setVisible(true);
    }
}
