package eric.gameoflife.settings;

public class SettingsModel {
	private int lowBirthThreshold = 3;
	private int highBirthThreshold = 3;
	
	private int lowSurvivalThreshold = 2;
	private int highSurvivalThreshold = 3;
	
	private int roundBreakTime = 1000; // in miliseconds
	
	private boolean isTaricMode = false;
	
	public SettingsModel(){
		
	}

	public int getLowBirthThreshold(){
		return lowBirthThreshold;
	}

	public void setLowBirthThreshold(int lowBirthThreshold){
		this.lowBirthThreshold = lowBirthThreshold;
	}

	public int getHighBirthThreshold(){
		return highBirthThreshold;
	}

	public void setHighBirthThreshold(int highBirthThreshold){
		this.highBirthThreshold = highBirthThreshold;
	}

	public int getLowSurvivalThreshold(){
		return lowSurvivalThreshold;
	}

	public void setLowSurvivalThreshold(int lowSurvivalThreshold){
		this.lowSurvivalThreshold = lowSurvivalThreshold;
	}

	public int getHighSurvivalThreshold(){
		return highSurvivalThreshold;
	}

	public void setHighSurvivalThreshold(int highSurvivalThreshold){
		this.highSurvivalThreshold = highSurvivalThreshold;
	}

	public int getRoundBreakTime(){
		return roundBreakTime;
	}

	public void setRoundBreakTime(int roundBreakTime){
		this.roundBreakTime = roundBreakTime;
	}

	public boolean isTaricMode(){
		return isTaricMode;
	}

	public void setTaricMode(boolean isTaricMode){
		this.isTaricMode = isTaricMode;
	}
	
	public void invertTaricMode(){
		isTaricMode = !isTaricMode;
	}
}
