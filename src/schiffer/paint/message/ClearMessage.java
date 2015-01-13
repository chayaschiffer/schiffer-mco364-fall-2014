package schiffer.paint.message;

import java.awt.Color;
import java.awt.Graphics2D;

public class ClearMessage implements PaintMessage {

	public String toString() {
		return "CLEAR\n";
	}

	@Override
	public void apply(Graphics2D g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1100, 600);
	}

}
