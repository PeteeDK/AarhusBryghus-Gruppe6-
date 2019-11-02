package model;

import java.time.LocalDate;
import java.util.ArrayList;

import controller.Controller;


public class Anlæg extends Produkt {

	private boolean afleveret;
	private double brugtFustageLiter;
	private double brugtKulsyreKg;
	private double engangsPris;
	private ArrayList<Pris> tilbehørsPriser = new ArrayList<>();
	private LocalDate købsdato;
	private int id = 1; 

	
	public Anlæg(String kategori, String produktNavn) {
		super(kategori, produktNavn);
		setKøbsdato(LocalDate.now());
		setId(getId() + Controller.getSolgteAnlæg().size());	
	}

	public double beregnForbrug() {
		double pris = 0;
		if(afleveret) {
			for(Pris t : tilbehørsPriser) {
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
		for(Pris t : tilbehørsPriser) {
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
		if(brugtFustageMængde < 0) {
			throw new IllegalArgumentException("brugt fustagemængde kan ikke være negativ");
		}
		double samletFustageMængde = 0;
		for(Pris p : tilbehørsPriser) {
			if(p.getProdukt().getKategori().equals("fustage")) {
				samletFustageMængde += ((Tilbehør)p.getProdukt()).getMængde();
			}
		}
		if(brugtFustageMængde <= samletFustageMængde) {
			this.brugtFustageLiter = brugtFustageMængde;
		}else {
			throw new ArithmeticException("brugt fustage-mængde kan ikke overstiger indkøbt mængde");
		}
	}

	public double getBrugtKulsyremængde() {
		return brugtKulsyreKg;
	}

	public void setBrugtKulsyremængde(double brugtKulsyreMængde) {
		if(brugtKulsyreMængde < 0) {
			throw new IllegalArgumentException("brugt kulsyremængde kan ikke være negativ");
		}
		double samletKulsyreMængde = 0;
		for(Pris p : tilbehørsPriser) {
			if(p.getProdukt().getKategori().equals("kulsyre")) {
				samletKulsyreMængde += ((Tilbehør)p.getProdukt()).getMængde();
			}
		}
		if(brugtKulsyreMængde <= samletKulsyreMængde) {
			this.brugtKulsyreKg = brugtKulsyreMængde;
		}else {
			throw new RuntimeException("brugt kulsyre-mængde kan ikke overstige indkøbt mængde");
		}
	}
	
	public void addTilbehør(Pris t) {
		if(!tilbehørsPriser.contains(t)) {
			tilbehørsPriser.add(t);
		}
	}
	
	public void removeTilbehør(Pris t) {
		if(tilbehørsPriser.contains(t)) {
			tilbehørsPriser.remove(t);
		}
	}
	
	public ArrayList<Pris> getTilbehør(){
		return new ArrayList<>(tilbehørsPriser);
	}

	public String getStatus() {
		if(afleveret) {
			return "Anlægget er afleveret";
		}else {
			return "Anlægget er udlejet";
		}
	}
	
	//bruges i [Bestilling -> "listView: vise tilføjede produkter til anlæg"]
	public ArrayList<Produkt> getTilbehørsProdukter(){
		ArrayList<Produkt> produkter = new ArrayList<>();
		for(Pris p : tilbehørsPriser) {
			Produkt produkt = p.getProdukt();
			produkter.add(produkt); 
		}
		return produkter;
	}

	@Override
	public String toString() {
		return "Anlæg [afleveret=" + afleveret + ", engangsPris=" + engangsPris + ", tilbehørsPriser=" + tilbehørsPriser
				+ "]";
	}

	public LocalDate getKøbsdato() {
		return købsdato;
	}

	public void setKøbsdato(LocalDate købsdato) {
		this.købsdato = købsdato;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
