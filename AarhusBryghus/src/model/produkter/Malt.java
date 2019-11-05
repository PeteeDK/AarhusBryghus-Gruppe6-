package model.produkter;

import model.Produkt;

public class Malt extends Produkt {

	private double mængde;
	
	public Malt(String kategori, String produktNavn) {
		super(kategori, produktNavn);
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
	
	 
}
