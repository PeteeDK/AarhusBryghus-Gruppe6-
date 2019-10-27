package model;

import java.time.LocalDate;
import java.util.ArrayList;

import controller.Controller;
import model.betalingsform.*;
import model.rabat.*;

public class Salg {
 
	private int id = 1;
	private ArrayList<ProduktLinje> produktLinjer = new ArrayList<>();
	private IBetalingsform betalingsform;
	private LocalDate salgsdato;
	private Rabat rabat;
	
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
    		return beregnPris();
    	}else {
    		return prisMedRabat(beregnPris());
    	}
    } 
	
    private double prisMedRabat(double prisUdenRabat) {
    	return rabat.tildelRabat(prisUdenRabat);
    }
    
    public void setRabat(Rabat rabat) {
		if(rabat == null) {
			throw new IllegalArgumentException();
		}
    	this.rabat = rabat;
    }
	
	public int getId() {
		return id;
	}
	
	public IBetalingsform getBetalingsform() {
		return betalingsform;
	}

	public void setBetalingsform(Betalingsform betalingsform) {
		if(betalingsform == null) {
			throw new IllegalArgumentException("Betalingsform kan ikke være null");
		}
		this.betalingsform = betalingsform;
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
		if(produktlinje == null) {
			throw new IllegalArgumentException("Produktlinje kan ikke være null");
		}
		if(produktLinjer.contains(produktlinje)) {
			produktLinjer.remove(produktlinje);
		}
	}
	
	public ArrayList<ProduktLinje> getProduktLinjer(){
		return new ArrayList<>(produktLinjer);
	}
	
	@Override
	public String toString() {
		return "Salg [id=" + id + ", produktLinjer=" + produktLinjer + ", betalingsform=" + betalingsform
				+ ", salgsdato=" + salgsdato + ", rabat=" + rabat + "]";
	}
	
	
}
