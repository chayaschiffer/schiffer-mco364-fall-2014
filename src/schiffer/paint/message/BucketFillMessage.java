package schiffer.paint.message;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.Stack;

import schiffer.paint.Canvas;

public class BucketFillMessage implements PaintMessage {
	private int x;
	private int y;
	private int color;
	private Canvas canvas;

	public BucketFillMessage(Canvas canvas, int x, int y, int color) {
		this.canvas = canvas;
		this.x = x;
		this.y = y;
		this.color = color;

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "BUCKET_FILL " + x + " " + y + " " + color + "\n";
	}

	@Override
	public void apply(Graphics2D g) {
		g.setColor(new Color(color));
		BufferedImage image = canvas.getImage();
		int replaceColor = color;
		int targetColor = image.getRGB(x, y);
		if (targetColor != replaceColor) {
			Stack<Point> stack = new Stack<Point>();
			stack.push(new Point(x, y));
			Point point;
			while (!stack.isEmpty()) {
				point = stack.pop();

				if (image.getRGB(point.x, point.y) == targetColor) {
					image.setRGB(point.x, point.y, replaceColor);

					if (point.x + 1 < image.getWidth()) {
						stack.push(new Point(point.x + 1, point.y));
					}
					if (point.x - 1 >= 0) {
						stack.push(new Point(point.x - 1, point.y));
					}
					if (point.y + 1 < image.getHeight()) {
						stack.push(new Point(point.x, point.y + 1));
					}
					if (point.y - 1 >= 0) {
						stack.push(new Point(point.x, point.y - 1));
					}
				}
			}
		}
	}
}