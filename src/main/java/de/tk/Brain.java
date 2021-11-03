/*--- (C) 1999-2021 Techniker Krankenkasse ---*/

package main.java.de.tk;

import java.util.ArrayList;
import java.util.List;

public class Brain {
	private boolean kiAlsGegner = false;
	private Status kiSymbol = Status.O;
	private Status aktPlayer = Status.X;
	private List<Reihe> reihen = new ArrayList<>();
	public Feld feld0 = new Feld();
	public Feld feld1 = new Feld();
	public Feld feld2 = new Feld();
	public Feld feld3 = new Feld();
	public Feld feld4 = new Feld();
	public Feld feld5 = new Feld();
	public Feld feld6 = new Feld();
	public Feld feld7 = new Feld();
	public Feld feld8 = new Feld();
	Reihe zeile1 = new Reihe(feld0, feld1, feld2);
	Reihe zeile2 = new Reihe(feld3, feld4, feld5);
	Reihe zeile3 = new Reihe(feld6, feld7, feld8);
	Reihe spalte1 = new Reihe(feld0, feld3, feld6);
	Reihe spalte2 = new Reihe(feld1, feld4, feld7);
	Reihe spalte3 = new Reihe(feld2, feld5, feld8);
	Reihe diagonale1 = new Reihe(feld0, feld4, feld8);
	Reihe diagonale2 = new Reihe(feld2, feld4, feld6);
	private Feld[] felder = { feld0, feld1, feld2, feld3, feld4, feld5, feld6, feld7, feld8 };
	private Ui ui;
	private KiInterface ki;

	public Brain(Ui ui, KiInterface ki) {
		this.ui = ui;
		this.ki = ki;
		reihen.add(zeile1);
		reihen.add(zeile2);
		reihen.add(zeile3);
		reihen.add(spalte1);
		reihen.add(spalte2);
		reihen.add(spalte3);
		reihen.add(diagonale1);
		reihen.add(diagonale2);
	}

	public void startGame() {
		feldZuruecksetzen();
		reihenZuruecksetzen();
		ui.setGewinner(null);
		ui.setUnentschieden(false);
		ui.spielModusWaehlen();
		eingabeVerarbeitung(false);
		ui.zeichneSpielfeld(felder, aktPlayer, true);
		eingabeVerarbeitung(true);
	}

	public void eingabeVerarbeitung(boolean neuerZug) {
		String eingabe;
		if (kiAlsGegner && kiSymbol == aktPlayer && neuerZug) {
			einZug(ki.berechneZug(felder));
		} else {
			eingabe = ui.leseEingabe();
			Input inputConverter = new Input(eingabe);
			if (inputConverter.isRestartCommand()) {
				startGame();
			} else if (inputConverter.isExitCommand()) {
				System.exit(0);
			} else if (inputConverter.isComputerModusCommand()) {
				kiAlsGegner = true;
			} else if (inputConverter.isZweispielerModusCommand()) {
				kiAlsGegner = false;
			} else if (neuerZug) {
				int koordinate = inputConverter.convertKoordinate(eingabe);
				if (koordinate == 9) {
					ui.falscheEingabe(eingabe);
					eingabeVerarbeitung(neuerZug);
				} else {
					einZug(koordinate);
				}
			}
		}

	}

	public void einZug(int koordinate) {
		Status gewinner = Status.LEER;

		// setzt markierung wenn möglich, sonst:
		if (markierenMoeglich(koordinate)) {
			setzeMarkierung(koordinate);
			gewinner = ermittelGewinner();

			// hatt jemand gewonnen?
			if (gewinner != Status.LEER) {
				ui.setGewinner(gewinner.toString());
				ui.zeichneSpielfeld(getFelder(), aktPlayer);
				for (Feld feld : felder) {
					System.out.println(feld.status);
				}
				eingabeVerarbeitung(false);
				// sind alle felder belegt? -> unentschieden
			} else if (feldVoll()) {
				System.out.println("Feld voll");
				ui.setUnentschieden(true);
				ui.zeichneSpielfeld(getFelder(), aktPlayer);
				eingabeVerarbeitung(false);
				// nächster zug
			} else if (gewinner == Status.LEER) {
				ui.zeichneSpielfeld(getFelder(), aktPlayer);
				eingabeVerarbeitung(true);
			}

		} else {
			ui.zeichneHinweisFeldBelegt(koordinate);
			eingabeVerarbeitung(true);
		}

	}

	public void setzeMarkierung(int koordinate) {
		felder[koordinate].status = aktPlayer;
		switchPlayer();
	}

	public boolean markierenMoeglich(int koordinate) {
		if (felder[koordinate].status == Status.LEER) {
			return true;
		} else {
			return false;
		}
	}

	public void switchPlayer() {
		if (aktPlayer == Status.X) {
			aktPlayer = Status.O;
		} else {
			aktPlayer = Status.X;
		}
	}

	public Status getAktPlayer() {
		return aktPlayer;
	}

	public Feld[] getFelder() {
		return felder;
	}

	public Status ermittelGewinner() {
		for (Reihe i : reihen) {
			i.ermittelGewinner();
			if (i.getGibtsGewinner()) {
				return i.getGewinner();
			}
		}
		return Status.LEER;
	}

	public boolean feldVoll() {
		for (Feld feld : felder) {
			if (feld.status == Status.LEER) {
				return false;
			}
		}
		return true;
	}

	public void feldZuruecksetzen() {
		for (int i = 0; i < felder.length; i++) {
			felder[i].status = Status.LEER;
		}
	}

	public void reihenZuruecksetzen() {
		for (Reihe reihe : reihen) {
			reihe.zuruecksetzen();
		}
	}

	public void setFelder(Feld[] felder) {
		this.felder = felder;
	}

}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
