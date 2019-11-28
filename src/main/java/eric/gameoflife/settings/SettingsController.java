package eric.gameoflife.settings;

import javax.swing.JFrame;

public class SettingsController {

	private static JFrame frame;
	private static SettingsController controller;
	
	private SettingsModel model;
	private SettingsView view;
	
	private SettingsController(SettingsModel model, SettingsView view){
		this.model = model;
		this.view = view;
	}

	public SettingsModel getSetingsModel(){
		return model;
	}
	
	public SettingsView getSettingsView(){
		return view;
	}
	
	public static SettingsController createController(){
		if(controller == null){
			controller = new SettingsController(new SettingsModel(), new SettingsView());
			
			frame = new JFrame();
			frame.setTitle("Settings");
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			frame.setContentPane(controller.getSettingsView());

			frame.pack();
		}
		
		return controller;
	}
	
	public static void showSettings(){
		frame.setVisible(true);
		frame.setResizable(false);
	}
}
