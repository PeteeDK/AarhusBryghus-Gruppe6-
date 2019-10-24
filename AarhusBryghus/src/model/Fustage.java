package model;

public class Fustage extends Produkt {

	private double liter;
	private double pant;
	
	//fustage har egentlig ikke et produktNavn, men der taget højde for det ved at angive produktnavn med
	//" ",  når varen registreres
	public Fustage(String kategori, String produktNavn, double liter, double pant) {
		super(kategori, produktNavn);
		this.liter = liter;
		this.pant = pant;
	}

	 
	public double getLiter() {
		return liter;
	}

	public void setLiter(double liter) {
		this.liter = liter;
	}

	public double getPant() {
		return pant;
	}


	public void setPant(double pant) {
		this.pant = pant;
	}
	
	
	
}
