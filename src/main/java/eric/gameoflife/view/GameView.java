package eric.gameoflife.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameView extends JPanel {
	
	private FieldView field;

	public GameView(int width, int height){
		setLayout(new BorderLayout());
		
		field = new FieldView(width, height, getSideSize(width, height));
		
		add(field);
	}
	
	private static int getSideSize(int width, int height){ // TODO: implement numbers that make sense here
		var toComp = width > height ? width : height; // max of width and height
		
		if(toComp <= 20)
			return 32;
		else if(toComp <= 40)
			return 16;
		else if(toComp <= 80)
			return 8;
		else if(toComp <= 160) // there's a hard limit between 220 (35 secs)
			return 4;
		else if(toComp <= 320)
			return 2;
		else
			return 1;
	}
	
	public void updateField(int x, int y, boolean isAlive){
		field.getCell(x, y).setLiveliness(isAlive);
	}
	
	public void addClickEventsToField(MouseClickEvent event){
		for(var y = 0; y < field.getFieldWidth(); y++)
			for(var x = 0; x < field.getFieldHeight(); x++)
				field.getCell(x, y).addMouseClickEvent(event);
	}
}
