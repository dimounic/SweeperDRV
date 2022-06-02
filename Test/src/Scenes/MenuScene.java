package Scenes;

import Extra.Images;
import Extra.clickDaten;
import Frames.Frame;
import Panel.ScenePanel;

import java.awt.*;
import java.awt.event.MouseEvent;


public class MenuScene extends Scene {


    private static int btSizeWidth = (int) (381 / Frame.displayScaleX);
    private static int btSizeHeight = (int) (100 / Frame.displayScaleY);
    private static int changeBtSizeHeight = btSizeHeight;
    private static int changeBtSizeWidth = btSizeWidth;
    private final int btPosX = (int) (774 / Frame.displayScaleX);
    private final int btPosY = (int) (515 / Frame.displayScaleY);
    clickDaten[] clickArray = new clickDaten[10];
    private boolean isEntered;


    @Override
    public void drawScene(Graphics g) {
        Graphics2D G2D = (Graphics2D) g;

        G2D.drawImage(Images.BACKGROUND.image("MenuImage"), 0, 0, null);

        G2D.drawImage(Images.MENUBUTTON.image("MenuButton"), btPosX, btPosY, null);
        clickArray[0] = new clickDaten(btPosX, btPosY, btPosX + btSizeWidth, btPosY + btSizeHeight);

        G2D.setFont(new Font("Arial", Font.BOLD, 51));
        G2D.drawString("Start", (int) (895/Frame.displayScaleX), (int) (585/Frame.displayScaleY));

        G2D.drawImage(Images.MENUBUTTON.image("MenuButton"), btPosX, (btPosY + btSizeHeight) + 2, null);
        clickArray[1] = new clickDaten(btPosX, btPosY + btSizeHeight + 2, btPosX + btSizeWidth, btPosY + btSizeHeight * 2 +2);

        G2D.drawImage(Images.MENUBUTTON.image("MenuButton"), btPosX, (btPosY + (btSizeHeight * 2)) + 4, null);
        clickArray[2] = new clickDaten(btPosX, (btPosY + (btSizeHeight * 2)) + 4, btPosX + btSizeWidth, (btPosY + (btSizeHeight * 3)) + 4);

    }


    @Override
    public void cycleScene() {
        if (isEntered && changeBtSizeHeight == btSizeHeight + 10 && changeBtSizeWidth == btSizeWidth + 10) {
            changeBtSizeHeight++;
            changeBtSizeWidth++;
        } else if (!isEntered) {

        }
        ;
    }

    @Override
    public void handleClick(MouseEvent e) {

        if (checkCoordinates(0, e)) {
            System.out.println("funkt " + 0);

            ScenePanel.setActiveScene(new GameScene(30));
        }
        if (checkCoordinates(1, e)) {
            System.out.println("funkt " + 1);


        }
        if (checkCoordinates(2, e)) {
            System.out.println("funkt " + 2);
           System.exit(0);
        }


    }

    @Override
    public void handleOver(MouseEvent e) {


    }

    @Override
    public void handleExit(MouseEvent e) {

    }

    private boolean checkCoordinates(int index, MouseEvent e) {
        if (e.getX() >= clickArray[index].getTopX() && e.getX() <= clickArray[index].getDownX() && e.getY() >= clickArray[index].getTopY() && e.getY() <= clickArray[index].getDownY())
            return true;
        return false;
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
