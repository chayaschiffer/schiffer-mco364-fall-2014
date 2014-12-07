package schiffer.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class Canvas extends JComponent {

	private static final long serialVersionUID = 1L;
	BufferedImage image;
	Color color;
	int stroke;
	JLabel colorLabel;
	JLabel strokeLabel;
	DrawListener listener;
	boolean clear;

	public Canvas() {
		image = new BufferedImage(1100, 600, BufferedImage.TYPE_INT_ARGB);
		stroke = 1;
		color = Color.black;
		setListener(new PencilListener(this));
		addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent mwe) {
				int mousestroke = stroke + mwe.getUnitsToScroll() * (-1);
				if (mousestroke < 1) {
					mousestroke = 1;
				}
				stroke = mousestroke;
			}
		});
		colorLabel = new JLabel();
		strokeLabel = new JLabel();
		clear = false;
	}

	public int getStroke() {
		return stroke;
	}

	public void setStroke(int stroke) {
		this.stroke = stroke;
	}

	public JLabel getColorLabel() {
		return colorLabel;
	}

	public void setColorLabel(JLabel colorLabel) {
		this.colorLabel = colorLabel;
	}

	public JLabel getStrokeLabel() {
		return strokeLabel;
	}

	public void setStrokeLabel(JLabel strokeLabel) {
		this.strokeLabel = strokeLabel;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public DrawListener getListener() {
		return listener;
	}

	public void setListener(DrawListener listener) {
		this.removeMouseListener(this.listener);
		this.removeMouseMotionListener(this.listener);
		this.listener = listener;
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);
	}

	public void resetCanvas() {
		this.image = new BufferedImage(1100, 600, BufferedImage.TYPE_INT_ARGB);
		repaint();
	}

	public void removeListener() {
		this.removeMouseListener(listener);
		this.removeMouseMotionListener(listener);

	}

	public boolean getClear() {
		return clear;
	}

	public void setClear(boolean clear) {
		this.clear = clear;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
		strokeLabel.setText("STROKE : " + stroke);
		if (clear == false) {
			listener.drawPreview((Graphics2D) g);
		}
	}

}