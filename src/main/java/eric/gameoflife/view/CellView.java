package eric.gameoflife.view;

import javax.swing.JPanel;

import static eric.gameoflife.view.CellView.Type.*;

import java.awt.*;

@SuppressWarnings("serial")
public class CellView extends JPanel {
	public enum Type {
		COLOR,
		KMP
	}
	
	private Type type;
	private boolean isAlive;
	private int sideSize;
	
	public CellView(int sideSize){
		this(COLOR, sideSize);
	}
	
	public CellView(Type type, int sideSize){
		this(type, false, sideSize);
	}
	
	public CellView(boolean isAlive, int sideSize){
		this(COLOR, isAlive, sideSize);
	}
	
	public CellView(Type type, boolean isAlive, int sideSize){
		this.type = type;
		this.isAlive = isAlive;
		this.sideSize = sideSize;
		
		// todo
	}
	
	@Override
	public void paintComponent(Graphics graphic){
		switch(type){
		case COLOR:
			graphic.setColor(isAlive ? Color.BLACK : Color.WHITE);
			// graphic.setStroke(new BasicStroke(4)); // this is part of Graphics2D but i don't think we need that?
			graphic.fillRect(0, 0, sideSize, sideSize);
			break;
		case KMP: // umm wip
		}
	}
	
	public void paintComponent(Graphics graphic, boolean isAlive){
		this.isAlive = isAlive;
		paintComponent(graphic);
	}
}
