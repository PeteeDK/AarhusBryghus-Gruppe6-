package model;

import java.util.ArrayList;

public class PrisListe {

	private String arrangement;
	private ArrayList<Pris> priser = new ArrayList<>();
	
	public PrisListe(String arrangement) {
		this.setArrangement(arrangement);
	}

	public Pris createPris(Produkt produkt, double pris) {
		if(produkt == null || pris < 0) {
			throw new IllegalArgumentException("Produktet kan ikke være null eller prisen kan ikke være negativ");
		}
		Pris p = new Pris(produkt,pris);
		priser.add(p);
		return p;
	}

	public String getArrangement() {
		return arrangement;
	}

	public void setArrangement(String arrangement) {
		this.arrangement = arrangement;
	}
	
	
	
	
}
