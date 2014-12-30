package schiffer.paint.message;

import java.util.Scanner;

public class PaintMessageFactory {

	public PaintMessage getMessage(String message) {
		Scanner scanner = new Scanner(message);

		String messageType = scanner.next();
		PaintMessage paintMessage = null;

		switch (messageType) {
		case "LINE":
			paintMessage = new LineMessage(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(),
					scanner.nextInt(), scanner.nextInt());
		case "SHAPE":
			paintMessage = new ShapeMessage(messageType, scanner.nextInt(), scanner.nextInt(), scanner.nextInt(),
					scanner.nextInt(), scanner.nextBoolean(), scanner.nextInt(), scanner.nextInt());
		case "CLEAR":
			paintMessage = new ClearMessage();
			break;
		case "BUCKET_FILL":
			paintMessage = new BucketFillMessage(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
			break;
		}
		return paintMessage;
	}
}