package Extra;

import javax.imageio.ImageIO;

import Frames.Game;
import Panels.GameBoard;
import Panels.MenuPanel;


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
    MENUBUTTON("Button.png");

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
            if (text.equals("block")) {
                Image scaledImage = image.getScaledInstance(GameBoard.blockSize, GameBoard.blockSize, Image.SCALE_SMOOTH);
                imageMap.put(path, scaledImage);
                return scaledImage;
            } else if (text.equals("button")) {
                Image scaledImage = image.getScaledInstance((int) (Game.getStWIDTH() - ((Game.getStWIDTH() - Game.getStHEIGHT()) / 1.0) * 2), ((Game.getStHEIGHT() / 2) / 5) - 20, Image.SCALE_SMOOTH);
                imageMap.put(path, scaledImage);
                return scaledImage;
            } else if (text.equals("buttonEntered")) {
                Image scaledImage = image.getScaledInstance((int) (Game.getStWIDTH() - ((Game.getStWIDTH() - Game.getStHEIGHT()) / 1.1) * 2) + 100, (((Game.getStHEIGHT() / 2) / 5) - 20) + 100, Image.SCALE_SMOOTH);
                imageMap.put(path, scaledImage);
                return scaledImage;
            } else if (text.equals("buttonClicked")) {
                Image scaledImage = image.getScaledInstance((int) (Game.getStWIDTH() - ((Game.getStWIDTH() - Game.getStHEIGHT()) / 1.1) * 2) - 100, (((Game.getStHEIGHT() / 2) / 5) - 20) + -100, Image.SCALE_SMOOTH);
                imageMap.put(path, scaledImage);
                return scaledImage;
            } else if (text.equals("Sign")) {
                Image scaledImage = image.getScaledInstance((Game.getStWIDTH() / 2), (Game.getStHEIGHT() / 2), Image.SCALE_SMOOTH);
                imageMap.put(path, scaledImage);
                return scaledImage;
            } else return image;

        }
    }
}