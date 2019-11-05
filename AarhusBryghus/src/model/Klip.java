package model;

import java.time.LocalDate;

/**
 * Objekter af klassen klip skabes og gemmes i fra objekter af klassen Klippekort. Når klip anvendes til betaling
 * registreres transaktionsdato og attributten brugt bliver sat til true
 * @author Erik Kato Ipsen
 */

public class Klip {

	private int nr;
	private boolean brugt;
	private LocalDate transaktionsdato;
	
	public Klip(int nr) { 
		this.nr = nr; 
	}  

	public int getNr() {
		return nr;
	}

	public void setNr(int nr) {
		this.nr = nr;
	}

	public boolean isBrugt() {
		return brugt;
	}

	public void setBrugt(boolean brugt) {
		this.brugt = brugt;
		if(this.brugt) {
			setTransaktionsdato(LocalDate.now());
		}
	}

	public LocalDate getTransaktionsdato() {
		return transaktionsdato;
	}

	public void setTransaktionsdato(LocalDate købsdato) {
		this.transaktionsdato = købsdato;
	}

	@Override
	public String toString() {
		return "Klip [nr=" + nr + ", brugt=" + brugt + ", transaktionsdato=" + transaktionsdato + "]";
	}
	
	
	

	
	
}
