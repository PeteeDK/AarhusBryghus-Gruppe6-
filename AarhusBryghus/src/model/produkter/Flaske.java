package model.produkter;

import model.Produkt;

public class Flaske extends Produkt {

	private double flaskeStørrelse;
	
	public Flaske(String kategori, String produktNavn) {
		super(kategori, produktNavn);
		// TODO Auto-generated constructor stub
	}

	public double getFlaskeStørrelse() {
		return flaskeStørrelse;
	}

	public void setFlaskeStørrelse(double flaskeStørrelse) {
		this.flaskeStørrelse = flaskeStørrelse;
	}

	
}
