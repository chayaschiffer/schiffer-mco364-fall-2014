package schiffer.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;

public class Canvas extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int x1, x2;
	int y1, y2;
	BufferedImage image;
	Color color;
	int stroke;
	
	public Canvas(){
		image = new BufferedImage(1100,600, BufferedImage.TYPE_INT_ARGB);
		this.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent me){
				setX1(me.getX());
				setY1(me.getY());
			}
		});

	}
	
	public void setX1(int x1){
		this.x1 = x1;
	}
	
	public void setY1(int y1){
		this.y1 = y1;
	}
	
	public int getStroke() {
		return stroke;
	}

	public void setStroke(int stroke) {
		this.stroke = stroke;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
		
	}

	public void setPoint(int x, int y, Color color) {
		this.x2 = x;
		this.y2 = y;
		Graphics2D g = (Graphics2D) image.getGraphics();
		this.color = color;
		g.setColor(color);
		g.fillOval(x2, y2, getStroke(), getStroke());
		if(!(x1==0 && y1==0)){
			g.setStroke(new BasicStroke(getStroke()));
			g.drawLine(x2, y2, x1, y1);
		}
		this.x1=x2;
		this.y1 = y2;
		
		
	}
	

	

	
}
