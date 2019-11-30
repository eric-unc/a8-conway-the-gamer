package eric.gameoflife;

import eric.gameoflife.model.GameModel;
import eric.gameoflife.settings.SettingsController;
import eric.gameoflife.view.GameView;

public class GameController {
	private GameModel model;
	private GameView view;
	
	public GameController(GameModel model, GameView view){
		this.model = model;
		this.view = view;
		
		model.addChangeEvent((newField, changedCoords) -> {
			if(changedCoords == null)
				newField.forEach(cell -> view.updateField(cell.getX(), cell.getY(), cell.isAlive())); // updates all
			else
				changedCoords.forEach(coord -> view.updateField(coord, newField.getCell(coord).isAlive()));
		});
		
		view.addClickEventsToField((cell, event) -> model.invertCell(cell.getFieldX(), cell.getFieldY()));
		
		view.addPauseButtonListener(event -> {
			view.invertPause();
			model.invertPause();
		});
		
		view.addAdvanceButtonListener(event -> model.doRound());
		view.addClearButtonListener(event -> model.clearField());
		view.addRandomizeButtonListener(event -> model.randomizeField());
		view.addSettingsButtonListener(event -> SettingsController.showSettings());
	}
}
