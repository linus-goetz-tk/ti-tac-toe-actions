package main.java.de.tk;

import java.util.List;

public interface KiInterface {

	//bekommt das aktuelle Spielfeld und gibt den besten zug f�r den Computer als integer von 0 bis 9 zur�ck.
	public int berechneZug(Feld[] felder);
}
