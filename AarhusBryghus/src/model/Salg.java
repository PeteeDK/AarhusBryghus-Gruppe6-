package model;

import java.time.LocalDate;
import java.util.ArrayList;

import controller.Controller;
import model.betalingsform.*;
import model.rabat.*;

public class Salg {
 
	private int id = 1;
	private ArrayList<ProduktLinje> produktLinjer = new ArrayList<>();
	private IBetalingsform betalingsform;
	private LocalDate salgsdato;
	private Rabat rabat;
	
	public Salg() {
		id += Controller.getSalgsEnheder().size();	
		salgsdato = LocalDate.now(); 
	}
	 
	private double beregnPris() {
		double samletPris = 0;
		
		for(ProduktLinje pl : produktLinjer) {
			samletPris += pl.getPris();
		}
		
		return samletPris;
	} 
	
    public double getPris() {
    	if(rabat == null) {
    		return beregnPris();
    	}else {
    		return prisMedRabat(beregnPris());
    	}
    } 
	
    private double prisMedRabat(double prisUdenRabat) {
    	return rabat.tildelRabat(prisUdenRabat);
    }
    
    public void setRabat(Rabat rabat) {
    	this.rabat = rabat;
    }
	
	public int getId() {
		return id;
	}
	
	public IBetalingsform getBetalingsform() {
		return betalingsform;
	}

	public void setBetalingsform(Betalingsform betalingsform) {
		this.betalingsform = betalingsform;
	}

	public LocalDate getSalgsdato() {
		return salgsdato;
	}

	public void setSalgsdato(LocalDate salgsdato) {
		this.salgsdato = salgsdato;
	}
	
	public ProduktLinje createProduktLinje(Pris pris, int antal) {
		ProduktLinje produktLinje = new ProduktLinje(pris, antal);
		produktLinjer.add(produktLinje);
		return produktLinje;
	}

	public void addProduktLinje(ProduktLinje produktlinje) {
		if(!produktLinjer.contains(produktlinje)) {
			produktLinjer.add(produktlinje);
		}
	}

	public void removeProduktLinje(ProduktLinje produktlinje) {
		if(produktLinjer.contains(produktlinje)) {
			produktLinjer.remove(produktlinje);
		}
	}
	
	public ArrayList<ProduktLinje> getProduktLinjer(){
		return new ArrayList<>(produktLinjer);
	}
	
	@Override
	public String toString() {
		return "Salg [id=" + id + ", produktLinjer=" + produktLinjer + ", betalingsform=" + betalingsform
				+ ", salgsdato=" + salgsdato + ", rabat=" + rabat + "]";
	}
	
	
}
