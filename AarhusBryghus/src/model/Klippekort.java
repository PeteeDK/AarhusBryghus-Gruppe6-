package model;

import java.time.LocalDate;
import java.util.ArrayList;

import controller.Controller;
import model.betalingsform.IBetalingsform;

/**
 * Objekter af klassen Klippekort kan både optræde som objekter af klassen Produkt og IBetalingsform, herved kan de
 * både optræde som vare og betalingsform i systemet. Ved oprettelsen af objekter af Klippekort oprettes 4 objekter
 * af klassen Klip, der gemmes i listen klipEnheder. Ved hver betaling sættes attributten "brugt" i et af klip-objekterne
 * til true. Når alle klip-objekter har fået sat deres attribut "brugt" til true, sættes attributten "opbrugt" i 
 * Klippekort til true, og der kan efterfølgende ikke foretages betalinger med det pågældende objekt af Klippekort.
 * @author Erik Kato Ipsen
 *
 */

public class Klippekort extends Produkt implements IBetalingsform {

	private int antalKlip;
	private ArrayList<Klip> klipEnheder = new ArrayList<>();
	private LocalDate købsdato;
	private boolean opbrugt;
	private int id = 1; 
	 
	public Klippekort(String kategori, String produktNavn) {
		super(kategori, produktNavn);
		setId(getId() + Controller.getSolgteKlippekort().size());	
		initKlip();
		this.antalKlip = klipEnheder.size(); 
		købsdato = LocalDate.now();
	}
	
	//copy constructor til BetalingsformWindow
	public Klippekort(Klippekort k) {
		super(k.getKategori(), k.getProduktNavn());
		antalKlip = k.antalKlip;
		klipEnheder = k.klipEnheder;
		købsdato = k.købsdato;
		id = k.id;	
	}
	
	
	private void initKlip() {
		int i = 1; 
		while(i < 5) {
			Klip k = createKlip(i);
			i++;
		}
	}
	
	public int antalKlipTilbage() {
		return antalKlip;
	}
 
	/**
	 * implementerer metoden fra interfaces IBetalingsform. Så længe attributten "opbrugt" ikke er sat til true kan
	 * objektet af Klippekort anvendes til betaling. Når attributten "brugt" i objekterne af Klip, der oprettes i
	 * constructoren og gemmes i listen klipEnheder er brugt, sættes "brugt" til true. Hvis man efterfølgende kalder
	 * metoden smides en runtimeException med en fejlmeddelelse.
	 */
	@Override
	public String registrerBetaling() {
		if(!opbrugt) {
			for(Klip k : klipEnheder) {
				if(!k.isBrugt() && antalKlip > 0) {
					k.setBrugt(true);
					String message = "Betalt med klippekort ID: " + id + ", " + "klip nr. " + k.getNr() + " af 4 er brugt";
					antalKlip--;
					if(antalKlip == 0) {
						setOpbrugt(true);
					}
					return message;
				} 
			}
		}
		throw new RuntimeException("Betalingen med klippekort blev ikke gennemført. Alle klip er opbrugt");
	}
	
	public ArrayList<Klip> getKlipEnheder(){
		return new ArrayList<>(klipEnheder);
	}
	
	public Klip createKlip(int nr) {
		Klip klip = new Klip(nr);
		klipEnheder.add(klip);
		return klip;
	}

	public int getAntalKlip() {
		return antalKlip;
	}

	public void setAntalKlip(int antalKlip) {
		if(antalKlip < 0) {
			throw new IllegalArgumentException("Antal klip kan ikke være negativ");
		}
		if(antalKlip > 0) {			
			opbrugt = false;		//i tilfælde af at alle klip er brugt sættes opbrugt til true
		}
		this.antalKlip = antalKlip;
	}

	public LocalDate getKøbsdato() {
		return købsdato;
	}

	public void setKøbsdato(LocalDate købsdato) {
		this.købsdato = købsdato;
	}

	@Override
	public String toString() {
		return "Klippekort [antalKlip=" + antalKlip + ", toString()=" + super.toString() + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isOpbrugt() {
		return opbrugt;
	}

	public void setOpbrugt(boolean opbrugt) {
		this.opbrugt = opbrugt;
	}

	
	
	
}
