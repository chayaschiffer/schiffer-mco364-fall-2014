package schiffer.client;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ConversationComponent extends JComponent{

	private ArrayList<JLabel>chatPieces;
	private JPanel chatPanel;

	public ConversationComponent(ArrayList<JLabel>chatPieces, JPanel chatPanel){
		this.chatPieces = chatPieces;
		this.chatPanel = chatPanel;
	}
	
	@Override
	public void paintComponent(Graphics pen) {
		super.paintComponent(pen);
		for(int i = 0; i<this.chatPieces.size(); i++){
			this.chatPanel.add(this.chatPieces.get(i));
		}
	}
	
	//Add a JLabel
	void addConvoPiece(JLabel convoPiece){
		this.chatPieces.add(convoPiece);
	}
	
}