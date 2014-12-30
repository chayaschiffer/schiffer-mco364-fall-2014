package schiffer.paint.message;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import schiffer.paint.Canvas;

public class ClientListener extends Thread {
	private Socket socket;
	private PaintMessageFactory factory;
	private Canvas canvas;

	public ClientListener(Socket socket, Canvas canvas) {
		this.socket = socket;
		this.canvas = canvas;
		factory = new PaintMessageFactory();
	}

	@Override
	public void run() {
		try {
			socket = new Socket("192.168.117.107", 3773);
			InputStream in = socket.getInputStream();

			BufferedReader reader = new BufferedReader(new InputStreamReader(in));

			String line;
			PaintMessage amessage = null;
			while ((line = reader.readLine()) != null) {
				amessage = factory.getMessage(line);
				if (amessage != null) {
					amessage.apply((Graphics2D) canvas.getImage().getGraphics());
					canvas.repaint();
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}