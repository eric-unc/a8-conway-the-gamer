package eric.gameoflife;

import java.awt.Dimension;

import javax.swing.JFrame;

import eric.gameoflife.setup.*;

public class Main {
	
	// Temp until it can become a toggle.
	public static final boolean IS_TARIC_MODE = false;

	public static void main(String[] args){
		var dim = setup();
	}
	
	private static Dimension setup(){
		var model = new SetupModel();
		var view = new SetupView();
		
		@SuppressWarnings("unused")
		var controller = new SetupController(model, view);
		
		var frame = new JFrame();
		frame.setTitle("Setup");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setContentPane(view);

		frame.pack();
		frame.setVisible(true);
		
		try {
			while(model.getWidth() == -1 && model.getHeight() == -1) // Waits until the width/height is defined
				Thread.sleep(1); // Don't ask why, but there has to be a statement here...
								// Otherwise the while loop goes berserk. It doesn't even matter what the statement is.
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		frame.setVisible(false);
		
		return new Dimension(model.getWidth(), model.getHeight());
	}
}
