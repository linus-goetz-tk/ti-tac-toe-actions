/*--- (C) 1999-2021 Techniker Krankenkasse ---*/

package main.java.de.tk;

public class Input {

	private String eingabe;

	public Input(String eingabe) {
		this.eingabe = eingabe;
	}

	public int convertKoordinate(String koordinate) {

		if (koordinate.equalsIgnoreCase("a1")) {
			return 0;
		} else if (koordinate.equalsIgnoreCase("a2")) {
			return 3;
		} else if (koordinate.equalsIgnoreCase("a3")) {
			return 6;
		} else if (koordinate.equalsIgnoreCase("b1")) {
			return 1;
		} else if (koordinate.equalsIgnoreCase("b2")) {
			return 4;
		} else if (koordinate.equalsIgnoreCase("b3")) {
			return 7;
		} else if (koordinate.equalsIgnoreCase("c1")) {
			return 2;
		} else if (koordinate.equalsIgnoreCase("c2")) {
			return 5;
		} else if (koordinate.equalsIgnoreCase("c3")) {
			return 8;
		}

		return 9;
	}

	public boolean isRestartCommand() {
		return ("R".equalsIgnoreCase(eingabe));
	}
	public boolean isExitCommand() {
		return ("S".equalsIgnoreCase(eingabe));
	}
	public boolean isZweispielerModusCommand() {
		return ("Z".equalsIgnoreCase(eingabe));
	}
	public boolean isComputerModusCommand() {
		return ("C".equalsIgnoreCase(eingabe));
	}

}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
