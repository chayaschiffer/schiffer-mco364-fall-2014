package schiffer.paint.message;

public class BucketFillMessage implements PaintMessage{
		private int x;
		private int y;
		private int color;
		
		public BucketFillMessage(int x, int y, int color){
			this.x = x;
			this.y = y;
			this.color = color;
		}

		@Override
		public void apply(Graphics2D g) {
			// TODO Auto-generated method stub
			
		}
}
