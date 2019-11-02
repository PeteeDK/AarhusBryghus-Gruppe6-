package model;

import java.time.LocalDate;
import java.util.ArrayList;

import controller.Controller;
import model.betalingsform.*;
import model.rabat.*;

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
	 
	private double beregnPris() {
		double samletPris = 0;
		
		for(ProduktLinje pl : produktLinjer) {
			samletPris += pl.getPris();
		}
		//display only two decimals
		return Math.round(samletPris * 100.0) / 100.0;
	} 
	
    public double getPris() {
    	if(rabat == null) {
    		fuldBeløb = beregnPris();
    		return beregnPris();
    	}else {
    		fuldBeløb = prisMedRabat(beregnPris());
    		return prisMedRabat(beregnPris());
    	}
    } 
	
    private double prisMedRabat(double prisUdenRabat) {
    	return rabat.tildelRabat(prisUdenRabat);
    }
    
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
		betalingsformer.add(betalingsform);
	}

	
	public void removeBetalingsform(IBetalingsform betalingsform) {
		betalingsformer.remove(betalingsform);
	}
	
	
	public void betaling(IBetalingsform betalingsform, double beløb) {
		if(betalingsform == null || beløb < 0) {
			throw new IllegalArgumentException("Betalingsformen kan ikke være null eller beløbet kan ikke være negativt");
		}
		 
		//Betalingsform->registrerBetaling() og trække beløb fra fuldtBetalt
		if(beløb <= fuldBeløb) {
			betalingsformer.add(betalingsform.registrerBetaling()+", beløb: "+beløb);
			fuldBeløb -= beløb;
			if(fuldBeløb == 0) {
				erbetalt = true;
			} 
//			System.out.println("[Salg -> delBetalinger()] Fuldbeløb: " + fuldBeløb);
		}else {
			throw new ArithmeticException("Beløb kan ikke være mindre en det fulde beløb");
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
