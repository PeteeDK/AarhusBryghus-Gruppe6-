package model;

public class Pris {

	private double pris;
	private Produkt produkt;
	
	public Pris(Produkt produkt, double pris) {
		this.produkt = produkt;
		this.setPris(pris);
	}

	public double getPris() {
		return pris;
	}

	public void setPris(double pris) {
		this.pris = pris;
	}

	public Produkt getProdukt() {
		return produkt;
	}

	
	@Override
	public String toString() {
		return "Pris [pris=" + pris + ", produkt=" + produkt + "]";
	}

	
	
}
