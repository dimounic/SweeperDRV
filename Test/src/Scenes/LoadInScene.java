package Scenes;

import Extra.Images;
import Frames.Frame;
import Panel.ScenePanel;

import java.awt.*;
import java.awt.event.MouseEvent;

public class LoadInScene extends Scene{
    Image activeImage;
    int count = 0;
    @Override
    public void drawScene(Graphics g) {
        Graphics2D G2D = (Graphics2D) g;
        G2D.setBackground(Color.BLACK);
        G2D.drawRect(0,0, (int) Frame.getDisplayWIDTH(), (int) Frame.getDisplayHEIGHT());
        G2D.drawImage(activeImage,0,0,null);
    }

    @Override
    public void cycleScene() {
    switch (count){
        case 0 -> activeImage = Images.LOADSCENE0.image("");
        case 7 -> activeImage = Images.LOADSCENE1.image("");
        case 14 -> activeImage = Images.LOADSCENE2.image("");
        case 21 -> activeImage = Images.LOADSCENE3.image("");
        case 28 -> activeImage = Images.LOADSCENE4.image("");
        case 35 -> activeImage = Images.LOADSCENE5.image("");
        case 42 -> activeImage = Images.LOADSCENE6.image("");
        case 49 -> activeImage = Images.LOADSCENE7.image("");
        case 56 -> activeImage = Images.LOADSCENE8.image("");
        case 63 -> activeImage = Images.LOADSCENE9.image("");
        case 70 -> activeImage = Images.LOADSCENE10.image("");
        case 77 -> activeImage = Images.LOADSCENE11.image("");
        case 84 -> activeImage = Images.LOADSCENE12.image("");
        case 91 -> activeImage = Images.LOADSCENE13.image("");
        case 98 -> activeImage = Images.LOADSCENE14.image("");
        case 105 -> activeImage = Images.LOADSCENE15.image("");
        case 112 -> activeImage = Images.LOADSCENE16.image("");
        case 119 -> activeImage = Images.LOADSCENE17.image("");
        case 126 -> ScenePanel.setActiveScene(new MenuScene());
    }
    count++;
    }

    @Override
    public void handleClick(MouseEvent e) {

    }

    @Override
    public void handleOver(MouseEvent e) {

    }

    @Override
    public void handleExit(MouseEvent e) {

    }
}
