package model;

/**
 * Klassen Kunde anvendes til at registrere info om kunden ved udlejning af fadølsanlæg
 * @author Erik Kato Ipsen
 *
 */

public class Kunde {

	private String navn;
	private String telefonNr;
	private String adresse;
	
	public Kunde(String navn, String telefonNr, String adresse) {
		super();
		this.navn = navn;
		this.telefonNr = telefonNr;
		this.adresse = adresse;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getTelefonNr() {
		return telefonNr;
	}

	public void setTelefonNr(String telefonNr) {
		this.telefonNr = telefonNr;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	

	
}
