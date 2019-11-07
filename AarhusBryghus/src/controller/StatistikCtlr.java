package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import model.*;
import storage.Storage;

/**
 * Klassen indeholder funktionalitet for StatistikPane samt tilknyttede klasser i gui.window
 * @author Erik Kato Ipsen
 *
 */

public class StatistikCtlr{

	public static ArrayList<Produkt> getIkkeAfleveredeAnlægMellemStartOgSlut(LocalDate startdato, LocalDate slutdato) {
		ArrayList<Produkt> ikkeAfleveredeAnlæg = new ArrayList<>();
		for(Produkt p : getSolgteAnlæg()) {
			if(!((Anlæg) p).isAfleveret() && ((Anlæg) p).getKøbsdato().isAfter(startdato) && ((Anlæg) p).getKøbsdato().isBefore(slutdato)) {
				ikkeAfleveredeAnlæg.add(p);
			}
		} 
		return ikkeAfleveredeAnlæg;
	} 

	
	public static ArrayList<Produkt> getSolgteAnlæg() {
		ArrayList<Produkt> solgteAnlæg = new ArrayList<>();
		for(Salg s : Storage.getSalgsenheder()) {
			for(ProduktLinje pl : s.getProduktLinjer()) {
				if(pl.getPrisObj().getProdukt().getKategori().equals("anlæg") && (pl.getPrisObj().getProdukt().getProduktNavn().equals("1-hane") || pl.getPrisObj().getProdukt().getProduktNavn().equals("2-haner") || pl.getPrisObj().getProdukt().getProduktNavn().equals("bar med flere haner"))) {
					int i = 0;
					while(i < pl.getAntal()) {
						solgteAnlæg.add(pl.getPrisObj().getProdukt());
						i++;
					}
				} 
			}
		}
		return solgteAnlæg;
	}

	
	public static ArrayList<Produkt> getSolgteKlippekortMellemStartOgSlut(LocalDate startdato, LocalDate slutdato) {
		ArrayList<Produkt> solgteKlippekort = new ArrayList<>();
		for(Produkt p : BetalingCtlr.getSolgteKlippekortDerIkkeErOpbrugt()) {
			if(((Klippekort)p).getKøbsdato().isAfter(startdato) && ((Klippekort)p).getKøbsdato().isBefore(slutdato)) {
				solgteKlippekort.add(p);
			}
		}
		return solgteKlippekort;
	}
	

	/**
	 * Tilgår alle solgte klip og hvilke klip der er hhv. brugte og ubrugte. 
	 * @param startDato
	 * @param slutDato
	 * @param brugt, afhængig om brugt sættes til true returneres brugte klip og false returneres ubrugte klip
	 * @return brugte/ubrugte klip mellem startdato og slutdato
	 */
	public static ArrayList<String> getBrugteKlipMellemStartOgSlut(LocalDate startDato, LocalDate slutDato, boolean brugt) {
		ArrayList<String> brugteKlip = new ArrayList<>();
		for(Produkt kk : getSolgteKlippekortMellemStartOgSlut(startDato, slutDato)) {
			for(Klip k : ((Klippekort) kk).getKlipEnheder()) {
				if(brugt == true) {
					if(k.isBrugt()) {
						String message = "KlippekortID: " + ((Klippekort) kk).getId() + " " + k.toString(); 
						brugteKlip.add(message);
					}
				}else {
					if(!k.isBrugt()) {
						String message = "KlippekortID: " + ((Klippekort) kk).getId() + " " + k.toString(); 
						brugteKlip.add(message);
					}
				}
			}
		}
		return brugteKlip;
	}

	
	/**
	 * Salg der er oprettet mellem startdato og slutdato ligges i en liste og returneres
	 * @param startdato
	 * @param slutdato
	 * @return arralist<Salg> med salg der er oprettet mellem startdato og slutdato
	 */
	public static ArrayList<Salg> getDagensSalgMellemStartOgSlut(LocalDate startdato, LocalDate slutdato){
		ArrayList<Salg> dagensSalg = new ArrayList<>();
		for(Salg s : getSalgsEnheder()) {
			if(s.getSalgsdato().isAfter(startdato) && s.getSalgsdato().isBefore(slutdato)) {
				dagensSalg.add(s);
			}
		}
		return dagensSalg; 
	}
	
    //get
    public static ArrayList<Salg> getSalgsEnheder() {
    	return Storage.getSalgsenheder();
    }

    
    
	
	
	
}
