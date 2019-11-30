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
	
	public static SettingsController getController(){
		if(controller == null){
			controller = new SettingsController(new SettingsModel(), new SettingsView());
			
			frame = new JFrame();
			frame.setTitle("Settings");
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			frame.setContentPane(controller.getSettingsView());
			frame.setResizable(false);

			frame.pack();
		}
		
		return controller;
	}
	
	public static void showSettings(){
		if(controller == null)
			getController(); // initializes the controller and jframe
		
		frame.setVisible(true);
	}
	
	public static int getLowBirthThreshold(){
		return getController().getSetingsModel().getLowBirthThreshold();
	}
	
	public static int getHighBirthThreshold(){
		return getController().getSetingsModel().getHighBirthThreshold();
	}
	
	public static int getLowSurvivalThreshold(){
		return getController().getSetingsModel().getLowSurvivalThreshold();
	}
	
	public static int getHighSurvivalThreshold(){
		return getController().getSetingsModel().getHighSurvivalThreshold();
	}
	
	public static int getRoundBreakTime(){
		return getController().getSetingsModel().getRoundBreakTime();
	}
	
	public static boolean isTaricMode(){
		return getController().getSetingsModel().isTaricMode();
	}
}
