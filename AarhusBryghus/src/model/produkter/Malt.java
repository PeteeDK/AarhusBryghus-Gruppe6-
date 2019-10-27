package model.produkter;

import model.Produkt;

public class Malt extends Produkt {

	private double mængde;
	
	public Malt(String kategori, String produktNavn) {
		super(kategori, produktNavn);
		// TODO Auto-generated constructor stub
	}

	public double getMængde() {
		return mængde;
	}

	public void setMængde(double mængde) {
		this.mængde = mængde;
	}
	
}
