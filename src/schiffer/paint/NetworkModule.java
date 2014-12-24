package schiffer.paint;

import schiffer.paint.message.PaintMessage;

public interface NetworkModule {
	public void sendMessage(PaintMessage message);
}
