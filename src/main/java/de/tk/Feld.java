package main.java.de.tk;

public class Feld {
	//int koordinate;
	public Status status;

	public Feld(Status status) {
		this.status = status;
	}
	public Feld() {
		status = Status.LEER;
	}

}
