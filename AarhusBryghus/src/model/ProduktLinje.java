package model;

import java.util.ArrayList;

import model.rabat.Rabat;
import model.rabat.StudieRabat;

public class ProduktLinje {

    private int antal;
    private Rabat rabat;
    private Produkt produkt;
    private Pris pris;

    public ProduktLinje(Pris pris, int antal) {
		setAntal(antal);
		setPris(pris);
	}
    
    public void setRabat(Rabat rabat) {
    	this.rabat = rabat;
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
			throw new IllegalArgumentException("prisen kan ikke være null");
		}
		this.pris = pris;
	}

	@Override
	public String toString() {
		return "ProduktLinje [antal=" + antal + ", rabat=" + rabat + ", produkt=" + produkt + ", pris=" + pris + "]";
	}
    
	
	
}
