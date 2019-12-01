package eric.gameoflife.settings;

public class SettingsModel {
	private int lowBirthThreshold = DefaultSettings.LOW_BIRTH_THRESHOLD;
	private int highBirthThreshold = DefaultSettings.HIGH_BIRTH_THRESHOLD;
	
	private int lowSurvivalThreshold = DefaultSettings.LOW_SURVIVAL_THRESHOLD;
	private int highSurvivalThreshold = DefaultSettings.HIGH_SURVIVAL_THRESHOLD;
	
	private long roundBreakTime = DefaultSettings.ROUND_BREAK_TIME; // in miliseconds
	
	private boolean isTaricMode = DefaultSettings.IS_TARIC_MODE;
	
	private boolean isKMPMode = DefaultSettings.IS_KMP_MODE;
	
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

	public long getRoundBreakTime(){
		return roundBreakTime;
	}

	public void setRoundBreakTime(long roundBreakTime){
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
	
	public boolean isKMPMode(){
		return isKMPMode;
	}

	public void setKMPMode(boolean isKMPMode){
		this.isKMPMode = isKMPMode;
	}
	
	public void invertKMPMode(){
		isKMPMode = !isKMPMode;
	}
}
