package schiffer.paint;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.IOException;

import schiffer.paint.message.Client;
import schiffer.paint.message.PaintMessage;
import schiffer.paint.message.ShapeMessage;

public class FillRectangleListener implements DrawListener {
	private Canvas canvas;
	private Point startDrag, endDrag;
	private int stroke;
	private Client client;

	public FillRectangleListener(Canvas canvas) {
		this.canvas = canvas;
		stroke = canvas.getStroke();
		client = canvas.getClient();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		endDrag = new Point(e.getX(), e.getY());
		canvas.repaint();

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

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
		startDrag = new Point(e.getX(), e.getY());
		endDrag = startDrag;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		endDrag = new Point(e.getX(), e.getY());
		draw((Graphics2D) canvas.getImage().getGraphics());
		canvas.repaint();
	}

	public void draw(Graphics2D g) {
		PaintMessage message = new ShapeMessage("RECT", Math.min(startDrag.x, endDrag.x), Math.min(startDrag.y,
				endDrag.y), Math.abs(endDrag.x - startDrag.x), Math.abs(endDrag.y - startDrag.y), true, canvas
				.getColor().getRGB(), stroke);
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