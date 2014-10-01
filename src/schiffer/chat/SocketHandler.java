package schiffer.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Queue;

public class SocketHandler extends Thread {
	private Socket s;
	private Queue<String> messages;

	public SocketHandler(Socket s, Queue<String> messages) {
		this.s = s;
		this.messages = messages;
	}

	public void run() {
		InputStream in;
		try {
			in = s.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));

			String line;
			while ((line = reader.readLine()) != null) {// this thread can only
														// read because it
														// blocks otherwise
				// gathers all messages that clients sent to server, and storing
				// in array list.
				messages.add(line);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
