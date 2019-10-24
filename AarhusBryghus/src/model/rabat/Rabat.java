package model.rabat;

public class Rabat {

	private double rabatPris;
	private Rabat rabat;
	
	public Rabat() {
	}
	
	public void setRabat(Rabat rabat) {
		this.rabat = rabat;
	}
	
	public double tildelRabat(double pris) {
		return rabat.tildelRabat(pris);
	}
	
	
}
