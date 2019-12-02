package eric.gameoflife.model;

import java.util.ArrayList;
import java.util.Iterator;

import eric.gameoflife.Coordinate;
import eric.gameoflife.settings.SettingsController;

public class FieldModel implements Iterable<CellModel> {
	
	private CellModel[][] field; // This y, then x
						// This is a bit confusing but arrays are go like...
						// [ [C C C] ]
						// [ [C C 8] ]
						// [ [C C C] ]
						// Where 8 is at x = 3, y = 2, but it's at array[1, 2] (second array, third index)
	private int maxX;
	private int maxY;
	
	public FieldModel(int width, int height){
		if(width < 10 || width > 500)
			throw new IllegalArgumentException("Invalid width");
		
		if(height < 10 || height > 500)
			throw new IllegalArgumentException("Invalid height");
		
		field = new CellModel[height][width];
		
		maxX = field[0].length - 1;
		maxY = field.length - 1;
		
		for(var y = 0; y < field.length; y++)
			for(var x = 0; x < field[y].length; x++)
				field[y][x] = new CellModel(x, y); // Initializing all of the cells in the grid
	}
	
	private boolean isInputValid(int x, int y){
		if(SettingsController.isTorusMode())
			return true;
		
		return maxY >= y && y >= 0 && maxX >= x && x >= 0;
	}
	
	/**
	 * This is only used in Torus Mode
	 * 
	 * @param x the x value
	 * @return the fixed value
	 */
	private int fixX(int x){
		if(maxX >= x && x >= 0)
			return x; // Then it's fine.
		
		if(x >= 0)
			while(x >= maxX)
				x -= (maxX + 1);
		else // x is negative
			while(x < 0)
				x += (maxX + 1);
		
		return x;
	}
	
	/**
	 * This is only used in Torus Mode
	 * 
	 * @param y the y value
	 * @return the fixed value
	 */
	private int fixY(int y){
		if(maxY >= y && y >= 0)
			return y; // Then it's fine.
		
		if(y >= 0)
			while(y >= maxY)
				y -= (maxY + 1);
		else // y is negative
			while(y < 0)
				y += (maxY + 1);
		
		return y;
	}

	public CellModel getCell(int x, int y){
		return field[fixY(y)][fixX(x)]; 
	}
	
	public CellModel getCell(Coordinate coord){
		return getCell(coord.getX(), coord.getY());
	}
	
	public ArrayList<CellModel> getNeighbors(CellModel cell){
		return getNeighbors(cell.getX(), cell.getY());
	}
	
	public ArrayList<CellModel> getNeighbors(int x, int y){
		var ret = new ArrayList<CellModel>();
		
		for(var itX = -1; itX <= 1; itX++)
			for(var itY = -1; itY <= 1; itY++)
				if(!(itX == 0 && itY == 0) && isInputValid(x + itX, y + itY))
					ret.add(getCell(x + itX, y + itY));
		
		return ret;
	}
	
	public ArrayList<CellModel> getAliveNeighbors(CellModel cell){
		var neighbors = getNeighbors(cell);
		var ret = new ArrayList<CellModel>();
		
		neighbors.stream().filter(neighbor -> neighbor.isAlive()).forEach(ret::add);
		
		return ret;
	}
	
	public int getWidth(){
		return maxY + 1;
	}
	
	public int getHeight(){
		return maxX + 1;
	}
	
	public void clear(){
		this.forEach(cell -> cell.kill());
	}

	@Override
	public Iterator<CellModel> iterator(){
		var retArray = new ArrayList<CellModel>();
		
		for(var y = 0; y < field.length; y++)
			for(var x = 0; x < field[y].length; x++)
				retArray.add(getCell(x, y));
		
		return retArray.iterator();
	}
	
	@Override
	public FieldModel clone(){
		var ret = new FieldModel(field.length, field[0].length);
		
		for(var y = 0; y < ret.field.length; y++)
			for(var x = 0; x < ret.field[y].length; x++)
				ret.field[y][x] = getCell(x, y).clone(); // Initializing all of the cells in the grid
		
		return ret;
	}
}
