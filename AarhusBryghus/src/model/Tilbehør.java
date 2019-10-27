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
		if(mængde < 0) {
			throw new IllegalArgumentException();
		}
		this.mængde = mængde;
	}

	public double getPant() {
		return pant;
	}

	public void setPant(double pant) {
		if(pant < 0) {
			throw new IllegalArgumentException();
		}
		this.pant = pant;
	}


	
	
	
}
