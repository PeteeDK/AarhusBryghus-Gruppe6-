package model.produkter;

import java.util.ArrayList;

import model.Produkt;

/**
 * Klassen Sampakninger benytter sig af composite pattern til at tilføje objekter af klasser der er eller nedarver fra
 * super-klassen Produkt som den gemmer i listen indholsEnheder. Der selekteres dog på, at det kun er objekter som har
 * angivet attributten "kategori" til enten flaske eller glas, der kan tilføjes til listen. Derudover anvendes objekternes
 * attributter ikke yderligere. 
 * @author Erik Kato Ipsen
 *
 */

public class Sampakninger extends Produkt {

	private int antalØl;
	private int antalGlas;
	private boolean sampakningFyldt;
	private ArrayList<Produkt> indholdsEnheder = new ArrayList<>();
	
	public Sampakninger(String kategori, String produktNavn, int antalØl, int antalGlas) {
		super(kategori, produktNavn);
		setAntalGlas(antalGlas);
		setAntalØl(antalØl);
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

	/**
	 * Attributterne "antalØl" og "antalGlas" tæller ned for hver gang, der tilføjes et objekt med kategorien 
	 * flaske eller glas. Når begge attributter er 0 opdateres attributten sampakningFyldt til true.
	 * @param objekter af klasser fra eller af Super-klassen Produkt
	 */
	public void addIndhold(Produkt indhold) {
		if(indhold.getKategori().equals("flaske") && antalØl > 0) {
			antalØl--;
			indholdsEnheder.add(indhold);
		}else if(indhold.getKategori().equals("glas") && antalGlas > 0) {
			antalGlas--;
			indholdsEnheder.add(indhold);
		}
	}
	
	
	public boolean isSampakningFyldt() {
		if(antalØl == 0 && antalGlas == 0) {
			sampakningFyldt = true;
		}else {
			sampakningFyldt = false;
		}
		return sampakningFyldt;
	}
	
	/**
	 * Hvis der fjernes objekter af klasser med super-klassen produkt, hvor attributten er angivet flaske eller glas
	 * optælles hhv. antalØl og antalGlas
	 * @param produkt objekt af klasser med super-klassen produkt.
	 */
	public void removeIndhold(Produkt produkt) {
		if(indholdsEnheder.contains(produkt)) {
			if(produkt.getKategori().equals("flaske")) {
				antalØl++;
				indholdsEnheder.remove(produkt);
			}else if(produkt.getKategori().equals("glas")) {
				antalGlas++;
				indholdsEnheder.remove(produkt);
			}
		}
	}
	
	public ArrayList<Produkt> getIndholdEnheder(){
		return new ArrayList<>(indholdsEnheder);
	}
	
}
