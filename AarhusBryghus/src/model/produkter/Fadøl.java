package model.produkter;

import model.Produkt;

public class Fadøl extends Produkt {

	private double ølstørrelse;
	
	public Fadøl(String kategori, String produktNavn) {
		super(kategori, produktNavn);
	}

	public double getØlstørrelse() {
		return ølstørrelse;
	}
 
	public void setØlstørrelse(double ølstørrelse) {
		if(ølstørrelse < 0) {
			throw new IllegalArgumentException("Ølstørrelsen kan ikke være negativ");
		}
		this.ølstørrelse = ølstørrelse;
	} 
	
}
