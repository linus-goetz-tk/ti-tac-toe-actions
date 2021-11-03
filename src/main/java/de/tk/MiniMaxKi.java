package main.java.de.tk;

import java.util.ArrayList;
import java.util.List;

public class MiniMaxKi implements KiInterface {
	int counter = 0;
	private Status kiSymbol = Status.O;
	int gespeicherterZug = 0;
	int gewuenschteTiefe = 9;
	int gespeicherterZugWert = -110;

	@Override
	public int berechneZug(Feld[] felder1) {
		int bewertung = max(kiSymbol, gewuenschteTiefe, felder1);
		//System.out.println(counter);
		System.out.println(gespeicherterZug);
		gespeicherterZugWert = -101;
		counter = 0;
		return gespeicherterZug;

	}

	public int max(Status player, int tiefe, Feld[] aktSpielFeld) {
		counter++;
		int bewertung = bewerten(player, aktSpielFeld);
		if (tiefe <= 0 || keineZuegeMehr(aktSpielFeld)) {
			return bewertung;
		}
		List<Integer> aktFreieFelder = aktFreieFelder(aktSpielFeld);
		int maxWert = -100;
		for (int i = 0; i < aktFreieFelder.size(); i++) {
			int point = aktFreieFelder.get(i);
			aktSpielFeld[point].status = player;
			int wert = min(otherPlayer(player), tiefe - 1, aktSpielFeld);
			aktSpielFeld[point].status = Status.LEER;
			if (tiefe == gewuenschteTiefe) {
				//System.out.println("Zug: " + point + " wert: " + wert + " maxWert: " + maxWert);
			}
			if (wert >= maxWert) {
				maxWert = wert;
				if (tiefe == gewuenschteTiefe) {
					gespeicherterZugWert = maxWert;
					gespeicherterZug = point;
				}
			}

		}
		return maxWert;
	}

	public int min(Status player, int tiefe, Feld[] aktSpielFeld) {
		int bewertung = bewerten(player, aktSpielFeld);
		if (tiefe <= 0 || keineZuegeMehr(aktSpielFeld)) {
			return bewertung;
		}
		List<Integer> aktFreieFelder = aktFreieFelder(aktSpielFeld);
		int minWert = 100;
		for (int i = 0; i < aktFreieFelder.size(); i++) {
			aktSpielFeld[aktFreieFelder.get(i)].status = player;
			int wert = max(otherPlayer(player), tiefe - 1, aktSpielFeld);
			aktSpielFeld[aktFreieFelder.get(i)].status = Status.LEER;
			if (wert <= minWert) {
				minWert = wert;
			}

		}
		return minWert;
	}

	public void kiZuruecksetzten() {
		gespeicherterZug = 0;
		gespeicherterZugWert = -101;
		counter = 0;
	}

	private void macheZugRueckgaengig(int zug, Feld[] felder) {
		felder[zug].status = Status.LEER;
	}

	private void fuehreZugAus(int feld, Feld[] felder, Status player) {
		felder[feld].status = player;

	}

	public int bewerten(Status player, Feld[] felder) {
		// List<Reihe> reihen = new ArrayList<>();

		if (felder[0].status == felder[1].status && felder[0].status == felder[2].status
				&& felder[0].status != Status.LEER) {
			if (felder[0].status == player) {
				return 1;
			} else {
				return -1;
			}
		} else if (felder[3].status == felder[4].status && felder[3].status == felder[5].status
				&& felder[3].status != Status.LEER) {
			if (felder[3].status == player) {
				return 1;
			} else {
				return -1;
			}
		} else if (felder[6].status == felder[7].status && felder[6].status == felder[8].status
				&& felder[6].status != Status.LEER) {
			if (felder[6].status == player) {
				return 1;
			} else {
				return -1;
			}
		} else if (felder[0].status == felder[3].status && felder[0].status == felder[6].status
				&& felder[0].status != Status.LEER) {
			if (felder[0].status == player) {
				return 1;
			} else {
				return -1;
			}
		} else if (felder[1].status == felder[4].status && felder[1].status == felder[7].status
				&& felder[1].status != Status.LEER) {
			if (felder[1].status == player) {
				return 1;
			} else {
				return -1;
			}
		} else if (felder[2].status == felder[5].status && felder[2].status == felder[8].status
				&& felder[2].status != Status.LEER) {
			if (felder[2].status == player) {
				return 1;
			} else {
				return -1;
			}
		} else if (felder[0].status == felder[4].status && felder[0].status == felder[8].status
				&& felder[0].status != Status.LEER) {
			if (felder[0].status == player) {
				return 1;
			} else {
				return -1;
			}
		} else if (felder[2].status == felder[4].status && felder[2].status == felder[6].status
				&& felder[2].status != Status.LEER) {
			if (felder[2].status == player) {
				return 1;
			} else {
				return -1;
			}
		}
		return 0;
	}

	public List<Integer> aktFreieFelder(Feld[] felder) {
		List<Integer> freieFelder = new ArrayList<Integer>();
		for (int i = 0; i < felder.length; i++) {
			if (felder[i].status == Status.LEER) {
				freieFelder.add(i);
			}
		}
		return freieFelder;
	}

	public boolean keineZuegeMehr(Feld[] felder) {
		for (Feld feld : felder) {
			if (feld.status == Status.LEER) {
				return false;
			}
		}
		return true;
	}

	public Status otherPlayer(Status player) {
		if (player == Status.O) {
			return Status.X;
		} else {
			return Status.O;
		}
	}

	public void printListe(Feld[] felder) {
		String ausgabe = "";
		for (Feld feld : felder) {
			ausgabe = ausgabe + feld.status;
		}
		System.out.println(ausgabe);
	}
	public boolean checkForWin(Feld[] felder) {
		if(bewerten(Status.X, felder) == 0) {
			return false;
		}
		return true;
	}
}

