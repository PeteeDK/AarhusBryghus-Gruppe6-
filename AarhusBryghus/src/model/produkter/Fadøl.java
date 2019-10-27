package model.produkter;

import model.Produkt;

public class Fadøl extends Produkt {

	private double ølstørrelse;
	
	public Fadøl(String kategori, String produktNavn) {
		super(kategori, produktNavn);
		// TODO Auto-generated constructor stub
	}

	public double getØlstørrelse() {
		return ølstørrelse;
	}

	public void setØlstørrelse(double ølstørrelse) {
		this.ølstørrelse = ølstørrelse;
	}
	
}
