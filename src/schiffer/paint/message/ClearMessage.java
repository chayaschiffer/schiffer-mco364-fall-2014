package schiffer.paint.message;

import java.awt.Color;
import java.awt.Graphics2D;

public class ClearMessage implements PaintMessage {

	public String toString() {
		return "CLEAR\n";
	}

	@Override
	public void apply(Graphics2D g) {
		Color originalBackground = new Color(238,238,238);
		g.setColor(originalBackground);
		g.fillRect(0, 0, 1100, 600);
	}

}
