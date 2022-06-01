package Scenes;

import javax.swing.*;
import java.awt.*;

public abstract class Scene extends JPanel {
    public abstract void drawScene(Graphics g);
    public abstract void cycleScene();
}
