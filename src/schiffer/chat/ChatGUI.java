package schiffer.chat;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChatGUI extends JFrame {
	private JTextField text;
	private JButton send;
	private JPanel panel;
	
	public ChatGUI(){
		text = new JTextField(500);
		send = new JButton("SEND");
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(text, BorderLayout.WEST);
		panel.add(send, BorderLayout.EAST);
		this.add(panel, BorderLayout.CENTER);
		this.setTitle("My Chat Room");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(600,600);
		
	}
	
	public String getText(){
		return text.getText();
	}
	public static void main(String[] args){
		ChatGUI gui = new ChatGUI();
		gui.setVisible(true);
	}
	
	
}
