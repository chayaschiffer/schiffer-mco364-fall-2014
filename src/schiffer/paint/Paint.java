package schiffer.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Paint extends JFrame {
	
	private Color color;
	DrawListener listener;
	
	public Paint(){
		setSize(1100,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("PAINT");
		setLocationRelativeTo(null);
		
		/*
		BorderLayout layout = new BorderLayout();
		Container container = getContentPane();
		container.setLayout(layout);
		*/
		
		JPanel panel = new JPanel();
		JButton button;
		for(Colors color : Colors.values()){
			button = new JButton();
			button.addActionListener(new ColorButtonListener());
			button.setText(color.toString());
			panel.add(button);
		}
		add(panel, BorderLayout.NORTH);
		
		Canvas canvas = new Canvas();
		add(canvas, BorderLayout.CENTER);
		
		listener = new DrawListener(canvas);
		
		canvas.addMouseMotionListener(listener);
		
	}
	
	private class ColorButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			Colors buttonColor = Colors.valueOf(e.getActionCommand());
			switch(buttonColor){
			case BLACK:
				color = Color.BLACK;
				break;
			case BLUE:
				color = Color.BLUE;
				break;
			case GREEN:
				color = Color.GREEN;
				break;
			case RED:
				color = Color.RED;
				break;
			case YELLOW:
				color = Color.YELLOW;
				break;
			case PINK:
				color = Color.PINK;
				break;
			case CYAN:
				color = Color.CYAN;
				break;
			case WHITE:
				color = Color.WHITE;
				break;
			case ORANGE:
				color = Color.ORANGE;
				break;
			case GRAY:
				color = Color.GRAY;
				break;
			case LIGHTGRAY:
				color = Color.LIGHT_GRAY;
				break;
			case MAGENTA:
				color = Color.MAGENTA;
				break;
			case DARKGRAY:
				color = Color.DARK_GRAY;
				break;
			
			}
			listener.setColor(color);
		}
	}
		
	public static void main(String[] args0){
		Paint paint = new Paint();
		paint.setVisible(true);
		
	}

}
