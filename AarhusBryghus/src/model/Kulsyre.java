package model;

import java.time.DayOfWeek;

public class Kulsyre extends Produkt {

	private double kg;
	private double pant;
	
	public Kulsyre(String kategori, String produktNavn, double kg, double pant) {
		super(kategori, produktNavn);
		this.kg = kg;
		this.pant = pant;
	}

	
	public double getKg() {
		return kg;
	}

	public double getPant() {
		return pant;
	}

	public void setPant(double pant) {
		this.pant = pant;
	}

	public void setKg(double kg) {
		this.kg = kg;
	}
	
}
