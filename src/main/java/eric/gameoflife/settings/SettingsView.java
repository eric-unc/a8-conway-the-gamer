package eric.gameoflife.settings;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class SettingsView extends JPanel {

	private JTextField lowBirthThreshholdTextField;
	private JButton lowBirthThreshholdButton;

	private JTextField highBirthThreshholdTextField;
	private JButton highBirthThreshholdButton;

	private JTextField lowSurvivalThreshholdTextField;
	private JButton lowSurvivalThreshholdButton;

	private JTextField highSurvivalThreshholdTextField;
	private JButton highSurvivalThreshholdButton;

	private JTextField roundBreakTimeTextField;
	private JButton roundBreakTimeButton;
	
	private JButton isTaricModeButton;

	public SettingsView(){
		setLayout(new GridLayout(3, 2)); // width, height

		// Low birth threshold
		var lowBirthThreshhold = new JPanel();
		lowBirthThreshhold.add(new JLabel("The low birth threshold [0-8]"));

		lowBirthThreshholdTextField = new JTextField(Integer.toString(DefaultSettings.LOW_BIRTH_THRESHOLD), 2);
		lowBirthThreshhold.add(lowBirthThreshholdTextField);

		lowBirthThreshholdButton = new JButton("Update");
		lowBirthThreshhold.add(lowBirthThreshholdButton);

		add(lowBirthThreshhold);

		// High birth threshold
		var highBirthThreshhold = new JPanel();
		highBirthThreshhold.add(new JLabel("The high birth threshold [0-8]"));

		highBirthThreshholdTextField = new JTextField(Integer.toString(DefaultSettings.HIGH_BIRTH_THRESHOLD), 2);
		highBirthThreshhold.add(highBirthThreshholdTextField);

		highBirthThreshholdButton = new JButton("Update");
		highBirthThreshhold.add(highBirthThreshholdButton);

		add(highBirthThreshhold);

		// Low survival threshold
		var lowSurvivalThreshhold = new JPanel();
		lowSurvivalThreshhold.add(new JLabel("The low survival threshold [0-8]"));

		lowSurvivalThreshholdTextField = new JTextField(Integer.toString(DefaultSettings.LOW_SURVIVAL_THRESHOLD), 2);
		lowSurvivalThreshhold.add(lowSurvivalThreshholdTextField);

		lowSurvivalThreshholdButton = new JButton("Update");
		lowSurvivalThreshhold.add(lowSurvivalThreshholdButton);

		add(lowSurvivalThreshhold);

		// High birth threshold
		var highSurvivalThreshhold = new JPanel();
		highSurvivalThreshhold.add(new JLabel("The high survival threshold [0-8]"));

		highSurvivalThreshholdTextField = new JTextField(Integer.toString(DefaultSettings.HIGH_SURVIVAL_THRESHOLD), 2);
		highSurvivalThreshhold.add(highSurvivalThreshholdTextField);

		highSurvivalThreshholdButton = new JButton("Update");
		highSurvivalThreshhold.add(highSurvivalThreshholdButton);

		add(highSurvivalThreshhold);

		// Round break time
		var roundBreakTime = new JPanel();
		roundBreakTime.add(new JLabel("The round break time [10-1000]"));

		roundBreakTimeTextField = new JTextField(Long.toString(DefaultSettings.ROUND_BREAK_TIME), 5);
		roundBreakTime.add(roundBreakTimeTextField);

		roundBreakTimeButton = new JButton("Update");
		roundBreakTime.add(roundBreakTimeButton);

		add(roundBreakTime);
		
		// is taric mode
		var isTaricMode = new JPanel();
		isTaricMode.add(new JLabel("Taric mode"));
		
		isTaricModeButton = new JButton("False");
		isTaricMode.add(isTaricModeButton);
		
		add(isTaricMode);
	}

	// birth methods

	public String getLowBirthThreshholdText(){
		return lowBirthThreshholdTextField.getText();
	}

	public void setLowBirthThreshholdText(String text){
		lowBirthThreshholdTextField.setText(text);
	}

	public void addLowBirthThreshholdButton(ActionListener event){
		lowBirthThreshholdButton.addActionListener(event);
	}

	public String getHighBirthThreshholdText(){
		return highBirthThreshholdTextField.getText();
	}

	public void setHighBirthThreshholdText(String text){
		highBirthThreshholdTextField.setText(text);
	}

	public void addHighBirthThreshholdButton(ActionListener event){
		highBirthThreshholdButton.addActionListener(event);
	}

	// survival methods

	public String getLowSurvivalThreshholdText(){
		return lowSurvivalThreshholdTextField.getText();
	}

	public void setLowSurvivalThreshholdText(String text){
		lowSurvivalThreshholdTextField.setText(text);
	}

	public void addLowSurvivalThreshholdButton(ActionListener event){
		lowSurvivalThreshholdButton.addActionListener(event);
	}

	public String getHighSurvivalThreshholdText(){
		return highSurvivalThreshholdTextField.getText();
	}

	public void setHighSurvivalThreshholdText(String text){
		highSurvivalThreshholdTextField.setText(text);
	}

	public void addHighSurvivalThreshholdButton(ActionListener event){
		highBirthThreshholdButton.addActionListener(event);
	}
	
	// round break time
	public String getRoundBreakTimeText(){
		return roundBreakTimeTextField.getText();
	}

	public void setRoundBreakTimeText(String text){
		roundBreakTimeTextField.setText(text);
	}

	public void addRoundBreakTimeButton(ActionListener event){
		roundBreakTimeButton.addActionListener(event);
	}
	
	// booleans
	public String getIsTaricModeButtonText(){
		return isTaricModeButton.getText();
	}
	
	public void setIsTaricModeButtonText(String text){
		isTaricModeButton.setText(text);
	}

	public void addIsTaricModeButton(ActionListener event){
		isTaricModeButton.addActionListener(event);
	}
}
