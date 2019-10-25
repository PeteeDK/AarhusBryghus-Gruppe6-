package model.rabat;

public class AftaltPrisRabat extends Rabat {

	private double fratrukketPris;
	
	public AftaltPrisRabat(double fratrukketPris) {
		this.fratrukketPris = fratrukketPris;
	}
	
	@Override
	public double tildelRabat(double pris) {
		return pris - this.fratrukketPris;
	}

	
	public double getFratrukketPris() {
		return fratrukketPris;
	}

	public void setFratrukketPris(double fratrukketPris) {
		this.fratrukketPris = fratrukketPris;
	} 
	
}
