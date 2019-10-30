package model;

import java.util.ArrayList;

import model.rabat.Rabat;
import model.rabat.StudieRabat;

public class ProduktLinje {

    private int antal;
    private Produkt produkt;
    private Pris pris;

    public ProduktLinje(Pris pris, int antal) {
		setPris(pris);
		setAntal(antal);
    }
    
    public void addPris(Pris pris) {
    	this.pris = pris; 
    } 
    
    //TODO Man kan måske refakturere lidt her
    public double getPris() {
    	if(pris.getProdukt().getKategori().equals("anlæg")) {
    		return antal * pris.getPris() + ((Anlæg)pris.getProdukt()).beregnForbrug();
    	}
    	else if(pris.getProdukt().getKategori().equals("rundvisning")) {
    		if(((Rundvisning)pris.getProdukt()).isBetalt()) {
    	    	return pris.getPris() * antal;
    		}else {
    			return 0;
    		}
    	}
    	return pris.getPris() * antal;
    }
    
	public int getAntal() {
		return antal;
	}
	
	public void setAntal(int antal) {
		if(antal < 0) {
			throw new IllegalArgumentException("Antallet kan ikke være negativ");
		}
		this.antal = antal;
	}

	public void setPris(Pris pris) {
		if(pris == null) {
			throw new IllegalArgumentException("Prisen kan ikke være null");
		}
		this.pris = pris;
	}
	
	public Pris getPrisObj() {
		return pris;
	}

	
	@Override
	public String toString() {
		return antal + " x " + pris.getProdukt().getProduktNavn() + " .......... " + getPris()+ " kr.";
	}
    
	
	
}
