package Scenes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class Scene extends JPanel {
    public abstract void drawScene(Graphics g);
    public abstract void cycleScene();
    public abstract void handleClick(MouseEvent e);
    public abstract void handleOver(MouseEvent e);
    public abstract void handleExit(MouseEvent e);
}
