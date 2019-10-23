package nyArkitektur;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Rundvisning extends Produkt {

	private LocalDate dato;
	private LocalTime tidspunkt;
	private double aftenPris;
	private double dagsPris;
	private boolean betalt;
	//Hvis kunde er studerende: Kunde skal være en klasse. Det antages at studierabat er en procentsats
	//af det hele beløb for prisen pr. person
	private double studierabat;		
	private ArrayList<Kunde> kunder = new ArrayList<>();
	private double rundvisningsPris;
	private String status;
	
	
	
	public Rundvisning(String kategori, String produktNavn, LocalDate dato, LocalTime tidspunkt, double aftenPris,
			double dagsPris, double studierabat) {
		super(kategori, produktNavn);
		this.dato = dato;	//TODO Skal det være muligt at booke rundvisning i weekenden og juleaften
		validerTidspunkt(tidspunkt);
		this.aftenPris = aftenPris;
		this.dagsPris = dagsPris;
		this.studierabat = studierabat;
		setStatus();
	}
	
	private void setStatus() {
		if(betalt) {
			status = "Rundvisning er betalt";
		}else {
			status = "Rundvisning registreret (ikke betalt)";		
		}
	}

	//Det antages at der kun kan bookes rundvisning i tidsrummet: 18-22 og 8-15
	public void validerTidspunkt(LocalTime tidspunkt) {
		if((tidspunkt.isAfter(LocalTime.of(8, 00)) && tidspunkt.isBefore(LocalTime.of(15, 00))) ||
			(tidspunkt.isAfter(LocalTime.of(18, 00)) && tidspunkt.isBefore(LocalTime.of(22, 00)))){
			this.tidspunkt = tidspunkt;
		}else {
			this.tidspunkt = LocalTime.of(00, 00);
		}
	}
	
	//TODO betalingsDato kan evt. undlades og erstattes med LocalDate.now(). I oplægget er det et krav at
	//betalingen skal foregå en dag efter rundvisningen, men her gives der plads til at det blot foregår efter
	public void setBetalt(boolean betalt, LocalDate betalingsDato) {
		if(betalingsDato.isAfter(dato)) {
			this.betalt = betalt;
			setStatus();
		}else {
			this.betalt = false;
			rundvisningsPris = 0;
			setStatus();
		}
	}
	
	
	public double beregnPris() {
		if(tidspunkt.isAfter(LocalTime.of(18, 00)) && tidspunkt.isBefore(LocalTime.of(22, 00)) && betalt) {
			for(Kunde k : kunder) {
				if(k.isStuderende()) {
					rundvisningsPris += aftenPris - (aftenPris * studierabat); 
				}
				else {
					rundvisningsPris += aftenPris;
				}
			}
		}
		else if(tidspunkt.isAfter(LocalTime.of(8, 00)) && tidspunkt.isBefore(LocalTime.of(15, 00)) && betalt) {
			for(Kunde k : kunder) {
				if(k.isStuderende()) {
					rundvisningsPris += dagsPris - (dagsPris * studierabat); 
				}
				else {
					rundvisningsPris += dagsPris;
				}
			}
		}
		return rundvisningsPris;
	}
	
	@Override
	public double getPris() {
		return rundvisningsPris;
	}
	
	public LocalDate getDato() {
		return dato;
	}
	public void setDato(LocalDate dato) {
		this.dato = dato;
	}
	public double getAftenPris() {
		return aftenPris;
	}
	public void setAftenPris(double aftenPris) {
		this.aftenPris = aftenPris;
	}
	public double getDagsPris() {
		return dagsPris;
	}
	public void setDagsPris(double dagsPris) {
		this.dagsPris = dagsPris;
	}
	public boolean isBetalt() {
		return betalt;
	}
	public double getStudierabat() {
		return studierabat;
	}
	public void setStudierabat(double studierabat) {
		this.studierabat = studierabat;
	}
	
	public void addKunde(Kunde k) {
		if(!kunder.contains(k)) {
			kunder.add(k);
		}
	}

	public LocalTime getTidspunkt() {
		return tidspunkt;
	}

	public void setTidspunkt(LocalTime tidspunkt) {
		this.tidspunkt = tidspunkt;
	}

	public double getRundvisningsPris() {
		return rundvisningsPris;
	}

	public void setRundvisningsPris(double rundvisningsPris) {
		this.rundvisningsPris = rundvisningsPris;
	}

	@Override
	public String toString() {
		return "Rundvisning [dato=" + dato + ", tidspunkt=" + tidspunkt + ", aftenPris=" + aftenPris + ", dagsPris="
				+ dagsPris + ", betalt=" + betalt + ", studierabat=" + studierabat + ", kunder=" + kunder
				+ ", rundvisningsPris=" + rundvisningsPris + ", status=" + status + "]";
	}
	
	
}
