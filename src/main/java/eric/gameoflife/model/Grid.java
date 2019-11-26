package eric.gameoflife.model;

import java.util.ArrayList;

import eric.gameoflife.Main;

public class Grid {

	private Cell[][] grid;
	private int maxX;
	private int maxY;
	
	public Grid(int width, int height){
		if(width < 10 || width > 500)
			throw new IllegalArgumentException("Invalid width");
		
		if(height < 10 || height > 500)
			throw new IllegalArgumentException("Invalid height");
		
		grid = new Cell[height][width];
		
		maxX = grid[0].length - 1;
		maxY = grid.length - 1;
	}
	
	private boolean isInputValid(int x, int y){
		if(Main.IS_TARIC_MODE)
			return true;
		
		return maxY >= y && y >= 0 && maxX >= x && x >= 0;
	}
	
	/**
	 * This is only used in Taric Mode
	 * 
	 * @param x the x value
	 * @return the fixed value
	 */
	private int fixX(int x){
		if(maxX >= x && x >= 0)
			return x; // Then it's fine.
		
		if(x >= 0)
			while(x >= maxX)
				x -= maxX;
		else // x is negative
			while(x < 0)
				x += maxX;
		
		return x;
	}
	
	/**
	 * This is only used in Taric Mode
	 * 
	 * @param y the y value
	 * @return the fixed value
	 */
	private int fixY(int y){
		if(maxY >= y && y >= 0)
			return y; // Then it's fine.
		
		if(y >= 0)
			while(y >= maxY)
				y -= maxY;
		else // y is negative
			while(y < 0)
				y += maxY;
		
		return y;
	}

	public Cell getCell(int x, int y){
		return grid[fixY(y)][fixX(x)]; // This is a bit confusing but arrays are go like...
							// [ [C C C] ]
							// [ [C C 8] ]
							// [ [C C C] ]
							// Where 8 is at x = 3, y = 2, but it's at array[1, 2] (second array, third index
	}
	
	public boolean isCellAlive(int x, int y){
		return getCell(x, y).isAlive();
	}
	
	public boolean isCellDead(int x, int y){
		return getCell(x, y).isDead();
	}
	
	public void invertLiveliness(int x, int y){
		getCell(x, y).invertLiveliness();
	}
	
	public void kill(int x, int y){
		getCell(x, y).kill();
	}
	
	public void revive(int x, int y){
		getCell(x, y).revive();
	}
	
	public ArrayList<Cell> getNeighbors(int x, int y){
		var ret = new ArrayList<Cell>();
		
		for(var itX = -1; itX <= 1; itX++)
			for(var itY = -1; itY <= 1; itY++)
				if(!(itX == 0 && itY == 0) && isInputValid(x + itX, y + itY))
					ret.add(getCell(x + itX, y + itY));
		
		return ret;
	}
}
