package schiffer.paint.message;

import java.awt.Graphics2D;

public class ShapeMessage implements PaintMessage{
		private String type;
		private int x;
		private int y;
		private int color;
		private int stroke;
		
		public ShapeMessage(String type, int x, int y, int color, int stroke){
			super();
			this.type = type;
			this.x = x;
			this.y = y;
			this.color = color;
			this.stroke = stroke;
		}

		@Override
		public void apply(Graphics2D g) {
			// TODO Auto-generated method stub
			
		}
	}
