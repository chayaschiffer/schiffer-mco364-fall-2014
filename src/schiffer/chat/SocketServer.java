package schiffer.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	public static void main(String[] args)throws IOException{
	ServerSocket serverSocket = new ServerSocket(8080);
	
	Socket socket = serverSocket.accept();
	BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

	String inputLine;

	ChatGUI chat = new ChatGUI();
		
	while ((inputLine = reader.readLine())!=null){
		chat.setText(inputLine);
	}
}

}
