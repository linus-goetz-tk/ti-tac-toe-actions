/*--- (C) 1999-2021 Techniker Krankenkasse ---*/

package main.java.de.tk;

import java.util.Scanner;

public class ConsolenUi implements Ui{
	Scanner sc = new Scanner(System.in);
	private String gewinner;
	private boolean unentschieden;

	@Override
	public void zeichneSpielfeld(Feld[] felder, Status aktPlayer) {
		zeichneSpielfeld(felder, aktPlayer, false);
	}

	@Override
	public void zeichneSpielfeld(Feld[] felder, Status aktPlayer, boolean mitEinleitung) {
		if (mitEinleitung) {
			System.out.println("Tic Tac Toe");
			System.out.println("Um eine Markierung zu setzen gebe die Koordinate an");
			System.out.println("r zum Zurücksetzen des Feldes");
			System.out.println(" ");
		}

		System.out.println("Spieler: " + aktPlayer.toString());
		System.out.println("  A   B   C");
		System.out.println("1 " + felder[0].status + " | " + felder[1].status + " | " + felder[2].status);
		System.out.println("  --+---+--");
		System.out.println("2 " + felder[3].status + " | " + felder[4].status + " | " + felder[5].status);
		System.out.println("  --+---+--");
		System.out.println("3 " + felder[6].status + " | " + felder[7].status + " | " + felder[8].status);

		if (gewinner != null) {
			System.out.println("Player " + gewinner + " hat gewonnen!");
			System.out.println("r zum Neustarten.");
			System.out.println("s zum Schliessen.");
		} else if(unentschieden){
			System.out.println("Unentschieden! ");
			System.out.println("r zum Neustarten.");
			System.out.println("s zum Schliessen.");
		}else {
			System.out.println("Bitte Koordinate angeben: ");
		}
	}

	@Override
	public void zeichneHinweisFeldBelegt(int koordinate) {
		System.out.println("Feld "+koordinate+" schon belegt.");
		System.out.println("Bitte Koordinate eingeben: ");
	}

	@Override
	public String leseEingabe() {
		return sc.next();
	}

	@Override
	public void setGewinner(String gewinner) {
		this.gewinner = gewinner;
	}

	@Override
	public void setUnentschieden(boolean b) {
		unentschieden = b;
		
	}

	@Override
	public void falscheEingabe(String eingabe) {
		System.out.println(eingabe + " ist keine bekannte Eingabe.");
		System.out.println("Bitte gebe eine Koordinate ein.");
		
	}

	@Override
	public void spielModusWaehlen() {
		System.out.println("C gegen den Computer");
		System.out.println("Z Zweipieler-Modus");
		System.out.println("");
		
	}


}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
