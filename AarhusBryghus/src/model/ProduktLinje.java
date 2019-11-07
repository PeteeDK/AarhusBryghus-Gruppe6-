package model;

import java.util.ArrayList;

import model.rabat.Rabat;
import model.rabat.StudieRabat;

/**
 * Klassen ProduktLinje muliggør at man kan til knytte et antal til et pågældende objekt af klassen Pris. Herved
 * behøver man ikke at tilføje x antal objekter af klassen Pris til objekter af klassen Salg. Attributten studierabat
 * anvendes i tilfælde af at objektet af klassen Pris indeholder et objekt af klassen Rundvisning.
 * @author Erik Kato Ipsen
 *
 */

public class ProduktLinje {
 
    private int antal;
    private StudieRabat studierabat;
    private Pris pris;

    public ProduktLinje(Pris pris, int antal) {
		setPris(pris);
		setAntal(antal);
    } 
     
    public void addPris(Pris pris) { 
    	this.pris = pris; 
    } 
    
    //TODO Man kan måske refakturere lidt her. Og er det alle produkter fra Anlæg, der skal beregnes på samme måde
    /**
	 * Den samlede pris for antal og den specifikke pris, der er tilknyttet et bestemt objekt af en sub-klasse til 
	 * super-klassen Produkt udregnes forskelligt, hvis produktkategorien er anlæg, rundvisning eller andet. 
     * @return den samlede pris af antal og den specifikke pris i attributten "pris"
     */
    public double getPris() {
    	
    	switch(pris.getProdukt().getKategori()) {
    		
    		case "anlæg":
        		if(!((Anlæg)pris.getProdukt()).isAfleveret()) {
            		return antal * pris.getPris() + ((Anlæg)pris.getProdukt()).beregnForbrug();
        		}else {
            		return ((Anlæg)pris.getProdukt()).beregnForbrug();
        		}
        		
    		case "rundvisning":
    			if(((Rundvisning)pris.getProdukt()).isBetalt()) {
        			if(studierabat == null) { 
           	    		return pris.getPris() * antal;
           	    	}else {
           	    		return studierabat.tildelRabat(pris.getPris() * antal);
           	    	}
        		}else {
        			return 0;
        		}
    			
    		default:
    	    	return pris.getPris() * antal;
    	}
    }
     
	public int getAntal() {
		return antal;
	}
	
	public void setStudieRabat(StudieRabat studierabat) {
		this.studierabat = studierabat;
	}
	
	public StudieRabat getStudieRabat() {
		return studierabat;
	}
	
	/**
	 * Antallet skal minimum være én før at det giver mening at oprette et objekt af klassen ProduktLinje
	 * @param antal man ønsker at bestille af et pågældende produkt
	 */
	public void setAntal(int antal) {
		if(antal < 1) {
			throw new IllegalArgumentException("Antallet skal være lig 1 eller over");
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



//TODO Tag endelig stilling til om metoden skal med eller ej
//public double getPris() {
//	if(pris.getProdukt().getKategori().equals("anlæg")) { 
//		if(!((Anlæg)pris.getProdukt()).isAfleveret()) {
//  		return antal * pris.getPris() + ((Anlæg)pris.getProdukt()).beregnForbrug();
//		}else {
//  		return ((Anlæg)pris.getProdukt()).beregnForbrug();
//		}
//	}
//	else if(pris.getProdukt().getKategori().equals("rundvisning")) {
//		if(((Rundvisning)pris.getProdukt()).isBetalt()) {
//			if(studierabat == null) {
// 	    		return pris.getPris() * antal;
// 	    	}else {
// 	    		return studierabat.tildelRabat(pris.getPris() * antal);
// 	    	}
//		}else {
//			return 0;
//		}
//	}
//	return pris.getPris() * antal;
//}
