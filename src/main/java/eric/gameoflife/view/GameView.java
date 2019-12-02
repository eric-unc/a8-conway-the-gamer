package eric.gameoflife.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import eric.gameoflife.Coordinate;

@SuppressWarnings("serial")
public class GameView extends JPanel {
	
	private FieldView field;
	private JPanel buttonPanel;
	private JButton pauseButton;
	private JButton advance;
	private JButton clear;
	private JButton randomize;
	private JButton settings;

	public GameView(int width, int height){
		setLayout(new BorderLayout());
		
		field = new FieldView(width, height, getSideSize(width, height));
		add(field, BorderLayout.WEST);
		
		buttonPanel = new JPanel(new GridLayout(5, 1)); // Change second arg to number of buttons
		
		// Buttons
		pauseButton = new JButton("Start"); // it starts paused, so pressing it will unpause it
		buttonPanel.add(pauseButton);
		
		advance = new JButton("Advance");
		buttonPanel.add(advance);
		
		clear = new JButton("Clear");
		buttonPanel.add(clear);
		
		randomize = new JButton("Randomize");
		buttonPanel.add(randomize);
		
		settings = new JButton("Settings");
		buttonPanel.add(settings);
		
		// Buttons end
		add(buttonPanel, BorderLayout.EAST);
	}
	
	private static int getSideSize(int width, int height){
		var toComp = width > height ? width : height;
		
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
	
	public void updateField(Coordinate coord, boolean isAlivevent){
		updateField(coord.getX(), coord.getY(), isAlivevent);
	}
	
	public void updateField(int x, int y, boolean isAlivevent){
		field.getCell(x, y).setLiveliness(isAlivevent);
	}
	
	public void updateImages(){
		for(var y = 0; y < field.getFieldHeight(); y++)
			for(var x = 0; x < field.getFieldWidth(); x++)
				field.getCell(x, y).repaint();
	}
	
	public void addClickEventsToField(MouseClickEvent event){
		for(var y = 0; y < field.getFieldWidth(); y++)
			for(var x = 0; x < field.getFieldHeight(); x++)
				field.getCell(x, y).addMouseClickEvent(event);
	}
	
	public void addPauseButtonListener(ActionListener event){
		pauseButton.addActionListener(event);
	}
	
	public boolean isPaused(){
		return pauseButton.getText().equals("Start");
	}
	
	public void invertPause(){
		pauseButton.setText(isPaused() ? "Pause" : "Start"); // Keep in mind that it says the opposite of what it is
	}
	
	public void addAdvanceButtonListener(ActionListener event){
		advance.addActionListener(event);
	}
	
	public void addClearButtonListener(ActionListener event){
		clear.addActionListener(event);
	}
	
	public void addRandomizeButtonListener(ActionListener event){
		randomize.addActionListener(event);
	}
	
	public void addSettingsButtonListener(ActionListener event){
		settings.addActionListener(event);
	}
}
