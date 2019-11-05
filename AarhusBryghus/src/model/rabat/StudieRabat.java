package model.rabat;

import model.ProduktLinje;

/**
 * Klassen StudieRabat dækker over den eneste rabat-type, der kun giver rabat til objekter af ProduktLinjer, der 
 * indeholder et objekt af Pris, der indeholder et objekt af eller en sub-klasse af super-klassen Produkt, hvis 
 * attribur "kategori" = "rundvisning". StudieRabat er derudover den eneste rabattype, der indeholder
 * en association til klassen ProduktLinje. Denne association er nødvendig for at udregne prisen for en rundvisning 
 * med studierabat, og derfor beregnes prisen for rundvisningen med rabat i dette i klassen ProduktLinje
 * @author Erik Kato Ipsen
 *
 */

public class StudieRabat extends Rabat {
 
	private int antalStuderende;
	private double rabatProcent; 
	private ProduktLinje produktlinje;
	
	public StudieRabat(ProduktLinje produktlinje, int antalStuderende, double rabatProcent) {
		setProduktlinje(produktlinje); 
		setAntalStuderende(antalStuderende); 
		setRabatProcent(rabatProcent); 
	} 
	
	public double tildelRabat(double pris) {
		double oprindeligPris = pris/produktlinje.getAntal();
		int ikkeStuderende = produktlinje.getAntal()-antalStuderende;	
		return (oprindeligPris * ikkeStuderende) + (oprindeligPris - (oprindeligPris * (rabatProcent/100))) * antalStuderende;
	}

	public int getAntalStuderende() {
		return antalStuderende;
	}

	public void setAntalStuderende(int antalStuderende) {
		if(antalStuderende < 0 || antalStuderende > produktlinje.getAntal()) {
			throw new IllegalArgumentException("Antallet af studerende kan ikke være negativ eller overstige antallet på rundvisningen");
		}
		this.antalStuderende = antalStuderende;
	}

	public double getRabatProcent() {
		return rabatProcent;
	}

	public void setRabatProcent(double rabatProcent) {
		if(rabatProcent < 0 || rabatProcent > 100) {
			throw new IllegalArgumentException("Studierabatprocenten kan ikke være negativ eller overstige 100%");
		}
		this.rabatProcent = rabatProcent;
	}

	public ProduktLinje getProduktlinje() {
		return produktlinje;
	}

	public void setProduktlinje(ProduktLinje produktlinje) {
		if(produktlinje == null) {
			throw new IllegalArgumentException("produktlinjen kan ikke være null");
		}
		this.produktlinje = produktlinje;
	}
	
	@Override
	public String toString() {
		return " antal studerende: " + antalStuderende + ", studierabatprocent: " + rabatProcent;
	}
	
}
