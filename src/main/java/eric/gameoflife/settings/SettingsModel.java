package eric.gameoflife.settings;

public class SettingsModel {
	private int lowBirthThreshold = 2;
	private int highBirthThreshold = 3;
	
	private int lowSurvivalThreshold = 3;
	private int highSurvivalThreshold = 3;
	
	private int roundBreakTime = 1000; // in miliseconds
	
	private boolean isTaricMode = false;
	
	public SettingsModel(){
		
	}

	/**
	 * @return the lowBirthThreshold
	 */
	public int getLowBirthThreshold(){
		return lowBirthThreshold;
	}

	/**
	 * @param lowBirthThreshold the lowBirthThreshold to set
	 */
	public void setLowBirthThreshold(int lowBirthThreshold){
		this.lowBirthThreshold = lowBirthThreshold;
	}

	/**
	 * @return the highBirthThreshold
	 */
	public int getHighBirthThreshold(){
		return highBirthThreshold;
	}

	/**
	 * @param highBirthThreshold the highBirthThreshold to set
	 */
	public void setHighBirthThreshold(int highBirthThreshold){
		this.highBirthThreshold = highBirthThreshold;
	}

	/**
	 * @return the lowSurvivalThreshold
	 */
	public int getLowSurvivalThreshold(){
		return lowSurvivalThreshold;
	}

	/**
	 * @param lowSurvivalThreshold the lowSurvivalThreshold to set
	 */
	public void setLowSurvivalThreshold(int lowSurvivalThreshold){
		this.lowSurvivalThreshold = lowSurvivalThreshold;
	}

	/**
	 * @return the highSurvivalThreshold
	 */
	public int getHighSurvivalThreshold(){
		return highSurvivalThreshold;
	}

	/**
	 * @param highSurvivalThreshold the highSurvivalThreshold to set
	 */
	public void setHighSurvivalThreshold(int highSurvivalThreshold){
		this.highSurvivalThreshold = highSurvivalThreshold;
	}

	/**
	 * @return the roundBreakTime
	 */
	public int getRoundBreakTime(){
		return roundBreakTime;
	}

	/**
	 * @param roundBreakTime the roundBreakTime to set
	 */
	public void setRoundBreakTime(int roundBreakTime){
		this.roundBreakTime = roundBreakTime;
	}

	/**
	 * @return the isTaricMode
	 */
	public boolean isTaricMode(){
		return isTaricMode;
	}

	/**
	 * @param isTaricMode the isTaricMode to set
	 */
	public void setTaricMode(boolean isTaricMode){
		this.isTaricMode = isTaricMode;
	}
	
	public void invertTaricMode(){
		isTaricMode = !isTaricMode;
	}
}
