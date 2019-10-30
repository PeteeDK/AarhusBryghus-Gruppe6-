package model.produkter;

import java.util.ArrayList;

import model.Produkt;

public class Sampakninger extends Produkt {

	private int antalØl;
	private int antalGlas;
	private boolean sampakningFyldt;
	private ArrayList<Produkt> indholdEnheder = new ArrayList<>();
	
	public Sampakninger(String kategori, String produktNavn, int antalGlas, int antalØl) {
		super(kategori, produktNavn);
		this.antalGlas = antalGlas;
		this.antalØl = antalØl;
		// TODO Auto-generated constructor stub
	}

	
	public int getAntalØl() {
		return antalØl;
	}

	public void setAntalØl(int antalØl) {
		if(antalØl < 0) {
			throw new IllegalArgumentException("Antal øl kan ikke være negativ");
		}
		this.antalØl = antalØl;
	}

	public int getAntalGlas() {
		return antalGlas;
	}

	public void setAntalGlas(int antalGlas) {
		if(antalGlas < 0) {
			throw new IllegalArgumentException();
		}
		this.antalGlas = antalGlas;
	}

	public void addIndhold(Produkt indhold) {
		if(indhold.getKategori().equals("flaske")) {
			antalØl--;
			indholdEnheder.add(indhold);
		}
		if(indhold.getKategori().equals("glas")) {
			antalGlas--;
			indholdEnheder.add(indhold);
		}
	}
	
	public boolean sampakningFyldt() {
		if(antalØl == 0 && antalGlas == 0) {
			return true;
		}
		return false;
	}
	
}
