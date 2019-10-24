package model;

public class Tilbehør extends Produkt {

	private double mængde;
	private double pant;
	
	public Tilbehør(String kategori, String produktNavn, double mængde, double pant) {
		super(kategori, produktNavn);
		this.mængde = mængde;
		this.pant = pant;
	}

	public double getMængde() {
		return mængde;
	}

	public void setMængde(double mængde) {
		this.mængde = mængde;
	}

	public double getPant() {
		return pant;
	}

	public void setPant(double pant) {
		this.pant = pant;
	}


	
	
	
}
