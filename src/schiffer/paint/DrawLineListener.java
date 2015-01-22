package schiffer.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;

import schiffer.paint.message.LineMessage;
import schiffer.paint.message.PaintMessage;

public class DrawLineListener implements DrawListener {
	private Canvas canvas;
	private Point startDrag, endDrag;

	public DrawLineListener(Canvas canvas) {
		this.canvas = canvas;
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
	}

	public void draw(Graphics2D g) {
		PaintMessage message = new LineMessage(startDrag.x, startDrag.y,
				endDrag.x, endDrag.y, canvas.getColor().getRGB(),
				canvas.getStroke());
		canvas.getModule().sendMessage(message);
	}

	@Override
	public void drawPreview(Graphics2D g) {
		g.setStroke(new BasicStroke(canvas.getStroke(), BasicStroke.CAP_ROUND,
				BasicStroke.JOIN_ROUND));
		g.setColor(new Color(canvas.getColor().getRGB()));
		g.drawLine(startDrag.x, startDrag.y, endDrag.x, endDrag.y);
	}
}