package schiffer.client;


import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;


public class ClientListeningThread extends Thread{
	
private Socket socket;
private ChatScreen screen;

public ClientListeningThread(Socket socket, ChatScreen screen){
	this.screen = screen;
	this.socket = socket;
}

public void run(){
	//Get the input stream
	InputStream input=null;
	try {
		input = this.socket.getInputStream();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	BufferedReader reader = new BufferedReader(new InputStreamReader(input));
	//In an infinite loop -- it should constantly listen!
	String text;
	try {
		while((text = reader.readLine())!=null){
			if(!"".equals(text)){
				UpdateGUIThread update = new UpdateGUIThread(this.screen, text, Color.GREEN);
				update.start();
			}
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
