package eric.gameoflife.view;

import javax.swing.JPanel;

import static eric.gameoflife.view.CellView.Type.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class CellView extends JPanel {
	public enum Type {
		COLOR,
		KMP
	}
	
	private Type type;
	private boolean isAlive;
	private int sideSize;
	private int x;
	private int y;
	
	private ArrayList<MouseClickEvent> events = new ArrayList<>();
	private boolean isHighlighted = false;
	
	public CellView(int sideSize, int x, int y){
		this(COLOR, sideSize, x, y);
	}
	
	public CellView(Type type, int sideSize, int x, int y){
		this(type, false, sideSize, x, y);
	}
	
	public CellView(boolean isAlive, int sideSize, int x, int y){
		this(COLOR, isAlive, sideSize, x, y);
	}
	
	public CellView(Type type, boolean isAlive, int sideSize, int x, int y){
		this.type = type;
		this.isAlive = isAlive;
		this.sideSize = sideSize;
		this.x = x;
		this.y = y;
		
		this.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e){
				events.forEach(mouseEvent -> mouseEvent.mouseClicked(getThis(), e));
			}

			@Override
			public void mousePressed(MouseEvent e){}

			@Override
			public void mouseReleased(MouseEvent e){}

			@Override
			public void mouseEntered(MouseEvent e){
				isHighlighted = true;
				repaint();
			}

			@Override
			public void mouseExited(MouseEvent e){
				isHighlighted = false;
				repaint();
			}
		});
	}
	
	private CellView getThis(){ // `this` doesn't work in an anonymous class so yeah
		return this;
	}
	
	@Override
	public void paintComponent(Graphics graphic){
		graphic.clearRect(0, 0, sideSize, sideSize);
		
		switch(type){
		case COLOR:
			graphic.setColor(isAlive ? Color.BLACK : Color.WHITE);
			graphic.fillRect(0, 0, sideSize, sideSize);
			break;
		case KMP: // umm wip
		}
		
		if(sideSize >= 4){
				graphic.setColor(Color.BLACK);
				graphic.drawRect(0, 0, sideSize, sideSize);
		}
		
		if(isHighlighted && sideSize >= 8){
			graphic.setColor(Color.YELLOW);
			graphic.drawRect(1, 1, sideSize - 1, sideSize - 1);
		}
	}
	
	public void setLiveliness(boolean isAlive){
		this.isAlive = isAlive;
		paintComponent(this.getGraphics());
	}
	
	public void invertLiveliness(){
		isAlive = !isAlive;
		paintComponent(this.getGraphics());
	}
	
	public void addMouseClickEvent(MouseClickEvent event){
		events.add(event);
	}
	
	public int getFieldX(){
		return x;
	}
	
	public int getFieldY(){
		return y;
	}
}
