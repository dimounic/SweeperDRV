package Frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import Extra.Images;


@SuppressWarnings("serial")
public class GameOver extends JPanel{
    private static GameOver theGameOverInstance;

    public GameOver() {
        setupPanel();

    }

    private void setupPanel() {
        //this.setPreferredSize(getMaximumSize());
        this.setBackground(new Color(1.0f,1.0f,1.0f,0f));
        this.setLayout(new GridLayout());
        this.repaint();

    }

    public static GameOver getTheGameOverInstance() {
        if(theGameOverInstance == null)
            theGameOverInstance = new GameOver();
        return theGameOverInstance;
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(Images.SIGN.image(""),0,0,null);
    }

}