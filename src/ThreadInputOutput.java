import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ThreadInputOutput extends Thread {
	private Socket clientSocket;
	private int counter;
	
	public ThreadInputOutput(Socket socket, int counter) throws IOException {
		this.clientSocket = socket;
		this.counter = counter;

	}

	@Override
	public void run() {
		try {
		InputStream input = clientSocket.getInputStream();
		OutputStream out = clientSocket.getOutputStream();
		
		while(true){
		String response = "<h2>This is the " + this.counter + "th request </h2>";
					
			out.write("HELLO WORLD".getBytes());
			out.write("HTTP/101 200 Ok\n".getBytes());
			out.write(("Content-Length: " + response.length()+"\n\n").getBytes());
			out.write(response.getBytes());
			out.flush();
			out.close();
			counter++;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		String line;
		
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		}
		}
	 catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
