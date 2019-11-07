package model;

import java.util.ArrayList;

/**
 * Alle produktkategorier nedarver fra klassen Produkt. For at kunne selektere de enkelte produkter fra hinanden, er 
 * det nødvendigt at objekter af subklasserne til Produkt specificerer en kategori samt et produkt-navn. 
 * @author Erik Kato Ipsen
 *
 */


public class Produkt {

	private String kategori;
	private String produktNavn;

	/**
	 * Når parametrene indsættes omformes evt. store bogstaver til små og mellem i hver ende elimineres for at skabe 
	 * øget konsistens i forhold til hvordan parametrene gemmes i attributterne, så man efterfølgende har lettere ved
	 * at finde fremt til dem og mindsker fejl ved registrering af et nyt produkt.  
	 * @param kategori produkt-kategorien produkt-navnet indgår under
	 * @param produktNavn det specifikke navn på produktet
	 */
	public Produkt(String kategori, String produktNavn) {
		this.kategori = kategori.toLowerCase().trim();
		this.produktNavn = produktNavn.toLowerCase().trim();
	} 
	
	public String getKategori() {
		return kategori;
	}

	public String getProduktNavn() {
		return produktNavn;
	}

	public void setKategori(String kategori) {
		this.kategori = kategori;
	}

	public void setProduktNavn(String produktNavn) {
		this.produktNavn = produktNavn;
	}

	@Override
	public String toString() {
		return "Produkt [kategori=" + kategori + ", produktNavn=" + produktNavn + "]";
	}

	
	
}
