package schiffer.paint;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Paint extends JFrame {
	
	public Paint(){
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("PAINT");
		setLocationRelativeTo(null);
		
		/*
		BorderLayout layout = new BorderLayout();
		Container container = getContentPane();
		container.setLayout(layout);
		*/
		
		Canvas canvas = new Canvas();
		add(canvas, BorderLayout.CENTER);
		
		DrawListener listener = new DrawListener(canvas);
		
		canvas.addMouseMotionListener(listener);
		
	}
		
	public static void main(String[] args0){
		Paint paint = new Paint();
		paint.setVisible(true);
		
	}

}
