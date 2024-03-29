package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Rundvisning extends Produkt {

	private LocalDate dato;
	private LocalTime tidspunkt;
	private boolean betalt;
	
	
	public Rundvisning(String kategori, String produktNavn, LocalDate dato, LocalTime tidspunkt) {
		super(kategori, produktNavn);
		this.dato = dato;					//TODO Skal dato valideres (fx muligt at booke i weekend og på helligdage)
		this.tidspunkt = tidspunkt;			//TODO Skal tidspunkt valideres (fx skal det være muligt at booke midnat)
	}

	
	//TODO I oplægget betalingen foreligge én dag efter rundvisningen, men her gives der plads til at betalinge blot foreligger efter datoen for rundvisninge
	public void setBetalt(boolean betalt, LocalDate betalingsDato) {
		if(betalingsDato.isAfter(dato)) {
			this.betalt = betalt;
		}
	}


	public LocalDate getDato() {
		return dato;
	}


	public void setDato(LocalDate dato) {
		this.dato = dato;
	}


	public LocalTime getTidspunkt() {
		return tidspunkt;
	}


	public void setTidspunkt(LocalTime tidspunkt) {
		this.tidspunkt = tidspunkt;
	}

	public boolean isBetalt() {
		return betalt;
	}
	
}
