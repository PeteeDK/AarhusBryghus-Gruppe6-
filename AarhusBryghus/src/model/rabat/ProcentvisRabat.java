package model.rabat;

public class ProcentvisRabat extends Rabat {

	private double procent;
	
	
	public ProcentvisRabat(double procent) {
		setProcent(procent);
	}
	
	public double tildelRabat(double pris) {
		return pris - pris * (procent/100.0);
	}
	
	
	public double getProcent() {
		return procent;
	}

	public void setProcent(double procent) {
		if(procent < 0) {
			throw new IllegalArgumentException();
		}
		this.procent = procent;
	}
	
}
