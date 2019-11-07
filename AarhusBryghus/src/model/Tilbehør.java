package model;

/**
 * Klasserne der udgør hhv. produktkategorierne for fustage og kulsyre nedarver fra klassen Tilbehør. Denne klasse
 * adskiller sig fra de andre sub-klasser til super-klassen Produkt, at den tilføjer 2 ekstra attributter til 
 * sub-klasserne, der nedarver fra denne: mængde og pant. I oplægget kan pant for hhv. fustage og kulsyre kun være
 * 200 og 1000. Hvis der senere bliver behov for at oprette objekter af sub-klasserne til Tilbehør med andre værdier
 * for pant, kan man evt. udvide klassen med en ekstra constructor, der tager pant som argument.
 * @author Erik Kato Ipsen
 *
 */

public class Tilbehør extends Produkt {

	private double mængde;
	private double pant;
	
	public Tilbehør(String kategori, String produktNavn, double mængde) {
		super(kategori, produktNavn);
		setMængde(mængde);
		if(kategori.equals("fustage")) {
			pant = 200;	
		}else if(kategori.equals("kulsyre")) {
			pant = 1000; 
		}
	} 
 
	public double getMængde() {
		return mængde;
	}

	public void setMængde(double mængde) {
		if(mængde < 0) {
			throw new IllegalArgumentException("Mængden kan ikke være negativ");
		}
		this.mængde = mængde;
	}

	public double getPant() {
		return pant;
	}

	public void setPant(double pant) {
		if(pant < 0) {
			throw new IllegalArgumentException("Panten kan ikke være negativ");
		}
		this.pant = pant;
	}

	@Override
	public String toString() {
		return "Kategori: " + getKategori() + ", produkt: " + getProduktNavn() + ", " + ", mængde: " + mængde + ", pant: " + pant;
	}
 
 		
	
}
