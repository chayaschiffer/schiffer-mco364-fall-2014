package schiffer.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class InputOutput extends Thread {
	private Socket socket;
	
	public InputOutput(Socket socket) throws IOException {
		this.socket = socket;

	}

	@Override
	public void run() {
		try {
		InputStream input = socket.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		String line;
		
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			OutputStream out = socket.getOutputStream();
			String response = "";
					
			out.write("HELLO WORLD".getBytes());
			out.write("HTTP/101 200 Ok\n".getBytes());
			out.write(("Content-Length: " + response.length()+"\n\n").getBytes());
			out.write(response.getBytes());
			//ChatGUI gc = new ChatGUI(response);
			
			out.flush();
			out.close();
		}
	 catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
