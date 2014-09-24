package schiffer.chat;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChatGUI extends JFrame {
	private JLabel enterText;
	private JTextField text;
	private JButton send;
	private JPanel panel;
	
	public ChatGUI(){
		enterText = new JLabel("Enter text");
		text = new JTextField(500);
		send = new JButton("Send");
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(enterText);
		panel.add(text);
		panel.add(send);
		this.add(panel);
		this.setTitle("My Chat Room");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(600,800);
		
	}
	public static void main(String[] args){
		ChatGUI gui = new ChatGUI();
		gui.setVisible(true);
	}
	
	
}
