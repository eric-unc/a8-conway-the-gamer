package eric.gameoflife;

import javax.swing.JFrame;

import eric.gameoflife.setup.*;

public class Main {

	public static void main(String[] args){
		var model = new SetupModel();
		var view = new SetupView();
		var controller = new SetupController(model, view);
		
		var frame = new JFrame();
		frame.setTitle("Setup");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setContentPane(view);

		frame.pack();
		frame.setVisible(true);
	}
}
