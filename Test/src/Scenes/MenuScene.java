package Scenes;

import Extra.Images;
import Frames.Frame;
import Panel.ScenePanel;

import java.awt.*;
import java.awt.event.MouseEvent;


public class MenuScene extends Scene {


    private static int btSizeWidth = (Frame.getDisplayWIDTH() / 4);
    private static int btSizeHeight = (Frame.getDisplayHEIGHT() / 3) / 3;
    private static int changeBtSizeHeight = btSizeHeight;
    private static int changeBtSizeWidth = btSizeWidth;
    private final int btPosX = (Frame.getDisplayWIDTH() / 2) - (btSizeWidth / 2);
    private final int btPosY = (Frame.getDisplayHEIGHT() / 2);
    private final Dimension btStartTopLeft = new Dimension(btPosX, btPosY);
    private final Dimension btStartDownRight = new Dimension(btPosX + btSizeWidth, btPosY + btSizeHeight);
    private boolean isEntered;

    @Override
    public void drawScene(Graphics g) {
        Graphics2D G2D = (Graphics2D) g;
        G2D.drawImage(Images.BACKGROUND.image(""), 0, 0, null);
        G2D.drawImage(Images.MENUBUTTON.image("MenuButton"), btPosX, btPosY, null);
        G2D.setFont(new Font("Arial", Font.BOLD, 50));
        G2D.drawString("Start", getCenterOfButton(btPosX, btPosY).width, getCenterOfButton(btPosX, btPosY).height);
        G2D.drawImage(Images.MENUBUTTON.image("MenuButton"), btPosX, (btPosY + btSizeHeight) + 2, null);
        G2D.drawImage(Images.MENUBUTTON.image("MenuButton"), btPosX, (btPosY + (btSizeHeight * 2)) + 4, null);


    }

    private Dimension getCenterOfButton(int posX, int posY) {
        return new Dimension(posX + (btSizeWidth / 2), posY + (btSizeHeight / 2));
    }



    @Override
    public void cycleScene() {
        if (isEntered && changeBtSizeHeight == btSizeHeight + 10 && changeBtSizeWidth == btSizeWidth + 10) {
            changeBtSizeHeight++;
            changeBtSizeWidth++;
        } else if (!isEntered){

        };
    }

    @Override
    public void handleClick(MouseEvent e) {

        if (e.getX() >= btStartTopLeft.width && e.getX() <= btStartDownRight.width && e.getY() >= btStartTopLeft.height && e.getY() <= btStartDownRight.height) {
            System.out.print("funkt");
            ScenePanel.setActiveScene(new GameScene(30));
        }


    }

    @Override
    public void handleOver(MouseEvent e) {

        if (e.getX() >= btStartTopLeft.width && e.getX() <= btStartDownRight.width && e.getY() >= btStartTopLeft.height && e.getY() <= btStartDownRight.height) {
            System.out.print("button entered");
            isEntered = true;
        }
    }

    @Override
    public void handleExit(MouseEvent e) {
        if (e.getX() >= btStartTopLeft.width && e.getX() <= btStartDownRight.width && e.getY() >= btStartTopLeft.height && e.getY() <= btStartDownRight.height) {
            isEntered = false;
        }
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

    public static int getChangeBtSizeHeight() {
        return changeBtSizeHeight;
    }

    public static void setChangeBtSizeHeight(int changeBtSizeHeight) {
        MenuScene.changeBtSizeHeight = changeBtSizeHeight;
    }

    public static int getChangeBtSizeWidth() {
        return changeBtSizeWidth;
    }

    public static void setChangeBtSizeWidth(int changeBtSizeWidth) {
        MenuScene.changeBtSizeWidth = changeBtSizeWidth;
    }

}
