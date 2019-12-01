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
		
		view.addLowBirthThreshholdButton(event -> {
			try {
				var newThreshold = Integer.parseInt(view.getLowBirthThreshholdText());
				
				if(newThreshold < 0 || newThreshold > 8 || newThreshold > model.getHighBirthThreshold())
					throw new IllegalArgumentException();
				
				model.setLowBirthThreshold(newThreshold);
			}catch(IllegalArgumentException ex){
				view.setLowBirthThreshholdText(Integer.toString(DefaultSettings.LOW_BIRTH_THRESHOLD));
			}
		});
		
		view.addHighBirthThreshholdButton(event -> {
			try {
				var newThreshold = Integer.parseInt(view.getHighBirthThreshholdText());
				
				if(newThreshold < 0 || newThreshold > 8 || newThreshold < model.getLowBirthThreshold())
					throw new IllegalArgumentException();
				
				model.setHighBirthThreshold(newThreshold);
			}catch(IllegalArgumentException ex){
				view.setHighBirthThreshholdText(Integer.toString(DefaultSettings.HIGH_BIRTH_THRESHOLD));
			}
		});
		
		view.addLowSurvivalThreshholdButton(event -> {
			try {
				var newThreshold = Integer.parseInt(view.getLowSurvivalThreshholdText());
				
				if(newThreshold < 0 || newThreshold > 8 || newThreshold > model.getHighSurvivalThreshold())
					throw new IllegalArgumentException();
				
				model.setLowSurvivalThreshold(newThreshold);
			}catch(IllegalArgumentException ex){
				view.setLowSurvivalThreshholdText(Integer.toString(DefaultSettings.LOW_SURVIVAL_THRESHOLD));
			}
		});
		
		view.addHighSurvivalThreshholdButton(event -> {
			try {
				var newThreshold = Integer.parseInt(view.getHighSurvivalThreshholdText());
				
				if(newThreshold < 0 || newThreshold > 8 || newThreshold < model.getLowSurvivalThreshold())
					throw new IllegalArgumentException();
				
				model.setHighSurvivalThreshold(newThreshold);
			}catch(IllegalArgumentException ex){
				view.setHighSurvivalThreshholdText(Integer.toString(DefaultSettings.HIGH_SURVIVAL_THRESHOLD));
			}
		});
		
		view.addRoundBreakTimeButton(event -> {
			try {
				var newBreakTime = Integer.parseInt(view.getRoundBreakTimeText());
				
				if(newBreakTime < 10 || newBreakTime > 1000)
					throw new IllegalArgumentException();
				
				model.setRoundBreakTime(newBreakTime);
			}catch(IllegalArgumentException ex){
				view.setRoundBreakTimeText(Long.toString(DefaultSettings.ROUND_BREAK_TIME));
			}
		});
		
		view.addIsTaricModeButton(e -> {
			var taricMode = view.getIsTaricModeButtonText();
			
			switch(taricMode){
			case "True":
				view.setIsTaricModeButtonText("False");
				model.setTaricMode(false);
				break;
			case "False":
				view.setIsTaricModeButtonText("True");
				model.setTaricMode(true);
				break;
			}
		});
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
	
	public static long getRoundBreakTime(){
		return getController().getSetingsModel().getRoundBreakTime();
	}
	
	public static boolean isTaricMode(){
		return getController().getSetingsModel().isTaricMode();
	}
	
	public static boolean isKMPMode(){
		return getController().getSetingsModel().isKMPMode();
	}
}
