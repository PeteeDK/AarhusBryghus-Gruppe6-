package model;

import java.time.LocalDate;
import java.util.ArrayList;

import controller.Controller;
import model.betalingsform.*;
import model.rabat.*;

/**
 * Ved oprettelsen af objekter af klassen Salg tildeles objektet et unikt id samt en salgdato, hvilket gør det nemmere at
 * finde det pågældende objekt senere hen, når fx dagens salg skal gøres op. Klassen salg står for at udregne den
 * samlede pris fra objekterne af klassen ProduktLinje, der er blevet tilføjet samt evt. at tildele forskellige
 * former for rabat og registrere betaling med forskellige betalingsformer med beløb, der trækkes fra det samlede pris.
 * Når den samlede pris er betalt sættes attributten "erBetalt" til true  
 * @author Erik Kato Ipsen
 *
 */

public class Salg {
  
	private int id = 1; 
	private ArrayList<ProduktLinje> produktLinjer = new ArrayList<>();
	private ArrayList<String> betalingsformer = new ArrayList<>();
	private LocalDate salgsdato;
	private Rabat rabat;
	private double fuldBeløb;
	private boolean erbetalt;
	 
	public Salg() {
		id += Controller.getSalgsEnheder().size();	 
		salgsdato = LocalDate.now(); 
	}
	
	/**
	 * beregnPris() er hjælpemetode til getPris(). Metoden beregner og returnerer den samlede pris fra produktlinjerne
	 * @return samlede pris fra produktlinjerne
	 */
	
	private double beregnPris() {
		double samletPris = 0;
		
		for(ProduktLinje pl : produktLinjer) {
			samletPris += pl.getPris();
		}
		//display only two decimals
		return Math.round(samletPris * 100.0) / 100.0;
	}  
	
	/**
	 * @return den samlede pris i forhold til om der er sat en rabat eller ej
	 */
    public double getPris() {
    	if(rabat == null) {
    		fuldBeløb = beregnPris();
    		return beregnPris();
    	}else {
    		fuldBeløb = prisMedRabat(beregnPris());
    		return prisMedRabat(beregnPris());
    	}
    } 
	
    /**
     * hjælpemetode til getPris(). Beregner den samlede pris i forhold til de forskellige rabat-former. Her anvendes
     * strategy-pattern, da algoritmen tildelrabat(double) afhænger af hvilken subklasse til Rabat, der er sat.
     * @param prisUdenRabat den samlede pris fra produktlinjerne i beregnPris()
     * @return den samlede pris med rabat (afhængig af subklassen attributten "rabat" er sat til samt dets paramtre)
     */
    private double prisMedRabat(double prisUdenRabat) {
    	return rabat.tildelRabat(prisUdenRabat);
    }
    
    /**
     * Hvis rabat ikke er null, sørger metoden for at opdatere fuldBeløb til den samlede pris med rabatten som rabat-
     * objektet udregner. Derved behøver man ikke at kalde getPris() lige efter man har indsat parameteren
     * @param rabat subklasserne til superklassen Rabat
     */
    public void setRabat(Rabat rabat) {
    	this.rabat = rabat;
    	if(rabat != null) {
    		fuldBeløb = rabat.tildelRabat(fuldBeløb);
    	}
    }
	
	public int getId() {
		return id;
	}
	
	public ArrayList<String> getBetalingsform() {
		return new ArrayList<>(betalingsformer);
	}


	public LocalDate getSalgsdato() {
		return salgsdato;
	}

	public void setSalgsdato(LocalDate salgsdato) {
		this.salgsdato = salgsdato;
	}
	
	//Under udførelse af programmet oprettes produktlinjerne uden for klassen salg og tilføjes efterfølgende
	//dog er der nogle salg i Controller->initStorage(), der anvender denne metode ved opstart af programmet.
	public ProduktLinje createProduktLinje(Pris pris, int antal) {
		if(pris == null || antal < 0) {
			throw new IllegalArgumentException("prisen kan ikke være null eller antallet kan ikke være negativ");
		}
		ProduktLinje produktLinje = new ProduktLinje(pris, antal);
		produktLinjer.add(produktLinje);
		return produktLinje;
	} 
 
	public void addProduktLinje(ProduktLinje produktlinje) {
		if(produktlinje == null) {
			throw new IllegalArgumentException("Produktlinje kan ikke være null");
		}
		if(!produktLinjer.contains(produktlinje)) {
			produktLinjer.add(produktlinje);
		}
	}

	public void removeProduktLinje(ProduktLinje produktlinje) {
		if(produktLinjer.contains(produktlinje)) {
			produktLinjer.remove(produktlinje);
		}
	}
	
	public ArrayList<ProduktLinje> getProduktLinjer(){
		return new ArrayList<>(produktLinjer);
	}
	

	
	private void addBetalingsform(String betalingsform) {
		if(betalingsform == null) {
			betalingsformer.add(betalingsform);
		}
	}

	
	public void removeBetalingsform(IBetalingsform betalingsform) {
		betalingsformer.remove(betalingsform);
	}
	

	/**
	 * Metoden registrerer betalinger af den samlede pris fra getPris() og gemmer dem i listen betalingsformer. Man kan
	 * enten betale et del-beløb af den samlede pris eller hele prisen, men aldrig over den samlede pris eller det
	 * tilbageværende beløb. Når fuldBeløb er lig 0, sættes attributten "erbetalt" til true
	 * @param betalingsform er den pågældende klasse som implementerer IBetalingsform. Hver klasse har sin implementation
	 * af registrerBetaling() 
	 * @param beløb er det beløb, der trækkes fra "fuldBeløb", der udgør den samlede pris fra getPris()
	 */
	public void betaling(IBetalingsform betalingsform, double beløb) {
		if(betalingsform == null || beløb < 0) {
			throw new IllegalArgumentException("Betalingsformen kan ikke være null eller beløbet kan ikke være negativt");
		}
		 
		if(beløb <= fuldBeløb) {
			betalingsformer.add(betalingsform.registrerBetaling()+", beløb: "+beløb);
			fuldBeløb -= beløb;
			if(fuldBeløb == 0) {
				erbetalt = true; 
			} 
		}else {
			throw new ArithmeticException("Beløb kan ikke være mindre end det fulde beløb/resterende beløb");
		}
	}

	
	public double getFuldBeløb() {
		return fuldBeløb;
	}

	public boolean getErBetalt() {
		return erbetalt;
	}
	
	public void setErBetalt(boolean betalt) {
		erbetalt = betalt;
	}

	@Override
	public String toString() {
		return "Salg [id=" + id + ", produktLinjer=" + produktLinjer + ", betalingsformer=" + betalingsformer
				+ ", salgsdato=" + salgsdato + ", rabat=" + rabat + ", fuldBeløb=" + fuldBeløb + ", erbetalt="
				+ erbetalt + "]";
	}
	
	
	
}
