package model;

import java.util.ArrayList;

public class PrisListe {

	//TODO skal der være mulighed for at oprette andre priser
	private String arrangement;
	private ArrayList<Pris> priser = new ArrayList<>();
	
	public PrisListe(String arrangement) {
		this.setArrangement(arrangement);
	}

	public Pris createPris(Produkt produkt, double pris) {
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
<<<<<<< Updated upstream
=======

	@Override
	public String toString() {
		return "PrisListe [arrangement=" + arrangement + ", priser=" + priser + "]";
	}

	public ArrayList<Pris> getPriser() {
		
		return new ArrayList<>(priser);
	}
>>>>>>> Stashed changes
	
	
	
	
}
