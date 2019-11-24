package src.java.main.setup.view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SetupView extends JPanel {
	
	private JLabel message;
	
	public SetupView(){
		setLayout(new BorderLayout());
		
		message = new JLabel("What size do you want your cell to be?" + "\n" +
				"Please enter a pair of numbers, such as 6x10." + "\n" +
				"Width comes first (in this case 6), and then height (in this case 10).");
	}
	
	public void setMessage(String newMessage){
		message.setText(newMessage);
	}
}
