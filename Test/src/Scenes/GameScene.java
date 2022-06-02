package Scenes;

import Extra.Field;
import Extra.Images;
import Extra.clickDaten;
import Frames.Frame;
import Panel.ScenePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;
import java.util.Random;

public class GameScene extends Scene {

    private int gameBoardSize;
    private static final int GAME_PANEL_SIZE = (int) Frame.getDisplayHEIGHT();
    public static int blockSize;
    private int dangerBlocks;
    private Field[][] gameField;
    private String gameStatus = "";
    int moveX = (int) (-960 / Frame.displayScaleX);
    clickDaten[] clickArray;

    int localCount1 = 0;

    // private standard constructor
    private GameScene() {
        clickArray = new clickDaten[10];
        this.gameBoardSize = 9;
        this.dangerBlocks = 9;
        setupClickDaten();

    }


    // Parameter Constructor
    public GameScene(int size) {
        this();
        this.gameBoardSize = size;
        this.dangerBlocks = (int) (size * size) / 8;
        blockSize = GAME_PANEL_SIZE / size;
        initialize();

        // http://dev.usw.at/manual/java/javainsel/javainsel_15_032.htm
        Cursor c = getToolkit().createCustomCursor(
                new ImageIcon(Images.CURSOR.image("")).getImage(),
                new Point(10, 10), "Cursor");

        setCursor(c);
    }

    private void initialize() {
        gameField = new Field[this.gameBoardSize][this.gameBoardSize];
        for (int y = 0; y < this.gameBoardSize; y++) {
            for (int x = 0; x < this.gameBoardSize; x++) {
                gameField[y][x] = new Field(y * blockSize, x * blockSize);
            }
        }
        setDangerBlocks();
    }

    private void blockClicked(MouseEvent e) {
        int blockX = e.getY() / blockSize;
        int blockY = e.getX() / blockSize;

        if (e.getX() < GAME_PANEL_SIZE && gameStatus.equals("")) {
            if (e.getButton() == 1 && gameField[blockY][blockX].getBlockType() != "Danger"
                    && !gameField[blockY][blockX].isFLagged()) {
                checkForDangerBlocks(e);
            } else if (e.getButton() == 3)
                setFlag(blockX, blockY);
            else if (e.getButton() == 1 && Objects.equals(gameField[blockY][blockX].getBlockType(), "Danger") && !gameField[blockY][blockX].isFLagged()) {
                gameField[blockY][blockX].setOpen(true);
                gameStatus = "false";

            }
        }

        this.repaint();
        if (localCount1 >= (gameBoardSize * gameBoardSize) - dangerBlocks) {
            gameStatus = "true";

        }

    }

    private void setFlag(int blockX, int blockY) {
        if (!gameField[blockY][blockX].isOpen() && !gameField[blockY][blockX].isFLagged()) {
            gameField[blockY][blockX].setFLagged(true);
        } else if (gameField[blockY][blockX].isFLagged()) {
            gameField[blockY][blockX].setFLagged(false);
        }
    }

    private void checkForDangerBlocks(MouseEvent e) {
        int x = e.getX() / blockSize;
        int y = e.getY() / blockSize;
        recursiveCheck(x, y);
    }

    private void recursiveCheck(int x, int y) {
        if (!gameField[x][y].isOpen() && !gameField[x][y].isFLagged()) {
            Integer localCount = 0;
            for (int i = x - 1; i < x + 2; i++) {
                for (int j = y - 1; j < y + 2; j++) {
                    if (i >= 0 && i < gameField.length && j >= 0 && j < gameField.length) {
                        if (Objects.equals(gameField[i][j].getBlockType(), "Danger")) {
                            localCount += 1;
                        }
                    }
                }
            }
            gameField[x][y].setBlockType(localCount.toString());
            gameField[x][y].setOpen(true);
            this.localCount1 += 1;

            if (localCount == 0) {
                for (int i = x - 1; i < x + 2; i++) {
                    for (int j = y - 1; j < y + 2; j++) {
                        if (i >= 0 && i < gameField.length && j >= 0 && j < gameField.length
                                && !gameField[i][j].isOpen()) {
                            recursiveCheck(i, j);
                        }
                    }
                }
            }
        }
    }


    private void drawBlocks(Graphics2D g) {
        for (int y = 0; y < this.gameBoardSize; y++) {
            for (int x = 0; x < this.gameBoardSize; x++) {
                gameField[y][x].drawBlock(g);
            }
        }
    }

    private void setDangerBlocks() {
        for (int i = 0; i < dangerBlocks; i++) {
            Random random = new Random();
            int randomColumn = random.nextInt(0, gameBoardSize);
            int randomRow = random.nextInt(0, gameBoardSize);
            if (!Objects.equals(gameField[randomColumn][randomRow].getBlockType(), "Danger"))
                gameField[randomColumn][randomRow].setBlockType("Danger");
            else
                i--;
        }
        this.repaint();
    }

    @Override
    public void drawScene(Graphics g) {
        drawBlocks((Graphics2D) g);
        Graphics2D G2D = (Graphics2D) g;
        if (gameStatus.equals("true")) {
            //G2D.setColor(Color.GREEN);
            // G2D.drawRect(moveX,Frame.getDisplayHEIGHT()/2 - 270,960,540);
           // G2D.drawImage(Images.VICTORY.image(""), moveX, Frame.getDisplayHEIGHT() / 2 - 270, null);
            G2D.drawImage(Images.VICTORY.image("Sign"), (int) (moveX * Frame.displayScaleX), (int) (270*Frame.displayScaleY), null);
        } else if (gameStatus.equals("false")) {


            // G2D.drawRect(moveX,Frame.getDisplayHEIGHT()/2 - 270,960,540);
            //G2D.drawImage(Images.DEFEAT.image(""), moveX, Frame.getDisplayHEIGHT() /2 -270, null);
            G2D.drawImage(Images.DEFEAT.image("Sign"), (int) (moveX / Frame.displayScaleX), (int) (270/Frame.displayScaleY), null);
            G2D.drawImage(Images.MENUBUTTON.image("button"), (int) ((moveX + 100) / Frame.displayScaleX), (int) (500/Frame.displayScaleY), null);
           // G2D.drawImage(Images.MENUBUTTON.image(""), moveX, clickArray[0].getTopY(), null);

        }
    }

    @Override
    public void cycleScene() {

        if(!gameStatus.equals("") &&moveX < 480/ Frame.displayScaleX){
            moveX +=(20 / Frame.displayScaleX);
        }
    }

    @Override
    public void handleClick(MouseEvent e) {
        blockClicked(e);
    }

    @Override
    public void handleOver(MouseEvent e) {

    }

    @Override
    public void handleExit(MouseEvent e) {

    }


    private void setupClickDaten() {
        int btTopX = (int) ((Frame.getDisplayWIDTH() / 2) - (MenuScene.getChangeBtSizeWidth()));
        int btTopY = (int) ((Frame.getDisplayHEIGHT() / 2) - (MenuScene.getChangeBtSizeHeight()));
        int btDownX = btTopX + MenuScene.getBtSizeWidth();
        int btDownY = btTopY + MenuScene.getChangeBtSizeHeight();
        clickArray[0] = new clickDaten(btTopX, btTopY, btDownX, btDownY);
    }



    }
