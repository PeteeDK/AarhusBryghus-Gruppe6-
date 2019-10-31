package model.produkter;

import java.util.ArrayList;

import model.Produkt;

public class Sampakninger extends Produkt {

	private int antalØl;
	private int antalGlas;
	private boolean sampakningFyldt;
	private ArrayList<Produkt> indholdEnheder = new ArrayList<>();
	private int indholdstæller;
	
	public Sampakninger(String kategori, String produktNavn, int antalØl, int antalGlas) {
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
		if(indhold.getKategori().equals("flaske") && antalØl > 0) {
			antalØl--;
			indholdstæller++;
			indholdEnheder.add(indhold);
		}else if(indhold.getKategori().equals("glas") && antalGlas > 0) {
			antalGlas--;
			indholdstæller++;
			indholdEnheder.add(indhold);
		}
	}
	
	
	public boolean isSampakningFyldt() {
		if(antalØl == 0 && antalGlas == 0 && indholdEnheder.size() == indholdstæller) {
			return true;
		}
		return false;
	}
	
	public void removeIndhold(Produkt produkt) {
		if(indholdEnheder.contains(produkt)) {
			if(produkt.getKategori().equals("flaske")) {
				antalØl++;
				indholdstæller--;
				indholdEnheder.remove(produkt);
			}else if(produkt.getKategori().equals("glas")) {
				antalGlas++;
				indholdstæller--;
				indholdEnheder.remove(produkt);
			}
		}
	}
	
	public ArrayList<Produkt> getIndholdEnheder(){
		return new ArrayList<>(indholdEnheder);
	}
	
}
