package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class ProduktComposite extends Produkt {

	private double samletPris; 
	private LocalDate dato; 
	private ArrayList<Produkt> produkter = new ArrayList<>(); 

	
	
	
	public void beregnSamletPris() {
		
		for(Produkt p : produkter) {
			if(p instanceof AnlægLeaf) {
				if(((AnlægLeaf) p).isAfleveret()) {
					for(ProduktLeaf pl : ((AnlægLeaf) p).getTilbehør()) {
						if(pl.getKatagori().equals("Fustage")) {
							samletPris += pl.getMængde() - ((AnlægLeaf) p).getBrugtFustageMængde();
						}else if(pl.getKatagori().equals("Kulsyre")) {
							samletPris += pl.getMængde() - ((AnlægLeaf) p).getBrugtKulsyreMængde();
						}
					}
				}
				
			}else if(p instanceof RundvisningLeaf) {
				
				
			}else if(p instanceof ProduktLeaf) {
				
				
			}
		}
		return;
		
	}
	
	
	
	
	public void vælgBetalingsform() {
		
	}
	
	public void vælgSalgsSituation() {
		
	}

	public double getSamletPris() {
		return samletPris;
	}

	public LocalDate getDato() {
		return dato;
	}

	public ArrayList<Produkt> getProdukt() {
		return produkter;
	}

	
	
	
	
	
}
