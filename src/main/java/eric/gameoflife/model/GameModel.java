package eric.gameoflife.model;

import java.util.ArrayList;

import eric.gameoflife.Coordinate;
import eric.gameoflife.settings.SettingsController;

public class GameModel {
	
	private FieldModel field;
	private ArrayList<FieldChangeEvent> changeEvents = new ArrayList<>();
	private boolean isPaused = true;
	
	public GameModel(int width, int height){
		field = new FieldModel(width, height);
		
		(new Thread(){
			@Override
			public void run(){
				try{
					while(true){
						Thread.sleep(1); // Don't ask why, but any statement can be here
						if(!isPaused){
							Thread.sleep(SettingsController.getRoundBreakTime());
							doRound();
						}
					}
				}catch(InterruptedException e){
					e.printStackTrace();
				}
				
			}
		}).start();
	}
	
	public synchronized void doRound(){ // I think this has to be synchronized. can't do two rounds at once.
		var newField = field.clone(); // We can't modify the grid while iterating through it or it'll break the results
		var changedCoords = new ArrayList<Coordinate>();
		
		field.forEach(cell -> {
			var aliveNeighbors = field.getAliveNeighbors(cell).size();
			
			if(cell.isAlive() && (aliveNeighbors < SettingsController.getLowSurvivalThreshold() 
					|| aliveNeighbors > SettingsController.getHighSurvivalThreshold())){
				newField.getCell(cell.getX(), cell.getY()).kill();
				changedCoords.add(new Coordinate(cell.getX(), cell.getY()));
			}else if(cell.isDead() && aliveNeighbors >= SettingsController.getLowBirthThreshold() 
					&& aliveNeighbors <= SettingsController.getHighBirthThreshold()){
				newField.getCell(cell.getX(), cell.getY()).revive();
				changedCoords.add(new Coordinate(cell.getX(), cell.getY()));
			}
			
			changedCoords.add(new Coordinate(cell.getX(), cell.getY()));
		});
		
		field = newField;
		
		notifyChangeEvents(changedCoords);
	}
	
	public synchronized void invertCell(int x, int y){
		field.getCell(x, y).invertLiveliness();
		
		var changedCoords = new ArrayList<Coordinate>();
		changedCoords.add(new Coordinate(x, y));
		
		notifyChangeEvents(changedCoords);
	}
	
	public synchronized void clearField(){
		field.clear();
		
		notifyChangeEvents(null);
	}
	
	public synchronized void randomizeField(){
		var newField = new FieldModel(field.getWidth(), field.getHeight());
		
		newField.forEach(cell -> cell.setStatus(Math.random() >= 0.5)); // Gives a 50-50 for cells being alive
		
		field = newField;
		
		notifyChangeEvents(null);
	}
	
	public void addChangeEvent(FieldChangeEvent event){
		changeEvents.add(event);
	}
	
	// Accepts null for changedCoords if the full field should be reset
	private void notifyChangeEvents(ArrayList<Coordinate> changedCoords){
		changeEvents.forEach(event -> event.onChange(field.clone(), changedCoords));
	}
	
	public boolean isPaused(){
		return isPaused;
	}
	
	public void invertPause(){
		isPaused = !isPaused;
	}
}
