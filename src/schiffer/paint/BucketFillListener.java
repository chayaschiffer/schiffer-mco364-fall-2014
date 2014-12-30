package schiffer.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.io.IOException;

import schiffer.paint.message.BucketFillMessage;
import schiffer.paint.message.Client;
import schiffer.paint.message.PaintMessage;

public class BucketFillListener implements DrawListener {
	private Canvas canvas;
	private Client client;

	public BucketFillListener(Canvas canvas) {
		this.canvas = canvas;
		this.client = canvas.getClient();
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
		canvas.repaint();

	}

	public void draw(int x, int y) {
		PaintMessage message = new BucketFillMessage(x, y, canvas);
		try {
			client.sendMessage(message.toString());
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
