package model;

import java.util.ArrayList;


public class Anlæg extends Produkt {

	private boolean afleveret;
	private double brugtFustageLiter;
	private double brugtKulsyreKg;
	private double engangsPris;
	private ArrayList<Pris> tilbehør = new ArrayList<>();
	
	public Anlæg(String kategori, String produktNavn) {
		super(kategori, produktNavn);
	}

	public double beregnForbrug() {
		double pris = 0;
		if(afleveret) {
			for(Pris t : tilbehør) {
				if(t.getProdukt().getKategori().equals("fustage")) {
					pris += t.getPris() * brugtFustageLiter;	//t.getPris() er vel at mærke pris pr. liter
				}else if(t.getProdukt().getKategori().equals("kulsyre")) {
					pris += t.getPris() * brugtKulsyreKg;	//t.getPris er vel at mærke pris pr. kg
				}
			}
			pris -= beregnPant();
		}else {
			pris = beregnPant();
		}
		return pris;
	}
	
	
	private double beregnPant() {
		double pant = 0;
		for(Pris t : tilbehør) {
			if(t.getProdukt().getKategori().equals("fustage") || t.getProdukt().getKategori().equals("kulsyre")) {
				pant += ((Tilbehør)t.getProdukt()).getPant();
			}
		}
		return pant;
	}

	public boolean isAfleveret() {
		return afleveret;
	}

	public void setAfleveret(boolean afleveret) {
		this.afleveret = afleveret;
	}

	public double getBrugtFustagemængde() {
		return brugtFustageLiter;
	}

	public void setBrugtFustagemængde(double brugtFustageMængde) {
		double samletFustageMængde = 0;
		for(Pris p : tilbehør) {
			if(p.getProdukt().getKategori().equals("fustage")) {
				samletFustageMængde += ((Tilbehør)p.getProdukt()).getMængde();
			}
		}
		if(brugtFustageMængde <= samletFustageMængde) {
			this.brugtFustageLiter = brugtFustageMængde;
		}else {
			//TODO Exception-Handling
			throw new RuntimeException("brugt fustage-mængde overstiger indkøbt mængde");
		}
	}

	public double getBrugtKulsyremængde() {
		return brugtKulsyreKg;
	}

	public void setBrugtKulsyremængde(double brugtKulsyreMængde) {
		double samletKulsyreMængde = 0;
		for(Pris p : tilbehør) {
			if(p.getProdukt().getKategori().equals("kulsyre")) {
				samletKulsyreMængde += ((Tilbehør)p.getProdukt()).getMængde();
			}
		}
		if(brugtKulsyreMængde <= samletKulsyreMængde) {
			this.brugtKulsyreKg = brugtKulsyreMængde;
		}else {
			//TODO Exception-Handling
			throw new RuntimeException("brugt kulsyre-mængde overstiger indkøbt mængde");
		}
	}
	
	public void addTilbehør(Pris t) {
		if(!tilbehør.contains(t)) {
			tilbehør.add(t);
		}
	}
	
	public void removeTilbehør(Pris t) {
		if(tilbehør.contains(t)) {
			tilbehør.remove(t);
		}
	}

	public String getStatus() {
		if(afleveret) {
			return "Anlægget er afleveret";
		}else {
			return "Anlægget er udlejet";
		}
	}
	
	
		
	
}
