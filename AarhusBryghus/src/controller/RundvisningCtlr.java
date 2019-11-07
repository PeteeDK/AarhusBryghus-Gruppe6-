package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import model.*;
import storage.Storage;

/**
 * Klassen indeholder funktionalitet for RundvisningPane samt tilknyttede klasser i gui.window
 * @author Erik Kato Ipsen
 *
 */

public class RundvisningCtlr{

	public static ArrayList<ProduktLinje> getSolgteRundvisningerEfterDagensDato(LocalDate now) {
		ArrayList<ProduktLinje> solgteRundvisninger = new ArrayList<>();
		for(Salg s : Storage.getSalgsenheder()) {
			for(ProduktLinje pl : s.getProduktLinjer()) {
				if(pl.getPrisObj().getProdukt().getKategori().equals("rundvisning")) {
					Rundvisning rundvisning = ((Rundvisning) pl.getPrisObj().getProdukt());
					if(rundvisning.getDato().isBefore(now) && !rundvisning.isBetalt()) {
						solgteRundvisninger.add(pl);
					}
				}
			}
		}
		return solgteRundvisninger;
	}
	
	
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


    
    //get prisliste-arrangement - bruges i [Bestilling -> "comboBox"]
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
    
    public static ProduktLinje createProduktLinje(Pris pris, int antal) {
    	ProduktLinje produktLinje = new ProduktLinje(pris, antal);
    	Storage.addProduktLinje(produktLinje);
    	return produktLinje;
    }

    public static void addProduktLinje(ProduktLinje produktlinje) {
    	Storage.addProduktLinje(produktlinje);
    }
    
      
}
