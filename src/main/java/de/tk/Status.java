/*--- (C) 1999-2021 Techniker Krankenkasse ---*/

package main.java.de.tk;

public enum Status {
	LEER, O, X;

	public String toString() {
		if(name() == "LEER") {
			return " ";
		}
		return name();
	}
}


/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
