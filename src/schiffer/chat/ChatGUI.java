package schiffer.chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ChatGUI extends JFrame {
	private JTextArea text;
	private JButton send;
	private JPanel panel;
	
	public ChatGUI(){
		text = new JTextArea();
		send = new JButton("SEND");
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(text, BorderLayout.CENTER);
		panel.add(send, BorderLayout.EAST);
		this.setLayout(new BorderLayout());
		this.add(panel, BorderLayout.CENTER);
		this.setTitle("My Chat Room");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(600,600);
		
		send.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				text.setText(getText() + "\n");
			}
		});
		setVisible(true);
	}
	
	public String getText(){
		return text.getText();
	} 
	
	public void setText(String message){
		this.text.setText(getText()+"\n"+message);
	}
	
	
}
