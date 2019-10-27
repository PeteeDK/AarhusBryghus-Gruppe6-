package model.rabat;

import model.ProduktLinje;

public class StudieRabat extends Rabat {

	private int antalStuderende;
	private double rabatProcent;
	private ProduktLinje produktlinje;
	
	public StudieRabat(ProduktLinje produktlinje, int antalStuderende, double rabatProcent) {
		this.produktlinje = produktlinje;
		this.antalStuderende = antalStuderende;
		setRabatProcent(rabatProcent);
	}
	
	@Override
	public double tildelRabat(double pris) {
		double oprindeligPris = pris/produktlinje.getAntal();
		int ikkeStuderende = produktlinje.getAntal()-antalStuderende;	//TODO der kan ikke være flere studerende end det totale antal til rundvisningen
		return (oprindeligPris * ikkeStuderende) + (oprindeligPris - (oprindeligPris * (rabatProcent/100))) * antalStuderende;
	}

	public int getAntalStuderende() {
		return antalStuderende;
	}

	public void setAntalStuderende(int antalStuderende) {
		if(antalStuderende < 0) {
			throw new IllegalArgumentException();
		}
		this.antalStuderende = antalStuderende;
	}

	public double getRabatProcent() {
		return rabatProcent;
	}

	public void setRabatProcent(double rabatProcent) {
		if(rabatProcent < 0) {
			throw new IllegalArgumentException();
		}
		this.rabatProcent = rabatProcent;
	}

	public ProduktLinje getProduktlinje() {
		return produktlinje;
	}

	public void setProduktlinje(ProduktLinje produktlinje) {
		this.produktlinje = produktlinje;
	}
	
	
	
	
}
