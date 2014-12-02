package schiffer.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Paint extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	Canvas canvas;
	JPanel colorStrokePanel;
	JButton colorButton;
	ActionPanel buttonPanel;

	public Paint() {
		setSize(1000, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("PAINT");
		setLocationRelativeTo(null);

		canvas = new Canvas();
		add(canvas, BorderLayout.CENTER);

		colorStrokePanel = new JPanel();
		colorStrokePanel.setLayout(new FlowLayout());
		colorStrokePanel.add(canvas.getColorLabel());
		colorStrokePanel.add(canvas.getStrokeLabel());

		add(colorStrokePanel, BorderLayout.NORTH);

		colorButton = new JButton("Choose a color");
		colorButton.addActionListener(this);
		add(colorButton, BorderLayout.SOUTH);
		buttonPanel = new ActionPanel(canvas);
		add(buttonPanel, BorderLayout.WEST);
	}

	public void actionPerformed(ActionEvent e) {
		Color startColor = colorButton.getBackground();
		Color color = JColorChooser.showDialog(this, "Select a color",
				startColor);
		if (color != null) {
			canvas.setColor(color);
			canvas.getColorLabel().setText("COLOR : " + color.toString());
		}
	}

	public ActionPanel getButtonPanel() {
		return buttonPanel;
	}

	public static void main(String[] args0) {
		Paint paint = new Paint();
		paint.setVisible(true);

	}

}
