package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Attributten "betalt" er afgørende for registreringen af prisen for rundvisningen senere i forløbet, og betalingen
 * kan først foregå efter datoen for rundvisningen, der specificeres i attributten "dato"
 * @author Erik Kato Ipsen
 *
 */

public class Rundvisning extends Produkt {

	private LocalDate dato;
	private boolean betalt; 
	
	
	public Rundvisning(String kategori, String produktNavn) { 
		super(kategori, produktNavn);
	}
 
	/**
	 * I dette projekt er det muligt at foretage betalingen af rundvisningen efter datoen for rundvisningen. I oplægget
	 * var dette begrænset til kun at omhandle dagen efter datoen for rundvisningen
	 * @param betalt kan kun sætte til true hvis betalingsdatoen foregår efter datoen for rundvisningen
	 * @param betalingsDato vil typiske være den pågældende dag registreringen for betalt rundvisning foregår altså LocalDate.now()
	 */
	public void setBetalt(boolean betalt, LocalDate betalingsDato) {
		if(betalingsDato.isAfter(dato)) {
			this.betalt = betalt;
		}
	}

	public LocalDate getDato() {
		return dato;
	}

	public void setDato(LocalDate dato) {
		this.dato = dato;
	}

	public boolean isBetalt() {
		return betalt;
	}
	
}
