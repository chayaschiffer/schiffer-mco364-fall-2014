package schiffer.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class Paint extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	DrawListener listener;
	
	public Paint(){
		setSize(1100,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("PAINT");
		setLocationRelativeTo(null);
				
		Canvas canvas = new Canvas();
		add(canvas, BorderLayout.CENTER);
		
		listener = new DrawListener(canvas);
		
		canvas.addMouseMotionListener(listener);
		canvas.addMouseWheelListener(new MouseWheelListener(){
			@Override
			public void mouseWheelMoved(MouseWheelEvent mwe) {
				int mousestroke = canvas.getStroke() + mwe.getUnitsToScroll() * (-1);
				if(mousestroke <1) {
					mousestroke = 1;
				}
				canvas.setStroke(mousestroke);
			
				
			}
		});
		JButton colorButton = new JButton("Choose a color");
		colorButton.addActionListener(this);
		add(colorButton, BorderLayout.SOUTH);
		
	}
	public void actionPerformed(ActionEvent e) {  
		Color startColor = Color.BLACK;  
		Color color=JColorChooser.showDialog(this,"Select a color",startColor);  
		listener.setColor(color);
	}  
	
	public static void main(String[] args0){
		Paint paint = new Paint();
		paint.setVisible(true);
		
	}

}
