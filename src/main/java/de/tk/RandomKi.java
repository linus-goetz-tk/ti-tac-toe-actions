package main.java.de.tk;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomKi implements KiInterface{
	Random random = new Random();
	private List<Integer> freieFelder = new ArrayList<>();
	
	public void KI() {

	}
	@Override
	public int berechneZug(Feld[] felder) {
		aktFreieFelder(felder);
		return freieFelder.get(random.nextInt(freieFelder.size()));
	}

	public void aktFreieFelder(Feld[] felder) {
		freieFelder.clear();
		for (int i = 0; i < felder.length; i++) {
			if (felder[i].status == Status.LEER) {
				freieFelder.add(i);
			}
		}
	}

}
