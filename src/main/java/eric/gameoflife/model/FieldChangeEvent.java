package eric.gameoflife.model;

import java.util.ArrayList;

public interface FieldChangeEvent {
	void onChange(FieldModel newField, ArrayList<Coordinate> changedCoords); // x, y
}
