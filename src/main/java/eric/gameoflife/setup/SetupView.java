package eric.gameoflife.setup;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class SetupView extends JPanel {
	
	public static final String DEFAULT_ENTRY = "10x10";
	
	public static final String DEFAULT_MESSAGE = "<html>What size do you want your cell to be?" + "<br />" +
			"Please enter a pair of numbers, such as 16x20." + "<br />" +
			"Width comes first (in this case 16), and then height (in this case 20)." + "<br />" +
			"The width/height must be at least 10, and no more than 500." + "<br />" +
			"Note that if you choose a large field, the simulation will be very slow. 500x500 takes 3 mins.</html>";
	
	public static final String ERROR_MESSAGE = "<html>What are you, an idiot?" + "<br />" +
			"The format was very clearly specified." + "<br />" +
			"Please enter a pair of numbers, such as 16x20." + "<br />" +
			"Width comes first (in this case 16), and then height (in this case 20)." + "<br />" +
			"The width/height must be at least 10, and no more than 500." + "<br />" +
			"Note that if you choose a large field, the simulation will be very slow. 500x500 takes 3 mins.</html>";
	
	private JTextField entry;
	private JButton enter;
	private JLabel message;
	
	public SetupView(){
		setLayout(new BorderLayout());
		
		entry = new JTextField(DEFAULT_ENTRY);
		
		add(entry, BorderLayout.WEST);
		
		enter = new JButton("Enter");
		
		add(enter, BorderLayout.SOUTH);
		
		message = new JLabel(DEFAULT_MESSAGE);
		message.setSize(new Dimension(200, 200));
		
		add(message, BorderLayout.EAST);
	}
	
	public String getEntry(){
		return entry.getText();
	}
	
	public void setMessage(String newMessage){
		message.setText(newMessage);
	}
	
	public void addButtonListener(ActionListener event){
		enter.addActionListener(event);
	}
}
