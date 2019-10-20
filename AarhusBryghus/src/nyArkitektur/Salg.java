package nyArkitektur;

import java.time.LocalDate;
import java.util.ArrayList;

import controller.Controller;
import kasseret.Produktgruppe;

public class Salg {

	private int id = 1;
	private double samletPris;
	private ArrayList<Produkt> produkter = new ArrayList<>();
	private Betalingsform betalingsform;
	private Salgssituation salgssituation;
	private LocalDate salgsdato;
	private boolean godkendAftaltPris;
	
	public Salg(Salgssituation salgssituation, Betalingsform betalingsform) {
		id += Controller.getSalgsEnheder().size();	//TODO Tjek om salgs-id stemmer
		this.salgssituation = salgssituation;
		this.betalingsform = betalingsform;
		salgsdato = LocalDate.now();
	}
	
	public double beregnSamletPris() {
		
		//remove all nulls
		while(produkter.remove(null)) {
		}
		
		for(Produkt p : produkter) {
			samletPris += p.getPris();
		}
		
		if(salgssituation.getProcentviseRabat() > 0) {
			samletPris = samletPris - (samletPris * salgssituation.getProcentviseRabat()/100.0);
		}
		else if(godkendAftaltPris) {
			samletPris = salgssituation.getAftaltPris();
		}
		
		return samletPris;
	} 
	
	
	
	public void setGodkendAftaltPris(boolean godkend) {
		godkendAftaltPris = godkend;
	}
	
	public double getSamletPris() {
		return samletPris;
	}
	
	public void addProdukt(Produkt p) {
		produkter.add(p);
	}

	public Betalingsform getBetalingsform() {
		return betalingsform;
	}

	public void setBetalingsform(Betalingsform betalingsform) {
		this.betalingsform = betalingsform;
	}

	public Salgssituation getSalgssituation() {
		return salgssituation;
	}

	public void setSalgssituation(Salgssituation salgssituation) {
		this.salgssituation = salgssituation;
	}
	
	
	
}
