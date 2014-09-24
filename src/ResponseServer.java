import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ResponseServer {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(8080);
		int counter = 0;
		while(true){
		Socket socket = serverSocket.accept();
		ThreadInputOutput thread = new ThreadInputOutput(socket,counter);
		thread.start();
		// the server socket is the part that listens,
		// you listen by calling serverSocket.accept();
		// when someone connects to you, the server is returned.
		// client initiate connections to server
		}
	}

}
