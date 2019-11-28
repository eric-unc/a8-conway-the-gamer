package eric.gameoflife.model;

import java.util.ArrayList;
import java.util.HashMap;

public class GameModel {
	
	// These constants are temporary for right now
	public static final int LOW_BIRTH_THRESHOLD = 2;
	public static final int HIGH_BIRTH_THRESHOLD = 3;
	
	// Yeah they're the same
	public static final int LOW_SURVIVAL_THRESHOLD = 3;
	public static final int HIGH_SURVIVAL_THRESHOLD = 3;
	
	public static final boolean IS_PAUSED = false; // I WILL NEVER PAUSE!
	
	// This pauses for _ miliseconds
	public static final int ROUND_BREAK = 1000;
	
	private FieldModel field;
	private ArrayList<FieldChangeEvent> changeEvents = new ArrayList<>();
	
	public GameModel(int width, int height){
		field = new FieldModel(width, height);
		
		(new Thread(){ // Will this work? big doubt
			@Override
			public void run(){
				try{
					Thread.sleep(10_000);
				}catch(InterruptedException e1){
					e1.printStackTrace();
				} //TODO: remove
				
				while(true)
					if(!IS_PAUSED){
						try{
							Thread.sleep(ROUND_BREAK);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
						
						doRound();
					}
				
			}
		}).start();
	}
	
	public synchronized void doRound(){ // I think this has to be synchronized. can't do two rounds at once.
		var newField = field.clone(); // We can't modify the grid while iterating through it or it'll break the results
		var changedCoords = new HashMap<Integer, Integer>();
		
		field.forEach(cell -> {
			var aliveNeighbors = field.getAliveNeighbors(cell).size();
			
			if(cell.isAlive() && (aliveNeighbors < LOW_SURVIVAL_THRESHOLD || aliveNeighbors > HIGH_SURVIVAL_THRESHOLD)){
				newField.getCell(cell.getX(), cell.getY()).kill();
				changedCoords.put(cell.getX(), cell.getY());
			}else if(cell.isDead() && aliveNeighbors >= LOW_BIRTH_THRESHOLD && aliveNeighbors <= HIGH_BIRTH_THRESHOLD){
				newField.getCell(cell.getX(), cell.getY()).revive();
				changedCoords.put(cell.getX(), cell.getY());
			}
		});
		
		field = newField;
		
		notifyChangeEvents(changedCoords);
	}
	
	public synchronized void invertCell(int x, int y){
		field.getCell(x, y).invertLiveliness();
		
		var changedCoords = new HashMap<Integer, Integer>();
		changedCoords.put(x, y);
		
		notifyChangeEvents(changedCoords);
	}
	
	public synchronized void clearField(){
		field.clear();
		
		notifyChangeEvents(null);
	}
	
	public synchronized void randomizeField(){
		var newField = new FieldModel(field.getWidth(), field.getHeight());
		
		newField.forEach(cell -> cell.setStatus(Math.random() >= 5.0)); // Gives a 50-50 for cells being alive
		
		field = newField;
		
		notifyChangeEvents(null);
	}
	
	public void addChangeEvent(FieldChangeEvent event){
		changeEvents.add(event);
	}
	
	// Accepts null for changedCoords if the full field should be reset
	private void notifyChangeEvents(HashMap<Integer, Integer> changedCoords){
		changeEvents.forEach(event -> event.onChange(field.clone(), changedCoords));
	}
}
