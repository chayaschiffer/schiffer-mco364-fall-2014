import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ResponseServer {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(8080);
		int counter = 0;
		while(true){
		Socket socket = serverSocket.accept();
		InputStream in = socket.getInputStream();
		// the server socket is the part that listens,
		// you listen by calling serverSocket.accept();
		// when someone connects to you, the server is returned.
		// client initiate connections to server
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String line;
		while (!"".equals(line = reader.readLine())) {
			System.out.println(line);
		}
		OutputStream out = socket.getOutputStream();
		String response = "<h2>This is the " + counter + "th request </h2>";
		out.write("HELLO WORLD".getBytes());
		out.write("HTTP/101 200 Ok\n".getBytes());
		out.write(("Content-Length: " + response.length()+"\n\n").getBytes());
		out.write(response.getBytes());
		out.flush();
		out.close();
		counter++;
		}
	}

}
