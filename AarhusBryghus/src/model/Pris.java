package model;

public class Pris {

	private double pris;
	private Produkt produkt;
	
	public Pris(Produkt produkt, double pris) {
		if(produkt == null || pris < 0) {
			throw new IllegalArgumentException();
		}
		this.produkt = produkt;
		setPris(pris);
	}

	public double getPris() {
		return pris;
	}

	public void setPris(double pris) {
		if(pris < 0) {
			throw new IllegalArgumentException();
		}
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
