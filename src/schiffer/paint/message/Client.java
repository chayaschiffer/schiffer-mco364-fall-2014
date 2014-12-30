package schiffer.paint.message;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client extends Thread {

	private Socket socket;
	private OutputStream out;

	public Client() throws IOException {
		socket = new Socket();
		out = socket.getOutputStream();
	}

	public void sendMessage(String message) throws IOException {
		out.write(message.toString().getBytes());
		out.flush();
	}

}
