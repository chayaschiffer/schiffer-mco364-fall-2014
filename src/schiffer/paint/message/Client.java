package schiffer.paint.message;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import schiffer.paint.Canvas;

public class Client extends Thread {

	private Socket socket;
	private InputStream in;
	private PrintWriter out;
	private PaintMessageFactory factory;
	private Canvas canvas;

	public Client(Canvas canvas) throws IOException {

		factory = new PaintMessageFactory(canvas);
	}

	@Override
	public void run() {
		try {
			socket = new Socket("192.168.117.107", 3773);
			out = new PrintWriter(socket.getOutputStream());
			in = socket.getInputStream();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line;
			PaintMessage amessage = null;
			while ((line = reader.readLine()) != null) {
				if (!amessage.equals("")) {
					amessage = factory.getMessage(line);
					if (amessage != null) {
						amessage.apply((Graphics2D) canvas.getImage().getGraphics());
						canvas.repaint();
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void readMessage(String message) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

	}

	public void sendMessage(String message) throws IOException {
		OutputStream output = socket.getOutputStream();
		output.write(message.toString().getBytes());
		output.flush();
	}

}
