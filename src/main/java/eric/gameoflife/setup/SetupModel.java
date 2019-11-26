package eric.gameoflife.setup;

public class SetupModel {
	public int width;
	public int length;
	
	public SetupModel(){
		width = -1;
		length = -1;
	}

	public int getWidth(){
		return width;
	}

	public void setWidth(int width){
		if(width < 10 || width > 500)
			throw new IllegalArgumentException("Invalid width");
		
		this.width = width;
	}

	public int getLength(){
		return length;
	}

	public void setLength(int length){
		if(length < 10 || length > 500)
			throw new IllegalArgumentException("Invalid length");
		
		this.length = length;
	}
}
