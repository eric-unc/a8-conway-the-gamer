package eric.gameoflife;

import eric.gameoflife.model.GameModel;
import eric.gameoflife.view.GameView;

public class GameController {
	private GameModel model;
	private GameView view;
	
	public GameController(GameModel model, GameView view){
		this.model = model;
		this.view = view;
		
		model.addChangeEvent((newField, changedCoords) -> {
			if(changedCoords == null)
				newField.forEach(cell -> view.updateField(cell.getX(), cell.getY(), cell.isAlive()));
			else
				changedCoords.forEach(coord -> 
				view.updateField(coord.getX(), coord.getY(), newField.getCell(coord.getX(), coord.getY()).isAlive()));
			System.out.println("Model update");
			//view.updateField(0, 0, newField.getCell(0, 0).isAlive());
			//changedCoords.forEach((x, y) -> view.updateField(x, y, newField.getCell(x, y).isAlive()));
			//newField.forEach(cell -> view.updateField(cell.getX(), cell.getY(), cell.isAlive()));
		});
		
		view.addClickEventsToField((cell, event) -> {
			model.invertCell(cell.getFieldX(), cell.getFieldY());
		});
	}
}
