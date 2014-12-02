package schiffer.paint;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ActionPanel extends JPanel {
	private Canvas canvas;
	private DrawListener listener;
	JButton pencil;
	JButton oval;
	JButton rect;
	JButton fillOval;
	JButton fillRect;
	JButton drawline;
	JButton clear;

	public ActionPanel(Canvas canvas) {
		this.canvas = canvas;
		pencil = new JButton("PENCIL");
		pencil.addActionListener(new buttonListen());
		oval = new JButton("OVAL");
		oval.addActionListener(new buttonListen());
		rect = new JButton("RECTANGLE");
		rect.addActionListener(new buttonListen());
		fillOval = new JButton("FILLOVAL");
		fillOval.addActionListener(new buttonListen());
		fillRect = new JButton("FILLRECT");
		fillRect.addActionListener(new buttonListen());
		drawline = new JButton("LINE");
		drawline.addActionListener(new buttonListen());
		clear = new JButton("CLEAR");
		clear.addActionListener(new buttonListen());
		setLayout(new GridLayout(3, 3));
		add(pencil);
		add(oval);
		add(rect);
		add(fillOval);
		add(fillRect);
		add(drawline);
		add(clear);

	}

	private class buttonListen implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			canvas.removeMouseListener(listener);
			canvas.removeMouseMotionListener(listener);

			if (e.getSource() == clear) {
				canvas.resetCanvas();
			} else {
				if (e.getSource() == pencil) {
					listener = new PencilListener(canvas);
				} else if (e.getSource() == rect) {
					listener = new RectangleListener(canvas);
				} else if (e.getSource() == oval) {
					listener = new OvalListener(canvas);
				} else if (e.getSource() == fillOval) {
					listener = new FillOvalListener(canvas);
				} else if (e.getSource() == fillRect) {
					listener = new FillRectangleListener(canvas);

				} else if (e.getSource() == drawline) {
					listener = new DrawLineListener(canvas);
				}
				canvas.addMouseListener(listener);
				canvas.addMouseMotionListener(listener);
			}

		}

	}
}
