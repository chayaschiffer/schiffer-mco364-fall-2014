package schiffer.chat;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Queue;

public class MessageSender extends Thread {
	private Queue<String> messages;
	private List<Socket> sockets;

	public MessageSender(List<Socket> sockets, Queue<String> messages) {
		this.sockets = sockets;
		this.messages = messages;
	}

	public void run() {
		while (true) {
			String message = messages.take();
			for (Socket socket : sockets) {
				try {
					OutputStream out = socket.getOutputStream();
					PrintWriter writer = new PrintWriter(out);
					writer.println(message);
					writer.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			messages.clear();
		}
	}

}
