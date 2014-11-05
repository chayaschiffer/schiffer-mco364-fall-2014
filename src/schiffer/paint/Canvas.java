package schiffer.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class Canvas extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int x;
	int y;
	BufferedImage image;
	
	public Canvas(){
		
		image = new BufferedImage(800,600, BufferedImage.TYPE_INT_ARGB);
		
	}
	
	
	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
		
	}

	public void setPoint(int x, int y) {
		this.x = x;
		this.y = y;
		Graphics g = image.getGraphics();
		g.setColor(Color.black);
		g.fillOval(x, y, 10, 10);
		
	}

	

	
}
