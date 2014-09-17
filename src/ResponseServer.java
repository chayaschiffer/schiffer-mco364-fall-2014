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

		Socket socket = serverSocket.accept();

		InputStream in = socket.getInputStream();

		// the server socket is the part that listens,

		// you listen by calling serverSocket.accept();

		// when someone connects to you, the server is returned.

		// client initiate connections to server

		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		String line;

		while ((line = reader.readLine()) != null) {

			System.out.println(line);

		}

		OutputStream out = socket.getOutputStream();

		out.write("HELLO WORLD".getBytes());

		out.flush();

		out.close();

	}

}
