package Extra;

import Frames.Frame;

import java.awt.*;

public class Field {

    private int blockX;
    private int blockY;
    private String blockType;
    private boolean isOpen;
    private boolean isFLagged;


    private Field() {
        this.blockType = "Block";
        this.isOpen = false;
        this.isFLagged = false;
    }

    public Field(int x, int y) {
        this();
        this.blockX = x;
        this.blockY = y;

    }


    public void drawBlock(Graphics2D g) {
        Image image = null;
        if(isFLagged) {
            image = Images.FLAG.image("block");
        }else if(!isOpen) {
            image = Images.BLOCKED.image("block");
        }else if(isOpen && blockType == "Danger" && !isFLagged){
            image = Images.DANGERBLOCK.image("block");
        }else if(!isFLagged) {
            switch (blockType) {
                case "Block" : image = Images.BLOCKED.image("block"); break;
                case "Danger": image = Images.BLOCKED.image("block"); break;
                case "Empty": image = Images.EMPTY.image("block");break;
                case "0": image = Images.EMPTY.image("block"); break;
                case "1": image = Images.ONE.image("block"); break;
                case "2": image = Images.TWO.image("block"); break;
                case "3": image = Images.THREE.image("block"); break;
                case "4": image = Images.FOUR.image("block"); break;
                case "5": image = Images.FIVE.image("block"); break;
                case "6": image = Images.SIX.image("block"); break;
                case "7": image = Images.SEVEN.image("block"); break;
                case "8": image = Images.EIGHT.image("block"); break;
                case "FLAG": image = Images.FLAG.image("block"); break;
                default: break;
            }
        }
        g.drawImage(image, blockX,blockY,null);

    }
    public boolean isFLagged() {
        return isFLagged;
    }
    public void setFLagged(boolean isFLagged) {
        this.isFLagged = isFLagged;
    }

    public boolean isOpen() {
        return isOpen;
    }
    public void setOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public String getBlockType() {
        return blockType;
    }
    public void setBlockType(String blockType) {
        this.blockType = blockType;
    }
}