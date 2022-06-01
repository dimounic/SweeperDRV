package Panel;

import Scenes.Scene;

import javax.swing.*;
import java.awt.*;

public class ScenePanel extends JPanel implements Runnable {
    Scene activeScene;
    public ScenePanel(){

    }

    @Override
    public void run() {
    repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
