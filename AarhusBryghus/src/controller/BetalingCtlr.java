package controller;

import java.util.ArrayList;
import model.*;
import storage.Storage;

/**
 * Klassen indeholder funktionalitet for BetalingPane samt tilknyttede klasser i gui.window
 * @author Erik Kato Ipsen
 *
 */

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
 

	/**
	 * Metoden gemmer de klippekort, der er blevet solgt og som ikke er opbrugt. Ved hver produktlinjer skal metoden
	 * oprette det antal unikke objekter af klassen Klippekort, som er angivet i produktlinjer ... virker ikke
	 * @return
	 */
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
