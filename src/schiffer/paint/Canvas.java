package schiffer.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.net.ConnectException;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import schiffer.paint.message.Client;

public class Canvas extends JComponent {

	private static final long serialVersionUID = 1L;
	BufferedImage image;
	Color color;
	int stroke;
	JLabel strokeLabel;
	DrawListener listener;
	boolean clear;
	JPanel colorPanel;
	Client client;
	NetworkModule module;

	public Canvas(JPanel colorPanel) {
		try {
			this.client = new Client(this);
			module = new OnlineNetworkModule(client);
		} catch (Exception e) {
			if (e instanceof ConnectException) {
				module = new LoopbackNetworkModule(this);
			}
		}
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
				strokeLabel.setText("STROKE : " + stroke);
			}
		});
		strokeLabel = new JLabel();
		clear = false;

		this.colorPanel = colorPanel;

	}

	public Client getClient() {
		return client;
	}

	public NetworkModule getModule() {
		return module;
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
		g.drawImage(image, 0, 0, null);
		strokeLabel.setText("STROKE : " + stroke);

	}

}