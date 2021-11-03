package main.java.de.tk;

public class Reihe {
	boolean gibtsGewinner = false;
	Status gewinner;
	Feld feld1;
	Feld feld2;
	Feld feld3;
	
	public Reihe(Feld feld1, Feld feld2, Feld feld3) {
		this.feld1 = feld1;
		this.feld2 = feld2;
		this.feld3 = feld3;
	}
	
	public void ermittelGewinner() {
		if(feld1.status == feld2.status && feld1.status == feld3.status && feld1.status != Status.LEER) {
			gibtsGewinner = true;
			gewinner = feld1.status;
		}
	}
	public Status getGewinner() {
		return gewinner;
	}
	public boolean getGibtsGewinner() {
		return gibtsGewinner;
	}
	public void zuruecksetzen() {
		gibtsGewinner = false;
		gewinner = null;
	}
	
}

