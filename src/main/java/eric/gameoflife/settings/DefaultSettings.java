package eric.gameoflife.settings;

public class DefaultSettings {
	
	// The following must be from 0-8:
	public static final int LOW_BIRTH_THRESHOLD = 3;
	public static final int HIGH_BIRTH_THRESHOLD = 3;
	
	public static final int LOW_SURVIVAL_THRESHOLD = 2;
	public static final int HIGH_SURVIVAL_THRESHOLD = 3;
	
	// Must be from 20-1000
	public static final long ROUND_BREAK_TIME = 1000;
	
	// True or false (duh)
	public static final boolean IS_TORUS_MODE = false;
	
	public static final boolean IS_KMP_MODE = false;
}
