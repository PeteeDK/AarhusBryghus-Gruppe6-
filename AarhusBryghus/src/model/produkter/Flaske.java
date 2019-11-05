package model.produkter;

import model.Produkt;

public class Flaske extends Produkt {

	private double flaskeStørrelse;
	
	public Flaske(String kategori, String produktNavn) {
		super(kategori, produktNavn);
	}

	public double getFlaskeStørrelse() {
		return flaskeStørrelse;
	}

	public void setFlaskeStørrelse(double flaskeStørrelse) {
		if(flaskeStørrelse < 0) {
			throw new IllegalArgumentException("Flaskestørrelsen kan ikke være negativ");
		}
		this.flaskeStørrelse = flaskeStørrelse;
	}

	
}
 