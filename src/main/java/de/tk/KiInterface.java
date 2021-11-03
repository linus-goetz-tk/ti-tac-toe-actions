package main.java.de.tk;

import java.util.List;

public interface KiInterface {

	//bekommt das aktuelle Spielfeld und gibt den besten zug für den Computer als integer von 0 bis 9 zurück.
	public int berechneZug(Feld[] felder);
}
