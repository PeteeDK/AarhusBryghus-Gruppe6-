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
		this.antal = antal;
		this.pris = pris;
	}
    
    public void setRabat(Rabat rabat) {
    	this.rabat = rabat;
    }
    
    public void addPris(Pris pris) {
    	this.pris = pris; 
    }
    
    //TODO Man kan måske refakturere lidt her
    private double beregnPris() {
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
    
    private double prisMedRabat(double prisUdenRabat) {
    	return rabat.tildelRabat(prisUdenRabat);
    }
    
    public double getPris() {
    	if(rabat == null) {
    		return beregnPris();
    	}else {
    		return prisMedRabat(beregnPris());
    	}
    } 

	public int getAntal() {
		return antal;
	}

	@Override
	public String toString() {
		return "ProduktLinje [antal=" + antal + ", rabat=" + rabat + ", produkt=" + produkt + ", pris=" + pris + "]";
	}
    
	
	
}
