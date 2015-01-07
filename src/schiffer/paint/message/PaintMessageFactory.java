package schiffer.paint.message;

import schiffer.paint.Canvas;

public class PaintMessageFactory {
	private Canvas canvas;

	public PaintMessageFactory(Canvas canvas) {
		this.canvas = canvas;
	}

	public PaintMessage getMessage(String message) {
		String[] messagePieces = message.split("\\s");

		String messageType = messagePieces[0];
		PaintMessage paintMessage = null;

		switch (messageType) {
		case "LINE":
			paintMessage = new LineMessage(Integer.parseInt(messagePieces[1]), Integer.parseInt(messagePieces[2]),
					Integer.parseInt(messagePieces[3]), Integer.parseInt(messagePieces[4]),
					Integer.parseInt(messagePieces[5]), Integer.parseInt(messagePieces[6]));
		break;
		case "SHAPE":
			paintMessage = new ShapeMessage(String.valueOf(messagePieces[1]), Integer.parseInt(messagePieces[2]),
					Integer.parseInt(messagePieces[3]), Integer.parseInt(messagePieces[4]),
					Integer.parseInt(messagePieces[5]), Boolean.valueOf(messagePieces[6]),
					Integer.parseInt(messagePieces[7]), Integer.parseInt(messagePieces[8]));
			break;
		case "CLEAR":
			paintMessage = new ClearMessage();
			break;
		case "BUCKET_FILL":
			paintMessage = new BucketFillMessage(Integer.parseInt(messagePieces[1]),
					Integer.parseInt(messagePieces[2]), canvas);
			break;
		}
		return paintMessage;
	}
}