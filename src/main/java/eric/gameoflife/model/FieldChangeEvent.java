package eric.gameoflife.model;

import java.util.ArrayList;

import eric.gameoflife.Coordinate;

public interface FieldChangeEvent {
	void onChange(FieldModel newField, ArrayList<Coordinate> changedCoords); // x, y
}
