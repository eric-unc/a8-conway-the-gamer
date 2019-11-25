package eric.gameoflife.setup;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class SetupView extends JPanel {
	
	public static final String DEFAULT_MESSAGE = "<html>What size do you want your cell to be?" + "<br />" +
			"Please enter a pair of numbers, such as 6x10." + "<br />" +
			"Width comes first (in this case 6), and then height (in this case 10).</html>";
	
	public static final String ERROR_MESSAGE = "<html>What are you, an idiot?" + "<br />" +
			"The format was very clearly specified." + "<br />" +
			"Please enter a pair of numbers, such as 6x10." + "<br />" +
			"Width comes first (in this case 6), and then height (in this case 10).</html>";;
	
	private JTextField entry;
	private JButton enter;
	private JLabel message;
	
	public SetupView(){
		setLayout(new BorderLayout());
		
		entry = new JTextField("10x10");
		
		add(entry, BorderLayout.WEST);
		
		enter = new JButton("Enter");
		
		add(enter, BorderLayout.SOUTH);
		
		message = new JLabel(DEFAULT_MESSAGE);
		message.setSize(new Dimension(200, 200));
		
		add(message, BorderLayout.EAST);
	}
	
	public void setMessage(String newMessage){
		message.setText(newMessage);
	}
	
	public void addButtonListener(ActionListener e){
		enter.addActionListener(e);
	}
}
