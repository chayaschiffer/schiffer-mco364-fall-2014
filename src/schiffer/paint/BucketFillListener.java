package schiffer.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.io.IOException;

import schiffer.paint.message.BucketFillMessage;
import schiffer.paint.message.Client;
import schiffer.paint.message.PaintMessage;

public class BucketFillListener implements DrawListener {
	private Canvas canvas;

	public BucketFillListener(Canvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		draw(e.getX(), e.getY());

	}

	public void draw(int x, int y) {
		PaintMessage message = new BucketFillMessage(canvas,x, y, canvas.getColor().getRGB());
		try {
			canvas.getClient().sendMessage(message.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

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
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawPreview(Graphics2D g) {
		// TODO Auto-generated method stub

	}

}
