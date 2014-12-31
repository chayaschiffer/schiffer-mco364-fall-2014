package schiffer.paint.message;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import schiffer.paint.Canvas;

public class Client extends Thread {

	private Socket socket;
	private OutputStream out;
	private ClientListener listener;
	
	public Client(Canvas canvas) throws IOException {
		socket = new Socket("192.168.117.107", 3773);
		out = socket.getOutputStream();
		listener = new ClientListener(socket,canvas);
		listener.start();
	}

	public void sendMessage(String message) throws IOException {
		out.write(message.toString().getBytes());
		out.flush();
	}

}
