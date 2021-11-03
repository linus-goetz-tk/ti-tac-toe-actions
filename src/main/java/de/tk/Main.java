/*--- (C) 1999-2021 Techniker Krankenkasse ---*/

package main.java.de.tk;

public class Main {

	public static void main(String[] args) {
		Ui ui = new ConsolenUi();
		KiInterface ki = new MiniMaxKi();
		Brain b = new Brain(ui, ki);

		b.startGame();
	}

}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
