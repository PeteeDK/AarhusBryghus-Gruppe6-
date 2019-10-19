package nyArkitektur;

import java.util.ArrayList;

import kasseret.Produktgruppe;

public class Salg {

	private int id;
	private double samletPris;
	private ArrayList<Produkt> produkter = new ArrayList<>();
	private Salgssituation salgssituation;
	private Betalingsform betalingsform;
	
	public Salg(int id) {
		this.id = id;
	}
	
	public double beregnSamletPris() {

		for(Produkt p : produkter) {
			samletPris += p.getPris();
		}
		return samletPris;
	} 
	
	
	
	public double getSamletPris() {
		return samletPris;
	}
	
	public void addProdukt(Produkt p) {
		produkter.add(p);
	}
	
}
