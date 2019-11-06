package controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import model.*;
import model.betalingsform.*;
import model.rabat.*;
import storage.Storage;
import model.produkter.*;

public class BetalingCtlr{


	public static ArrayList<ProduktLinje> getProduktlinjer(){
		return Storage.getProduktLinjer();
	}

    //create
    public static Salg createSalg() {
    	Salg salg = new Salg();
    	Storage.addSalg(salg);
    	return salg;
    } 

	public static void tømProduktlinjer() {
		Storage.tømProduktLinjer();
	}


    //get
    public static ArrayList<Salg> getSalgsEnheder() {
    	return Storage.getSalgsenheder();
    }
    
	public static void addSalg(Salg salg) {
		Storage.addSalg(salg);
	}

	
	public static ArrayList<Produkt> getSolgteKlippekortDerIkkeErOpbrugt() {
		ArrayList<Produkt> solgteKlippekort = new ArrayList<>();
		for(Salg s : Storage.getSalgsenheder()) {
			for(ProduktLinje pl : s.getProduktLinjer()) {
				if(pl.getPrisObj().getProdukt().getKategori().equals("klippekort")) {
					Klippekort p = (Klippekort) pl.getPrisObj().getProdukt();
					if(!p.isOpbrugt()) {
						int i = 0;
						//TODO Virker ikke rigtig
						while(i < pl.getAntal()) {
							solgteKlippekort.add(pl.getPrisObj().getProdukt());
							i++;
						}
					}
				}
			}
		}
		return solgteKlippekort;
	}
	

}
