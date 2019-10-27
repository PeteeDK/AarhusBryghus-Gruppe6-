package model.produkter;

import model.Produkt;

public class Sampakninger extends Produkt {

	private int antalØl;
	private int antalGlas;
	
	public Sampakninger(String kategori, String produktNavn) {
		super(kategori, produktNavn);
		// TODO Auto-generated constructor stub
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
