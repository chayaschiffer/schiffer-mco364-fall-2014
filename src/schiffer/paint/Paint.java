package schiffer.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import schiffer.paint.message.Client;

public class Paint extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	Canvas canvas;
	ActionPanel buttonPanel;
	JPanel panel;
	JPanel colorPanel;
	JLabel strokeLabel;
	JButton colorButton;

	public Paint() {
		setSize(1000, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("PAINT");
		setLocationRelativeTo(null);
		panel = new JPanel();
		colorPanel = new JPanel();
		colorPanel.setBackground(Color.BLACK);
		canvas = new Canvas(colorPanel);
		add(canvas, BorderLayout.CENTER);
		colorButton = new JButton("Choose a color");
		colorButton.addActionListener(this);

		strokeLabel = canvas.getStrokeLabel();
		panel.setLayout(new GridLayout(3, 1));
		panel.add(colorButton);
		panel.add(colorPanel);
		panel.add(strokeLabel);
		add(panel, BorderLayout.WEST);

		buttonPanel = new ActionPanel(canvas);
		add(buttonPanel, BorderLayout.NORTH);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Color startColor = colorButton.getBackground();
		Color color = JColorChooser.showDialog(this, "Select a color", startColor);
		if (color != null) {
			canvas.setColor(color);
			canvas.setColorPanel(color);
		}
	}

	public static void main(String[] args0) {
		Paint paint = new Paint();
		paint.setVisible(true);

	}

}