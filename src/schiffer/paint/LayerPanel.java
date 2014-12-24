package schiffer.paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LayerPanel extends JPanel implements ActionListener {
	private Canvas canvas;
	private JButton layer1;
	private JButton layer2;
	private JButton layer3;
	private JButton layer4;
	private int layerSelected;
	private JLabel layerLabel;
	
	public LayerPanel(Canvas canvas) {
		this.canvas = canvas;
		layer1 = new JButton("LAYER 1");
		layer2 = new JButton("LAYER 2");
		layer3 = new JButton("LAYER 3");
		layer4 = new JButton("LAYER 4");
		layer1.addActionListener(this);
		layer2.addActionListener(this);
		layer3.addActionListener(this);
		layer4.addActionListener(this);
		layerLabel = new JLabel("LAYER: 1");
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(layer1);
		add(layer2);
		add(layer3);
		add(layer4);
		add(layerLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "LAYER 1":
			layerSelected = 0;
			layerLabel.setText("Layer : " + 1);
			break;
		case "LAYER 2":
			layerSelected = 1;
			layerLabel.setText("Layer : " + 2);
			break;
		case "LAYER 3":
			layerSelected = 2;
			layerLabel.setText("Layer : " + 3);
			break;
		case "LAYER 4":
			layerSelected = 3;
			layerLabel.setText("Layer : " + 4);
			break;
		}
		canvas.repaint();
		canvas.setLayer(layerSelected);
		
	}

}
