package Panel;

import Scenes.MenuScene;
import Scenes.Scene;

import javax.swing.*;
import java.awt.*;

public class ScenePanel extends JPanel implements Runnable {
    Scene activeScene = new MenuScene();
     static final long DELAY = 5;
     Thread Threadi;

    public ScenePanel(){

    }

    @Override
    public void addNotify() {
        super.addNotify();
        Threadi = new Thread(this);
        Threadi.start();
    }

    @Override
    public void run() {
    long beforetime,sleep,diffrenece;
    beforetime = System.currentTimeMillis();

    while (true){
        activeScene.cycleScene();
        repaint();

        diffrenece = System.currentTimeMillis() - beforetime;
        sleep = DELAY - diffrenece;

        if(sleep < 0){
            sleep = 2;
        }
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        beforetime = System.currentTimeMillis();
    }




    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        activeScene.drawScene(g);
    }
}
