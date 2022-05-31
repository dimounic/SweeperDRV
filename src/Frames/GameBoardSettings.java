package Frames;

import Panels.GameBoard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;




public class GameBoardSettings extends JFrame implements ActionListener{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    JButton buttonEasy,buttonMedium,buttonHard,buttonCustom;

    private static GameBoardSettings theInstance;

    public GameBoardSettings() {
        setupGameSettingsFrame();

    }

    private void setupGameSettingsFrame() {
        Dimension DimMax = Toolkit.getDefaultToolkit().getScreenSize();
        this.setPreferredSize(new Dimension(DimMax.width / 2,DimMax.height/2));
        this.setMinimumSize(new Dimension(DimMax.width / 2,DimMax.height/2));
        this.setMaximumSize(new Dimension(DimMax.width / 2,DimMax.height/2));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setBackground(new Color(1.0f,1.0f,1.0f,0f));



        JPanel panel = new JPanel();
        panel.setBackground(new Color(1.0f,1.0f,1.0f,0f));
        panel.setLayout(new BorderLayout(10,10));

        JLabel ueberschrift = new JLabel("Schwierigkeitsgrad");
        ueberschrift.setFont(new Font("Arial", Font.BOLD, 50));
        ueberschrift.setHorizontalTextPosition(SwingConstants.CENTER);
        ueberschrift.setAlignmentX(CENTER_ALIGNMENT);

        buttonEasy = new JButton("Easy");
        buttonEasy.setPreferredSize(new Dimension(this.getWidth()/3,0));

        buttonMedium = new JButton("Medium");
        buttonMedium.setPreferredSize(new Dimension(this.getWidth()/3,0));
        buttonHard = new JButton("Hard");
        buttonHard.setPreferredSize(new Dimension(this.getWidth()/3,0));
        buttonCustom = new JButton("Custom");
        buttonCustom.setPreferredSize(new Dimension(0,this.getHeight()/3));
        buttonEasy.addActionListener(this);
        buttonMedium.addActionListener(this);
        buttonHard.addActionListener(this);
        buttonCustom.addActionListener(this);
        panel.add(ueberschrift, BorderLayout.NORTH);
        panel.add(buttonEasy,BorderLayout.WEST);
        panel.add(buttonMedium,BorderLayout.CENTER);
        panel.add(buttonHard,BorderLayout.EAST);
        panel.add(buttonCustom,BorderLayout.SOUTH);
        GameOver.getTheGameOverInstance().add(panel);
        this.add(GameOver.getTheGameOverInstance());
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonEasy) {
            this.setVisible(false);
            this.dispose();
            Game.getMainPanel().removeAll();
            Game.getMainPanel().add(new GameBoard(9),BorderLayout.CENTER);
            SwingUtilities.updateComponentTreeUI(Game.getMainPanel());
        }
        if(e.getSource() == buttonMedium) {
            this.setVisible(false);
            this.dispose();
            Game.getMainPanel().removeAll();
            Game.getMainPanel().add(new GameBoard(15),BorderLayout.CENTER);
            SwingUtilities.updateComponentTreeUI(Game.getMainPanel());
        }
        if(e.getSource() == buttonHard) {
            this.setVisible(false);
            this.dispose();
            Game.getMainPanel().removeAll();
            Game.getMainPanel().add(new GameBoard(30),BorderLayout.CENTER);
            SwingUtilities.updateComponentTreeUI(Game.getMainPanel());
        }

        if(e.getSource() == buttonCustom) {
        }

    }

    public static GameBoardSettings getTheInsance() {
        if(theInstance == null)
            theInstance = new GameBoardSettings();
        return theInstance;
    }
}