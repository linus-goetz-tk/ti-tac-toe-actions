package main.java.de.tk;

public class Gui implements Ui{
	private String gewinner;
	private boolean unentschieden;

	@Override
	public void setGewinner(String gewinner) {
		this.gewinner = gewinner;
		
	}

	@Override
	public void setUnentschieden(boolean b) {
		unentschieden = b;
	}

	@Override
	public void spielModusWaehlen() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void zeichneSpielfeld(Feld[] felder, Status aktPlayer, boolean mitEinleitung) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void zeichneSpielfeld(Feld[] felder, Status aktPlayer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void zeichneHinweisFeldBelegt(int koordinate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void falscheEingabe(String eingabe) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String leseEingabe() {
		// TODO Auto-generated method stub
		return null;
	}

}
