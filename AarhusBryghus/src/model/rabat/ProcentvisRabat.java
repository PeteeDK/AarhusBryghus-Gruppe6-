package model.rabat;

public class ProcentvisRabat extends Rabat {

	private double procent;
	
	
	public ProcentvisRabat(double procent) {
		this.procent = procent;
	}
	
	public double tildelRabat(double pris) {
		return pris - pris * (procent/100.0);
	}
	
	
	public double getProcent() {
		return procent;
	}

	public void setProcent(double procent) {
		this.procent = procent;
	}
	
}
