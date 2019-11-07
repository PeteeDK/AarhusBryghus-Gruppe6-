package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import model.*;
import storage.Storage;

/**
 * Klassen indeholder funktionalitet for BestillingPane samt tilknyttede klasser i gui.window
 * @author Erik Kato Ipsen
 *
 */

public class BestillingCtlr{

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

    
    public static ProduktLinje createProduktLinje(Pris pris, int antal) {
    	ProduktLinje produktLinje = new ProduktLinje(pris, antal);
    	Storage.addProduktLinje(produktLinje);
    	return produktLinje;
    }
    
    
	public static ArrayList<ProduktLinje> getProduktlinjer(){
		return Storage.getProduktLinjer();
	}

	
	public static void removeProduktLinje(ProduktLinje produktlinje) {
		Storage.removeProduktLinje(produktlinje);
	}

	
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


	public static void addProduktLinje(ProduktLinje produktlinje) {
		Storage.addProduktLinje(produktlinje);
	}

	/**
	 * Henter et eksemplar af alle kategorierne fra produkterne i storage på nær rundvisning og anlæg	
	 * @return arrayt med alle kategorierne på nær rundvisning og anlæg
	 */
    public static String[] getKategorierUdenRundvisningOgAnlæg(){
    	Set<String> kategorierSet = new HashSet<String>();
    	Set<String> discard = new HashSet<String>();
    	for(Produkt p : Storage.getProdukter()) {
    		//det var den eneste måde der virkede...
    		if(p.getKategori().equals("anlæg")||p.getKategori().equals("rundvisning")) {
    			discard.add(p.getKategori());
    		}else {
          		kategorierSet.add(p.getKategori());
    		}
    	}
    	
    	String[] kategorier = new String[kategorierSet.size()];
    	int i = 0;
    	for(String k : kategorierSet) {
    		kategorier[i] = k;
    		i++;
    	}
    	
     	return kategorier;
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
    
	//get 
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

    public static Produkt getGlas() {
        Produkt glas = null;
        for(Produkt p : Storage.getProdukter()) {
      	  if(p.getKategori().equals("glas")) {
      		  glas = p;
      	  }
        }
        return glas;
    }






}
