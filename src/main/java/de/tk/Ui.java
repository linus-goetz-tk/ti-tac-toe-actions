package main.java.de.tk;

public interface Ui {
	public void setGewinner(String gewinner);
	public void setUnentschieden(boolean b);
	public void spielModusWaehlen();
	public void zeichneSpielfeld(Feld[] felder, Status aktPlayer, boolean mitEinleitung);
	public void zeichneSpielfeld(Feld[] felder, Status aktPlayer);
	public void zeichneHinweisFeldBelegt(int koordinate);
	public void falscheEingabe(String eingabe);
	public String leseEingabe();

}
