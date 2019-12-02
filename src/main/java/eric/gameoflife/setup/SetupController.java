package eric.gameoflife.setup;

import java.util.regex.Pattern;

public class SetupController {
	
	private final Pattern pattern = Pattern.compile("^(\\d+)x(\\d+)$");
	
	public SetupController(SetupModel model, SetupView view){
		view.addButtonListener(e -> {
			var matcher = pattern.matcher(view.getEntry());
			
			try {
				matcher.find();
				
				var width = Integer.parseInt(matcher.group(1));
				var height = Integer.parseInt(matcher.group(2));
				
				model.setWidth(width);
				model.setHeight(height);
			}catch(Exception ex){
				view.setMessage(SetupView.ERROR_MESSAGE);
			}
		});
	}
}
