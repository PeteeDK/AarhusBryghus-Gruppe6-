package model;

import java.time.DayOfWeek;

public class Sampakninger extends Produkt {

	private int antalØl;
	private int antalGlas;
	
	public Sampakninger(String kategori, String produktNavn, int antalØl, int antalGlas) {
		super(kategori, produktNavn);
		this.antalØl = antalØl;
		this.antalGlas = antalGlas;
	} 

	public int getAntalØl() {
		return antalØl;
	}

	public void setAntalØl(int antalØl) {
		this.antalØl = antalØl;
	}

	public int getAntalGlas() {
		return antalGlas;
	}

	public void setAntalGlas(int antalGlas) {
		this.antalGlas = antalGlas;
	}

}
