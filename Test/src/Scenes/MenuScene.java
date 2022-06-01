package Scenes;

import Extra.Images;
import Frames.Frame;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuScene extends Scene implements MouseListener {


    private static int btSizeWidth =(Frame.getDisplayWIDTH()/4);
    private static int btSizeHeight = (Frame.getDisplayHEIGHT()/2)/3;
    private int btPosX = (Frame.getDisplayWIDTH()/2)-(btSizeWidth/2);
    private int btPosY = (Frame.getDisplayHEIGHT()/2);

    @Override
    public void drawScene(Graphics g) {
    Graphics2D G2D = (Graphics2D) g;
    G2D.drawImage(Images.BACKGROUND.image(""),0,0,null );
    G2D.drawImage(Images.MENUBUTTON.image("MenuButton"),btPosX,btPosY,null );

    }

    @Override
    public void cycleScene() {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    public static int getBtSizeWidth() {
        return btSizeWidth;
    }

    public static void setBtSizeWidth(int btSizeWidth) {
        MenuScene.btSizeWidth = btSizeWidth;
    }

    public static int getBtSizeHeight() {
        return btSizeHeight;
    }

    public static void setBtSizeHeight(int btSizeHeight) {
        MenuScene.btSizeHeight = btSizeHeight;
    }

}
