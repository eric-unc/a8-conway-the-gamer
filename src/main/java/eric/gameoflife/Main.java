package eric.gameoflife;

import javax.swing.JFrame;

import eric.gameoflife.setup.SetupView;

public class Main {

	public static void main(String[] args){
		var view = new SetupView();
		
		var frame = new JFrame();
		frame.setTitle("Setup");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setContentPane(view);

		frame.pack();
		frame.setVisible(true);
	}
}
