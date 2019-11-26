package eric.gameoflife.setup;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class SetupController implements ActionListener {

	private SetupModel model;
	private SetupView view;
	
	private Pattern pattern = Pattern.compile("^(\\d+)x(\\d+)$");
	
	public SetupController(SetupModel model, SetupView view){
		this.model = model;
		this.view = view;
		
		view.addButtonListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		var matcher = pattern.matcher(view.getEntry());
		
		try {
			var width = Integer.parseInt(matcher.group(1));
			var length = Integer.parseInt(matcher.group(2));
			
			model.setWidth(width);
			model.setLength(length);
		}catch(Exception ex){
			view.setMessage(SetupView.ERROR_MESSAGE);
		}
	}
}
