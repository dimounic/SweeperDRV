package Panel;

import Scenes.MenuScene;
import Scenes.Scene;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ScenePanel extends JPanel implements Runnable, MouseListener {


    static Scene activeScene = new MenuScene();
     static final long DELAY = 5;
     Thread Threadi;

    public ScenePanel(){
    this.addMouseListener(this);
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

    @Override
    public void mouseClicked(MouseEvent e) {
        activeScene.handleClick(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        activeScene.handleOver(e);
        System.out.print("entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        activeScene.handleExit(e);
    }

    public Scene getActiveScene() {
        return activeScene;
    }

    public static void setActiveScene(Scene newActiveScene) {
        activeScene = newActiveScene;
    }
}
