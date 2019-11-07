package controller;

import java.util.ArrayList;
import model.*;
import storage.Storage;

/**
 * Klassen indeholder funktionalitet til AnlægPane samt tilknyttede klasser i gui.window
 * @author Erik Kato Ipsen
 *
 */


public class AnlægCtlr{

    public static ArrayList<Pris> getPriserEfterArrangementOgKategori(String arrangement, String kategori){
    	ArrayList<Pris> priser = new ArrayList<>();
    	for(PrisListe pl : getPrislister()) {
    		if(pl.getArrangement().equals(arrangement)) {
    			for(Pris p : pl.getPriser()) {
    				if(p.getProdukt().getKategori().equals(kategori)) {
        				priser.add(p);
    				}
    			}
    		}
    	}
    	return priser;
    }


    /**
     * Henter alle arrangementer fra prislisterne i storage
     * @return arrangementer på alle prislister og returnerer dem som et array
     */
    public static String[] getArrangementer(){
    	String[] arrangementer = new String[getPrislister().size()];
    	int i = 0;
    	for(PrisListe pl : getPrislister()) {
    		arrangementer[i] = pl.getArrangement();
    		i++;
    	}
    	return arrangementer;
    }

    
    public static ArrayList<PrisListe> getPrislister() {
    	return Storage.getPrislister();
    }

    /**
     * Metoden returner alle priser, der er kynttet til en bestemt prisliste med det pågældende arrangement
     * @param arrangementet for prislisten
     * @return priserne tilknyttet prislisten med arrangementet i parameteren
     */
    public static ArrayList<Pris> getPriser(String arg){
    	ArrayList<Pris> priser = new ArrayList<>();
    	for(PrisListe pl : getPrislister()) {
    		if(pl.getArrangement().equals(arg)) {
        		for(Pris p : pl.getPriser()) {
        			priser.add(p);
        		}
    		}
    	}
    	return priser;
    }

	public static ArrayList<ProduktLinje> getIkkeAfleveredeAnlæg() {
		ArrayList<ProduktLinje> ikkeAfleveredeAnlæg = new ArrayList<>();
		for(ProduktLinje pl : getSolgteAnlæg()) {
			if(!((Anlæg) pl.getPrisObj().getProdukt()).isAfleveret()) {
				ikkeAfleveredeAnlæg.add(pl); 
			} 
		}
		return ikkeAfleveredeAnlæg;
	}
	
	
	public static ArrayList<ProduktLinje> getSolgteAnlæg() {
		ArrayList<ProduktLinje> solgteAnlæg = new ArrayList<>();
		for(Salg s : Storage.getSalgsenheder()) {
			for(ProduktLinje pl : s.getProduktLinjer()) {
				if(pl.getPrisObj().getProdukt().getKategori().equals("anlæg") && (pl.getPrisObj().getProdukt().getProduktNavn().equals("1-hane") || pl.getPrisObj().getProdukt().getProduktNavn().equals("2-haner") || pl.getPrisObj().getProdukt().getProduktNavn().equals("bar med flere haner"))) {
					solgteAnlæg.add(pl);
				}
			}
		} 
		return solgteAnlæg; 
	}

    
    public static ProduktLinje createProduktLinje(Pris pris, int antal) {
    	ProduktLinje produktLinje = new ProduktLinje(pris, antal);
    	Storage.addProduktLinje(produktLinje);
    	return produktLinje;
    }

    public static void addProduktLinje(ProduktLinje produktlinje) {
    	Storage.addProduktLinje(produktlinje);
    }
    
      
}
