package schiffer.chat;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class MessageSender extends Thread {
	private BlockingQueue<String> messages;
	private List<Socket> sockets;

	public MessageSender(List<Socket> sockets, BlockingQueue<String> messages) {
		this.sockets = sockets;
		this.messages = messages;
	}

	public void run() {
		while (true) {
			String message;
			try {
				message = messages.take();
				Iterator<Socket> iter = sockets.iterator();
				while (iter.hasNext()) {
					OutputStream out;
					Socket socket = iter.next();
					try {
						out = socket.getOutputStream();
						PrintWriter writer = new PrintWriter(out);
						writer.println(message);
						writer.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						iter.remove();
					}
				}
			} catch (InterruptedException e2) {
				e2.printStackTrace();
			}

		}
	}

}
