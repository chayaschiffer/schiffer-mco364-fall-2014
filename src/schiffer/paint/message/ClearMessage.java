package schiffer.paint.message;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;

public class ClearMessage implements PaintMessage {
	int width, height;

	public ClearMessage(schiffer.paint.Canvas canvas) {
		width = canvas.getWidth();
		height = canvas.getHeight();
	}

	public String toString() {
		return "CLEAR\n";
	}

	@Override
	public void apply(Graphics2D g) {
		g.setPaint(Color.WHITE);
		g.fillRect(0, 0, width, height);
	}

}
