package nyArkitektur;

import java.time.LocalDate;
import java.util.ArrayList;

import controller.Controller;

public class Salg {

	private int id = 1;
	private double samletPris;
	private ArrayList<Produkt> produkter = new ArrayList<>();
	private IBetalingsform betalingsform;
	private Salgssituation salgssituation;
	private LocalDate salgsdato;
	private boolean godkendAftaltPris;
	
	public Salg(Salgssituation salgssituation, IBetalingsform betalingsform) {
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

	public IBetalingsform getBetalingsform() {
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
	
	public LocalDate getSalgsdato() {
		return salgsdato;
	}

	public void setSalgsdato(LocalDate salgsdato) {
		this.salgsdato = salgsdato;
	}

	@Override
	public String toString() {
		return "Salg [id=" + id + ", samletPris=" + samletPris + ", produkter=" + produkter + ", betalingsform="
				+ betalingsform + ", salgssituation=" + salgssituation + ", salgsdato=" + salgsdato
				+ ", godkendAftaltPris=" + godkendAftaltPris + "]";
	}
	
	
	
}
