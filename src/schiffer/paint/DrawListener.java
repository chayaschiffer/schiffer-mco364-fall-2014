package schiffer.paint;

import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public interface DrawListener extends MouseMotionListener, MouseListener {
	void drawPreview(Graphics2D g);

}
