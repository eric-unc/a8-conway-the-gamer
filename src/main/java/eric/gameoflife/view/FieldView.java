package eric.gameoflife.view;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import eric.gameoflife.settings.SettingsController;
import eric.gameoflife.view.CellView.Type;

@SuppressWarnings("serial")
public class FieldView extends JPanel {
	private int width; // number of cells, not the pixels
	private int height;
	private int sideSize; // size in pixels of the cell
	
	private CellView[][] field; // y, x
	
	public FieldView(int width, int height, int sideSize){
		setLayout(new GridLayout(width, height));
		
		this.width = width;
		this.height = height;
		this.sideSize = sideSize;
		
		field = new CellView[height][width];
		
		for(var y = 0; y < field.length; y++)
			for(var x = 0; x < field[y].length; x++){
				field[y][x] = new CellView(SettingsController.isKMPMode() ? Type.KMP : Type.COLOR, sideSize, x, y);
				add(field[y][x]);
			}
		
		this.setPreferredSize(new Dimension(width * sideSize, height * sideSize));
	}
	
	public CellView getCell(int x, int y){
		return field[y][x]; 
	}
	
	public int getFieldWidth(){ // not getWidth since that's a JPanel thing
		return width;
	}
	
	public int getFieldHeight(){
		return height;
	}
	
	public int getSideSize(){
		return sideSize;
	}
}
