package model;

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
//		return Math.round(pris * 100.0) / 100.0;
		return Math.round(pris);

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

	
	@Override
	public String toString() {
		if(getProdukt().getProduktNavn().equals("") && !getProdukt().getKategori().equals("kulsyre")) {
			return getProdukt().getKategori() + "\t\t" + getPris() + "kr.";
		}else if(getProdukt().getKategori().equals("fustage") || getProdukt().getKategori().equals("kulsyre")) {
			return ((Tilbehør)getProdukt()).getKategori() + ", " + ((Tilbehør)getProdukt()).getProduktNavn() + ", " 
					+ ((Tilbehør)getProdukt()).getMængde() + ", " + ((Tilbehør)getProdukt()).getPant();
		}
		return getProdukt().getProduktNavn() + "\t\t" + getPris() + "kr.";
	}

	
	
}
