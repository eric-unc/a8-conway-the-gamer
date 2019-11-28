package eric.gameoflife.model;

import java.util.HashMap;

public interface FieldChangeEvent {
	void onChange(FieldModel newField, HashMap<Integer, Integer> changedCoords); // x, y
}
