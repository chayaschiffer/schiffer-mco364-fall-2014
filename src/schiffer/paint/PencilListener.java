package schiffer.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.io.IOException;

import schiffer.paint.message.Client;
import schiffer.paint.message.LineMessage;
import schiffer.paint.message.PaintMessage;

public class PencilListener implements DrawListener {
	private Canvas canvas;
	private int x1, y1, x2, y2;
	private int stroke;
	private Client client;

	public PencilListener(Canvas canvas) {
		this.canvas = canvas;
		stroke = canvas.getStroke();
		client = canvas.getClient();
	}

	public void setPoint(int oldx, int oldy, int newX, int newY) {
		x2 = newX;
		y2 = newY;
		draw((Graphics2D) canvas.getImage().getGraphics());
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
	public void mouseReleased(MouseEvent e) {

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

	public void draw(Graphics2D g) {
		PaintMessage message = new LineMessage(x1, y1, x2, y2, canvas.getColor().getRGB(), stroke);
		try {
			client.sendMessage(message.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void drawPreview(Graphics2D g) {
		draw(g);

	}
}