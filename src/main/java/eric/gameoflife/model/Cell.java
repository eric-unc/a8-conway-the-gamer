package eric.gameoflife.model;

public class Cell {

	private boolean isAlive;
	
	public Cell(){
		isAlive = false;
	}

	public Cell(boolean isAlive){
		this.isAlive = isAlive;
	}
	
	public boolean isAlive(){
		return isAlive;
	}
	
	public boolean isDead(){
		return !isAlive;
	}
	
	public void invertLiveliness(){
		isAlive = !isAlive;
	}
	
	public void kill(){
		isAlive = false;
	}
	
	public void revive(){
		isAlive = true;
	}
}
