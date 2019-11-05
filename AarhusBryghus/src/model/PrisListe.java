package model;

import java.util.ArrayList;

/**
 * Objekter af klassen PrisListe, står for at oprette objekter af klassen Pris og gemme den i listen priser. 
 * Som beskrevet i klassen Pris kan et objekt af klassen Produkt blive tilknyttet flere priser. Ved at selektere 
 * på PrisListe kan man tilgå den ønskede pris man ønsker til det pågældende objekt af klassen Produkt.
 * @author Erik Kato Ipsen
 *
 */

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
	
	public ArrayList<Pris> getPriser(){
		return new ArrayList<>(priser);
	}
	
	
}
