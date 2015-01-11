package schiffer.paint;

import java.io.IOException;

import schiffer.paint.message.Client;
import schiffer.paint.message.PaintMessage;

public class OnlineNetworkModule implements NetworkModule {

	private Client client;

	public OnlineNetworkModule(Client client) {
		this.client = client;
	}

	@Override
	public void sendMessage(PaintMessage message) {
		try {
			client.sendMessage(message.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}