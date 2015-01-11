package schiffer.paint;

import java.awt.Graphics2D;

import schiffer.paint.message.PaintMessage;

public class LoopbackNetworkModule implements NetworkModule {
	private Canvas canvas;

	public LoopbackNetworkModule(Canvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void sendMessage(PaintMessage message) {
		message.apply((Graphics2D) canvas.getImage().getGraphics());
		canvas.repaint();

	}

}