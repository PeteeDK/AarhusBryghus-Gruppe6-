package nyArkitektur;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Rundvisning {

	private double samletPris;	
	private LocalDate dato;
	private LocalTime tidspunkt;
	private double aftenPris;
	private double dagsPris;
	private boolean påbegyndtSalg;
	private boolean betalt;
	private double studierabat;		//Hvis kunde er studerende: Kunde skal være en klasse
	private ArrayList<Kunde> kunder = new ArrayList<>();
	
	
	public Rundvisning(double aftenPris, double dagsPris, double studierabat) {
		this.studierabat = studierabat;
		this.aftenPris = aftenPris;
		this.dagsPris = dagsPris;
		tidspunkt = LocalTime.now();
	}

	
	public double beregnPris() {
		if(tidspunkt.isAfter(LocalTime.of(18, 00)) && tidspunkt.isBefore(LocalTime.of(22, 00))) {
			for(Kunde k : kunder) {
				if(k.isStuderende()) {
					samletPris += kunder.size() * aftenPris * studierabat; 
				}
				else {
					samletPris += kunder.size() * aftenPris;
				}
			}
		}
		else if(tidspunkt.isAfter(LocalTime.of(8, 00)) && tidspunkt.isBefore(LocalTime.of(15, 00))) {
			for(Kunde k : kunder) {
				if(k.isStuderende()) {
					samletPris += kunder.size() * aftenPris * studierabat; 
				}
				else {
					samletPris += kunder.size() * aftenPris;
				}
			}
		}
		return samletPris;
		
	}
	
	public LocalDate getDato() {
		return dato;
	}
	public void setDato(LocalDate dato) {
		this.dato = dato;
	}
	public double getAftenPris() {
		return aftenPris;
	}
	public void setAftenPris(double aftenPris) {
		this.aftenPris = aftenPris;
	}
	public double getDagsPris() {
		return dagsPris;
	}
	public void setDagsPris(double dagsPris) {
		this.dagsPris = dagsPris;
	}
	public boolean isPåbegyndSalg() {
		return påbegyndtSalg;
	}
	public void setPåbegyndSalg(boolean påbegyndSalg) {
		this.påbegyndtSalg = påbegyndSalg;
	}
	public boolean isBetalt() {
		return betalt;
	}
	public void setBetalt(boolean betalt) {
		this.betalt = betalt;
	}
	public double getStudierabat() {
		return studierabat;
	}
	public void setStudierabat(double studierabat) {
		this.studierabat = studierabat;
	}
	
	public void addKunde(Kunde k) {
		kunder.add(k);
	}
	
	
}
