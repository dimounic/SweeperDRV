package Frames;

import Buttons.MenuButton;
import Panels.MenuPanel;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Game extends JFrame implements ActionListener {
    private static JPanel MainPanel = new MenuPanel();



    public static JPanel pnMiddleSide;
    private static int stHEIGHT;
    private static int stWIDTH;
    static MenuButton btPlay, btSettings, btAchievements, btLogin, btExit;
    private static Game theGameInstance;


    private Game() {
        setupFrame();


    }


    private void setupFrame() {
        Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
        // set size of JFrame
        this.setPreferredSize(new Dimension(DimMax));
        this.setMinimumSize(new Dimension(DimMax));
        this.setMaximumSize(new Dimension(DimMax));

        // start JFrame maximised
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);


        // close JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        stHEIGHT = this.getHeight();
        stWIDTH = this.getWidth();
        // MainPanel.setLayout(new BorderLayout());

        setupMainMenu();

        this.add(MainPanel);
        this.setVisible(true);
    }

    private void setupMainMenu() {
        JPanel pnMiddleSide = new JPanel();
        pnMiddleSide.setLayout(new GridLayout(0,1,0,0));
        pnMiddleSide.setBorder(new EmptyBorder(0, 0, 50, 0));
        pnMiddleSide.setBackground(new Color(1.0f,1.0f,1.0f,0f));

        JPanel pnButtonList = new JPanel();
        pnButtonList.setLayout(new GridLayout(0, 1, 1, 10));
        pnButtonList.setPreferredSize(new Dimension(Game.getStHEIGHT()/2,200));
        pnButtonList.setBackground(new Color(1.0f,1.0f,1.0f,0f));


        JPanel pnLeftSide = new JPanel();
        pnLeftSide.setPreferredSize(new Dimension((int) ((stWIDTH - stHEIGHT) / 1.1), 0));
        pnLeftSide.setBackground(new Color(1.0f,1.0f,1.0f,0f));
        // pnLeftSide.setBackground(new Color(224, 205, 148));

        JPanel pnRightSide = new JPanel();
        pnRightSide.setPreferredSize(new Dimension((int) ((stWIDTH - stHEIGHT) / 1.1), 0));
        pnRightSide.setBackground(new Color(1.0f,1.0f,1.0f,0f));

        btPlay = new MenuButton("New Game");
        btPlay.addActionListener(this);

        btSettings = new MenuButton("Settings");
        btAchievements = new MenuButton("Achievements");
        btLogin = new MenuButton("Login");
        btExit = new MenuButton("Exit");

        //add Button to Panel
        pnButtonList.add(btPlay);
        pnButtonList.add(btSettings);
        pnButtonList.add(btAchievements);
        pnButtonList.add(btLogin);
        pnButtonList.add(btExit);
        btExit.addActionListener(this);
        JPanel moin = new JPanel();
        moin.setBackground(new Color(1.0f,1.0f,1.0f,0f));

        moin.setPreferredSize(new Dimension(Game.getStHEIGHT()/2,200));
        pnMiddleSide.add(moin);
        pnMiddleSide.add(pnButtonList);

        MainPanel.add(pnMiddleSide, BorderLayout.CENTER);
        MainPanel.add(pnLeftSide, BorderLayout.WEST);
        MainPanel.add(pnRightSide, BorderLayout.EAST);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btPlay) {
            if(!GameFrames.getTheInstance().isFocusOwner())
                GameFrames.getTheInstance().requestFocus();
            GameFrames.getTheInstance().convertToGameDifficulty();

        }
        if (e.getSource() == btSettings) {

        }
        if (e.getSource() == btAchievements) {

        }
        if (e.getSource() == btLogin) {

        }
        if (e.getSource() == btExit) {
            System.exit(0);
        }


    }

    public static int getStHEIGHT() {
        return stHEIGHT;
    }

    public static int getStWIDTH() {
        return stWIDTH;
    }

    public static void gameLost() {
        theGameInstance.removeAll();
    }

    public static Game getTheGameInstance() {
        if (theGameInstance == null)
            theGameInstance = new Game();
        return theGameInstance;
    }
    public static JPanel getPnMiddleSide() {
        return pnMiddleSide;
    }

    public static void setPnMiddleSide(JPanel pnMiddleSide) {
        Game.pnMiddleSide = pnMiddleSide;
    }

    public static JPanel getMainPanel() {
        return MainPanel;
    }

    public static void setMainPanel(JPanel mainPanel) {
        MainPanel = mainPanel;
    }



}