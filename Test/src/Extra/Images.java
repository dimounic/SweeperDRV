package Extra;

import Frames.Frame;
import Scenes.GameScene;
import Scenes.MenuScene;

import javax.imageio.ImageIO;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

public enum Images {

    ONE("1.png"),
    TWO("2.png"),
    THREE("3.png"),
    FOUR("4.png"),
    FIVE("5.png"),
    SIX("6.png"),
    SEVEN("7.png"),
    EIGHT("8.png"),
    BLOCKED("Block.png"),
    EMPTY("EmptyBlock.png"),
    FLAG("Cross.png"),
    DANGERBLOCK("DangerBlock.png"),
    CURSOR("shovel.png"),
    SIGN("Sign.png"),
    BACKGROUND("Background.png"),
    MENUBUTTON("Button.png"),
    VICTORY("VictorySign.png"),
    DEFEAT("GameOverSign.png"),
    LOADSCENE0("loadInScene.png"),
    LOADSCENE1("loadInScene1.png"),
    LOADSCENE2("loadInScene2.png"),
    LOADSCENE3("loadInScene3.png"),
    LOADSCENE4("loadInScene4.png"),
    LOADSCENE5("loadInScene5.png"),
    LOADSCENE6("loadInScene6.png"),
    LOADSCENE7("loadInScene7.png"),
    LOADSCENE8("loadInScene8.png"),
    LOADSCENE9("loadInScene9.png"),
    LOADSCENE10("loadInScene10.png"),
    LOADSCENE11("loadInScene11.png"),
    LOADSCENE12("loadInScene12.png"),
    LOADSCENE13("loadInScene13.png"),
    LOADSCENE14("loadInScene14.png"),
    LOADSCENE15("loadInScene15.png"),
    LOADSCENE16("loadInScene16.png"),
    LOADSCENE17("loadInScene17.png");


    private final boolean DEBUG = true;

    private final String path;
    Map<String, Image> imageMap = new HashMap<>();

    Images(String path) {
        this.path = path;
    }

    public Image image(String text) {
        if (imageMap.containsKey(path)) {
            return imageMap.get(path);
        } else {
            BufferedImage image;
            try {
                if (DEBUG) {
                    image = ImageIO.read(new File("res/" + path));
                } else {
                    image = ImageIO.read(getClass().getResource("/" + path));
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (text.equals("MenuButton")) {
                Image scaledImage = image.getScaledInstance(MenuScene.getChangeBtSizeWidth(), MenuScene.getChangeBtSizeHeight(), Image.SCALE_SMOOTH);
                imageMap.put(path, scaledImage);
                return scaledImage;
            } else if (text.equals("block")) {
                Image scaledImage = image.getScaledInstance(GameScene.blockSize, GameScene.blockSize, Image.SCALE_SMOOTH);
                imageMap.put(path, scaledImage);
                return scaledImage;
            } else if (text.equals("MenuImage")) {
                Image scaledImage = image.getScaledInstance((int) Frame.getDisplayWIDTH(), (int) Frame.getDisplayHEIGHT(), Image.SCALE_SMOOTH);
                imageMap.put(path, scaledImage);
                return scaledImage;
            }else if (text.equals("Sign")) {
            Image scaledImage = image.getScaledInstance((int) Frame.getDisplayWIDTH() /2, (int) Frame.getDisplayHEIGHT() /2, Image.SCALE_SMOOTH);
            imageMap.put(path, scaledImage);
            return scaledImage;
        }
                return image;


            }
        }
    }