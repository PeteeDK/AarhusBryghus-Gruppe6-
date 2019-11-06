package model;

/**
 * Objekter af klassen Pris oprettes af objekter af klassen PrisListe, og gemmes i en liste i det pågældende objekt
 * af PrisListe. Klassen Pris knytter et objekt af klassen Produkt til en pris. På den måde kan man tilknytte flere 
 * priser til det samme objekt af Produkt. 
 * @author Erik Kato Ipsen
 *
 */

public class Pris {

	private double pris;
	private Produkt produkt;
	 
	public Pris(Produkt produkt, double pris) {
		if(produkt == null || pris < 0) {
			throw new IllegalArgumentException("Produktet kan ikke være null eller prisen kan ikke være negativ");
		}
		this.produkt = produkt;
		this.pris = pris; 
	}

	public double getPris() {
		//display only two decimals
		return Math.round(pris * 100.0) / 100.0;
	}
 
	public void setPris(double pris) {
		if(pris < 0) {
			throw new IllegalArgumentException("prisen kan ikke være negativ");
		}
		this.pris = pris;
	}

	public Produkt getProdukt() {
		return produkt;
	}

	
	/**
	 * TODO Find ud af hvordan jeg beskriver de forskellige situationer der knytter sig til denne. 
	 * Metoden er ikke færdig endnu.
	 */
	@Override
	public String toString() {
		if(getProdukt().getProduktNavn().equals("") && !getProdukt().getKategori().equals("kulsyre")) {
			return getProdukt().getKategori() + "\t\t" + getPris() + "kr.";
		}else if(getProdukt().getKategori().equals("fustage")) {
			return "Kategori: " + ((Tilbehør)getProdukt()).getKategori() + ", produkt: " + ((Tilbehør)getProdukt()).getProduktNavn() + ", " 
					+ ", mængde: " + ((Tilbehør)getProdukt()).getMængde() + ", pant: " + ((Tilbehør)getProdukt()).getPant();
		}else if(getProdukt().getKategori().equals("kulsyre")) {
			return "Kategori: " + ((Tilbehør)getProdukt()).getKategori() + ", mængde: " + ((Tilbehør)getProdukt()).getMængde() + ", pant: "
					+ ((Tilbehør)getProdukt()).getPant();
		}
		return getProdukt().getProduktNavn() + "\t\t" + getPris() + "kr.";
	}

	
	
}
