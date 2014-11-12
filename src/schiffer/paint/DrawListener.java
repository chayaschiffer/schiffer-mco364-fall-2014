package schiffer.paint;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class DrawListener implements MouseMotionListener{
	private Canvas canvas;
	private Color color;
	
	public DrawListener(Canvas canvas){
		this.canvas = canvas;
	}
	
	public void setColor(Color color){
		this.color = color;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		canvas.setPoint(e.getX(), e.getY(), color);
		canvas.repaint(); 
		
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
	
	}

}
