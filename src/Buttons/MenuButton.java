package Buttons;

import Extra.Images;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuButton extends JButton implements MouseListener {
    String text;
    public MenuButton() {
        setIcon(new ImageIcon(Images.MENUBUTTON.image("button")));
        //setContentAreaFilled(false);
        setBackground(new Color(1.0f,1.0f,1.0f,0f));
        setFont(new Font("Arial", Font.BOLD, 30));
        setHorizontalTextPosition(SwingUtilities.CENTER);
        setBorder(null);

        addMouseListener(this);
    }

    public MenuButton(String text) {
        this();
        this.text = text;
        setText(text);
    }


    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == this){
            setForeground(Color.DARK_GRAY);

        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource() == this){
            setForeground(Color.BLACK);
        }
    }
}