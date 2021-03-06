package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.JButton;



/*
 *  Ova klasa je pronadjena na 
 * 
 * */



public class CustomButton extends JButton{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8400746613937178616L;

	private Color hoverBackgroundColor = new Color(255,255,255);
    private Color pressedBackgroundColor = new Color(255,255,255);

    public CustomButton() {
        this(null);
        setMargin(new Insets(0,0,0,0));
        setBorderPainted(false);
    }

    public CustomButton(String text) {
        super(text);
        super.setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            g.setColor(pressedBackgroundColor);
        } else if (getModel().isRollover()) {
            g.setColor(hoverBackgroundColor);
        } else {
            g.setColor(getBackground());
        }
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    @Override
    public void setContentAreaFilled(boolean b) {
    }

    public Color getHoverBackgroundColor() {
        return hoverBackgroundColor;
    }

    public void setHoverBackgroundColor(Color hoverBackgroundColor) {
        this.hoverBackgroundColor = hoverBackgroundColor;
    }

    public Color getPressedBackgroundColor() {
        return pressedBackgroundColor;
    }

    public void setPressedBackgroundColor(Color pressedBackgroundColor) {
        this.pressedBackgroundColor = pressedBackgroundColor;
    }
		
		
	
	
	

}
