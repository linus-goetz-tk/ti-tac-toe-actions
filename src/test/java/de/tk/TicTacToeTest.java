package test.java.de.tk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import main.java.de.tk.ConsolenUi;
import main.java.de.tk.MiniMaxKi;
import main.java.de.tk.RandomKi;
import main.java.de.tk.Brain;
import main.java.de.tk.Status;
import main.java.de.tk.Feld;

class TicTacToeTest {
	ConsolenUi ui = new ConsolenUi();
	RandomKi ki = new RandomKi();
	MiniMaxKi minimaxki = new MiniMaxKi();
	Brain b = new Brain(ui, ki);


	@Test
	void testFeldVollFalse() {
		b.feld0.status = Status.LEER;
		b.feld1.status = Status.X;
		b.feld2.status = Status.X;
		b.feld3.status = Status.O;
		b.feld4.status = Status.LEER;
		b.feld5.status = Status.O;
		b.feld6.status = Status.O;
		b.feld7.status = Status.X;
		b.feld8.status = Status.LEER;
		assertEquals(false, (b.feldVoll()));
	}
	@Test
	void testFeldVollTrue() {
		b.feld0.status = Status.X;
		b.feld1.status = Status.O;
		b.feld2.status = Status.X;
		b.feld3.status = Status.O;
		b.feld4.status = Status.X;
		b.feld5.status = Status.O;
		b.feld6.status = Status.O;
		b.feld7.status = Status.X;
		b.feld8.status = Status.O;		
		assertEquals(true, (b.feldVoll()));
	}
	@Test
	void testErmittelGewinner1() {

		assertEquals(Status.LEER, b.ermittelGewinner());
	}
	@Test
	void testErmittelGewinner2() {
		b.feld0.status = Status.X;
		b.feld1.status = Status.O;
		b.feld2.status = Status.O;
		b.feld3.status = Status.X;
		b.feld4.status = Status.X;
		b.feld5.status = Status.O;
		b.feld6.status = Status.X;
		b.feld7.status = Status.O;
		b.feld8.status = Status.O;
		assertEquals(Status.X, b.ermittelGewinner());
	}
	@Test
	void testErmittelGewinner3() {
		b.feld0.status = Status.O;
		b.feld1.status = Status.O;
		b.feld2.status = Status.O;
		b.feld3.status = Status.X;
		b.feld4.status = Status.X;
		b.feld5.status = Status.O;
		b.feld6.status = Status.X;
		b.feld7.status = Status.O;
		b.feld8.status = Status.O;
		assertEquals(Status.O, b.ermittelGewinner());
	}
	/*
	@Test
	void testFeldZurücksetzen() {
		b.feldZuruecksetzen();
		boolean allesLeer = true;
		for (Feld feld : felder) {
			if(feld.status != Status.LEER) {
				allesLeer = false;
			}
		}
		assertEquals(true, allesLeer);
	}
	*/

	@Test
	void testBewerten1() {
		Feld[] felder = new Feld[9];
		for (int i = 0; i < felder.length; i++) {
			Feld aFeld = new Feld();
			felder[i] = aFeld;
		}
		felder[0].status = Status.O;
		felder[1].status = Status.X;
		felder[2].status = Status.LEER;
		felder[3].status = Status.O;
		felder[4].status = Status.O;
		felder[5].status = Status.X;
		felder[6].status = Status.O;
		felder[7].status = Status.X;
		felder[8].status = Status.X;
		
		assertEquals(1, minimaxki.bewerten(Status.O, felder));
	}
	@Test
	void testBewerten2() {
		Feld[] felder = new Feld[9];
		for (int i = 0; i < felder.length; i++) {
			Feld aFeld = new Feld();
			felder[i] = aFeld;
		}
		felder[0].status = Status.O;
		felder[1].status = Status.X;
		felder[2].status = Status.LEER;
		felder[3].status = Status.X;
		felder[4].status = Status.O;
		felder[5].status = Status.X;
		felder[6].status = Status.O;
		felder[7].status = Status.X;
		felder[8].status = Status.X;
		
		assertEquals(0, minimaxki.bewerten(Status.O, felder));
	}
	@Test
	void testBewerten3() {
		Feld[] felder = new Feld[9];
		for (int i = 0; i < felder.length; i++) {
			Feld aFeld = new Feld();
			felder[i] = aFeld;
		}
		felder[0].status = Status.O;
		felder[1].status = Status.X;
		felder[2].status = Status.LEER;
		felder[3].status = Status.O;
		felder[4].status = Status.X;
		felder[5].status = Status.X;
		felder[6].status = Status.LEER;
		felder[7].status = Status.X;
		felder[8].status = Status.O;
		
		assertEquals(-1, minimaxki.bewerten(Status.O, felder));
	}
}
