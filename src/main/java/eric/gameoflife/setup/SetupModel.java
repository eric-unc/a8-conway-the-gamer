package eric.gameoflife.setup;

public class SetupModel {
	private int width;
	private int height;
	
	public SetupModel(){
		width = -1;
		height = -1;
	}

	public int getWidth(){
		return width;
	}

	public void setWidth(int width){
		if(width < 10 || width > 500)
			throw new IllegalArgumentException("Invalid width");
		
		this.width = width;
	}

	public int getHeight(){
		return height;
	}

	public void setHeight(int height){
		if(height < 10 || height > 500)
			throw new IllegalArgumentException("Invalid height");
		
		this.height = height;
	}
}
