package model;

import java.util.ArrayList;

public class AnlægLeaf extends Produkt{
	
	private double pris; 
	private boolean afleveret; 
	private double brugtFustageMængde; 
	private double brugtKulsyreMængde; 
	private ArrayList<ProduktLeaf> tilbehør = new ArrayList<>();
	
	public AnlægLeaf(double pris, boolean afleveret, double brugtFustageMængde, double brugtKulsyreMængde,
			ArrayList<ProduktLeaf> tilbehør) {
		this.pris = pris;
		this.afleveret = afleveret;
		this.brugtFustageMængde = brugtFustageMængde;
		this.brugtKulsyreMængde = brugtKulsyreMængde;
		this.tilbehør = tilbehør;
	}
	
	
	public double getPris() {
		return pris;
	}
	public boolean isAfleveret() {
		return afleveret;
	}
	public double getBrugtFustageMængde() {
		return brugtFustageMængde;
	}
	public double getBrugtKulsyreMængde() {
		return brugtKulsyreMængde;
	}
	public ArrayList<ProduktLeaf> getTilbehør() {
		return tilbehør;
	}
	
	
	
	
	
	
	
	
}
