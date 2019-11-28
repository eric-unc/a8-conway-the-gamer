package eric.gameoflife.model;

public class CellModel {

	private final int x; // This doesn't seem right since Grid is also keeping track of the info but
	private final int y; // idk... it's going to make it easier to work with
	private boolean isAlive;
	
	public CellModel(int x, int y){
		this.x = x;
		this.y = y;
		isAlive = false;
	}

	public CellModel(int x, int y, boolean isAlive){
		this.x = x;
		this.y = y;
		this.isAlive = isAlive;
	}
	
	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}
	
	// I know it's a lot for one boolean, but trust me, the helpers make it much easier to understand
	
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
	
	public void setStatus(boolean status){
		isAlive = status;
	}
}
