package schiffer.paint;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public class PencilListener implements DrawListener {
	private Canvas canvas;
	private int x1, y1, x2, y2;
	private int stroke;

	public PencilListener(Canvas canvas) {
		this.canvas = canvas;
		stroke = canvas.getStroke();

	}

	public void setPoint(int oldx, int oldy, int newX, int newY) {
		x2 = newX;
		y2 = newY;
		drawPreview((Graphics2D) canvas.getImage().getGraphics());
		x1 = x2;
		y1 = y2;

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		setPoint(x1, y1, e.getX(), e.getY());
		canvas.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawPreview(Graphics2D g) {
		g.setStroke(new BasicStroke(canvas.getStroke(), BasicStroke.CAP_ROUND,
				BasicStroke.JOIN_ROUND));
		g.setColor(canvas.getColor());
		g.drawLine(x1, y1, x2, y2);

	}
}
