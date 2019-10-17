package model;

import java.time.LocalDate;
import java.time.LocalTime;


public class RundvisningLeaf extends Produkt {
	
	private LocalDate dato; 
	private LocalTime tid; 
	private Boolean påbegyndtSalg = false; 
	private Boolean betalt = false; 
	private double aftenPris; 
	private double dagsPris; 
	private int studieRabat; 
	private int antalPersoner;
	
	public RundvisningLeaf(LocalDate dato, LocalTime tid, Boolean påbegyndtSalg, Boolean betalt, double aftenPris,
			double dagsPris, int studieRabat, int antalPersoner) {
		this.dato = dato;
		this.tid = tid;
		this.påbegyndtSalg = påbegyndtSalg;
		this.betalt = betalt;
		this.aftenPris = aftenPris;
		this.dagsPris = dagsPris;
		this.studieRabat = studieRabat;
		this.antalPersoner = antalPersoner;
	}

	public LocalDate getDato() {
		return dato;
	}

	public LocalTime getTid() {
		return tid;
	}

	public Boolean getPåbegyndtSalg() {
		return påbegyndtSalg;
	}

	public Boolean getBetalt() {
		return betalt;
	}

	public double getAftenPris() {
		return aftenPris;
	}

	public double getDagsPris() {
		return dagsPris;
	}

	public int getStudieRabat() {
		return studieRabat;
	}

	public int getAntalPersoner() {
		return antalPersoner;
	}
	
	
	
}
