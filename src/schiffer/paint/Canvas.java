package schiffer.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Canvas extends JComponent {

	private static final long serialVersionUID = 1L;
	BufferedImage[] images;
	Color color;
	int stroke;
	JLabel strokeLabel;
	DrawListener listener;
	boolean clear;
	int layer;
	JPanel colorPanel;

	public Canvas(JPanel colorPanel) {
		images = new BufferedImage[4];
		for (int i = 0; i < 4; i++) {
			images[i] = new BufferedImage(1100, 600, BufferedImage.TYPE_INT_ARGB);
		}
		layer = 0;
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
				strokeLabel.setText("STROKE : " + stroke);
			}
		});
		strokeLabel = new JLabel();
		clear = false;

		this.colorPanel = colorPanel;
	}

	public int getStroke() {
		return stroke;
	}

	public void setStroke(int stroke) {
		this.stroke = stroke;
	}

	public JLabel getStrokeLabel() {
		return strokeLabel;
	}

	public void setStrokeLabel(JLabel strokeLabel) {
		this.strokeLabel = strokeLabel;
	}

	public BufferedImage[] getImages() {
		return images;
	}

	public void setImages(BufferedImage[] images) {
		this.images = images;
	}

	public BufferedImage getImage() {
		return images[layer];
	}

	public void setImage(BufferedImage image) {
		this.images[layer] = image;
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

	public void setLayer(int layer) {
		if (layer >= 0 && layer < 4) {
			this.layer = layer;

		}
	}

	public int getLayer() {
		return layer;
	}

	public void setColorPanel(Color color) {
		this.colorPanel.setBackground(color);
	}

	public void setListener(DrawListener listener) {
		this.removeMouseListener(this.listener);
		this.removeMouseMotionListener(this.listener);
		this.listener = listener;
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);
	}

	public void resetCanvas() {
		for (int i = 0; i < 4; i++) {
			images[i] = new BufferedImage(1100, 600, BufferedImage.TYPE_INT_ARGB);
			repaint();
		}
		clear = true;
		repaint();
		setListener(new PencilListener(this));
		setColor(Color.BLACK);
		colorPanel.setBackground(Color.BLACK);
		setStroke(1);
	}

	public void resetLayer() {
		clear = true;
		images[layer] = new BufferedImage(1100, 600, BufferedImage.TYPE_INT_ARGB);
		repaint();
	}

	public void removeListener() {
		this.removeMouseListener(listener);
		this.removeMouseMotionListener(listener);

	}

	public void setClear(boolean clear) {
		this.clear = clear;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < 4; i++) {
			g.drawImage(images[i], 0, 0, null);
		}
		strokeLabel.setText("STROKE : " + stroke);
		if (clear == false) {
			listener.drawPreview((Graphics2D) g);
		}

	}

}