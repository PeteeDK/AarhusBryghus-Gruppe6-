package nyArkitektur;

import java.time.LocalDate;
import java.time.LocalTime;
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
	
	
	public Rundvisning(String kategori, String produktNavn, LocalDate dato, LocalTime tidspunkt, double aftenPris,
			double dagsPris, double studierabat) {
		super(kategori, produktNavn);
		this.dato = dato;	//TODO Skal det være muligt at booke rundvisning i weekenden og juleaften
		validerTidspunkt(tidspunkt);
		this.aftenPris = aftenPris;
		this.dagsPris = dagsPris;
		this.studierabat = studierabat;
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
	
	public void setBetalt(boolean betalt) {
		if(tidspunkt!=LocalTime.of(00, 00)) {
			this.betalt = betalt;
		}
	}
	
	
	public double beregnPris() {
		if(tidspunkt.isAfter(LocalTime.of(18, 00)) && tidspunkt.isBefore(LocalTime.of(22, 00)) && betalt) {
			for(Kunde k : kunder) {
				if(k.isStuderende()) {
					rundvisningsPris += aftenPris * studierabat; 
				}
				else {
					rundvisningsPris += aftenPris;
				}
			}
		}
		else if(tidspunkt.isAfter(LocalTime.of(8, 00)) && tidspunkt.isBefore(LocalTime.of(15, 00)) && betalt) {
			for(Kunde k : kunder) {
				if(k.isStuderende()) {
					rundvisningsPris += dagsPris * studierabat; 
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
	
	
}
