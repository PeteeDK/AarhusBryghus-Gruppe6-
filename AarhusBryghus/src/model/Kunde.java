package model;

public class Kunde {

	private String navn;
	private boolean studerende;
	
	public Kunde(String navn, boolean studerende) {
		this.navn = navn;
		this.studerende = studerende;
	}

	public String getNavn() {
		return navn;
	}

	public boolean isStuderende() {
		return studerende;
	}

	@Override
	public String toString() {
		return "Kunde [navn=" + navn + ", studerende=" + studerende + "]";
	}
	
	
}
