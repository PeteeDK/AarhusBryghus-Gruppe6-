package model.rabat;

public class AftaltPrisRabat extends Rabat {

	private double fratrukketPris;
	
	public AftaltPrisRabat(double fratrukketPris) {
		this.fratrukketPris = fratrukketPris;
	}
	
	@Override
	public double tildelRabat(double pris) {
		if(pris < fratrukketPris) {
			throw new IllegalArgumentException("Fratrukket pris kan ikke overstige prisen på bestillingen");
		}
		return pris - fratrukketPris;
	}

	
	public double getFratrukketPris() {
		return fratrukketPris;
	}

	public void setFratrukketPris(double fratrukketPris) {
		this.fratrukketPris = fratrukketPris;
	} 
	
}
