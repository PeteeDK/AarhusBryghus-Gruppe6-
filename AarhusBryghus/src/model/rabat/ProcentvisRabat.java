package model.rabat;

/**
 * Klassen ProcentvisRabat dækker over en rabat-type, hvor man angiver en procentsats, der skal fratrækkes den samlede
 * pris fra produklinjerne i objekter af klassen Salg. Dog kan procentsatsen hverken være negativ eller over 100
 * @author erikk
 *
 */

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
		if(procent < 0 || procent > 100) {
			throw new IllegalArgumentException("Rabatprocenten kan ikke være negativ eller overstige 100%");
		}
		this.procent = procent;
	}
	
}
