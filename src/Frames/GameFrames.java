package Frames;

import Panels.ImagePanel;

import javax.swing.*;
import java.awt.*;

public class GameFrames extends JFrame {
    private static Panels.ImagePanel ImagePanel = new ImagePanel();
    private static GameFrames theInstance = null;
    static JButton buttonEasy,buttonMedium,buttonHard,buttonCustom;
    public GameFrames(){
        setupBasicFrame();

    }

    private void setupBasicFrame() {
        setPreferredSize(new Dimension(960,540));
        setMaximumSize(new Dimension(960,540));
        setMinimumSize(new Dimension(960,540));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setBackground(new Color(1.0f,1.0f,1.0f,0f));
        add(ImagePanel);
        setVisible(true);
    }

    private void convertToGameOver(){

    }
    private void convertToGameWon(){

    }
    public static void convertToGameDifficulty(){
        ImagePanel.removeAll();

        JPanel panel = new JPanel();
        //panel.setBackground(new Color(1.0f,1.0f,1.0f,0f));
        panel.setLayout(new BorderLayout(10,10));

        JLabel ueberschrift = new JLabel("Schwierigkeitsgradee");
        ueberschrift.setFont(new Font("Arial", Font.BOLD, 50));
        ueberschrift.setHorizontalTextPosition(SwingConstants.CENTER);
        ueberschrift.setAlignmentX(CENTER_ALIGNMENT);

        JButton buttonEasy = new JButton("Easy");
        buttonEasy.setPreferredSize(new Dimension(theInstance.getWidth()/3,0));

        JButton buttonMedium = new JButton("Medium");
        buttonMedium.setPreferredSize(new Dimension(theInstance.getWidth()/3,0));
        JButton buttonHard = new JButton("Hard");
        buttonHard.setPreferredSize(new Dimension(theInstance.getWidth()/3,0));
        JButton buttonCustom = new JButton("Custom");
        buttonCustom.setPreferredSize(new Dimension(0,theInstance.getHeight()/3));

        panel.add(ueberschrift, BorderLayout.NORTH);
        panel.add(buttonEasy,BorderLayout.WEST);
        panel.add(buttonMedium,BorderLayout.CENTER);
        panel.add(buttonHard,BorderLayout.EAST);
        panel.add(buttonCustom,BorderLayout.SOUTH);
        ImagePanel.add(panel,BorderLayout.CENTER);
        //theInstance.add(ImagePanel);
        SwingUtilities.updateComponentTreeUI(theInstance);
    }

    public static GameFrames getTheInstance(){
        if(theInstance == null)
            theInstance = new GameFrames();
        return theInstance;
    }

}